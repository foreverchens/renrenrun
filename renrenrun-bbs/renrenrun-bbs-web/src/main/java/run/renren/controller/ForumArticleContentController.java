package run.renren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import run.renren.service.ForumArticleContentService;


/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-09-04 22:14:28
 */
@RestController
public class ForumArticleContentController {
	@Autowired
	private ForumArticleContentService forumArticleContentService;

	/**
	 * 列表
	 */
	@GetMapping("/article/content/list")
	public Object list() {
		return forumArticleContentService.list();
	}
}
