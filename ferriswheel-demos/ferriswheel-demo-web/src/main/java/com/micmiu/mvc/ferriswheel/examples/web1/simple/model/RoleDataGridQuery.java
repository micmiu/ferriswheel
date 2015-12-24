package com.micmiu.mvc.ferriswheel.examples.web1.simple.model;


import com.micmiu.mvc.ferriswheel.core.annotation.QueryProperty;
import com.micmiu.mvc.ferriswheel.support.easyui.vo.DatagridQuery;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class RoleDataGridQuery extends DatagridQuery {

	private String roleName;

	@QueryProperty
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
