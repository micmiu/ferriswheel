package com.micmiu.mvc.ferriswheel.examples.web2.simple.model;


import com.micmiu.mvc.ferriswheel.core.annotation.ShowParam;

/**
 * Description: 角色VO
 *
 * @author <a href="http://www.micmiu.com">Michael</a>
 * @version 1.0
 * @time Create on 2013-6-21 下午3:25:47
 * @see <a href="http://www.micmiu.com">http://www.micmiu.com</a>
 */
public class RoleVo {

	private Long id;

	@ShowParam("system.role.roleNamee")
	private String roleName;

	@ShowParam(value = "system.role.nodes", width = 500)
	private String permissionNames;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPermissionNames() {
		return permissionNames;
	}

	public void setPermissionNames(String permissionNames) {
		this.permissionNames = permissionNames;
	}

}
