package com.micmiu.mvc.ferriswheel.orm.mybatis.entity;

import com.micmiu.mvc.ferriswheel.core.entity.AbstractEntity;

import java.io.Serializable;

/**
 * 泛型Entity
 * 如果继承该Entity需要在 *Mapper.xml中指定配置主键ID类型
 * 以Long为例：javaType="long" jdbcType="BIGINT"
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 12/16/2015
 * Time: 11:16
 */
public abstract class MybatisEntity<ID extends Serializable> extends AbstractEntity<ID> {
	protected ID id;

	/**
	 * 实体类需要重写次方法，否则报错 No typehandler Exception
	 *
	 * @return
	 */
	public abstract ID getId();

	public abstract void setId(ID id);
}
