package com.micmiu.mvc.ferriswheel.examples.core.mybatis.service;

import com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity.Permission;
import com.micmiu.mvc.ferriswheel.orm.mybatis.service.GenerateService;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 6/29/2017
 * Time: 16:12
 */
public interface PermissionService extends GenerateService<Permission, Long> {

	Integer selectCountAll();
}
