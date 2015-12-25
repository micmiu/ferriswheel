package com.micmiu.mvc.ferriswheel.orm.mybatis.mapper;

import com.micmiu.mvc.ferriswheel.orm.mybatis.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}