package com.micmiu.mvc.ferriswheel.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解解析转化工具栏
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class RefAnnotationUtil {

	/**
	 * 获取包含制定Annotation的类公共Field(有get方法).
	 *
	 * @param clazz             类
	 * @param annotationClasses Field必须包含的Annotation类
	 * @return List<Field> Field列表
	 */
	public static List<Field> getPublicFields(Class<?> clazz, Class<? extends Annotation>... annotationClasses) {
		List<Field> returnFields = new ArrayList<Field>();

		Field fields[] = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (hasGetMethod(clazz, field.getName())) {
				boolean hasAnnotation = true;
				for (Class<? extends Annotation> annotationClass : annotationClasses) {
					if (!field.isAnnotationPresent(annotationClass)) {
						try {
							Method getMethod = clazz.getMethod(buildGetMethodName(field.getName()));
							if (!getMethod.isAnnotationPresent(annotationClass)) {
								hasAnnotation = false;
							}
						} catch (Exception e) {
						}
					}
				}
				if (hasAnnotation) {
					returnFields.add(field);
				}
			}
		}
		return returnFields;
	}

	/**
	 * 获取所有(包括父类)公共Field(有get方法).
	 *
	 * @param clazz             类
	 * @param annotationClasses Field必须包含的Annotation类
	 * @return List<Field> Field列表
	 */
	public static List<Field> getAllPublicFields(Class<?> clazz,
												 Class<? extends Annotation>... annotationClasses) {
		List<Field> returnFields = new ArrayList<Field>();

		if (clazz.getSuperclass() != null) {
			List<Field> parentClassFields = getAllPublicFields(
					clazz.getSuperclass(), annotationClasses);
			for (Field field : parentClassFields) {
				returnFields.add(field);
			}
		}
		returnFields.addAll(getPublicFields(clazz, annotationClasses));
		return returnFields;
	}

	/**
	 * 按方法名获取对象Field值.
	 *
	 * @param obj       对象实例
	 * @param fieldName Field名称
	 * @return Object Field值
	 */
	public static Object getFieldValue(Object obj, String fieldName) {
		return getFieldValue(obj, fieldName, false);
	}

	/**
	 * 按方法名获取对象Field值.
	 *
	 * @param obj               对象实例
	 * @param fieldName         Field名称
	 * @param includeSuperClass 是否包含父类
	 * @return Object Field值
	 */
	public static Object getFieldValue(Object obj, String fieldName, boolean includeSuperClass) {
		Object value = null;

		String methodName = buildGetMethodName(fieldName);
		try {
			Method method;
			if (includeSuperClass) {
				method = getSuperMethod(obj.getClass(), methodName);
			} else {
				method = obj.getClass().getMethod(methodName);
			}
			value = method.invoke(obj, new Object[]{});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 获取Field指定注解,若不存在则返回null.
	 *
	 * @param clazz           类
	 * @param fieldName       Field名称
	 * @param annotationClass 注解类
	 * @return 注解
	 */
	public static Annotation getFieldAnnotation(Class<?> clazz, String fieldName,
												Class<? extends Annotation> annotationClass) {
		Annotation a = null;
		Field f;
		try {
			f = clazz.getDeclaredField(fieldName);
			a = f.getAnnotation(annotationClass);
			if (a == null) {
				Method m = getSuperMethod(clazz, buildGetMethodName(fieldName));
				a = m.getAnnotation(annotationClass);
			}
		} catch (Exception e) {
		}
		return a;
	}

	/**
	 * 按方法名获取Method对象(包括父类).
	 *
	 * @param clazz      类
	 * @param methodName 方法名
	 * @return Method Method对象
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static Method getSuperMethod(Class<?> clazz, String methodName)
			throws NoSuchMethodException, SecurityException {
		Method method = null;
		try {
			method = clazz.getMethod(methodName);
		} catch (NoSuchMethodException e) {
			if (clazz.getSuperclass() != null) {
				method = getSuperMethod(clazz.getSuperclass(), methodName);
			} else {
				throw e;
			}
		}
		return method;
	}

	/**
	 * 判断Field是否有相应的get方法.
	 *
	 * @param clazz     类
	 * @param fieldName field名称
	 * @return boolean 有/无
	 */
	private static boolean hasGetMethod(Class<?> clazz, String fieldName) {
		String m = buildGetMethodName(fieldName);
		try {
			clazz.getMethod(m);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 生成Get方法名称.
	 *
	 * @param fieldName field名称
	 * @return String Get方法名称
	 */
	private static String buildGetMethodName(String fieldName) {
		return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}
}
