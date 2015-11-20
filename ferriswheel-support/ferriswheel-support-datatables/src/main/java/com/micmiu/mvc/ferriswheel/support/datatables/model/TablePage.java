package com.micmiu.mvc.ferriswheel.support.datatables.model;


import com.micmiu.mvc.ferriswheel.core.model.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * extend page support for datatables plugin show result
 *
 * @author <a href="http://www.micmiu.com">Michael</a>
 * @version 1.0
 */
public class TablePage<T> extends Page<T> {

	private int sEcho = 1;

	private int iTotalRecords = 0;

	private int iTotalDisplayRecords = 0;

	private List<T> aaData = new ArrayList<T>();

	/**
	 * 构造函数．
	 */
	public TablePage() {
	}

	/**
	 * 构造函数．
	 *
	 * @param page
	 */
	public TablePage(Page<T> page) {
		try {
			this.sEcho = page.getsEcho();
			this.aaData = page.getPageList();
			this.iTotalDisplayRecords = (int) page.getTotalCount();
			this.iTotalRecords = (int) page.getTotalCount();
		} catch (Exception e) {
		}
	}

	public int getsEcho() {
		return sEcho;
	}

	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}

	public int getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public List<T> getAaData() {
		return aaData;
	}

	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}

}
