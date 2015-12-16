package com.micmiu.mvc.ferriswheel.support.mybatis.mapper;

import java.io.Serializable;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 12/15/2015
 * Time: 16:39
 */
public interface BaseMapper<E, ID extends Serializable> {
	int deleteByPrimaryKey(ID id);

	int insert(E record);

	int insertSelective(E record);

	E selectByPrimaryKey(ID id);

	int updateByPrimaryKeySelective(E record);

	int updateByPrimaryKeyWithBLOBs(E record);

	int updateByPrimaryKey(E record);
}