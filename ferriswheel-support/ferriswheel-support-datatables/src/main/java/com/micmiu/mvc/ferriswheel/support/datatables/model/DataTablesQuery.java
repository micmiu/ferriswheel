package com.micmiu.mvc.ferriswheel.support.datatables.model;


import com.micmiu.mvc.ferriswheel.core.model.AbstractQuery;
import com.micmiu.mvc.ferriswheel.core.model.SortType;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * extend query support for datatables plugin
 *
 * @author <a href="http://www.micmiu.com">Michael</a>
 * @version 1.0
 */
public abstract class DataTablesQuery extends AbstractQuery {

	private int iDisplayLength = DEFAULT_ITEMS_PERPAGE;
	private int iDisplayStart = 0;

	private String sortName;
	private String sortType;

	private int sEcho = 1;

	public int getsEcho() {
		return sEcho;
	}

	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}

	public int getiDisplayLength() {
		return iDisplayLength;
	}

	public void setiDisplayLength(int iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public int getiDisplayStart() {
		return iDisplayStart;
	}

	public void setiDisplayStart(int iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	public String getSortName() {
		return sortName;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	@Override
	public int getPageNo() {
		return this.iDisplayStart / this.iDisplayLength + 1;
	}

	@Override
	public int getPageRows() {
		return this.getiDisplayLength();
	}

	@Override
	public int getStartIndex() {
		return this.iDisplayStart;
	}

	public Map<String, SortType> getSortProperties() {
		// 排序字段有先后顺序, 必须采用LinkedHashMap
		Map<String, SortType> sortProperties = new LinkedHashMap<String, SortType>();
		if (null == this.getSortName()) {
			return sortProperties;
		}
		if ("desc".equalsIgnoreCase(this.sortType)) {
			sortProperties.put(this.getSortName(), SortType.DESC);
		} else {
			sortProperties.put(this.getSortName(), SortType.ASC);
		}
		return sortProperties;
	}

}
