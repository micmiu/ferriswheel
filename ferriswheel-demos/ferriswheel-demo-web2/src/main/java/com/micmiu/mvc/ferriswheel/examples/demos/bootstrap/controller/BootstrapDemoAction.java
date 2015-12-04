package com.micmiu.mvc.ferriswheel.examples.demos.bootstrap.controller;

import com.micmiu.mvc.ferriswheel.examples.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 8/21/2014
 * Time: 18:54
 */
@Controller
@RequestMapping("/demo/bootstrap")
public class BootstrapDemoAction {

	private static final String PREFIX = Constant.VIEW_PREFIX + "demo" + Constant.LAYOUT_SPLIT;

	@RequestMapping("/index.do")
	public String index(HttpServletRequest req) {
		return PREFIX + "bootstrap" + Constant.VIEW_PAGE_SPLIT + "index";
	}

	@RequestMapping("/treeview.do")
	public String showTree(HttpServletRequest req) {
		return PREFIX + "bootstrap" + Constant.VIEW_PAGE_SPLIT + "treeview";
	}
}
