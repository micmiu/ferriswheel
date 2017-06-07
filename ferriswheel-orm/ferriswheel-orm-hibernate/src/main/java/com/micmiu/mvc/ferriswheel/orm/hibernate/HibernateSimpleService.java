package com.micmiu.mvc.ferriswheel.orm.hibernate;

import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;
import com.micmiu.mvc.ferriswheel.utils.DateTimeUtis;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 6/6/2017
 * Time: 23:28
 */
public abstract class HibernateSimpleService<E extends FerriswheelID, ID extends Serializable> extends HibernateBaseService<E, ID> {
	@Override
	protected Criteria handleProperty(Criteria currentCriteria, String propertyName, Object value) {
		if (value instanceof List) {
			currentCriteria.add(buildDisjunction(propertyName, (List) value));
		} else if (value.getClass().isArray()) {
			currentCriteria.add(buildDisjunction(propertyName, Arrays.asList(value)));
		} else if (value instanceof Date) {
			currentCriteria.add(Restrictions.ge(propertyName, DateTimeUtis.getStartTimeOfDay((Date) value)));
			currentCriteria.add(Restrictions.lt(propertyName, DateTimeUtis.getEndTimeOfDay((Date) value)));
		} else if (value instanceof Timestamp) {
			Date day = new Date((((Timestamp) value).getTime()));
			currentCriteria.add(Restrictions.ge(propertyName, DateTimeUtis.getStartTimeOfDay(day)));
			currentCriteria.add(Restrictions.lt(propertyName, DateTimeUtis.getEndTimeOfDay(day)));
		} else {
			currentCriteria.add(Restrictions.like(propertyName, "%" + value + "%"));
		}
		return currentCriteria;
	}

	private Disjunction buildDisjunction(String propertyName, List<?> params) {
		Disjunction d = Restrictions.disjunction();
		for (Object s : params) {
			d.add(Restrictions.eq(propertyName, s));
		}
		return d;
	}
}
