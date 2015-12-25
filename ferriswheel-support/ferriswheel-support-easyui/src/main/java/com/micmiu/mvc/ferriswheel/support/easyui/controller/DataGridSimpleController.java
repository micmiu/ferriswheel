package com.micmiu.mvc.ferriswheel.support.easyui.controller;

import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;
import com.micmiu.mvc.ferriswheel.support.easyui.vo.DatagridQuery;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Easyui基础controller
 * User: <a href="http://micmiu.com">micmiu</a>
 */
public abstract class DataGridSimpleController<E extends FerriswheelID, ID extends Serializable, Q extends DatagridQuery>
		extends PropertyGridController<E, E, ID, Q> {
	@Override
	protected E convertE2V(E e, HttpServletRequest request) {
		return e;
	}
}
