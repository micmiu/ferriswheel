package com.micmiu.mvc.ferriswheel.examples.web2.demos.jqgrid.controller;

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
	public String index(HttpServletRequest req) {
		return getViewPrefix() + viewHandler.getViewLayout() + "index";
	}
}
