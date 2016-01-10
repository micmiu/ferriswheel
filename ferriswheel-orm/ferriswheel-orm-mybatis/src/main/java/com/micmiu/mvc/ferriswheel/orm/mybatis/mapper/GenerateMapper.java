package com.micmiu.mvc.ferriswheel.orm.mybatis.mapper;

import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;

import java.io.Serializable;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 */
public interface GenerateMapper<E extends FerriswheelID, ID extends Serializable> {

	int deleteByPrimaryKey(ID id);

	int insert(E record);

	int insertSelective(E record);

	E selectByPrimaryKey(ID id);

	int updateByPrimaryKeySelective(E record);

	int updateByPrimaryKey(E record);
}
