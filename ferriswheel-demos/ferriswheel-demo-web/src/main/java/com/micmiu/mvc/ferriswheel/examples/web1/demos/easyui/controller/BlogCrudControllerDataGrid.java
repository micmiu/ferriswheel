package com.micmiu.mvc.ferriswheel.examples.web1.demos.easyui.controller;


import com.micmiu.mvc.ferriswheel.core.service.BaseService;
import com.micmiu.mvc.ferriswheel.examples.web1.demos.entity.Blog;
import com.micmiu.mvc.ferriswheel.examples.web1.demos.model.BlogDatagridQuery;
import com.micmiu.mvc.ferriswheel.examples.web1.demos.service.BlogService;
import com.micmiu.mvc.ferriswheel.support.easyui.controller.DataGridSimpleController;
import com.micmiu.mvc.ferriswheel.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 博客演示基本的CRUD
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Controller
@RequestMapping(value = "/demo/easyui/crud.do")
public class BlogCrudControllerDataGrid extends DataGridSimpleController<Blog, Long, BlogDatagridQuery> {

	@Autowired
	private BlogService blogService;

	@Override
	public BaseService<Blog, Long> getBaseService() {
		return blogService;
	}

	@Override
	protected void checkAuth(String operation) {
		// no check
	}

	@Override
	protected boolean handler4Create(HttpServletRequest request, Blog entity) {
		super.handler4Create(request, entity);
		if (null == entity.getCreater() || "".equals(entity.getCreater())) {
			entity.setCreater(SecurityUtils.getSubject().getPrincipal()
					.toString());
		}
		return true;
	}

	@Override
	protected Long[] parseDeleteIDS(HttpServletRequest request) {
		return StringUtils.parseIdstr(request.getParameter("ids"));
	}

}
