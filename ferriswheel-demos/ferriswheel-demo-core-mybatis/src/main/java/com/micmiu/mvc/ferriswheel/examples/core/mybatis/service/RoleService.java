package com.micmiu.mvc.ferriswheel.examples.core.mybatis.service;

import com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity.Role;
import com.micmiu.mvc.ferriswheel.orm.mybatis.service.GenerateService;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 6/29/2017
 * Time: 16:13
 */
public interface RoleService extends GenerateService<Role, Long> {

	Integer selectCountAll();

	Role selectOneExtById(Long id);
}
