package com.micmiu.mvc.ferriswheel.support.jqgrid.model;

import com.micmiu.mvc.ferriswheel.core.annotation.QueryProperty;
import com.micmiu.mvc.ferriswheel.utils.RefAnnotationUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 4/7/2017
 * Time: 13:44
 */
public abstract class JqgridMultiSearchQuery extends JqgridQuery {

	private String filters;

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	@Override
	public Map<String, Object> getQueryProperties() {

		if (null == filters || "".equals(filters)) {
			Map<String, Object> propertyValues = new HashMap<String, Object>();
			List<Field> properties = RefAnnotationUtil.getAllPublicFields(getClass(), QueryProperty.class);
			for (Field p : properties) {
				if (p.getName().equals(getSearchField()) && StringUtils.isNotEmpty(getSearchString())) {
					propertyValues.put(getSearchOper() + ":" + getQueryPropertyName(p.getName()), getSearchString());
				}
			}
			return propertyValues;
		}
		Map<String, Object> propertyValues = new HashMap<String, Object>();
		List<Field> properties = RefAnnotationUtil.getAllPublicFields(getClass(), QueryProperty.class);
		Set<String> queryFieldSet = new HashSet<String>();
		for (Field f : properties) {
			queryFieldSet.add(f.getName());
		}

		JSONObject jsono = null;
		try {
			jsono = JSONObject.fromObject(filters);
		} catch (Exception e) {
			e.printStackTrace();
			return propertyValues;
		}
		if (null == jsono || jsono.isNullObject()) {
			return propertyValues;
		}
		String group = jsono.getString("groupOp");
		JSONArray rules = jsono.getJSONArray("rules");
		int len = rules.size();
		Map<String, Object> rulesMap = new HashMap<String, Object>();
		for (int i = 0; i < len; i++) {
			JSONObject o = rules.getJSONObject(i);
			String field = o.getString("field");
			String op = o.getString("op");
			Object data = o.get("data");
//			String data = o.getString("data");
			if (null == data || !queryFieldSet.contains(field)) {
				continue;
			}
			rulesMap.put(op + ":" + field, data);
		}
		propertyValues.put("_" + group + "_", rulesMap);


		return propertyValues;
	}
}
