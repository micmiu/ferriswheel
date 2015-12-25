package com.micmiu.mvc.ferriswheel.orm.mybatis.mapper;

import com.micmiu.mvc.ferriswheel.orm.mybatis.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}