package com.micmiu.mvc.ferriswheel.examples.demos.jqgrid.controller;

import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;
import com.micmiu.mvc.ferriswheel.examples.demos.jqgrid.model.JqgridQuery;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 11/29/2015
 * Time: 22:54
 */
public abstract class JqgridSimpleController<E extends FerriswheelID, ID extends Serializable, Q extends JqgridQuery>
		extends JqgridManageController<E, E, ID, Q> {

	public JqgridSimpleController() {
		super();
	}

	@Override
	protected void parseQuery(HttpServletRequest request, Q query) {
		//
	}

	@Override
	protected E convertE2V(E e, HttpServletRequest request) {
		return e;
	}
}