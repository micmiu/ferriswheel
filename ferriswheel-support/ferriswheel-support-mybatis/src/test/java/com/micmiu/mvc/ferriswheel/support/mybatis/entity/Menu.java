package com.micmiu.mvc.ferriswheel.support.mybatis.entity;


import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */

public class Menu extends MybatisEntity<Long> {

	private String menuName;

	private String aliasName;

	private String menuURL;

	private String menuType;

	private Integer orderNum;

	private Set<Menu> children = new HashSet<Menu>();

	private Set<Permission> permssionList = new HashSet<Permission>();

	private Menu parent;

	public Menu getParent() {
		return parent;
	}


	public Set<Menu> getChildren() {
		return children;
	}

	public Set<Permission> getPermssionList() {
		return permssionList;
	}

	public void setPermssionList(Set<Permission> permssionList) {
		this.permssionList = permssionList;
	}

	public String getMenuName() {
		return menuName;
	}

	public String getAliasName() {
		return aliasName;
	}

	public String getMenuURL() {
		return menuURL;
	}

	public String getMenuType() {
		return menuType;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public void setChildren(Set<Menu> children) {
		this.children = children;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
