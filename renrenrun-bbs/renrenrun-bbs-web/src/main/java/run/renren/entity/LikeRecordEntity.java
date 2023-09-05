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
@TableName("like_record")
public class LikeRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增ID
	 */
	@TableId
	private Integer likeId;
	/**
	 * 内容Id、可能为文章也可能为评论
	 */
	private Integer contentId;
	/**
	 * 操作类型0:文章点赞 1:评论点赞
	 */
	private Integer contentType;
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 点赞状态、第一次喜欢拆入新纪录、后续取消在喜欢则修改此字段
	 */
	private Integer status;
	/**
	 * 内容作者Id
	 */
	private Integer contentUserId;
	/**
	 * 点赞时间
	 */
	private Date createAt;
	/**
	 * 更新时间
	 */
	private Date updateAt;

}
