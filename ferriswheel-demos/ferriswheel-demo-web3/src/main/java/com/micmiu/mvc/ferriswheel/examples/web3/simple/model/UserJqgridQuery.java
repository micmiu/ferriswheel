package com.micmiu.mvc.ferriswheel.examples.web3.simple.model;


import com.micmiu.mvc.ferriswheel.core.annotation.QueryProperty;
import com.micmiu.mvc.ferriswheel.support.jqgrid.model.JqgridMultiSearchQuery;

/**
 * 用户查询条件.
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class UserJqgridQuery extends JqgridMultiSearchQuery {

	private String loginName;

	private String name;

	private String email;

	private Long roleId;

	/**
	 * 获取查询用户名.
	 *
	 * @return loginName
	 */
	@QueryProperty
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 设置查询用户名.
	 *
	 * @param loginName 用户名
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * 获取查询用户姓名.
	 *
	 * @return 用户姓名
	 */
	@QueryProperty
	public String getName() {
		return name;
	}

	/**
	 * 设置查询用户姓名.
	 *
	 * @param name 用户姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	@QueryProperty
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@QueryProperty
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
