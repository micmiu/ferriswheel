package com.micmiu.mvc.ferriswheel.examples.web1.simple.controller;

import com.micmiu.mvc.ferriswheel.core.FerriswheelConstant;
import com.micmiu.mvc.ferriswheel.core.service.BaseService;
import com.micmiu.mvc.ferriswheel.examples.core.entity.Menu;
import com.micmiu.mvc.ferriswheel.examples.core.entity.Permission;
import com.micmiu.mvc.ferriswheel.examples.core.entity.Role;
import com.micmiu.mvc.ferriswheel.examples.core.entity.User;
import com.micmiu.mvc.ferriswheel.examples.core.service.MenuService;
import com.micmiu.mvc.ferriswheel.examples.core.service.RoleService;
import com.micmiu.mvc.ferriswheel.examples.core.service.UserService;
import com.micmiu.mvc.ferriswheel.examples.web1.simple.model.TreeNode;
import com.micmiu.mvc.ferriswheel.examples.web1.simple.model.UserDataGridQuery;
import com.micmiu.mvc.ferriswheel.examples.web1.simple.util.MenuPermUtils;
import com.micmiu.mvc.ferriswheel.support.easyui.controller.DataGridSimpleController;
import com.micmiu.mvc.ferriswheel.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 7/16/2014
 * Time: 14:50
 */
@Controller
@RequestMapping(value = "/system/user.do")
public class UserController extends DataGridSimpleController<User, Long, UserDataGridQuery> {
	@Autowired
	private UserService userService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private RoleService roleService;

	@Override
	public BaseService<User, Long> getBaseService() {
		return userService;
	}

	@Override
	protected void handler4ListShow(HttpServletRequest request, Model model) {
		super.handler4ListShow(request, model);
		model.addAttribute("roleList", roleService.queryAll());
	}

	@Override
	protected void handler4CreateShow(HttpServletRequest request, User entity,
									  Model model) {
		super.handler4CreateShow(request, entity, model);
		model.addAttribute("roleList", roleService.queryAll());
	}

	@Override
	protected void handler4UpdateShow(HttpServletRequest request, User entity,
									  Model model) {
		super.handler4UpdateShow(request, entity, model);
		model.addAttribute("roleList", roleService.queryAll());
	}

	@Override
	protected boolean handler4Create(HttpServletRequest request, User entity) {
		String roleIdStr = request.getParameter("roleId");
		Role role = roleService.find(Long.parseLong(roleIdStr));
		entity.getRoleList().add(role);
		return true;

	}

	@Override
	protected boolean handler4Update(HttpServletRequest request, User entity) {
		handler4Create(request, entity);
		User exit = userService.find(entity.getId());
		entity.setPassword(exit.getPassword());
		return true;
	}

	@Override
	protected boolean allowDeleteData(Long[] ids, StringBuffer msgkey) {
		for (Long id : ids) {
			User user = this.userService.find(id);
			if (null != user
					&& SecurityUtils.getSubject().getPrincipal().toString()
					.equals(user.getLoginName())) {
				msgkey.append(FerriswheelConstant.MSG_FORBID_DELETE_SELF);
				return false;
			}
		}
		return true;
	}

	@RequestMapping(params = {"method=checkLoginName"})
	@ResponseBody
	public String checkLoginName(
			@RequestParam("oldLoginName") String oldLoginName,
			@RequestParam("loginName") String loginName) {
		if (loginName.equals(oldLoginName)) {
			return "true";
		} else if (userService.getUserByLoginName(loginName) == null) {
			return "true";
		}

		return "false";
	}

	@RequestMapping(params = {"method=getUserMenu"})
	@ResponseBody
	public List<TreeNode> getUserTreeMenu(HttpServletRequest request) {
		String contextPath = request.getSession().getServletContext()
				.getContextPath();

		List<TreeNode> treeNodeList = new ArrayList<TreeNode>();

		String loginName = SecurityUtils.getSubject().getPrincipal().toString();
		User currUser = userService.getUserByLoginName(loginName);

		MenuPermUtils.parseUserMenu(menuService.getRootMenuByOrder(), treeNodeList, parseMenuIds(currUser.getRoleList()),
				contextPath, messageSource, RequestContextUtils.getLocale(request));

		return treeNodeList;
	}

	/**
	 * 获取角色的所有的菜单
	 *
	 * @param roles
	 * @return
	 */
	private Set<Long> parseMenuIds(List<Role> roles) {
		Set<Long> ids = new HashSet<Long>();
		for (Role role : roles) {
			for (Permission perm : role.getPermissions()) {
				recParseMenuIds(ids, perm.getMenu());
			}
		}
		return ids;

	}

	/**
	 * 递归菜单
	 *
	 * @param menuIds
	 * @param menu
	 */
	private void recParseMenuIds(Set<Long> menuIds, Menu menu) {
		menuIds.add(menu.getId());
		if (null != menu.getParent()) {
			recParseMenuIds(menuIds, menu.getParent());
		}
	}

	@Override
	protected Long[] parseDeleteIDS(HttpServletRequest request) {
		return StringUtils.parseIdstr(request.getParameter("ids"));
	}
}
