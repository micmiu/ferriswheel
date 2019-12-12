package com.micmiu.mvc.ferriswheel.examples.core.mybatis.service.impl;

import com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity.User;
import com.micmiu.mvc.ferriswheel.examples.core.mybatis.mapper.UserMapper;
import com.micmiu.mvc.ferriswheel.examples.core.mybatis.service.UserService;
import com.micmiu.mvc.ferriswheel.orm.mybatis.mapper.GenerateMapper;
import com.micmiu.mvc.ferriswheel.orm.mybatis.service.AbstractGenerateService;
import com.micmiu.mvc.ferriswheel.support.shiro.ShiroPermissible;
import com.micmiu.mvc.ferriswheel.support.shiro.ShiroRealmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 6/29/2017
 * Time: 16:14
 */
@Service
public class UserServiceMybatis extends AbstractGenerateService<User, Long> implements UserService, ShiroRealmService {

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
	public User selectOneByLoginName(String loginName) {
		return mapper.selectOneByLoginName(loginName);
	}

	@Override
	public String[] findLoginUser(String username) {
		User user = this.selectOneByLoginName(username);
		if (null == user) {
			return null;
		} else {
			return new String[]{user.getLoginName(), user.getName(),
					user.getPassword()};
		}
	}


	@Override
	public List<ShiroPermissible> queryUserPermission(String username) {
		return null;
	}
}
