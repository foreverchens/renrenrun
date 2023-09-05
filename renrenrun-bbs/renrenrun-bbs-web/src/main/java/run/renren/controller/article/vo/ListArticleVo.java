package run.renren.controller.article.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@Data
public class ListArticleVo {
	private Integer articleId;
	private Integer boardId;
	private String boardName;
	private Integer parBoardId;
	private String parBoardName;
	private Integer userId;
	private String nickName;
	private String title;
	private String cover;
	private String summary;
	private Integer readCount;
	private Integer likeCount;
	private Integer commentCount;
	private Integer top;
	private Date updateAt;
}
