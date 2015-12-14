package com.micmiu.mvc.ferriswheel.examples.web2.simple.model;


import com.micmiu.mvc.ferriswheel.core.annotation.QueryPropery;
import com.micmiu.mvc.ferriswheel.support.jqgrid.model.JqgridQuery;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class RoleJqgridQuery extends JqgridQuery {

	private String roleName;

	@QueryPropery
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
