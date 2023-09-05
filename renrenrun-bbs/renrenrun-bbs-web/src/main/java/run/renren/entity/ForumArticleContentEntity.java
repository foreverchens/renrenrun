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
@TableName("forum_article_content")
public class ForumArticleContentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 文章Id
	 */
	@TableId
	private Integer articleId;
	/**
	 * 文章内容
	 */
	private String content;
	/**
	 * markdown格式
	 */
	private String contentMarkdown;

}
