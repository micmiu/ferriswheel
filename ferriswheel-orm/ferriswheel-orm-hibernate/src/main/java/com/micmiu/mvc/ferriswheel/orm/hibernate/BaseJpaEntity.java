package com.micmiu.mvc.ferriswheel.orm.hibernate;

import com.micmiu.mvc.ferriswheel.core.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 11/12/2015
 * Time: 15:13
 */
@MappedSuperclass
public abstract class BaseJpaEntity<ID extends Serializable> extends AbstractEntity<ID> {

	protected ID id;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	// @GeneratedValue(generator = "system-uuid")
	// @GenericGenerator(name = "system-uuid", strategy = "uuid")
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
}
