package com.micmiu.mvc.ferriswheel.support.datatables.controller;


import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;
import com.micmiu.mvc.ferriswheel.core.model.AbstractQuery;
import com.micmiu.mvc.ferriswheel.core.model.OperationType;
import com.micmiu.mvc.ferriswheel.core.model.Page;
import com.micmiu.mvc.ferriswheel.core.service.BaseService;
import com.micmiu.mvc.ferriswheel.support.datatables.model.DataTablesPage;
import com.micmiu.mvc.ferriswheel.support.datatables.model.DataTablesQuery;
import com.micmiu.mvc.ferriswheel.support.spring.mvc.SpringBaseManageController;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于datatables组件的controller
 *
 * @param <E>  实体类
 * @param <ID> 注解
 * @param <Q>  查询vo
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */

public abstract class DatatablesManageController<E extends FerriswheelID, V, ID extends Serializable, Q extends DataTablesQuery>
		extends SpringBaseManageController<E, V, ID, Q> {

	public DatatablesManageController() {
		super();
	}

	@RequestMapping(params = {"method=read4json"})
	@ResponseBody
	public E read4json(ID id) {
		checkAuth(OperationType.READ.getValue());
		return getBaseService().find(id);
	}

	@Override
	protected void parseQuery(HttpServletRequest request, Q query) {
		String sortColIndex = request.getParameter("iSortCol_0");
		if (null == sortColIndex || "".equals(sortColIndex)) {
			return;
		}
		try {
			int sortNameIndex = Integer.parseInt(sortColIndex);
			String sortName = request
					.getParameter("mDataProp_" + sortNameIndex);
			if (null == sortName || "".equals(sortName)
					|| "null".equals(sortName)) {
				return;
			}
			query.setSortName(sortName);
			String sortTypeStr = request.getParameter("sSortDir_0");
			if (null == sortTypeStr || "".equals(sortTypeStr)) {
				query.setSortType("asc");
			} else {
				query.setSortType(sortTypeStr);
			}

		} catch (Exception e) {
			logger.warn(e.toString());
		}
	}

	@Override
	protected Page<E> doPagedQuery(AbstractQuery q, BaseService<E, ID> s, int pg, int rows) {
		Page<E> pageE = super.doPagedQuery(q, s, pg, rows);
		DataTablesPage dataTablesPage = new DataTablesPage(super.doPagedQuery(q, s, pg, rows));
		try {
			BeanUtils.copyProperties(dataTablesPage, pageE);
		} catch (Exception e) {
			logger.warn("convert Page<E> to DataTablesPage error:", e);
		}
		dataTablesPage.setsEcho(((DataTablesQuery) q).getsEcho());
		return dataTablesPage;
	}

	@Override
	protected Page<V> convertPageE2V(Page<E> pageE, HttpServletRequest request) {
		Page<V> pageV = new DataTablesPage<V>();
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
		return pageV;
	}

}