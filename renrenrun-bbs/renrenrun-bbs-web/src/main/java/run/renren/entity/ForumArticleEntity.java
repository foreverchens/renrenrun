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
@TableName("forum_article")
public class ForumArticleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 文章ID
	 */
	@TableId
	private Integer articleId;
	/**
	 * 板块ID
	 */
	private Integer boardId;
	/**
	 * 父级板块ID
	 */
	private Integer parBoardId;
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 封面
	 */
	private String cover;
	/**
	 * 0:富文本编辑器 1:markdown编辑器
	 */
	private Integer editorType;
	/**
	 * 摘要
	 */
	private String summary;
	/**
	 * 阅读数量
	 */
	private Integer readCount;
	/**
	 * 点赞数
	 */
	private Integer likeCount;
	/**
	 * 评论数
	 */
	private Integer commentCount;
	/**
	 * 0未置顶  1:已置顶
	 */
	private Integer top;
	/**
	 * 0:不显示  1:显示 
	 */
	private Integer status;
	/**
	 * 发布时间
	 */
	private Date createAt;
	/**
	 * 最后更新时间
	 */
	private Date updateAt;

}
