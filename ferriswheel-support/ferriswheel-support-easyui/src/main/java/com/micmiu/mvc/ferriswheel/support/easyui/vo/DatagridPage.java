package com.micmiu.mvc.ferriswheel.support.easyui.vo;

import com.micmiu.mvc.ferriswheel.core.model.Page;
import org.apache.commons.beanutils.BeanUtils;

import java.util.List;


/**
 * Easy UI Datagrid组件的页数据组件. 专用于EasyUI,建议在VO命名中直观体现,并降低代码的耦合度. Easy UI
 * Datagrid组件分页逻辑在前端由javascript完成,因此后台逻辑处理较Page<T>简化.
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class DatagridPage<T> extends Page<T> {

	/**
	 * 构造函数．
	 */
	public DatagridPage() {
	}

	/**
	 * 构造函数．
	 *
	 * @param page
	 */
	public DatagridPage(Page<T> page) {
		try {
			BeanUtils.copyProperties(this, page);
		} catch (Exception e) {
		}
	}

	/**
	 * 获取当页记录列表.
	 *
	 * @return List<T> 当页记录列表
	 */
	public List<T> getRows() {
		return getPageList();
	}

	/**
	 * 获取总记录数.
	 *
	 * @return long 总记录数
	 */
	public long getTotal() {
		return getTotalCount();
	}
}
