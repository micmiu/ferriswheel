package com.micmiu.mvc.ferriswheel.examples.web1.demos.i18n.controller;

import com.micmiu.mvc.ferriswheel.core.controller.ViewHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 国际化演示
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Controller
@RequestMapping(value = "/demo/i18n")
public class I18nController {

	private static final Logger logger = LoggerFactory.getLogger(I18nController.class);

	@Autowired
	private ViewHandler viewHandler;

	@RequestMapping(value = "index.do")
	public String index() {
		return getPrefix() + viewHandler.getViewDelimiter() + "index";

	}

	@RequestMapping(value = "change.do")
	@ResponseBody
	public String change(HttpServletRequest request) {
		logger.info("change to locale=:" + request.getParameter("locale"));
		return "success";
	}

	@RequestMapping(value = "show.do")
	public String show() {
		return getPrefix() + viewHandler.getViewDelimiter() + "show";

	}

	private String getPrefix() {
		return viewHandler.getViewStyle() + viewHandler.getViewLayout() + "demo" + viewHandler.getViewLayout() + "i18n";
	}
}
