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

	private Long id;

	private String author;

	private String category;

	private String url;

	@QueryPropery
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@QueryPropery
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@QueryPropery
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@QueryPropery
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@QueryPropery
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
