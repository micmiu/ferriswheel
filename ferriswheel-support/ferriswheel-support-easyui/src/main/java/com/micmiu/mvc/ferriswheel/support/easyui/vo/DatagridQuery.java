package com.micmiu.mvc.ferriswheel.support.easyui.vo;


import com.micmiu.mvc.ferriswheel.core.model.AbstractQuery;
import com.micmiu.mvc.ferriswheel.core.model.SortType;
import com.micmiu.mvc.ferriswheel.utils.RefAnnotationUtil;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Easy UI Datagrid组件的查询抽象类. 专用于EasyUI,建议在VO命名中直观体现,并降低代码的耦合度.
 * 不建议在Query对象中直接返回查询结果及构造查询语句,VO对象不应包含PO层逻辑.
 * 若不支持EasyUI的Datagrid查询，建议其他查询类直接继承AbstractQuery.
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public abstract class DatagridQuery extends AbstractQuery {

	/**
	 * easyui datagrid提交升序常量.
	 */
	public static final String EASY_UI_SORT_ASC = "asc";

	/**
	 * easyui datagrid提交降序常量.
	 */
	public static final String EASY_UI_SORT_DESC = "desc";

	private int page = 1;

	private int rows = DEFAULT_ITEMS_PERPAGE;

	private String sort;

	private String order;

	/**
	 * 获取每页记录数.
	 *
	 * @return 每页记录数
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * 设置每页记录数.
	 *
	 * @param rows 每页记录数
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * 获取当前页数.
	 *
	 * @return 页数
	 */
	public int getPage() {
		return page;
	}

	/**
	 * 设置当前页数.
	 *
	 * @param page 页数
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * 获取排序字段.
	 *
	 * @return 排序字段
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * 设置排序字段.
	 *
	 * @param sort 排序字段
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * 获取排序方式.
	 *
	 * @return 排序方式
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * 设置排序方式.
	 *
	 * @param order 排序方式
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * 获取子类所有排序字段及排序顺序Map. 需要生成的字段值可用@SortProperty标示.
	 *
	 * @return Map<String, String> 排序字段Map
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, SortType> getSortProperties() {
		// 优先处理EasyUI提交的排序字段.
		// 排序字段有先后顺序, 必须采用LinkedHashMap
		Map<String, SortType> easyuiSortProperties = new LinkedHashMap<String, SortType>();
		List<Field> properties = RefAnnotationUtil.getAllPublicFields(getClass());
		for (Field p : properties) {
			if (getQueryPropertyName(p.getName()).equals(this.sort)) {
				if (EASY_UI_SORT_ASC.equals(this.order)) {
					easyuiSortProperties.put(getQueryPropertyName(p.getName()),
							SortType.ASC);
				} else if (EASY_UI_SORT_DESC.equals(this.order)) {
					easyuiSortProperties.put(getQueryPropertyName(p.getName()),
							SortType.DESC);
				}
			}
		}
		easyuiSortProperties.putAll(super.getSortProperties());
		return easyuiSortProperties;
	}

	@Override
	public int getPageNo() {
		return this.getPage();
	}

	@Override
	public int getPageRows() {
		return this.getRows();
	}

	@Override
	public int getStartIndex() {
		return (page - 1) * rows;
	}

}
