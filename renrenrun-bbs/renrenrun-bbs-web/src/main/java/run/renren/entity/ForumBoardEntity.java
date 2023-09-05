package run.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@Data
@TableName("forum_board")
public class ForumBoardEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 板块ID
	 */
	@TableId
	private Integer boardId;
	/**
	 * 父级板块ID
	 */
	private Integer parBoardId;
	/**
	 * 板块名
	 */
	private String boardName;
	/**
	 * 封面
	 */
	private String cover;
	/**
	 * 描述
	 */
	private String boardDesc;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 0:只允许管理员发帖 1:任何人可以发帖
	 */
	private Integer postType;

}
