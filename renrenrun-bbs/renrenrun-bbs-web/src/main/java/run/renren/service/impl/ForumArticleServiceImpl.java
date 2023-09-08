package run.renren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import run.renren.common.CallResult;
import run.renren.controller.article.vo.ListArticleParamVo;
import run.renren.controller.article.vo.ListArticleVo;
import run.renren.entity.ForumArticleEntity;
import run.renren.entity.ForumBoardEntity;
import run.renren.mapper.ForumArticleMapper;
import run.renren.service.ForumArticleService;
import run.renren.service.ForumBoardService;

import javax.annotation.Resource;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@Service("forumArticleService")
public class ForumArticleServiceImpl extends ServiceImpl<ForumArticleMapper, ForumArticleEntity> implements ForumArticleService {


	@Resource
	private ForumBoardService forumBoardService;

	@Override
	public CallResult<ListArticleVo> listArticle(ListArticleParamVo paramVo) {
		Integer parBoardId = paramVo.getParBoardId();
		Integer boardId = paramVo.getBoardId();
		Integer orderType = paramVo.getOrderType();
		Integer pageNo = paramVo.getPageNo();
		Page<ForumArticleEntity> pageParam = new Page<ForumArticleEntity>(1, 3) {};
		LambdaQueryWrapper<ForumArticleEntity> queryWrapper = new LambdaQueryWrapper<ForumArticleEntity>().eq(!Objects.isNull(parBoardId), ForumArticleEntity::getParBoardId, parBoardId).eq(!Objects.isNull(boardId) && boardId > 0, ForumArticleEntity::getBoardId, boardId);

		Page<ForumArticleEntity> pageRlt = this.page(pageParam, queryWrapper);
		ListArticleVo.ListArticleVoBuilder voBuilder = ListArticleVo.builder().totalCount(Math.toIntExact(pageRlt.getTotal())).pageNo(Math.toIntExact(pageRlt.getCurrent()))
																	.pageSize(Math.toIntExact(pageRlt.getSize())).pageTotal(Math.toIntExact(pageRlt.getPages()));
		ListArticleVo rlt = voBuilder.list(pageRlt.getRecords().stream().map(ele -> {
			ListArticleVo.ArticleItem articleItem = new ListArticleVo.ArticleItem();
			BeanUtils.copyProperties(ele, articleItem);
			Optional<ForumBoardEntity> board = Optional.ofNullable(forumBoardService.getById(ele.getBoardId()));
			board.ifPresent(forumBoardEntity -> articleItem.setBoardName(forumBoardEntity.getBoardName()));
			Optional<ForumBoardEntity> parBoard = Optional.ofNullable(forumBoardService.getById(ele.getParBoardId()));
			parBoard.ifPresent(forumBoardEntity -> articleItem.setParBoardName(forumBoardEntity.getBoardName()));
			articleItem.setNickName("laoyang");
			return articleItem;
		}).collect(Collectors.toList())).build();
		return CallResult.success(rlt);
	}
}