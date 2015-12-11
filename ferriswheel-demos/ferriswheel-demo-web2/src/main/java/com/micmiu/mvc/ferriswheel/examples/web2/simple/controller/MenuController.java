package com.micmiu.mvc.ferriswheel.examples.web2.simple.controller;

import com.micmiu.mvc.ferriswheel.examples.web2.simple.entity.Menu;
import com.micmiu.mvc.ferriswheel.examples.web2.simple.entity.Permission;
import com.micmiu.mvc.ferriswheel.examples.web2.simple.entity.Role;
import com.micmiu.mvc.ferriswheel.examples.web2.simple.entity.User;
import com.micmiu.mvc.ferriswheel.examples.web2.simple.model.TreeNode;
import com.micmiu.mvc.ferriswheel.examples.web2.simple.service.MenuService;
import com.micmiu.mvc.ferriswheel.examples.web2.simple.service.UserService;
import com.micmiu.mvc.ferriswheel.examples.web2.simple.util.MenuPermUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Controller
@RequestMapping(value = "/system/menu.do")
public class MenuController {

	@Autowired
	private UserService userService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(params = {"method=getUserMenu"})
	@ResponseBody
	public String getUserMenu(HttpServletRequest request) {

		List<TreeNode> treeNodeList = new ArrayList<TreeNode>();

		String loginName = SecurityUtils.getSubject().getPrincipal().toString();
		User currUser = userService.getUserByLoginName(loginName);
		String contextPath = request.getSession().getServletContext()
				.getContextPath();

		MenuPermUtils.parseUserMenu(menuService.getRootMenuByOrder(), treeNodeList, parseMenuIds(currUser.getRoleList()),
				contextPath, messageSource, RequestContextUtils.getLocale(request));

		return MenuPermUtils.parseMenuHTML(treeNodeList);
	}

	private Set<Long> parseMenuIds(List<Role> roles) {
		Set<Long> ids = new HashSet<Long>();
		for (Role role : roles) {
			for (Permission perm : role.getPermissions()) {
				recParseMenuIds(ids, perm.getMenu());
			}
		}
		return ids;

	}

	private void recParseMenuIds(Set<Long> menuIds, Menu menu) {
		menuIds.add(menu.getId());
		if (null != menu.getParent()) {
			recParseMenuIds(menuIds, menu.getParent());
		}
	}

}
