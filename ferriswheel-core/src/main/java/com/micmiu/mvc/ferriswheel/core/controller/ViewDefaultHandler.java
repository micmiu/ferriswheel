package com.micmiu.mvc.ferriswheel.core.controller;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 12/10/2015
 * Time: 13:22
 */
public class ViewDefaultHandler implements ViewHandler {

	private String viewStyle = "bootstrap";

	private String viewPrefix = "bootstrap";

	private String viewDelimiter = "_";

	private String viewLayout = "/";


	public String getViewDelimiter() {
		return viewDelimiter;
	}

	public void setViewDelimiter(String viewDelimiter) {
		this.viewDelimiter = viewDelimiter;
	}

	public String getViewLayout() {
		return viewLayout;
	}

	public void setViewLayout(String viewLayout) {
		this.viewLayout = viewLayout;
	}

	public String getViewPrefix() {
		return viewPrefix;
	}

	public void setViewPrefix(String viewPrefix) {
		this.viewPrefix = viewPrefix;
	}

	public String getViewStyle() {
		return viewStyle;
	}

	public void setViewStyle(String viewStyle) {
		this.viewStyle = viewStyle;
	}
}
