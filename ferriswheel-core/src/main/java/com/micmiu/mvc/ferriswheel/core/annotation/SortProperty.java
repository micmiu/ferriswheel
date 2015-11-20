package com.micmiu.mvc.ferriswheel.core.annotation;


import com.micmiu.mvc.ferriswheel.core.model.SortType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 排序属性.
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SortProperty {
	SortType type() default SortType.ASC;
}
