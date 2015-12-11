package com.micmiu.mvc.ferriswheel.examples.web2.demos.bootstrap.controller;

import com.micmiu.mvc.ferriswheel.examples.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String index() {
		return PREFIX + "bootstrap" + Constant.VIEW_PAGE_SPLIT + "index";
	}

	@RequestMapping("/treeview.do")
	public String showTreeview() {
		return PREFIX + "bootstrap" + Constant.VIEW_PAGE_SPLIT + "treeview";
	}

	@RequestMapping("/ztree.do")
	public String showZtree() {
		return PREFIX + "ztree";
	}

	@RequestMapping("/jstree.do")
	public String showJstree() {
		return PREFIX + "jstree";
	}
}
