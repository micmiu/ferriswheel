package com.micmiu.mvc.ferriswheel.support.spring.mvc;

import com.micmiu.mvc.ferriswheel.core.controller.BaseManageController;
import com.micmiu.mvc.ferriswheel.core.controller.ViewHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 */
public abstract class SpringAbstractController extends BaseManageController implements ControllerConstant {

	protected static Logger logger = LoggerFactory.getLogger(SpringAbstractController.class);

	@Autowired
	protected MessageSource messageSource;

	@Autowired
	protected ViewHandler viewHandler;


	private String urlPrefix;

	private String[] viewModules;

	@SuppressWarnings("unchecked")
	public SpringAbstractController() {
		setUrlPrefix(getDefaultUrlPrefix());
	}

	public String getUrlPrefix() {
		return urlPrefix;
	}

	public void setUrlPrefix(String urlPrefix) {
		if (null == urlPrefix) {
			return;
		}
		this.urlPrefix = urlPrefix;
		String url = urlPrefix;
		if (urlPrefix.startsWith("/")) {
			url = urlPrefix.substring(1);
		}
		if (url.endsWith(".do")) {
			url = url.substring(0, url.lastIndexOf('.'));
		}
		this.viewModules = url.split("/");
	}

	protected String getDefaultUrlPrefix() {
		String currentPrefix = "";
		RequestMapping requestMapping = AnnotationUtils.findAnnotation(getClass(), RequestMapping.class);
		if (requestMapping != null && requestMapping.value().length > 0) {
			currentPrefix = requestMapping.value()[0];
		}
		return currentPrefix;
	}

	@Override
	public String getViewModules() {
		return StringUtils.join(viewModules, viewHandler.getViewLayout());
	}

	@Override
	protected String getViewPrefix() {
		return viewHandler.getViewStyle() + viewHandler.getViewLayout() + getViewModules();
	}

	protected String getViewDelimiter() {
		return viewHandler.getViewDelimiter();
	}

	@Override
	protected void checkAuth(String operation) {

	}

	@Override
	protected String getRedirectView() {
		return null;
	}
}
