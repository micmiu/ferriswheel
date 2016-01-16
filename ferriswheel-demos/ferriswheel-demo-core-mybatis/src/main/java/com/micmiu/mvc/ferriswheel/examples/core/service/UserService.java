package com.micmiu.mvc.ferriswheel.examples.core.service;

import com.micmiu.mvc.ferriswheel.examples.core.entity.User;
import com.micmiu.mvc.ferriswheel.orm.mybatis.service.GenerateService;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 1/8/2016
 * Time: 23:11
 */
public interface UserService extends GenerateService<User, Long> {

	Integer selectCountAll();

	User findUserByLoginName(String loginName);
}
