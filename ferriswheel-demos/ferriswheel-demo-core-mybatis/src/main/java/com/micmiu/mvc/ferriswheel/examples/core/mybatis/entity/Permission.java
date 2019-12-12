package com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.micmiu.mvc.ferriswheel.orm.mybatis.entity.IdLongEntity;
import com.micmiu.mvc.ferriswheel.support.shiro.ShiroPermissible;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class Permission extends IdLongEntity implements ShiroPermissible {

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

	@JsonBackReference
	public Menu getMenu() {
		return menu;
	}

	@Override
	public String getPermOperation() {
		return this.getResName() + ":" + this.getOperation();
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
