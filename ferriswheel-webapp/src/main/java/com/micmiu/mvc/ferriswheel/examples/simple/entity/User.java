package com.micmiu.mvc.ferriswheel.examples.simple.entity;


import com.micmiu.mvc.ferriswheel.core.annotation.ShowParam;
import com.micmiu.mvc.ferriswheel.support.hibernate.BaseJpaEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 用户.
 * 
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Entity
@Table(name = "T_SYS_USER")
public class User extends BaseJpaEntity<Long> {

	@ShowParam("system.user.loginName")
	@Column(name = "LOGIN_NAME")
	private String loginName;

	@Column(name = "PASSWORD")
	private String password;

	@ShowParam("system.user.name")
	@Column(name = "NAME")
	private String name;

	@ShowParam(value = "system.user.email", width = 120)
	@Column(name = "EMAIL")
	private String email;

	@ShowParam("system.user.other")
	@Column(name = "OTHER")
	private String other;

	private String roleId;

	private List<Role> roleList = new ArrayList<Role>();

	// 多对多定义
	@ManyToMany
	@JoinTable(name = "T_SYS_U2R", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	// Fecth策略定义
	@Fetch(FetchMode.SUBSELECT)
	// 集合按id排序.
	@OrderBy("id")
	// 集合中对象id的缓存.
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<Role> getRoleList() {
		return roleList;
	}

	@ShowParam(value = "system.user.rolename", width = 200)
	@Transient
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

	@Transient
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