package com.micmiu.mvc.ferriswheel.examples.simple.model;


import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class TreeNode {

	private String id;

	private String text;

	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private String iconCls;

	private Boolean state = true;

	private Boolean checked = false;

	private List<TreeNode> children = new ArrayList<TreeNode>();

	public String getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	public String getIconCls() {
		return iconCls;
	}

	public Boolean getState() {
		return state;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

}
