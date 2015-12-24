package com.micmiu.mvc.ferriswheel.examples.web2.demos.jqgrid.model;

import com.micmiu.mvc.ferriswheel.core.annotation.QueryProperty;
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

	@QueryProperty
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@QueryProperty
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@QueryProperty
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@QueryProperty
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@QueryProperty
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
