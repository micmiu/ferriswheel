package com.micmiu.mvc.ferriswheel.orm.mybatis.mapper;

import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;

import java.io.Serializable;
import java.util.List;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 5/26/2014
 * Time: 17:58
 */
public interface MybatisMapper<E extends FerriswheelID, ID extends Serializable> {

	void create(E entity);

	E read(ID id);

	void update(E entity);

	void delete(ID id);

	List<E> queryAll();
}
