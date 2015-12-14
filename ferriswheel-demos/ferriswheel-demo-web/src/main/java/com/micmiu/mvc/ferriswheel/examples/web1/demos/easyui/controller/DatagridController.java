package com.micmiu.mvc.ferriswheel.examples.web1.demos.easyui.controller;

import com.micmiu.mvc.ferriswheel.core.controller.ViewHandler;
import com.micmiu.mvc.ferriswheel.examples.web1.demos.entity.Blog;
import com.micmiu.mvc.ferriswheel.examples.web1.demos.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Description: data grid demo
 *
 * @author <a href="http://www.micmiu.com">Michael</a>
 */
@Controller
@RequestMapping(value = "/demo/easyui/datagrid.do")
public class DatagridController {

	@Autowired
	private ViewHandler viewHandler;

	@Autowired
	private BlogService blogService;

	@RequestMapping(params = {"method=dg4base"})
	public String list4base(Model model) {
		List<Blog> list = blogService.queryAll();
		model.addAttribute("blogs", list);
		return getPrefix() + viewHandler.getViewDelimiter() + "list" + viewHandler.getViewDelimiter() + "base";
	}

	@RequestMapping(params = {"method=dg4tb"})
	public String list4tb(Model model) {
		List<Blog> list = blogService.queryAll();
		model.addAttribute("blogs", list);
		return getPrefix() + viewHandler.getViewDelimiter() + "list" + viewHandler.getViewDelimiter() + "tb";
	}

	@RequestMapping(params = {"method=dg4export"})
	public String list4export(Model model) {
		List<Blog> list = blogService.queryAll();
		model.addAttribute("blogs", list);
		return getPrefix() + viewHandler.getViewDelimiter() + "list" + viewHandler.getViewDelimiter() + "export";
	}

	private String getPrefix() {
		return viewHandler.getViewStyle() + viewHandler.getViewLayout() + "demo" + viewHandler.getViewLayout() + "datagrid";
	}
}
