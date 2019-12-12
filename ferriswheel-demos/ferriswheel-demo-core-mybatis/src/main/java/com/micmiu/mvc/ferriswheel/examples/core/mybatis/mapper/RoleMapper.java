package com.micmiu.mvc.ferriswheel.examples.core.mybatis.mapper;

import com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity.Role;
import com.micmiu.mvc.ferriswheel.orm.mybatis.mapper.GenerateMapper;

public interface RoleMapper extends GenerateMapper<Role, Long> {
	Integer selectCountAll();

	Role selectOneExtById(Long id);
}