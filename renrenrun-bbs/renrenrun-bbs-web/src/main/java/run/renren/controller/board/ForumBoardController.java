package run.renren.controller.board;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import run.renren.common.CallResult;
import run.renren.controller.board.vo.ListBoardVo;
import run.renren.service.ForumBoardService;

import javax.annotation.Resource;

import java.util.List;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@RestController
public class ForumBoardController {
	@Resource
	private ForumBoardService forumBoardService;

	/**
	 * 列表
	 */
	@PostMapping("/board/list")
	public CallResult<List<ListBoardVo>> list() {
		return forumBoardService.listBoard();
	}
}
