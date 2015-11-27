package com.micmiu.mvc.ferriswheel.examples.simple.model;


import com.micmiu.mvc.ferriswheel.core.annotation.QueryPropery;
import com.micmiu.mvc.ferriswheel.support.datatables.model.TableQuery;

/**
 * 用户查询条件.
 * 
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class UserTableQuery extends TableQuery {

	private String loginName;

	private String name;

	private Long department;

	/**
	 * 获取查询用户名.
	 * 
	 * @return loginName
	 */
	@QueryPropery
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
	@QueryPropery
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

	/**
	 * 获取查询部门ID.
	 * 
	 * @return 查询部门ID
	 */
	@QueryPropery(name = "departmentId")
	public Long getDepartment() {
		return department;
	}

	/**
	 * 设置查询部门ID.
	 * 
	 * @param department 查询部门ID
	 */
	public void setDepartment(Long department) {
		this.department = department;
	}

}
