package run.renren.controller.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import run.renren.service.ForumArticleContentService;


/**
 * @author yyy
 * @tg t.me/ychen5325
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
