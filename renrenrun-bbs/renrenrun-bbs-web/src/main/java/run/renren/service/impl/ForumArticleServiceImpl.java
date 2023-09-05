package run.renren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import run.renren.common.CallResult;
import run.renren.controller.article.vo.ListArticleParamVo;
import run.renren.entity.ForumArticleEntity;
import run.renren.mapper.ForumArticleMapper;
import run.renren.service.ForumArticleService;

import java.util.Objects;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@Service("forumArticleService")
public class ForumArticleServiceImpl extends ServiceImpl<ForumArticleMapper, ForumArticleEntity> implements ForumArticleService {


	@Override
	public CallResult<Page<ForumArticleEntity>> listArticle(ListArticleParamVo paramVo) {
		Integer parBoardId = paramVo.getParBoardId();
		Integer boardId = paramVo.getBoardId();
		Page<ForumArticleEntity> pageParam = new Page<ForumArticleEntity>(1, 3) {};
		LambdaQueryWrapper<ForumArticleEntity> queryWrapper = new LambdaQueryWrapper<ForumArticleEntity>()
				.eq(ForumArticleEntity::getParBoardId, parBoardId)
				.eq(!Objects.isNull(boardId), ForumArticleEntity::getBoardId, boardId);
		Page<ForumArticleEntity> pageRlt = this.page(pageParam, queryWrapper);
		return CallResult.success(pageRlt);
	}
}