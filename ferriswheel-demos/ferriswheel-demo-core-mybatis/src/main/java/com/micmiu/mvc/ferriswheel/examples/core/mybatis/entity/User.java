package com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.micmiu.mvc.ferriswheel.core.annotation.ShowParam;
import com.micmiu.mvc.ferriswheel.orm.mybatis.entity.IdLongEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户.
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class User extends IdLongEntity {

	@ShowParam("system.user.loginName")
	private String loginName;

	private String password;

	@ShowParam("system.user.name")
	private String name;

	@ShowParam(value = "system.user.email", width = 120)
	private String email;

	@ShowParam("system.user.other")
	private String other;

	private String roleId;

	private List<Role> roleList = new ArrayList<Role>();

	public List<Role> getRoleList() {
		return roleList;
	}

	@ShowParam(value = "system.user.rolename", width = 200)
	public String getRoleName() {
		List<String> roleNames = new ArrayList<String>();

		for (Role role : getRoleList()) {
			roleNames.add(role.getRoleName());
		}
		return StringUtils.join(roleNames, ",");
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public String getLoginName() {
		return loginName;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getOther() {
		return other;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getRoleId() {
		if (getRoleList().isEmpty()) {
			return null;
		}
		roleId = getRoleList().get(0).getId() + "";
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}