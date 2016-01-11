package com.micmiu.mvc.ferriswheel.orm.mybatis.service;

import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;

import java.io.Serializable;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 1/11/2016
 * Time: 23:00
 */
public abstract class AbstractGenerateService<T extends FerriswheelID, ID extends Serializable> implements GenerateService<T,ID> {

	public abstract GenerateService<T, ID> getMapper() ;

	@Override
	public int deleteByPrimaryKey(ID id) {
		return getMapper().deleteByPrimaryKey(id);
	}

	@Override
	public int insert(T record) {
		return getMapper().insert(record);
	}

	@Override
	public int insertSelective(T record) {
		return getMapper().insertSelective(record);
	}

	@Override
	public T selectByPrimaryKey(ID id) {
		return getMapper().selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		return getMapper().updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(T record) {
		return getMapper().updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		return getMapper().updateByPrimaryKey(record);
	}
}
