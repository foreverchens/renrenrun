package run.renren.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import run.renren.entity.Test;
import run.renren.service.TestService;

import javax.annotation.Resource;

import java.util.List;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@RestController
public class TestController {

	@Resource
	private TestService testService;
	@GetMapping("/test/list")
	public List<Test> list(){
		return testService.list(null);
	}
}
