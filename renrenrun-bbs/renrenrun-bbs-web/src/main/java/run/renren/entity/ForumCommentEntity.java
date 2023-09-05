package run.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@Data
@TableName("forum_comment")
public class ForumCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 评论ID
	 */
	@TableId
	private Integer commentId;
	/**
	 * 父级评论ID
	 */
	private Integer pCommentId;
	/**
	 * 文章ID
	 */
	private String articleId;
	/**
	 * 回复内容
	 */
	private String content;
	/**
	 * 图片
	 */
	private String imgPath;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 用户ip地址
	 */
	private String userIpAddress;
	/**
	 * 回复人ID
	 */
	private String replyUserId;
	/**
	 * 回复人昵称
	 */
	private String replyNickName;
	/**
	 * 0:未置顶  1:置顶
	 */
	private Integer topType;
	/**
	 * 发布时间
	 */
	private Date postTime;
	/**
	 * good数量
	 */
	private Integer goodCount;
	/**
	 * 0:待审核  1:已审核
	 */
	private Integer status;

}
