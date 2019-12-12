package com.micmiu.mvc.ferriswheel.examples.web3.demos.jqgrid.controller;

import com.micmiu.mvc.ferriswheel.support.spring.mvc.SpringAbstractController;
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
public class JqgridDemoController extends SpringAbstractController {


	@RequestMapping("/index.do")
	public String index() {
		return getViewPrefix() + viewHandler.getViewLayout() + "index";
	}

	@RequestMapping("/list.do")
	public String list() {
		return getViewPrefix() + viewHandler.getViewLayout() + "jqgrid_list";
	}

	@RequestMapping("/base.do")
	public String base() {
		return getViewPrefix() + viewHandler.getViewLayout() + "jqgrid_base";
	}

}
