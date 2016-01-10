package com.micmiu.mvc.ferriswheel.examples.core.mapper;


import com.micmiu.mvc.ferriswheel.examples.core.entity.Menu;
import com.micmiu.mvc.ferriswheel.orm.mybatis.mapper.GenerateMapper;

/**
 * User: <a href="http://micmiu.com">micmiu</a>
 */
public interface MenuMapper extends GenerateMapper<Menu, Long> {
	Integer selectCountAll();
}