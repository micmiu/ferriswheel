package com.micmiu.mvc.ferriswheel.examples.web1.demos.easyui.controller;

import com.micmiu.mvc.ferriswheel.examples.web1.Constant;
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

	private static final String PREFIX = Constant.VIEW_PREFIX + "demo" + Constant.LAYOUT_SPLIT + "datagrid";

	@Autowired
	private BlogService blogService;

	@RequestMapping(params = {"method=dg4base"})
	public String list4base(Model model) {
		List<Blog> list = blogService.queryAll();
		model.addAttribute("blogs", list);
		return PREFIX + Constant.VIEW_PAGE_SPLIT + "list" + Constant.VIEW_PAGE_SPLIT + "base";
	}

	@RequestMapping(params = {"method=dg4tb"})
	public String list4tb(Model model) {
		List<Blog> list = blogService.queryAll();
		model.addAttribute("blogs", list);
		return PREFIX + Constant.VIEW_PAGE_SPLIT + "list" + Constant.VIEW_PAGE_SPLIT + "tb";
	}

	@RequestMapping(params = {"method=dg4export"})
	public String list4export(Model model) {
		List<Blog> list = blogService.queryAll();
		model.addAttribute("blogs", list);
		return PREFIX + Constant.VIEW_PAGE_SPLIT + "list" + Constant.VIEW_PAGE_SPLIT + "export";
	}
}
