package com.micmiu.mvc.ferriswheel.examples.web1.demos.easyui.controller;

import com.micmiu.mvc.ferriswheel.core.controller.ViewHandler;
import com.micmiu.mvc.ferriswheel.examples.web1.demos.model.FormBean;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private ViewHandler viewHandler;

	private String getPrefix() {
		return viewHandler.getViewStyle() + viewHandler.getViewLayout() + "demo";
	}

	@RequestMapping()
	public String index() {
		return getPrefix() + viewHandler.getViewDelimiter() + "index";

	}

	@RequestMapping(params = {"method=showForm"})
	public String showForm(FormBean bean) {
		return getPrefix() + viewHandler.getViewDelimiter() + "form";

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
