package run.renren.controller.article.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@Data
@Builder
public class ListArticleVo {


	private Integer totalCount;
	private Integer pageSize;
	private Integer pageNo;
	private Integer pageTotal;
	private List<ArticleItem> list;

	@Data
	public static class ArticleItem {
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
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
		private Date updateAt;
	}

}
