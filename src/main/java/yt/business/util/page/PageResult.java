package yt.business.util.page;

import lombok.Data;

import java.util.List;

/**
 * @author yunteng
 */
@Data
public class PageResult<E> {
	Integer total;
	Integer page;
	Integer limit;
	List<E> list;

}
