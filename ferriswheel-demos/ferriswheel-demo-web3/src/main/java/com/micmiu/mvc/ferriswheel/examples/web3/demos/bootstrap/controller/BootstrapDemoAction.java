package com.micmiu.mvc.ferriswheel.examples.web3.demos.bootstrap.controller;

import com.micmiu.mvc.ferriswheel.core.controller.ViewHandler;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private ViewHandler viewHandler;

	@RequestMapping("/index.do")
	public String index() {
		return getViewPrefix() + "bootstrap" + viewHandler.getViewDelimiter() + "index";
	}

	@RequestMapping("/treeview.do")
	public String showTreeview() {
		return getViewPrefix() + "bootstrap" + viewHandler.getViewDelimiter() + "treeview";
	}

	@RequestMapping("/ztree.do")
	public String showZtree() {
		return getViewPrefix() + "ztree";
	}

	@RequestMapping("/jstree.do")
	public String showJstree() {
		return getViewPrefix() + "jstree";
	}

	private String getViewPrefix() {
		return viewHandler.getViewStyle() + viewHandler.getViewLayout() + "demo" + viewHandler.getViewLayout();
	}
}
