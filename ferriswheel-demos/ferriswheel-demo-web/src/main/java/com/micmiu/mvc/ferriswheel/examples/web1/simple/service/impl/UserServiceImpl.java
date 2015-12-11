package com.micmiu.mvc.ferriswheel.examples.web1.simple.service.impl;


import com.micmiu.mvc.ferriswheel.examples.web1.simple.entity.Role;
import com.micmiu.mvc.ferriswheel.examples.web1.simple.entity.User;
import com.micmiu.mvc.ferriswheel.examples.web1.simple.service.UserService;
import com.micmiu.mvc.ferriswheel.support.hibernate.HibernateBaseService;
import com.micmiu.mvc.ferriswheel.support.shiro.ShiroPermissible;
import com.micmiu.mvc.ferriswheel.support.shiro.ShiroRealmService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理服务类.
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Service
public class UserServiceImpl extends HibernateBaseService<User, Long> implements
		UserService, ShiroRealmService {

	/**
	 * 生成Hibernate查询条件对象. 各实现类针对所管理的实体对象，实现支持查询字段的处理逻辑.
	 *
	 * @param currentCriteria 当前Hibernate Criteria对象
	 * @param propertyName    字段名
	 * @param value           字段值
	 * @return Hibernate Criteria
	 */
	@Override
	protected Criteria handleProperty(Criteria currentCriteria,
									  String propertyName, Object value) {
		if ("loginName".equals(propertyName)) {
			currentCriteria.add(Restrictions.like("loginName", "%" + value
					+ "%"));
		} else if ("name".equals(propertyName)) {
			currentCriteria.add(Restrictions.like("name", "%" + value + "%"));
		} else if ("positionId".equals(propertyName)) {
			currentCriteria.add(Restrictions.eq("position.positionId", value));
		} else if ("departmentId".equals(propertyName)) {
			// 两种关联查询方式均可.
			// 简单
			currentCriteria.add(Restrictions.eq("department.departmentId",
					value));
			// 复杂
			// currentCriteria.createCriteria("department").add(Restrictions.eq("departmentId",
			// value));
		} else if ("status".equals(propertyName)) {
			// 健壮性捕获异常
			// Cast异常则不处理该条件
			try {
				@SuppressWarnings("unchecked")
				List<String> ss = (List<String>) value;
				Disjunction d = Restrictions.disjunction();
				for (String s : ss) {
					d.add(Restrictions.eq("status", s));
				}
				currentCriteria.add(d);
			} catch (Exception e) {
			}
		}
		return currentCriteria;
	}

	@Override
	public String[] findLoginUser(String username) {
		List<User> list = this.queryAll();
		System.out.print(list.size());
		User user = this.getUserByLoginName(username);
		if (null == user) {
			return null;
		} else {
			return new String[]{user.getLoginName(), user.getName(),
					user.getPassword()};
		}
	}

	@Override
	public List<ShiroPermissible> queryUserPermission(String username) {
		List<ShiroPermissible> list = new ArrayList<ShiroPermissible>();
		User user = this.getUserByLoginName(username);
		for (Role role : user.getRoleList()) {
			list.addAll(role.getPermissions());
		}
		return list;
	}

	@Override
	public User getUserByLoginName(String loginName) {
		return this.find("loginName", loginName);
	}

}
