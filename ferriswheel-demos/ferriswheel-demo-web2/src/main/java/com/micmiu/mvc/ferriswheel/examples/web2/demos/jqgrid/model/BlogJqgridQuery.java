package com.micmiu.mvc.ferriswheel.examples.web2.demos.jqgrid.model;

import com.micmiu.mvc.ferriswheel.core.annotation.QueryPropery;
import com.micmiu.mvc.ferriswheel.support.jqgrid.model.JqgridQuery;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 11/29/2015
 * Time: 23:14
 */
public class BlogJqgridQuery extends JqgridQuery {

	private String title;

	@QueryPropery
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
