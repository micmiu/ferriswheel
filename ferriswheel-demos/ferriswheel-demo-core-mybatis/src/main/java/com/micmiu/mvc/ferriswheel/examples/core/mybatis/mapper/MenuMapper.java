package com.micmiu.mvc.ferriswheel.examples.core.mybatis.mapper;


import com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity.Menu;
import com.micmiu.mvc.ferriswheel.orm.mybatis.mapper.GenerateMapper;

/**
 * User: <a href="http://micmiu.com">micmiu</a>
 */
public interface MenuMapper extends GenerateMapper<Menu, Long> {
	Integer selectCountAll();
}