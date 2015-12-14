package com.micmiu.mvc.ferriswheel.examples.core.service.impl;


import com.micmiu.mvc.ferriswheel.examples.core.entity.Permission;
import com.micmiu.mvc.ferriswheel.examples.core.entity.Role;
import com.micmiu.mvc.ferriswheel.examples.core.service.PermissionService;
import com.micmiu.mvc.ferriswheel.examples.core.service.RoleService;
import com.micmiu.mvc.ferriswheel.support.hibernate.HibernateBaseService;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Service
public class RoleServiceImpl extends HibernateBaseService<Role, Long> implements RoleService {
	@Autowired
	private PermissionService permssionService;

	@Override
	protected Criteria handleProperty(Criteria currentCriteria, String propertyName, Object value) {
		// TODO Auto-generated method stub
		return currentCriteria;
	}

	@Override
	public Role getRoleByName(String name) {
		return find("roleName", name);
	}

	@Override
	public void updateRole(Role role, List<Permission> permList) {
		for (Permission perm : permList) {
			this.permssionService.update(perm);
		}
		role.setPermissions(permList);
		this.update(role);

	}

}
