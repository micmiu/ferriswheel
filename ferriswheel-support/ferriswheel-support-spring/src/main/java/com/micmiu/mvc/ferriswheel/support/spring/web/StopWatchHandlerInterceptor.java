package com.micmiu.mvc.ferriswheel.support.spring.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 执行性能监控
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 8/25/2014
 * Time: 16:44
 */
public class StopWatchHandlerInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(StopWatchHandlerInterceptor.class);

	private boolean usePerformance = true;

	private long thresholdTimes = 500;

	private NamedThreadLocal<StopWatch> stopWatchLocal = new NamedThreadLocal<StopWatch>("StopWatchInterceptor");

	public StopWatchHandlerInterceptor() {
		super();
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		if (usePerformance) {
			StopWatch stopWatch = new StopWatch(handler.toString());
			stopWatchLocal.set(stopWatch);
			stopWatch.start(handler.toString());
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		if (usePerformance) {
			StopWatch stopWatch = stopWatchLocal.get();
			stopWatch.stop();
			String requestURI = request.getRequestURI();
			String queryString = request.getQueryString();
			queryString = queryString == null ? "" : "?" + queryString;
			LOGGER.info("access URL:{} | consume time:{} millis.", requestURI + queryString, stopWatch.getTotalTimeMillis());
			if (stopWatch.getTotalTimeMillis() > thresholdTimes) {
				LOGGER.warn("access URL:{} | consume time:{} millis > " + thresholdTimes, requestURI + queryString, stopWatch.getTotalTimeMillis());
			}
			stopWatchLocal.set(null);
		}
	}

}