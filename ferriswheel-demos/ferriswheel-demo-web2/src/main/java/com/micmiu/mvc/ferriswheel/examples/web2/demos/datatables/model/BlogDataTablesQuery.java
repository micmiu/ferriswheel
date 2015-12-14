package com.micmiu.mvc.ferriswheel.examples.web2.demos.datatables.model;


import com.micmiu.mvc.ferriswheel.core.annotation.QueryPropery;
import com.micmiu.mvc.ferriswheel.support.datatables.model.DataTablesQuery;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class BlogDataTablesQuery extends DataTablesQuery {

	private String title;

	@QueryPropery
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
