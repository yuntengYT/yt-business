package yt.business.util.page;

import lombok.Data;

/**
 * 分页参数
 *
 * @author zyt
 */
@Data
public class PageSearchParam {
	/**
	 * 默认数据
	 */
	public static final Integer PAGE = 1;
	public static final Integer LIMIT = 10;
	Integer page;
	Integer limit;
	/**
	 * 开始行数
	 */
	private Integer startRowNumber;

	public PageSearchParam(Integer page, Integer limit) {
		this.page = page;
		this.limit = limit;
	}

	public Integer getStartRowNumber() {
		if (this.page == null || this.limit == null) {
			return 0;
		}
		// (当前页码-1) * 每页读取长度
		return (this.page - 1) * limit;
	}
}
