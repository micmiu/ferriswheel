package com.micmiu.mvc.ferriswheel.examples.simple.controller;

import com.micmiu.mvc.ferriswheel.examples.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="http://www.micmiu.com">Michael</a>
 * @version 1.0
 * @time Create on 2013-12-12 下午11:56:46
 */
@Controller
@RequestMapping(value = "/system/setting")
public class SettingController {
	private static final Logger logger = LoggerFactory.getLogger(SettingController.class);

	private static final String PREFIX = Constant.VIEW_PREFIX + ".system.config";

	@RequestMapping(value = "i18n.do")
	@ResponseBody
	public String change(HttpServletRequest request) {
		logger.info("change to locale=:" + request.getParameter("locale"));
		return "success";
	}

}
