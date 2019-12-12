package com.micmiu.mvc.ferriswheel.examples.core.mybatis.service.impl;

import com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity.Role;
import com.micmiu.mvc.ferriswheel.examples.core.mybatis.mapper.RoleMapper;
import com.micmiu.mvc.ferriswheel.examples.core.mybatis.service.RoleService;
import com.micmiu.mvc.ferriswheel.orm.mybatis.mapper.GenerateMapper;
import com.micmiu.mvc.ferriswheel.orm.mybatis.service.AbstractGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 6/29/2017
 * Time: 16:14
 */
@Service
public class RoleServiceMybatis extends AbstractGenerateService<Role, Long> implements RoleService {

	@Autowired
	private RoleMapper mapper;

	@Override
	public GenerateMapper<Role, Long> getMapper() {
		return mapper;
	}

	@Override
	public Integer selectCountAll() {
		return mapper.selectCountAll();
	}

	@Override
	public Role selectOneExtById(Long id) {
		return mapper.selectOneExtById(id);
	}
}
