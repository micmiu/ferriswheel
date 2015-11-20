package com.micmiu.mvc.ferriswheel.support.spring.web;

import com.micmiu.mvc.ferriswheel.support.spring.SpringContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 8/15/2014
 * Time: 15:43
 */
public class FerriswheelContextLoaderListener extends org.springframework.web.context.ContextLoaderListener {

	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);

		ServletContext context = event.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		SpringContextUtil.setApplicationContext(ctx);
		String contextName = context.getServletContextName();
		String realPath = context.getRealPath("/");
		String serverInfo = context.getServerInfo();
		SpringContextUtil.setContextName(contextName);
		SpringContextUtil.setRealPath(realPath);
		SpringContextUtil.setServerInfo(serverInfo);
	}

}
