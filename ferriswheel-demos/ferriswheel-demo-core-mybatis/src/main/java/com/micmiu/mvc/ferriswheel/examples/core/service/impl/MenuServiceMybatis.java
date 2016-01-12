package com.micmiu.mvc.ferriswheel.examples.core.service.impl;

import com.micmiu.mvc.ferriswheel.examples.core.entity.Menu;
import com.micmiu.mvc.ferriswheel.examples.core.mapper.MenuMapper;
import com.micmiu.mvc.ferriswheel.examples.core.service.MenuService;
import com.micmiu.mvc.ferriswheel.orm.mybatis.mapper.GenerateMapper;
import com.micmiu.mvc.ferriswheel.orm.mybatis.service.AbstractGenerateService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 1/8/2016
 * Time: 23:14
 */
public class MenuServiceMybatis extends AbstractGenerateService<Menu, Long> implements MenuService {

	@Autowired
	private MenuMapper mapper;

	@Override
	public GenerateMapper<Menu, Long> getMapper() {
		return mapper;
	}

	@Override
	public Integer selectCountAll() {
		return mapper.selectCountAll();
	}
}
