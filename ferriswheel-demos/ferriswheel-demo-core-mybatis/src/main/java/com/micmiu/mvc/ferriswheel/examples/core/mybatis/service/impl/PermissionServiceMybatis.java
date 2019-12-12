package com.micmiu.mvc.ferriswheel.examples.core.mybatis.service.impl;

import com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity.Permission;
import com.micmiu.mvc.ferriswheel.examples.core.mybatis.mapper.PermissionMapper;
import com.micmiu.mvc.ferriswheel.examples.core.mybatis.service.PermissionService;
import com.micmiu.mvc.ferriswheel.orm.mybatis.mapper.GenerateMapper;
import com.micmiu.mvc.ferriswheel.orm.mybatis.service.AbstractGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 6/29/2017
 * Time: 16:13
 */
@Service
public class PermissionServiceMybatis extends AbstractGenerateService<Permission, Long> implements PermissionService{

	@Autowired
	private PermissionMapper mapper;

	@Override
	public GenerateMapper<Permission, Long> getMapper() {
		return mapper;
	}

	@Override
	public Integer selectCountAll() {
		return mapper.selectCountAll();
	}
}
