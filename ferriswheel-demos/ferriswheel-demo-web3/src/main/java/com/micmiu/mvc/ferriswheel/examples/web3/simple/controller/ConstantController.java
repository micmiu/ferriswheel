package com.micmiu.mvc.ferriswheel.examples.web3.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/system/constant.do")
public class ConstantController {

	@RequestMapping(params = {"method=getSelectList"})
	@ResponseBody
	public List<DeptVo> getSelectList() {
		List<DeptVo> volist = new ArrayList<DeptVo>();

		volist.add(new DeptVo("arch", "架构组"));
		volist.add(new DeptVo("dev", "开发组"));
		volist.add(new DeptVo("qa", "QA组"));
		volist.add(new DeptVo("test", "测试组"));
		return volist;
	}

	class DeptVo {
		public DeptVo(String value, String name) {
			this.value = value;
			this.name = name;
		}

		private String value;

		private String name;

		public String getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
}
