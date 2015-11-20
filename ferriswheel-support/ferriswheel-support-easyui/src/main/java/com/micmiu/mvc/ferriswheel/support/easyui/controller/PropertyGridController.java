package com.micmiu.mvc.ferriswheel.support.easyui.controller;

import com.micmiu.mvc.ferriswheel.core.annotation.AnnotationUtils;
import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;
import com.micmiu.mvc.ferriswheel.core.model.OperationType;
import com.micmiu.mvc.ferriswheel.support.easyui.EasyuiBeanUtils;
import com.micmiu.mvc.ferriswheel.support.easyui.vo.DatagridQuery;
import com.micmiu.mvc.ferriswheel.support.easyui.vo.PropertyGridData;
import com.micmiu.mvc.ferriswheel.support.spring.mvc.SimpleManageController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 11/12/2015
 * Time: 14:10
 */
public abstract class PropertyGridController<E extends FerriswheelID, V,ID extends Serializable, Q extends DatagridQuery>
		extends DataGridManageController<E,V, ID, Q> {


	@RequestMapping(params = {"method=getViewData"})
	@ResponseBody
	public Map<String, Object> getViewData(ID id, HttpServletRequest request) {
		checkAuth(OperationType.READ.getValue());
		Map<String, String> showMap = AnnotationUtils.getBeanShwoParamMap(clazz, messageSource,
				RequestContextUtils.getLocale(request));

		Map<String, Object> retMap = new HashMap<String, Object>();
		List<PropertyGridData> list = EasyuiBeanUtils.convertPropertyGridData(getBaseService().find(id),
				showMap);
		retMap.put("total", list.size());
		retMap.put("rows", list);
		return retMap;
	}
}
