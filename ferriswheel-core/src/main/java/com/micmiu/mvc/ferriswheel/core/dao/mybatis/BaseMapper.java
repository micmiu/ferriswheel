package com.micmiu.mvc.ferriswheel.core.dao.mybatis;

import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;

import java.io.Serializable;

/**
 * Base mapper for mybatis
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 5/26/2014
 * Time: 17:58
 */
public interface BaseMapper<E extends FerriswheelID, ID extends Serializable> {

	int deleteByPrimaryKey(ID id);

	int insert(E record);

	int insertSelective(E record);

	E selectByPrimaryKey(ID id);

	int updateByPrimaryKeySelective(E record);

	int updateByPrimaryKeyWithBLOBs(E record);

	int updateByPrimaryKey(E record);
}
