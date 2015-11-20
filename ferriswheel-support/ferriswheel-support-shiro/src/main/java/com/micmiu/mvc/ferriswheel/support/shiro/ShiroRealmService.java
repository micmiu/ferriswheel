package com.micmiu.mvc.ferriswheel.support.shiro;

import java.util.List;

/**
 * 用户鉴权的service
 * 
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 * 
 */
public interface ShiroRealmService {

	/**
	 * 找到登陆用户的信息[登陆名、姓名、密码]
	 * 
	 * @param username
	 * @return
	 */
	public String[] findLoginUser(String username);

	/**
	 * 查询用户的权限列表
	 * 
	 * @param username
	 * @return
	 */
	public List<ShiroPermissible> queryUserPermission(String username);
}
