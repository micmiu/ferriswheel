package com.micmiu.mvc.ferriswheel.core.annotation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 11/11/2015
 * Time: 15:48
 */
public class AnnotationUtils {

	/**
	 * 根据实体类中@showparam 注释转化为Map<字段属性，字段名称>
	 *
	 * @param clazz
	 * @param messageSource
	 * @param locale
	 */
	public static Map<String, String> getBeanShwoParamMap(Class<?> clazz, MessageSource messageSource, Locale locale) {

		Field fields[] = clazz.getDeclaredFields();
		Map<String, String> showMap = new LinkedHashMap<String, String>();
		for (Field field : fields) {
			String fieldName = field.getName();
			if (!field.isAnnotationPresent(ShowParam.class)) {
				continue;
			}
			String cname = field.getAnnotation(ShowParam.class).value();
			if (!StringUtils.isEmpty(cname)) {
				showMap.put(fieldName, messageSource.getMessage(cname, null, locale));
			} else {
				showMap.put(fieldName, fieldName);
			}
		}

		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (!method.isAnnotationPresent(ShowParam.class)) {
				continue;
			}
			String cname = method.getAnnotation(ShowParam.class).value();
			String name = method.getName();
			if (name.startsWith("get")) {
				String propertyName = StringUtils.uncapitalize(name
						.substring(3));
				if (!StringUtils.isEmpty(cname)) {
					showMap.put(propertyName, cname);
				} else {
					showMap.put(propertyName, propertyName);
				}
			}

		}
		return showMap;

	}

	/**
	 * 根据实体对象中@showparam 注释转化为griddata表头信息
	 *
	 * @param obj
	 * @param messageSource
	 * @param locale
	 */
	public static Map<String, String> getBeanShwoParamMap(Object obj,
														  MessageSource messageSource, Locale locale) {
		return getBeanShwoParamMap(obj.getClass(), messageSource, locale);

	}
}
