package com.micmiu.mvc.ferriswheel.examples.system2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * use for ztree json data
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 12/7/2015
 * Time: 14:41
 */
public class ZtreeNode implements Serializable {

	private static final long serialVersionUID = -1538240719571310842L;

	private String id;
	private String pId;
	private String name;
	private Boolean open;
	private Boolean checked;

	private List<ZtreeNode> children = new ArrayList<ZtreeNode>();

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public List<ZtreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<ZtreeNode> children) {
		this.children = children;
	}
}
