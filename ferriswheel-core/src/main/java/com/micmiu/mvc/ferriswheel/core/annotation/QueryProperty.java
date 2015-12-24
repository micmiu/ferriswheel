package com.micmiu.mvc.ferriswheel.core.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 查询条件属性.
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryProperty {
	String name() default "";
}
