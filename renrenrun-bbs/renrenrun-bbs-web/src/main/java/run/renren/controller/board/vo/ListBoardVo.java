package run.renren.controller.board.vo;

import lombok.Data;

import java.util.List;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@Data
public class ListBoardVo {
	private Integer boardId;
	private Integer parBoardId;
	private String boardName;
	private String cover;
	private String boardDesc;
	private Integer sort;
	private Integer postType;
	private List<ListBoardVo> children;
}
