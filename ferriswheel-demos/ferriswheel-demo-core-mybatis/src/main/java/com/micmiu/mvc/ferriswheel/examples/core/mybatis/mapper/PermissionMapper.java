package com.micmiu.mvc.ferriswheel.examples.core.mybatis.mapper;

import com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity.Permission;
import com.micmiu.mvc.ferriswheel.orm.mybatis.mapper.GenerateMapper;

public interface PermissionMapper extends GenerateMapper<Permission, Long> {
    Integer selectCountAll();
}