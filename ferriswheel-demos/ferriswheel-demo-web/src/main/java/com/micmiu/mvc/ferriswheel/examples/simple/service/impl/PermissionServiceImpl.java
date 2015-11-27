package com.micmiu.mvc.ferriswheel.examples.simple.service.impl;

import com.micmiu.mvc.ferriswheel.examples.simple.entity.Permission;
import com.micmiu.mvc.ferriswheel.examples.simple.service.PermissionService;
import com.micmiu.mvc.ferriswheel.support.hibernate.HibernateBaseService;
import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Service
public class PermissionServiceImpl extends
		HibernateBaseService<Permission, Long> implements PermissionService {

	@Override
	protected Criteria handleProperty(Criteria currentCriteria,
									  String propertyName, Object value) {
		// TODO Auto-generated method stub
		return currentCriteria;
	}

}
