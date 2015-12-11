package com.micmiu.mvc.ferriswheel.examples.web2.simple.model;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public enum Module {

	USER("user", "用户"),

	ROLE("role", "角色"),

	DEMO("demo", "演示"),

	DEMO_COMMON("demo_common", "基础演示");
	static Map<String, Module> valueMap = Maps.newHashMap();

	public String value;
	public String displayName;

	static {
		for (Module permission : Module.values()) {
			valueMap.put(permission.value, permission);
		}
	}

	Module(String value, String displayName) {
		this.value = value;
		this.displayName = displayName;
	}

	public static Module parse(String value) {
		return valueMap.get(value);
	}

	public String getValue() {
		return value;
	}

	public String getDisplayName() {
		return displayName;
	}
}
