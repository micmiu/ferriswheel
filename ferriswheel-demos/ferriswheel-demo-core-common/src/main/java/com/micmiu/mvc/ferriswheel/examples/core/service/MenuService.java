package com.micmiu.mvc.ferriswheel.examples.core.service;

import com.micmiu.mvc.ferriswheel.core.service.BaseService;
import com.micmiu.mvc.ferriswheel.examples.core.entity.Menu;

import java.util.List;

/**
 * 
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public interface MenuService extends BaseService<Menu, Long> {

	List<Menu> getRootMenuByOrder();

}
