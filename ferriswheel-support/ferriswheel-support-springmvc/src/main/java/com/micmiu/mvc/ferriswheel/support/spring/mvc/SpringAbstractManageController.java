package com.micmiu.mvc.ferriswheel.support.spring.mvc;


import com.micmiu.mvc.ferriswheel.core.FerriswheelConstant;
import com.micmiu.mvc.ferriswheel.core.controller.BaseManageController;
import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;
import com.micmiu.mvc.ferriswheel.core.model.AbstractQuery;
import com.micmiu.mvc.ferriswheel.core.model.OperationType;
import com.micmiu.mvc.ferriswheel.core.model.Page;
import com.micmiu.mvc.ferriswheel.core.service.BaseService;
import com.micmiu.mvc.ferriswheel.support.spring.mvc.views.CsvView;
import com.micmiu.mvc.ferriswheel.support.spring.mvc.views.JxlExcelView;
import com.micmiu.mvc.ferriswheel.support.spring.mvc.views.PdfiText5View;
import com.micmiu.mvc.ferriswheel.support.spring.mvc.views.PoiExcelView;
import com.micmiu.mvc.ferriswheel.utils.ReflectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 抽象Action 实现基本操作：CRUD+Export
 * <table><tr><td>method=showList</td><td>一般列表</td></tr>
 * <tr><td>method=pageQuery</td><td>分页列表</td></tr>
 * <tr><td>method=create</td><td>创建</td></tr>
 * <tr><td>method=read</td><td>读取</td></tr>
 * <tr><td>method=update</td><td>更新</td></tr>
 * <tr><td>method=delete</td><td>删除</td></tr>
 * <tr><td>method=export</td><td>导出</td></tr>
 * <tr><td>method=deleteBatch</td><td>批量删除</td></tr>
 * </table>
 *
 * @param <E>  实体类
 * @param <V>  展现的VO
 * @param <ID> 主键
 * @param <Q>  查询vo
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public abstract class SpringAbstractManageController<E extends FerriswheelID, V, ID extends Serializable, Q extends AbstractQuery> extends BaseManageController {

	protected static Logger logger = LoggerFactory.getLogger(SpringAbstractManageController.class);

	protected static final String RP_PARAM_CREATE = "method=create";
	protected static final String RP_PARAM_READ = "method=read";
	protected static final String RP_PARAM_UPDATE = "method=update";
	protected static final String RP_PARAM_DELETE = "method=delete";
	protected static final String RP_PARAM_SHOWLIST = "method=showList";

	@Autowired
	protected MessageSource messageSource;

	/**
	 * 实体Class.
	 */
	protected final Class<E> clazz;

	private String urlPrefix;

	@SuppressWarnings("unchecked")
	public SpringAbstractManageController() {
		this.clazz = ReflectionUtils.findParameterizedType(getClass(), 0);
		setUrlPrefix(getDefaultUrlPrefix());
	}

	/**
	 * 获取当前的service
	 *
	 * @return
	 */
	public abstract BaseService<E, ID> getBaseService();


	/**
	 * 获取模块的权限名称
	 *
	 * @return
	 */
	protected abstract String getPermssionName();

	/**
	 * showList page
	 *
	 * @return
	 */
	protected abstract String getShowListPage();

	/**
	 * showForm page
	 *
	 * @return
	 */
	protected abstract String getShowFormPage();

	/**
	 * showList
	 *
	 * @return
	 */
	protected abstract String getReadPage();

	/**
	 * 页面form attr 属性名称
	 *
	 * @return
	 */
	protected abstract String getModelAttr();

	/**
	 * 判断数据是否可以删除
	 *
	 * @param id
	 * @param msgkey
	 * @return true -> 可以删除 false->不能删除
	 */
	protected abstract boolean allowDeleteData(ID id, StringBuffer msgkey);

	/**
	 * 判断数据是否可以删除
	 *
	 * @param ids
	 * @param msgkey
	 * @return true -> 可以删除 false->不能删除
	 */
	protected abstract boolean allowDeleteData(ID[] ids, StringBuffer msgkey);

	/**
	 * 显示列表前自定义处理过程
	 *
	 * @param request
	 */
	protected abstract void handler4ListShow(HttpServletRequest request, Model model);

	/**
	 * 添加显示前自定义处理过程
	 *
	 * @param request
	 * @param entity
	 */
	protected abstract void handler4CreateShow(HttpServletRequest request, E entity, Model model);

	/**
	 * 更新显示前自定义处理过程
	 *
	 * @param request
	 * @param entity
	 */
	protected abstract void handler4UpdateShow(HttpServletRequest request, E entity, Model model);

	/**
	 *
	 *
	 * @param request
	 * @param entity
	 */
	/**
	 * 保存（添加或者更新）自定义处理过程
	 *
	 * @param request
	 * @param entity
	 * @return 如果是true 父类中执行更新实体类 false 父类中不执行更新实体类
	 */
	protected abstract boolean handler4Save(HttpServletRequest request, E entity);

	/**
	 * 添加操作的自定义处理过程
	 *
	 * @param request
	 * @param entity
	 * @return 如果是true 父类中执行添加实体类 false 父类中不执行添加实体类
	 */
	protected abstract boolean handler4Create(HttpServletRequest request, E entity);

	/**
	 * 更新操作的自定义处理过程
	 *
	 * @param request
	 * @param entity
	 * @return 如果是true 父类锺更新实体类 false 父类中不在更新实体类
	 */
	protected abstract boolean handler4Update(HttpServletRequest request, E entity);

	/**
	 * 2013-12-10 增加自定义转换查询参数的bean
	 *
	 * @param request
	 * @param query
	 */
	protected abstract void parseQuery(HttpServletRequest request, Q query);

	/**
	 * 导出前自定义处理过程
	 *
	 * @param request
	 * @param model
	 */
	protected abstract void handler4Export(HttpServletRequest request, Map<String, Object> model);

	/**
	 * 分页查询的结果转为自定义的vo
	 *
	 * @param pageE
	 * @param pageE
	 */
	protected abstract Page<V> convertPageE2V(Page<E> pageE, HttpServletRequest request);

	public String getUrlPrefix() {
		return urlPrefix;
	}

	public void setUrlPrefix(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}

	@Override
	protected String getRedirectView() {
		return "redirect:" + this.getUrlPrefix() + "?" + RP_PARAM_SHOWLIST;
	}

	/**
	 * 获取空实体对象
	 *
	 * @return
	 */
	protected E getNewInstance() {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	protected String getDefaultUrlPrefix() {
		String currentPrefix = "";
		RequestMapping requestMapping = AnnotationUtils.findAnnotation(getClass(), RequestMapping.class);
		if (requestMapping != null && requestMapping.value().length > 0) {
			currentPrefix = requestMapping.value()[0];
		}
		if (StringUtils.isEmpty(currentPrefix)) {
			currentPrefix = this.clazz.getSimpleName();
		}
		return currentPrefix;
	}

	@RequestMapping(params = {RP_PARAM_CREATE})
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


	@RequestMapping(params = {RP_PARAM_READ})
	public String read(ID id, Model model) {
		checkAuth(OperationType.READ.getValue());
		model.addAttribute(getModelAttr(), getBaseService().find(id));
		return getReadPage();
	}

	@RequestMapping(params = {RP_PARAM_UPDATE})
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

	@RequestMapping(params = {RP_PARAM_DELETE})
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

	/**
	 * 显示列表页面
	 *
	 * @return
	 */
	@RequestMapping(params = {RP_PARAM_SHOWLIST})
	public String showList(Model model, HttpServletRequest request) {
		checkAuth(OperationType.READ.getValue());
		this.handler4ListShow(request, model);
		return getShowListPage();
	}

	@RequestMapping(params = {"method=pageQuery"})
	@ResponseBody
	public Page<V> pageQuery(Model model, Q query, HttpServletRequest request) {
		checkAuth(OperationType.READ.getValue());
		parseQuery(request, query);
		Page<E> pageE = doPagedQuery(query, getBaseService(),
				query.getPageNo(), query.getPageRows());
		return convertPageE2V(pageE, request);
	}


	@RequestMapping(params = {"method=showForm"})
	public String showForm(HttpServletRequest request, ID id, Model model) {
		E entity;
		if (null != id) {
			checkAuth(OperationType.UPDATE.getValue());
			entity = getBaseService().find(id);
			this.handler4UpdateShow(request, entity, model);
			model.addAttribute("showFormType", "update");
		} else {
			checkAuth(OperationType.CREATE.getValue());
			entity = getNewInstance();
			this.handler4CreateShow(request, entity, model);
			model.addAttribute("showFormType", "create");
		}
		model.addAttribute(this.getModelAttr(), entity);
		return getShowFormPage();
	}


	@RequestMapping(params = "method=deleteBatch")
	@ResponseBody
	public String deleteBatch(HttpServletRequest request, ID[] ids) {
		checkAuth(OperationType.DELETE.getValue());
		String message = null;
		try {
			StringBuffer msgkey = new StringBuffer();
			if (this.allowDeleteData(ids, msgkey)) {
				getBaseService().delete(ids);
				message = messageSource.getMessage(FerriswheelConstant.FW_MSG_SUCC, null, RequestContextUtils.getLocale(request));
			} else {
				message = messageSource.getMessage(msgkey.toString(), null, RequestContextUtils.getLocale(request));
			}
		} catch (Exception e) {
			message = messageSource.getMessage(FerriswheelConstant.FW_MSG_FAILED, null, RequestContextUtils.getLocale(request));
		}
		return message;
	}

	@RequestMapping(params = {"method=export"}, method = RequestMethod.POST)
	public ModelAndView export(HttpServletRequest request, Q pageQuery,
							   String exportType) {
		checkAuth(OperationType.EXPORT.getValue());
		parseQuery(request, pageQuery);
		List<E> list = getBaseService().query(pageQuery.getQueryProperties(), pageQuery.getSortProperties());
		Map<String, Object> model = new HashMap<String, Object>();
		this.handler4Export(request, model);
		model.put(FerriswheelConstant.EXPORT_ROW_DATA, list);
		if ("POI".equals(exportType)) {
			return new ModelAndView(new PoiExcelView(), model);
		} else if ("JXL".equals(exportType)) {
			return new ModelAndView(new JxlExcelView(), model);
		} else if ("CSV".equals(exportType)) {
			return new ModelAndView(new CsvView(), model);
		}
		return new ModelAndView(new PdfiText5View(), model);
	}

	/**
	 * 封装分页查询逻辑. 考虑到各子类实现对分页查询的权限配置需求的差异,作为protected方法,以避免该方法直接对外暴露.
	 *
	 * @param q    查询对象
	 * @param s    查询Service
	 * @param pg   当前页
	 * @param rows 每页记录数
	 * @return Page<E> 页对象
	 */
	protected Page<E> doPagedQuery(AbstractQuery q, BaseService<E, ID> s,
								   int pg, int rows) {
		Page<E> page = new Page<E>();
		page.setCurrentPage(pg);
		page.setRowsPerPage(rows);
		page.setPageList(s.query(q.getQueryProperties(), q.getSortProperties(), (pg - 1) * rows, rows));
		page.setTotalCount(s.count(q.getQueryProperties()));
		return page;
	}

}
