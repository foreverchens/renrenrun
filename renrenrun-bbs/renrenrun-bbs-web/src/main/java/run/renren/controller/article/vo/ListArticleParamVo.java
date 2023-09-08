package run.renren.controller.article.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@Data
public class ListArticleParamVo {
	@NotNull
	private Integer boardId;
	private Integer parBoardId;
	@NotNull
	private Integer orderType;
	private Integer pageNo;
}
