package com.micmiu.mvc.ferriswheel.core.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 实体类中属性增强性注解(用于自动导出列名、代码生成工具等)
 * 
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ShowParam {

	String value();

	int width() default 80;

	boolean sortable() default false;

	String align() default "left";

}
