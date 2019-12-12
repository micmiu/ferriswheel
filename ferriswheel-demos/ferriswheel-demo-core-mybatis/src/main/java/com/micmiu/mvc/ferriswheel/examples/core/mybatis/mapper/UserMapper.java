package com.micmiu.mvc.ferriswheel.examples.core.mybatis.mapper;

import com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity.User;
import com.micmiu.mvc.ferriswheel.orm.mybatis.mapper.GenerateMapper;

public interface UserMapper extends GenerateMapper<User, Long> {
	Integer selectCountAll();

	User selectOneByLoginName(String loginName);

	User selectOneExtByLoginName(String loginName);
}