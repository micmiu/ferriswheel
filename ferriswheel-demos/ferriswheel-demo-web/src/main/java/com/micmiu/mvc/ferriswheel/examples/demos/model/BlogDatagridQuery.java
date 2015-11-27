package com.micmiu.mvc.ferriswheel.examples.demos.model;


import com.micmiu.mvc.ferriswheel.core.annotation.QueryPropery;
import com.micmiu.mvc.ferriswheel.support.easyui.vo.DatagridQuery;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class BlogDatagridQuery extends DatagridQuery {

	private String title;

	@QueryPropery
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
