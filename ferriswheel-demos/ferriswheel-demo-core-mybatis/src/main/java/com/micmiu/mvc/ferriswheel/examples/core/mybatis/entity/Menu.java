package com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity;


import com.micmiu.mvc.ferriswheel.orm.mybatis.entity.IdLongEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */

public class Menu extends IdLongEntity {

	private String menuName;

	private String aliasName;

	private String menuUrl;

	private String menuType;

	private Integer orderNum;

	private Long parentId;

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
