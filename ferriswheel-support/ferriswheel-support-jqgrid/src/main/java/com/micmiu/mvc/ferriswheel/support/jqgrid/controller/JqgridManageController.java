package com.micmiu.mvc.ferriswheel.support.jqgrid.controller;

import com.micmiu.mvc.ferriswheel.core.FerriswheelConstant;
import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;
import com.micmiu.mvc.ferriswheel.core.model.OperationType;
import com.micmiu.mvc.ferriswheel.core.model.Page;
import com.micmiu.mvc.ferriswheel.support.jqgrid.model.JqgridPage;
import com.micmiu.mvc.ferriswheel.support.jqgrid.model.JqgridQuery;
import com.micmiu.mvc.ferriswheel.support.spring.mvc.SpringBaseManageController;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

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

	@RequestMapping(params = {"oper=add"})
	@ResponseBody
	public String create(E entity, HttpServletRequest request) {
		checkAuth(OperationType.CREATE.getValue());
		if (this.handler4Create(request, entity)) {
			getBaseService().create(entity);
		}
		String message = messageSource.getMessage(FerriswheelConstant.FW_MSG_SUCC,
				null, RequestContextUtils.getLocale(request));
		return message;
	}

	@RequestMapping(params = {"oper=edit"})
	@ResponseBody
	public String update(E entity, HttpServletRequest request) {
		checkAuth(OperationType.UPDATE.getValue());
		if (this.handler4Update(request, entity)) {
			getBaseService().update(entity);
		}
		String message = messageSource.getMessage(FerriswheelConstant.FW_MSG_SUCC,
				null, RequestContextUtils.getLocale(request));
		return message;
	}

	@RequestMapping(params = {"oper=del"})
	public String delete(ID id, RedirectAttributes redirectAttributes,
						 HttpServletRequest request) {
		checkAuth(OperationType.DELETE.getValue());
		StringBuffer msgkey = new StringBuffer();
		String message = null;
		if (allowDeleteData(id, msgkey)) {
			getBaseService().delete(id);
			message = messageSource.getMessage(FerriswheelConstant.FW_MSG_SUCC, null,
					RequestContextUtils.getLocale(request));
		} else {
			message = messageSource.getMessage(msgkey.toString(), null,
					RequestContextUtils.getLocale(request));
		}
		redirectAttributes.addFlashAttribute("message", message);
		return this.getRedirectView();
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