package com.micmiu.mvc.ferriswheel.examples.core.mapper;


import com.micmiu.mvc.ferriswheel.examples.core.entity.User;
import com.micmiu.mvc.ferriswheel.orm.mybatis.mapper.GenerateMapper;

/**
 * User: <a href="http://micmiu.com">micmiu</a>
 */
public interface UserMapper extends GenerateMapper<User, Long> {

	Integer selectCountAll();

	User findUserByLoginName(String loginName);
}