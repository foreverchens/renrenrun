package run.renren.aqi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@Slf4j
@Controller
public class AqiController {

	@Resource
	private AqiService aqiService;

	@GetMapping("/aqi")
	public String test() {
		return "aiq";
	}


	@GetMapping("/data/{city}")
	@ResponseBody
	public Object data(@PathVariable("city") String city) {
		return aqiService.listData(city);
	}
}
