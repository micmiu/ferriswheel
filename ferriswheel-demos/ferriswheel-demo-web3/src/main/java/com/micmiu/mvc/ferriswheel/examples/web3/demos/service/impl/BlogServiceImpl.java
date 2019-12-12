package com.micmiu.mvc.ferriswheel.examples.web3.demos.service.impl;


import com.micmiu.mvc.ferriswheel.examples.web3.demos.entity.Blog;
import com.micmiu.mvc.ferriswheel.examples.web3.demos.service.BlogService;
import com.micmiu.mvc.ferriswheel.orm.hibernate.HibernateBaseService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Service
public class BlogServiceImpl extends HibernateBaseService<Blog, Long> implements BlogService {


	@Override
	protected Criteria handleProperty(Criteria currentCriteria,
									  String propertyName, Object value) {
		if ("id".equals(propertyName)) {
			currentCriteria.add(Restrictions.idEq(Long.parseLong(value.toString())));
		}
		if ("title".equals(propertyName)) {
			currentCriteria.add(Restrictions.like("title", "%" + value + "%"));
		}
		if ("category".equals(propertyName)) {
			currentCriteria.add(Restrictions.like("category", "%" + value + "%"));
		}
		if ("author".equals(propertyName)) {
			currentCriteria.add(Restrictions.like("author", "%" + value + "%"));
		}
		if ("url".equals(propertyName)) {
			currentCriteria.add(Restrictions.like("url", "%" + value + "%"));
		}
		return currentCriteria;
	}

	@Override
	public List queryStatic() {
		List list = this.getSession().createCriteria(Blog.class).setProjection(Projections.projectionList()
				.add(Projections.groupProperty("category")).add(Projections.rowCount(), "count")).list();
		return list;
	}
}
