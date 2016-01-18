package com.micmiu.mvc.ferriswheel.examples.core.mybatis.service;

import com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity.Menu;
import com.micmiu.mvc.ferriswheel.orm.mybatis.service.GenerateService;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 1/8/2016
 * Time: 23:11
 */
public interface MenuService extends GenerateService<Menu, Long> {

	Integer selectCountAll();
}
