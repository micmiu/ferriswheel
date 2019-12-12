package com.micmiu.mvc.ferriswheel.examples.web3.simple.model;


import com.micmiu.mvc.ferriswheel.core.annotation.QueryProperty;
import com.micmiu.mvc.ferriswheel.support.jqgrid.model.JqgridQuery;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class RoleJqgridQuery extends JqgridQuery {

	private String roleName;

	@QueryProperty
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
