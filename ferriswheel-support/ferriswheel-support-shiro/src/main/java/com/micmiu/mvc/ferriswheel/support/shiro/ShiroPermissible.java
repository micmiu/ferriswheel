package com.micmiu.mvc.ferriswheel.support.shiro;

/**
 * 权限接口
 * 
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 * 
 */
public interface ShiroPermissible {

	/**
	 * 获取权限字符串
	 * 
	 * @return
	 */
	public String getPermOperation();
}
