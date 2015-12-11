package com.micmiu.mvc.ferriswheel.support.spring.mvc;


import com.micmiu.mvc.ferriswheel.core.entity.FerriswheelID;
import com.micmiu.mvc.ferriswheel.core.model.AbstractQuery;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * 进一步简单实现了基本CRUD+Export功能
 *
 * @param <E>  实体类
 * @param <ID> 注解
 * @param <Q>  查询vo
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */

public abstract class SpringSimpleManageController<E extends FerriswheelID, ID extends Serializable, Q extends AbstractQuery>
		extends SpringBaseManageController<E, E, ID, Q> {

	public SpringSimpleManageController() {
		super();
	}

	@Override
	protected E convertE2V(E e, HttpServletRequest request) {
		return e;
	}

}