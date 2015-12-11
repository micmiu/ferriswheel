package com.micmiu.mvc.ferriswheel.examples.web1.demos.easyui.controller;

import com.micmiu.mvc.ferriswheel.examples.web1.Constant;
import com.micmiu.mvc.ferriswheel.examples.web1.demos.model.FormBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Controller
@RequestMapping(value = "/demo/easyui/index.do")
public class EasyuiDemoController {

	private static final String PREFIX = Constant.VIEW_PREFIX + "demo";

	@RequestMapping()
	public String index() {
		return PREFIX + Constant.VIEW_PAGE_SPLIT + "index";

	}

	@RequestMapping(params = {"method=showForm"})
	public String showForm(FormBean bean) {
		return PREFIX + Constant.VIEW_PAGE_SPLIT + "form";

	}

	@RequestMapping(params = {"method=create"})
	@ResponseBody
	public String save(FormBean bean, RedirectAttributes redirectAttributes) {
		System.out.println("--->:" + bean);
		String message = "bean info:" + bean;
		redirectAttributes.addFlashAttribute("message", message);
		return message;
	}

}
