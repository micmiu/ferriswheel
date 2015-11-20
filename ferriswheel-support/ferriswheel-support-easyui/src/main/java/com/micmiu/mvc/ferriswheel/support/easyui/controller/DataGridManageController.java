package com.micmiu.mvc.ferriswheel.support.easyui.controller;

import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;
import com.micmiu.mvc.ferriswheel.core.model.Page;
import com.micmiu.mvc.ferriswheel.support.easyui.vo.DatagridPage;
import com.micmiu.mvc.ferriswheel.support.easyui.vo.DatagridQuery;
import com.micmiu.mvc.ferriswheel.support.spring.mvc.SpringBaseManageController;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 11/19/2015
 * Time: 13:38
 */
public abstract class DataGridManageController<E extends FerriswheelID, V, ID extends Serializable, Q extends DatagridQuery>
		extends SpringBaseManageController<E, V, ID, Q> {

	@Override
	protected Page convertPageE2V(Page<E> pageE, HttpServletRequest request) {
		Page<V> pageV = new DatagridPage<V>();
		try {
			BeanUtils.copyProperties(pageV, pageE);
			List<V> vlist = new ArrayList<V>();
			for (E e : pageE.getPageList()) {
				vlist.add(this.convertE2V(e, request));
			}
			pageV.setPageList(vlist);
		} catch (Exception e) {
			logger.warn("convert Page<E> to Page<V> error:", e);
		}
		return pageV;
	}
}
