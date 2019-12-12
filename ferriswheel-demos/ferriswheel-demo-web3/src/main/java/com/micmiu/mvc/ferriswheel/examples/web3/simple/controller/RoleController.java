package com.micmiu.mvc.ferriswheel.examples.web3.simple.controller;


import com.google.common.collect.Lists;
import com.micmiu.mvc.ferriswheel.core.model.OperationType;
import com.micmiu.mvc.ferriswheel.core.service.BaseService;
import com.micmiu.mvc.ferriswheel.examples.core.entity.Menu;
import com.micmiu.mvc.ferriswheel.examples.core.entity.Permission;
import com.micmiu.mvc.ferriswheel.examples.core.entity.Role;
import com.micmiu.mvc.ferriswheel.examples.core.model.RoleVo;
import com.micmiu.mvc.ferriswheel.examples.core.service.MenuService;
import com.micmiu.mvc.ferriswheel.examples.core.service.PermissionService;
import com.micmiu.mvc.ferriswheel.examples.core.service.RoleService;
import com.micmiu.mvc.ferriswheel.examples.web3.simple.model.RoleJqgridQuery;
import com.micmiu.mvc.ferriswheel.examples.web3.simple.model.ZtreeNode;
import com.micmiu.mvc.ferriswheel.support.jqgrid.controller.JqgridManageController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Controller
@RequestMapping(value = "/system/role.do")
public class RoleController extends JqgridManageController<Role, RoleVo, Long, RoleJqgridQuery> {

	@Autowired
	private RoleService roleService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private PermissionService permissionService;

	@Override
	public BaseService<Role, Long> getBaseService() {
		return roleService;
	}

	@Override
	protected boolean handler4Create(HttpServletRequest request, Role entity) {
		super.handler4Create(request, entity);
		Long id = null;
		String idstr = request.getParameter("id");
		String roleName = request.getParameter("roleName");
		String nodes = request.getParameter("nodes");
		if (null != idstr && !"".equals(idstr)) {
			id = Long.parseLong(idstr);
		}
		Role role = new Role();
		if (null != id) {
			role = roleService.find(id);
		}
		role.setRoleName(roleName);
		String[] nodeArr = nodes.split(",");
		List<Permission> perms = new ArrayList<Permission>();
		for (String node : nodeArr) {
			if (!node.startsWith("perm:")) {
				continue;
			}
			Long permId = Long.parseLong(node.split("\\:")[1]);
			Permission perm = permissionService.find(permId);
			if (null != perm) {
				perms.add(perm);
			}
		}
		roleService.updateRole(role, perms);
		return false;
	}

	@Override
	protected boolean handler4Update(HttpServletRequest request, Role entity) {
		return this.handler4Create(request, entity);
	}

	@Override
	protected RoleVo convertE2V(Role e, HttpServletRequest request) {
		RoleVo vo = new RoleVo();
		vo.setId(e.getId());
		vo.setRoleName(e.getRoleName());

		List<String> list = Lists.newArrayList();
		String lastName = null, resName = null, oper = null;
		List<String> operList = Lists.newArrayList();
		for (Permission permssion : e.getPermissions()) {
			try {
				resName = messageSource.getMessage(permssion.getResCnName(), null,
						RequestContextUtils.getLocale(request));

				oper = messageSource.getMessage(OperationType.parse(permssion.getOperation()).getDisplay(), null,
						RequestContextUtils.getLocale(request));
			} catch (Exception ex) {
				resName = permssion.getResCnName();
				oper = permssion.getOperation();
			}
			if (null != lastName && !lastName.equals(resName)) {
				if (!operList.isEmpty()) {
					list.add(lastName + ":" + (StringUtils.join(operList, ",")));
				}
				operList = Lists.newArrayList();

			}
			lastName = resName;
			operList.add(oper);
		}
		if (!operList.isEmpty()) {
			list.add(lastName + ":" + (StringUtils.join(operList, ",")));
		}
		vo.setPermissionNames(StringUtils.join(list, ";"));
		return vo;
	}

	@RequestMapping(params = {"method=checkRoleName"})
	@ResponseBody
	public String checkRoleName(
			@RequestParam("oldRoleName") String oldRoleName,
			@RequestParam("roleName") String roleName) {
		if (roleName.equals(oldRoleName)) {
			return "true";
		} else if (roleService.getRoleByName(roleName) == null) {
			return "true";
		}

		return "false";
	}

	@RequestMapping(params = {"method=getPermTree"})
	@ResponseBody
	public List<ZtreeNode> getPermTree(Long id, HttpServletRequest request) {
		List<ZtreeNode> permTree = new ArrayList<ZtreeNode>();
		Set<String> hasPerm = new HashSet<String>();
		if (null != id) {
			Role role = roleService.find(id);
			hasPerm = parsePermissionStrs(role.getPermissions());
		}
		parseMenuPermTree(menuService.getRootMenuByOrder(), permTree, hasPerm,
				request);

		return permTree;
	}

	/**
	 * 转化已有的权限ID
	 *
	 * @param permssions
	 * @return
	 */
	private Set<String> parsePermissionStrs(List<Permission> permssions) {
		Set<String> permStrs = new HashSet<String>();
		for (Permission permssion : permssions) {
			permStrs.add("perm:" + permssion.getId());
		}
		return permStrs;
	}

	/**
	 * 转化已有角色的权限树形结构
	 *
	 * @param allMenus
	 * @param permTree
	 * @param hasPerms
	 */
	private void parseMenuPermTree(List<Menu> allMenus, List<ZtreeNode> permTree, Set<String> hasPerms,
								   HttpServletRequest request) {
		for (Menu menu : allMenus) {
			permTree.add(recMenuPermTree(menu, hasPerms, request));

		}
	}

	/**
	 * 递归解析权限树型
	 *
	 * @param menu
	 * @param hasPerms
	 * @return
	 */
	private ZtreeNode recMenuPermTree(Menu menu, Set<String> hasPerms,
									 HttpServletRequest request) {
		ZtreeNode vo = new ZtreeNode();
		vo.setId("menu:" + menu.getId());
		vo.setName(messageSource.getMessage(menu.getMenuName(), null,
				RequestContextUtils.getLocale(request)));
		vo.setOpen(true);
		if (!menu.getChildren().isEmpty()) {
			for (Menu childMenu : menu.getChildren()) {
				vo.getChildren().add(
						recMenuPermTree(childMenu, hasPerms, request));
			}
		} else {
			for (Permission perm : menu.getPermssionList()) {
				ZtreeNode permNode = new ZtreeNode();
				String nodeId = "perm:" + perm.getId();
				permNode.setId(nodeId);
				if (null != hasPerms && hasPerms.contains(nodeId)) {
					permNode.setChecked(true);
				}
				permNode.setName(messageSource.getMessage(
						OperationType.parse(perm.getOperation()).getDisplay(),
						null, RequestContextUtils.getLocale(request)));

				vo.getChildren().add(permNode);
			}
		}
		return vo;
	}

	@Override
	protected Long[] parseDeleteIDS(HttpServletRequest request) {
		return com.micmiu.mvc.ferriswheel.utils.StringUtils.parseIdstr(request.getParameter("ids"));
	}
}
