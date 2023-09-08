package run.renren.controller.article;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import run.renren.common.CallResult;
import run.renren.controller.article.vo.ListArticleParamVo;
import run.renren.controller.article.vo.ListArticleVo;
import run.renren.service.ForumArticleService;

import javax.validation.Valid;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@RestController
public class ForumArticleController {
	@Autowired
	private ForumArticleService forumArticleService;

	/**
	 * 列表
	 */
	@PostMapping("/article/list")
	public CallResult<ListArticleVo> list(@Valid @RequestBody ListArticleParamVo paramVo) {
		return forumArticleService.listArticle(paramVo);
	}
}
