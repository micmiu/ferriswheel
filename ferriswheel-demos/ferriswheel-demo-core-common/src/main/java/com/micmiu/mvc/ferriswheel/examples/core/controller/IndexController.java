package com.micmiu.mvc.ferriswheel.examples.core.controller;

import com.micmiu.mvc.ferriswheel.core.controller.ViewHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Controller
public class IndexController {

	@Autowired
	private ViewHandler viewHandler;

	@RequestMapping("/index.do")
	public String index() {
		return viewHandler.getViewStyle() + viewHandler.getViewLayout() + "index";
	}

}
