package com.micmiu.mvc.ferriswheel.examples.demos.jqgrid.controller;

import com.micmiu.mvc.ferriswheel.core.service.BaseService;
import com.micmiu.mvc.ferriswheel.examples.Constant;
import com.micmiu.mvc.ferriswheel.examples.demos.entity.Blog;
import com.micmiu.mvc.ferriswheel.examples.demos.jqgrid.model.BlogJqgridQuery;
import com.micmiu.mvc.ferriswheel.examples.demos.service.BlogService;
import com.micmiu.mvc.ferriswheel.support.jqgrid.controller.JqgridSimpleController;
import com.micmiu.mvc.ferriswheel.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 11/29/2015
 * Time: 22:46
 */
@Controller
@RequestMapping(value = "/demo/jqgrid/blog.do")
public class BlogJqgridController extends JqgridSimpleController<Blog, Long, BlogJqgridQuery> {
	private static final String PREFIX = Constant.VIEW_PREFIX + "demo" + Constant.LAYOUT_SPLIT + "jqgrid";

	@Autowired
	private BlogService blogService;

	@Override
	public BaseService<Blog, Long> getBaseService() {
		return blogService;
	}

	@Override
	public String getViewPrefix() {
		return PREFIX;
	}

	@Override
	protected String getViewDelimiter() {
		return Constant.VIEW_PAGE_SPLIT;
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
