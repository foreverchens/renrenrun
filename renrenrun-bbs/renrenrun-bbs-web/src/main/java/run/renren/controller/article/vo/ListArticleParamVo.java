package run.renren.controller.article.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yyy
 * @tg t.me/ychen5325
 */
@Data
public class ListArticleParamVo {
	private Integer boardId;
	@NotNull
	private Integer parBoardId;
	private Integer orderType;
	private Integer pageNo;
}
