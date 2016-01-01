package com.micmiu.mvc.ferriswheel.examples.core.service;


import com.micmiu.mvc.ferriswheel.core.service.BaseService;
import com.micmiu.mvc.ferriswheel.examples.core.entity.User;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public interface UserService extends BaseService<User, Long> {

	/**
	 * 根据登陆名查找用户
	 *
	 * @param loginName
	 * @return
	 */
	User getUserByLoginName(String loginName);
}
