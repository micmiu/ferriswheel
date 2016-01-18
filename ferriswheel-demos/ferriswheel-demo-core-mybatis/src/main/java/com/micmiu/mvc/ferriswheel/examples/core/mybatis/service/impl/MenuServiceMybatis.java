package com.micmiu.mvc.ferriswheel.examples.core.mybatis.service.impl;

import com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity.Menu;
import com.micmiu.mvc.ferriswheel.examples.core.mybatis.mapper.MenuMapper;
import com.micmiu.mvc.ferriswheel.examples.core.mybatis.service.MenuService;
import com.micmiu.mvc.ferriswheel.orm.mybatis.mapper.GenerateMapper;
import com.micmiu.mvc.ferriswheel.orm.mybatis.service.AbstractGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 1/8/2016
 * Time: 23:14
 */
@Service
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
