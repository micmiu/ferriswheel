package com.micmiu.mvc.ferriswheel.support.mybatis.entity;


import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class Permission extends MybatisEntity<Long>  {

	private String resName;

	private String resCnName;

	private String operation;

	private Menu menu;

	public String getResName() {
		return resName;
	}

	public String getOperation() {
		return operation;
	}

	public String getResCnName() {
		return resCnName;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setResCnName(String resCnName) {
		this.resCnName = resCnName;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
