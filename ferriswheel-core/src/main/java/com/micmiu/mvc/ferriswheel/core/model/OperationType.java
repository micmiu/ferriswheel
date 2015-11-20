package com.micmiu.mvc.ferriswheel.core.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 操作权限及国际化key的枚举类
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public enum OperationType {

	CREATE("create", "global.text.create"),

	READ("read", "global.text.read"),

	UPDATE("update", "global.text.update"),

	DELETE("delete", "global.text.delete"),

	EXPORT("export", "global.text.export"),

	PRINT("print", "global.text.print");

	private static Map<String, OperationType> valueMap = new HashMap<String, OperationType>();

	public String value;
	public String display;

	static {
		for (OperationType oper : OperationType.values()) {
			valueMap.put(oper.value, oper);
		}
	}

	OperationType(String value, String display) {
		this.value = value;
		this.display = display;
	}

	public static OperationType parse(String value) {
		return valueMap.get(value);
	}

	public String getValue() {
		return value;
	}

	public String getDisplay() {
		return display;
	}

}
