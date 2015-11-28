package com.micmiu.mvc.ferriswheel.examples.demos.jqgrid.model;


import com.micmiu.mvc.ferriswheel.core.model.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * extend page support for jqgrid
 *
 * @author <a href="http://www.micmiu.com">Michael</a>
 */
public class JqgridPage<T> extends Page<T> {

	/**
	 * 当前页码
	 */
	private int page = 1;

	/**
	 * 总页码数
	 */
	private long total = 0;

	/**
	 * 总记录数
	 */
	private long records = 0;

	/**
	 * 数据
	 */
	private List<T> rows = new ArrayList<T>();

	/**
	 * 构造函数．
	 */
	public JqgridPage() {
	}

	/**
	 * 构造函数．
	 *
	 * @param page
	 */
	public JqgridPage(Page<T> page) {
		try {
			this.page = page.getCurrentPage();
			this.records = page.getTotalCount();
			this.total = page.getPageCount();
			this.rows = page.getPageList();
		} catch (Exception e) {
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public long getRecords() {
		return records;
	}

	public void setRecords(long records) {
		this.records = records;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
