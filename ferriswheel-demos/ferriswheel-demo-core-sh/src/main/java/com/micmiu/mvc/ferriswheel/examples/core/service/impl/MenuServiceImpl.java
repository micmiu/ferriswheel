package com.micmiu.mvc.ferriswheel.examples.core.service.impl;

import com.micmiu.mvc.ferriswheel.examples.core.entity.Menu;
import com.micmiu.mvc.ferriswheel.examples.core.service.MenuService;
import com.micmiu.mvc.ferriswheel.orm.hibernate.HibernateBaseService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Service
public class MenuServiceImpl extends HibernateBaseService<Menu, Long> implements
		MenuService {

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getRootMenuByOrder() {
		Criterion top = Restrictions.isNull("parent");
		return (List<Menu>) this.getSession().createCriteria(Menu.class)
				.add(top).addOrder(Order.asc("orderNum")).list();
	}

	@Override
	protected Criteria handleProperty(Criteria currentCriteria, String propertyName, Object value) {
		// TODO Auto-generated method stub
		return currentCriteria;
	}

}
