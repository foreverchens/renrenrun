package run.renren.aqi;

import com.alibaba.fastjson.JSONObject;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.io.FileUtil;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@Slf4j
@Service
public class AqiService {

	/**
	 *  key-> cityName
	 *  val-> [sumAqi,count,lastHour]
	 */
	private Map<String, Integer[]> aqiMap = new HashMap<>();

	private SimpleDateFormat sdf = new SimpleDateFormat("HH");
	@Resource
	private RestTemplate restTemplate;


	/**
	 * 从city.txt获取需要统计的城市数据、并初始化aqiMap、
	 */
	@PostConstruct
	private void init() {
		String dir = System.getProperty("user.dir");
		List<String> cityFile = FileUtil.readUtf8Lines(dir + File.separator + "city.txt");
		cityFile.forEach(ele -> {
			String[] split = ele.split("=");
			if (split.length == 2) {
				aqiMap.put(split[1], new Integer[]{0, 0, -1});
			}
		});
		CompletableFuture.runAsync(() -> {
			while (true) {
				loop();
			}
		});
	}


	private void loop() {
		for (String cityKey : aqiMap.keySet()) {
			// 获取aqi数据、为null跳过
			JSONObject data = getAqi(cityKey);
			if (Objects.isNull(data)) {
				continue;
			}
			// arr[2] 记录为采集上次数据的小时时间、如果本次采集时间未更新、则跳过
			Integer aqi = data.getInteger("aqi");
			Date date = data.getJSONObject("time").getDate("s");
			Integer dataHour = Integer.valueOf(sdf.format(date));
			Integer[] arr = aqiMap.get(cityKey);
			if (arr[2].equals(dataHour)) {
				// 远端数据未更新
				continue;
			}
			// 更新aqi缓存
			arr[0] += aqi;
			arr[1]++;
			arr[2] = dataHour;
			log.info("{}: {}={}", cityKey, arr[0], arr[1]);

			// 如果当前hour为0、则需要将采集的昨日aqi数据入库、并重置aqi缓存
			LocalDateTime now = LocalDateTime.now();
			if (now.getHour() == 0) {
				// 昨日平均aqi、昨日日期、及存储地址
				String avgAqi = BigDecimal.valueOf(arr[0]).divide(BigDecimal.valueOf(arr[1]), 1, RoundingMode.DOWN).toEngineeringString();
				String content = now.toLocalDate().minusDays(1).toString().concat("=").concat(avgAqi).concat(System.lineSeparator());
				String path = System.getProperty("user.dir") + File.separator + "data" + File.separator + cityKey + "_aqi.txt";
				FileUtil.appendUtf8String(content, path);
				arr[0] = arr[1] = 0;
				arr[2] = -1;
				log.info("{}: {}", cityKey, content);
			}
		}
		try {
			TimeUnit.HOURS.sleep(1);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取指定城市的AQI数据、需要用到起aqi和time数据
	 */
	private JSONObject getAqi(String city) {
		try {
			String url = "https://api.waqi.info/feed/" + city + "/?token=c8097d014ae9fe310b0535f99d283814d6b3e3f2";
			JSONObject jsonObj = restTemplate.getForObject(url, JSONObject.class);
			assert jsonObj != null;
			return jsonObj.getJSONObject("data");
		} catch (Exception ex) {
			return null;
		}
	}

	public List<String[]> listData(String city) {
		if (!aqiMap.containsKey(city)) {
			return ListUtil.empty();
		}
		String path = System.getProperty("user.dir") + File.separator + "data" + File.separator + city + "_aqi.txt";
		List<String> aqiList = FileUtil.readUtf8Lines(path);
		return aqiList.stream().map(ele -> StringUtils.split(ele, "=")).collect(Collectors.toList());
	}
}
