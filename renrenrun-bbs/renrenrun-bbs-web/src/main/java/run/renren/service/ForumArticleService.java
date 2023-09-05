package run.renren.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import run.renren.common.CallResult;
import run.renren.controller.article.vo.ListArticleParamVo;
import run.renren.entity.ForumArticleEntity;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
public interface ForumArticleService extends IService<ForumArticleEntity> {

	/**
	 * 获取板块文章列表
	 */
	CallResult<Page<ForumArticleEntity>> listArticle(ListArticleParamVo paramVo);
}

