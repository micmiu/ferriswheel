package com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity;

import com.micmiu.mvc.ferriswheel.core.annotation.ShowParam;
import com.micmiu.mvc.ferriswheel.orm.mybatis.entity.IdLongEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class Role extends IdLongEntity {

	@ShowParam("system.role.roleName")
	private String roleName;

	private List<Permission> permissions = new ArrayList<Permission>();

	public String getRoleName() {
		return roleName;
	}

	/**
	 * 操作权限集合.
	 */
	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
