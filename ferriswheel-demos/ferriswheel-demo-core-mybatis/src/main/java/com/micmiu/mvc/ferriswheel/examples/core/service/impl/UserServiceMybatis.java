package com.micmiu.mvc.ferriswheel.examples.core.service.impl;

import com.micmiu.mvc.ferriswheel.examples.core.entity.User;
import com.micmiu.mvc.ferriswheel.examples.core.mapper.UserMapper;
import com.micmiu.mvc.ferriswheel.examples.core.service.UserService;
import com.micmiu.mvc.ferriswheel.orm.mybatis.mapper.GenerateMapper;
import com.micmiu.mvc.ferriswheel.orm.mybatis.service.AbstractGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 1/16/2016
 * Time: 22:04
 */
@Service
public class UserServiceMybatis extends AbstractGenerateService<User, Long> implements UserService {

	@Autowired
	private UserMapper mapper;

	@Override
	public GenerateMapper<User, Long> getMapper() {
		return mapper;
	}

	@Override
	public Integer selectCountAll() {
		return mapper.selectCountAll();
	}

	@Override
	public User findUserByLoginName(String loginName) {
		return mapper.findUserByLoginName(loginName);
	}
}
