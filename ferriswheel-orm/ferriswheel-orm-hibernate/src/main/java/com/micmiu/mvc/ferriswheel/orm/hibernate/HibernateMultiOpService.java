package com.micmiu.mvc.ferriswheel.orm.hibernate;

import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 4/7/2017
 * Time: 16:52
 */
public abstract class HibernateMultiOpService<E extends FerriswheelID, ID extends Serializable> extends HibernateBaseService<E, ID> {
	@Override
	protected Criteria handleProperty(Criteria currentCriteria, String propertyName, Object value) {

		String groupOp = propertyName;
		if (propertyName.indexOf(":") > 0) {
			String[] arr = propertyName.split(":");
			groupOp = arr[0];
		}
		if ("_OR_".equalsIgnoreCase(groupOp)) {
			Map<String, Object> subMap = (HashMap<String, Object>) value;
			Disjunction dis = Restrictions.disjunction();

			for (Map.Entry<String, Object> entry : subMap.entrySet()) {
				dis.add(handlCriterion(currentCriteria, entry.getKey(), entry.getValue()));
			}
			currentCriteria.add(dis);
		} else if ("_AND_".equalsIgnoreCase(groupOp)) {
			Map<String, Object> subMap = (HashMap<String, Object>) value;
			for (Map.Entry<String, Object> entry : subMap.entrySet()) {
				currentCriteria.add(handlCriterion(currentCriteria, entry.getKey(), entry.getValue()));
			}
		} else {
			currentCriteria.add(handlCriterion(currentCriteria, propertyName, value));
		}
		return currentCriteria;
	}

	/**
	 * 根据不同的操作 生成Criterion
	 *
	 * @param field
	 * @param value
	 * @return
	 */
	protected Criterion handlCriterion(Criteria currentCriteria, String field, Object value) {
		String op = "cn";
		String column = field;
		if (field.indexOf(":") > 0) {
			String[] arr = field.split(":");
			op = arr[0];
			column = arr[1];
		}
		return handlCriterion(currentCriteria, op, column, value);
	}

	protected Criterion handlCriterion(Criteria currentCriteria, String op, String column, Object value) {
		if ("eq".equals(op)) {
			return Restrictions.eq(column, handlePrpertyValue(column, value));
		} else if ("ne".equals(op)) {
			return Restrictions.ne(column, handlePrpertyValue(column, value));
		} else {
			return Restrictions.like(column, "%" + handlePrpertyValue(column, value) + "%");
		}
	}

	protected Object handlePrpertyValue(String column, Object value) {
		return value;
	}

}
