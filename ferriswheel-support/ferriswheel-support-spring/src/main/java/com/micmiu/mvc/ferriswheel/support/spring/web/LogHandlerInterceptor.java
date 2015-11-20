package com.micmiu.mvc.ferriswheel.support.spring.web;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 增加日志拦截器
 *
 * @author <a href="http://www.micmiu.com">Michael</a>
 * @version 1.0
 * @time Create on 2013-9-4 上午9:59:09
 */
public class LogHandlerInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(LogHandlerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		LOGGER.debug("SESSION={} pre handler={}", request.getSession().getId(), handler.toString());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		LOGGER.debug("SESSION={} post handler={}", request.getSession().getId(), handler.toString());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			String clazzName = handlerMethod.getBean().getClass()
					.getSimpleName();
			String methodName = handlerMethod.getMethod().getName();
			Object obj = SecurityUtils.getSubject().getPrincipal();
			if (null != obj) {
				LOGGER.debug(String.format(
						">>>> afterCompletion : [%s] execute class %s's method %s", obj.toString(), clazzName, methodName));
			} else {
				LOGGER.debug(String.format(
						">>>> afterCompletion : [anonymous] execute class %s's method %s", clazzName, methodName));
			}
		}

	}
}
