package com.micmiu.mvc.ferriswheel.support.spring;

import org.springframework.context.ApplicationContext;

/**
 * spring 上下文工具栏
 * 
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class SpringContextUtil {
	private static ApplicationContext applicationContext;
	private static String contextName;
	private static String realPath;
	private static String serverInfo;

	/**
	 * @return the applicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * @return the contextName
	 */
	public static String getContextName() {
		return contextName;
	}

	/**
	 * @return the realPath
	 */
	public static String getRealPath() {
		return realPath;
	}

	/**
	 * @return the serverInfo
	 */
	public static String getServerInfo() {
		return serverInfo;
	}

	/**
	 * @param pApplicationContext the applicationContext to set
	 */
	public static void setApplicationContext(
			ApplicationContext pApplicationContext) {
		applicationContext = pApplicationContext;
	}

	/**
	 * @param pContextName the contextName to set
	 */
	public static void setContextName(String pContextName) {
		contextName = pContextName;
	}

	/**
	 * @param pRealPath the realPath to set
	 */
	public static void setRealPath(String pRealPath) {
		realPath = pRealPath;
	}

	/**
	 * @param pServerInfo the serverInfo to set
	 */
	public static void setServerInfo(String pServerInfo) {
		serverInfo = pServerInfo;
	}

}
