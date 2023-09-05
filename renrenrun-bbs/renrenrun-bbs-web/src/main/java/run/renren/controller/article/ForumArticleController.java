package run.renren.controller.article;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import run.renren.common.CallResult;
import run.renren.controller.article.vo.ListArticleParamVo;
import run.renren.entity.ForumArticleEntity;
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
	@GetMapping("/article/list")
	public CallResult<Page<ForumArticleEntity>> list(@Valid @RequestBody ListArticleParamVo paramVo) {
		return forumArticleService.listArticle(paramVo);
	}
}
