package com.micmiu.mvc.ferriswheel.examples.core.mapper;


import com.micmiu.mvc.ferriswheel.examples.core.entity.Menu;

public interface MenuMapper {

	int deleteByPrimaryKey(Long id);

	int insert(Menu record);

	int insertSelective(Menu record);

	Menu selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Menu record);

	int updateByPrimaryKey(Menu record);
}