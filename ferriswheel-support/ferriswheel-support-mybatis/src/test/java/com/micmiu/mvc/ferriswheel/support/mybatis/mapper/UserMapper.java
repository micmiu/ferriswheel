package com.micmiu.mvc.ferriswheel.support.mybatis.mapper;

import com.micmiu.mvc.ferriswheel.support.mybatis.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}