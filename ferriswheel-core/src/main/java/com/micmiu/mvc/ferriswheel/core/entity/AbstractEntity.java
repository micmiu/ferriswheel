package com.micmiu.mvc.ferriswheel.core.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 6/11/2014
 * Time: 14:18
 */
public abstract class AbstractEntity<ID extends Serializable> implements FerriswheelID {

	public abstract ID getId();

	/**
	 * Sets the id of the entity.
	 *
	 * @param id the id to set
	 */
	public abstract void setId(final ID id);


	@Override
	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!getClass().equals(obj.getClass())) {
			return false;
		}
		AbstractEntity<?> that = (AbstractEntity<?>) obj;
		return null == this.getId() ? false : this.getId().equals(that.getId());
	}

	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode += null == getId() ? 0 : getId().hashCode() * 31;
		return hashCode;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


}
