package com.micmiu.mvc.ferriswheel.support.datatables.controller;


import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;
import com.micmiu.mvc.ferriswheel.core.model.Page;
import com.micmiu.mvc.ferriswheel.support.datatables.model.DataTablesPage;
import com.micmiu.mvc.ferriswheel.support.datatables.model.DataTablesQuery;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * 实现了datables基本CRUD+Export功能
 *
 * @param <E>  实体类
 * @param <ID> 注解
 * @param <Q>  查询vo
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */

public abstract class DatatablesSimpleController<E extends FerriswheelID, ID extends Serializable, Q extends DataTablesQuery>
		extends DatatablesManageController<E, E, ID, Q> {

	public DatatablesSimpleController() {
		super();
	}

	@Override
	protected E convertE2V(E e, HttpServletRequest request) {
		return e;
	}

	@Override
	protected Page<E> convertPageE2V(Page<E> pageE, HttpServletRequest request) {
		return pageE;
	}
}