package com.micmiu.mvc.ferriswheel.core.controller;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 7/4/2014
 * Time: 16:27
 */
public abstract class AbstractBaseController implements FerriswheelController {

	/**
	 * url前缀
	 *
	 * @return
	 */
	protected abstract String getUrlPrefix();

	/**
	 * view 前缀
	 *
	 * @return
	 */
	protected abstract String getViewPrefix();

	/**
	 * view 前缀
	 *
	 * @return
	 */
	protected abstract String getViewDelimiter();

	/**
	 * 返回重定向view
	 *
	 * @return
	 */
	protected abstract String getRedirectView();

	/**
	 * 权限检查
	 *
	 * @param operation
	 */
	protected abstract void checkAuth(String operation);


	/**
	 * view moudles
	 *
	 * @return
	 */
	protected abstract String getViewModules();
}
