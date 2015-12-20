package com.micmiu.mvc.ferriswheel.support.mybatis.entity;

import java.util.ArrayList;
import java.util.List;

public class Role extends MybatisEntity<Long> {

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
