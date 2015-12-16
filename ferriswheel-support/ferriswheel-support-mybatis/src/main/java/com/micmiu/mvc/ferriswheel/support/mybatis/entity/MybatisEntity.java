package com.micmiu.mvc.ferriswheel.support.mybatis.entity;

import java.io.Serializable;

/**
 * 泛型Entity
 * 如果继承该Entity需要在 *Mapper.xml中指定jdbcType，比如 jdbcType="Long"
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 12/16/2015
 * Time: 11:16
 */
public abstract class MybatisEntity<ID extends Serializable> extends AbstractEntity<ID> {
	protected ID id;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
}
