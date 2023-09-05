package run.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;

import run.renren.common.CallResult;
import run.renren.controller.board.vo.ListBoardVo;
import run.renren.entity.ForumBoardEntity;

import java.util.List;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
public interface ForumBoardService extends IService<ForumBoardEntity> {

	/**
	 * 获取板块列表
	 * @return
	 */
	CallResult<List<ListBoardVo>> listBoard();
}

