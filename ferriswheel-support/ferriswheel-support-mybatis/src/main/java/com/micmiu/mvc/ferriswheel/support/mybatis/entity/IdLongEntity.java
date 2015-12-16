package com.micmiu.mvc.ferriswheel.support.mybatis.entity;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 12/16/2015
 * Time: 14:39
 */
public class IdLongEntity extends MybatisEntity<Long> {

	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
