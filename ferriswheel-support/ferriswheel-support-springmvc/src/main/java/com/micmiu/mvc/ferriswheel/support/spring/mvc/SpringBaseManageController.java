package com.micmiu.mvc.ferriswheel.support.spring.mvc;


import com.micmiu.mvc.ferriswheel.core.annotation.AnnotationUtils;
import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;
import com.micmiu.mvc.ferriswheel.core.model.AbstractQuery;
import com.micmiu.mvc.ferriswheel.core.model.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 进一步简单实现了基本CRUD+Export功能
 *
 * @param <E>  实体类
 * @param <ID> 注解
 * @param <Q>  查询vo
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */

public abstract class SpringBaseManageController<E extends FerriswheelID, V, ID extends Serializable, Q extends AbstractQuery>
		extends SpringAbstractManageController<E, V, ID, Q> {
	protected static final String SHOWLIST_PAGE = "list";
	protected static final String SHOWFORM_PAGE = "form";
	protected static final String READ_PAGE = "view";

	public SpringBaseManageController() {
		super();
	}

	@Override
	protected void checkAuth(String operation) {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.checkPermission(this.getPermssionName() + ":" + operation);
	}

	/**
	 * 以小写类名作为权限别名
	 */
	@Override
	protected String getPermssionName() {
		return this.clazz.getSimpleName().toLowerCase();
	}

	/**
	 * 以小写类名作为form属性
	 */
	@Override
	protected String getModelAttr() {
		return this.clazz.getSimpleName().toLowerCase();
	}

	@Override
	protected String getViewPage(String operation) {
		if ("read".equals(operation)) {
			return this.getViewPrefix() + this.getViewDelimiter() + READ_PAGE;
		} else if ("showForm".endsWith(operation)) {
			return this.getViewPrefix() + this.getViewDelimiter() + SHOWFORM_PAGE;
		} else if ("showList".equals(operation)) {
			return this.getViewPrefix() + this.getViewDelimiter() + SHOWLIST_PAGE;
		}
		return getRedirectView();
	}

	@Override
	protected String getShowListPage() {
		return this.getViewPrefix() + this.getViewDelimiter() + SHOWLIST_PAGE;
	}

	@Override
	protected String getShowFormPage() {
		return this.getViewPrefix() + this.getViewDelimiter() + SHOWFORM_PAGE;
	}

	@Override
	protected String getReadPage() {
		return this.getViewPrefix() + this.getViewDelimiter() + READ_PAGE;
	}

	@Override
	protected void handler4ListShow(HttpServletRequest request, Model model) {
	}

	@Override
	protected boolean handler4Create(HttpServletRequest request, E entity) {
		return true;
	}

	@Override
	protected void handler4CreateShow(HttpServletRequest request, E entity, Model model) {
	}

	@Override
	protected void handler4UpdateShow(HttpServletRequest request, E entity, Model model) {
	}

	@Override
	protected boolean handler4Save(HttpServletRequest request, E entity) {
		return true;
	}

	@Override
	protected boolean handler4Update(HttpServletRequest request, E entity) {
		return true;
	}

	@Override
	protected boolean allowDeleteData(ID id, StringBuffer msgkey) {
		return true;
	}

	@Override
	protected boolean allowDeleteData(ID[] ids, StringBuffer msgkey) {
		return true;
	}

	@Override
	protected void parseQuery(HttpServletRequest request, Q query) {
		// noting to do for base

	}

	@Override
	protected void handler4Export(HttpServletRequest request, Map<String, Object> model) {
		model.put(ControllerConstant.KEY_EXPORT_FILENAME, messageSource.getMessage(
				this.clazz.getSimpleName().toLowerCase() + "." + ControllerConstant.KEY_EXPORT_FILENAME, null,
				ControllerConstant.KEY_EXPORT_FILENAME, RequestContextUtils.getLocale(request)));
		model.put(ControllerConstant.KEY_EXPORT_SHEETNAME, messageSource.getMessage(
				this.clazz.getSimpleName().toLowerCase() + "." + ControllerConstant.KEY_EXPORT_SHEETNAME, null,
				ControllerConstant.KEY_EXPORT_SHEETNAME, RequestContextUtils.getLocale(request)));
		model.put(ControllerConstant.KEY_EXPORT_TITLE, messageSource.getMessage(
				this.clazz.getSimpleName().toLowerCase() + "." + ControllerConstant.KEY_EXPORT_TITLE, null,
				ControllerConstant.KEY_EXPORT_TITLE, RequestContextUtils.getLocale(request)));
		model.put(ControllerConstant.KEY_EXPORT_COLUMN_MAP, AnnotationUtils.getBeanShwoParamMap(this.clazz, messageSource,
				RequestContextUtils.getLocale(request)));
	}

	protected abstract V convertE2V(E e, HttpServletRequest request);

	@Override
	protected Page<V> convertPageE2V(Page<E> pageE, HttpServletRequest request) {
		Page<V> pageV = new Page<V>();
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