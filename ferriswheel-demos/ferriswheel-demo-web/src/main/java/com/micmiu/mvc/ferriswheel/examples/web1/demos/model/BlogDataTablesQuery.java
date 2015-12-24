package com.micmiu.mvc.ferriswheel.examples.web1.demos.model;


import com.micmiu.mvc.ferriswheel.core.annotation.QueryProperty;
import com.micmiu.mvc.ferriswheel.support.datatables.model.DataTablesQuery;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class BlogDataTablesQuery extends DataTablesQuery {

	private String title;

	@QueryProperty
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
