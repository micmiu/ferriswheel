package com.micmiu.mvc.ferriswheel.support.easyui.vo;

/**
 * 用于easyui datagrid 自动生成列属性
 * 
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 * 
 */
public class GridColumn {

	private String field;

	private String title;

	private Integer width;

	private Boolean sortable;

	private String align;

	public String getField() {
		return field;
	}

	public String getTitle() {
		return title;
	}

	public Integer getWidth() {
		return width;
	}

	public Boolean getSortable() {
		return sortable;
	}

	public String getAlign() {
		return align;
	}

	public void setField(String field) {
		this.field = field;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public void setSortable(Boolean sortable) {
		this.sortable = sortable;
	}

	public void setAlign(String align) {
		this.align = align;
	}

}
