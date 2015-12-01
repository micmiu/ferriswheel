package com.micmiu.mvc.ferriswheel.examples.demos.jqgrid.controller;

import com.micmiu.mvc.ferriswheel.examples.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 12/1/2015
 * Time: 14:26
 */
@Controller
@RequestMapping("/demo/jqgrid/")
public class JqgridDemoController {


	private static final String PREFIX = Constant.VIEW_PREFIX + "demo" + Constant.LAYOUT_SPLIT;

	@RequestMapping("/index.do")
	public String index(HttpServletRequest req) {
		return PREFIX + "jqgrid" + Constant.VIEW_PAGE_SPLIT + "index";
	}
}
