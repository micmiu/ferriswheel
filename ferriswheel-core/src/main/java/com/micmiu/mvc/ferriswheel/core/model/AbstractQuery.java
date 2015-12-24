package com.micmiu.mvc.ferriswheel.core.model;


import com.micmiu.mvc.ferriswheel.core.annotation.QueryProperty;
import com.micmiu.mvc.ferriswheel.core.annotation.SortProperty;
import com.micmiu.mvc.ferriswheel.utils.RefAnnotationUtil;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 抽象查询类.
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public abstract class AbstractQuery {

	/**
	 * 默认每页记录数.
	 */
	public static final int DEFAULT_ITEMS_PERPAGE = 10;

	/**
	 * 获取当前页数.
	 */
	public abstract int getPageNo();

	/**
	 * 获取当前开始的位置.
	 */
	public abstract int getStartIndex();

	/**
	 * 获取每页记录数.
	 */
	public abstract int getPageRows();

	/**
	 * 获取子类所有排序字段及排序顺序Map. 需要生成的字段值可用@SortProperty标示.
	 *
	 * @return Map<String, String> 排序字段Map
	 */
	@SuppressWarnings("unchecked")
	public Map<String, SortType> getSortProperties() {
		// 排序字段有先后顺序, 必须采用LinkedHashMap
		Map<String, SortType> sortProperties = new LinkedHashMap<String, SortType>();
		List<Field> properties = RefAnnotationUtil.getAllPublicFields(getClass(), SortProperty.class);
		for (Field p : properties) {
			sortProperties.put(getQueryPropertyName(p.getName()), p
					.getAnnotation(SortProperty.class).type());
		}
		return sortProperties;
	}

	/**
	 * 获取子类所有查询字段值Map. 需要生成的字段值可用@QueryProperty标示.
	 *
	 * @return Map<String, Object> 查询字段Map
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getQueryProperties() {
		Map<String, Object> propertyValues = new HashMap<String, Object>();
		List<Field> properties = RefAnnotationUtil.getAllPublicFields(getClass(), QueryProperty.class);
		for (Field p : properties) {
			Object value = RefAnnotationUtil.getFieldValue(this, p.getName(), true);
			if (null != value) {
				propertyValues.put(getQueryPropertyName(p.getName()),
						RefAnnotationUtil.getFieldValue(this, p.getName(), true));
			}
		}
		return propertyValues;
	}

	/**
	 * 获取查询Field名称. 优先处理QueryPropery注解name,若未配置,用Field名称代替.
	 *
	 * @param fieldName Field名称
	 * @return 查询属性名称
	 */
	protected String getQueryPropertyName(String fieldName) {
		String queryName = fieldName;
		QueryProperty qp = (QueryProperty) RefAnnotationUtil.getFieldAnnotation(
				getClass(), fieldName, QueryProperty.class);
		if (qp != null && StringUtils.isNotEmpty(qp.name())) {
			queryName = qp.name();
		}
		return queryName;
	}
}
