package com.micmiu.mvc.ferriswheel.support.jqgrid.controller;

import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;
import com.micmiu.mvc.ferriswheel.core.model.Page;
import com.micmiu.mvc.ferriswheel.support.jqgrid.model.JqgridPage;
import com.micmiu.mvc.ferriswheel.support.jqgrid.model.JqgridQuery;
import com.micmiu.mvc.ferriswheel.support.spring.mvc.SpringBaseManageController;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	protected JqgridPage<V> convertPageE2V(Page<E> pageE, HttpServletRequest request) {
		JqgridPage<V> pageV = new JqgridPage<V>();
		try {
			BeanUtils.copyProperties(pageV, pageE);
			List<V> vlist = new ArrayList<V>();
			for (E e : pageE.getPageList()) {
				vlist.add(convertE2V(e, request));
			}
			pageV.setPageList(vlist);
		} catch (Exception e) {
			logger.warn("convert Page<E> to Page<V> error:", e);
		}
		pageV.setPage(pageV.getCurrentPage());
		pageV.setRecords(pageV.getTotalCount());
		pageV.setTotal(pageV.getPageCount());
		pageV.setRows(pageV.getPageList());
		return pageV;
	}

}