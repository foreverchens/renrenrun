package run.renren.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.hutool.core.collection.CollectionUtil;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import run.renren.common.CallResult;
import run.renren.controller.board.vo.ListBoardVo;
import run.renren.entity.ForumBoardEntity;
import run.renren.mapper.ForumBoardMapper;
import run.renren.service.ForumBoardService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@Service("forumBoardService")
public class ForumBoardServiceImpl extends ServiceImpl<ForumBoardMapper, ForumBoardEntity> implements ForumBoardService {


	@Override
	public CallResult<List<ListBoardVo>> listBoard() {
		List<ForumBoardEntity> forumBoardList = this.list();
		if (CollectionUtil.isEmpty(forumBoardList)) {
			return CallResult.success();
		}
		List<ListBoardVo> boardVoList = forumBoardList.stream().map(ele -> {
			ListBoardVo vo = new ListBoardVo();
			BeanUtils.copyProperties(ele, vo);
			return vo;
		}).collect(Collectors.toList());
		return CallResult.success(buildBoardTree(boardVoList, 0));
	}

	private List<ListBoardVo> buildBoardTree(List<ListBoardVo> data, Integer pid) {
		List<ListBoardVo> children = new ArrayList<>();
		for (ListBoardVo m : data) {
			if (m.getParBoardId().equals(pid)) {
				m.setChildren(buildBoardTree(data, m.getBoardId()));
				children.add(m);
			}
		}
		return children;
	}
}