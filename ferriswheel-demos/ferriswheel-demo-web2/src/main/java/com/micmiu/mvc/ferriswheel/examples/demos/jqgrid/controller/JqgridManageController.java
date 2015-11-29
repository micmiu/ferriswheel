package com.micmiu.mvc.ferriswheel.examples.demos.jqgrid.controller;

import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;
import com.micmiu.mvc.ferriswheel.core.model.Page;
import com.micmiu.mvc.ferriswheel.examples.demos.jqgrid.model.JqgridPage;
import com.micmiu.mvc.ferriswheel.examples.demos.jqgrid.model.JqgridQuery;
import com.micmiu.mvc.ferriswheel.support.spring.mvc.SpringBaseManageController;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 11/29/2015
 * Time: 22:54
 */
public abstract class JqgridManageController<E extends FerriswheelID, V, ID extends Serializable, Q extends JqgridQuery>
		extends SpringBaseManageController<E, V, ID, Q> {

	public JqgridManageController() {
		super();
	}

	@Override
	protected void parseQuery(HttpServletRequest request, Q query) {
		//
	}


	@Override
	protected Page<V> convertPageE2V(Page<E> pageE, HttpServletRequest request) {
		return new JqgridPage<V>(super.convertPageE2V(pageE, request));
	}

}