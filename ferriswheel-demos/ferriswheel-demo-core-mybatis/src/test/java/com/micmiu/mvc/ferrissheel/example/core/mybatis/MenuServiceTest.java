package com.micmiu.mvc.ferrissheel.example.core.mybatis;

import com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity.Menu;
import com.micmiu.mvc.ferriswheel.examples.core.mybatis.service.MenuService;
import com.micmiu.mvc.ferriswheel.orm.mybatis.service.GenerateService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 1/18/2016
 * Time: 16:34
 */
public class MenuServiceTest extends AbstractMybatisServiceTest<Menu,Long> {

	@Autowired
	private MenuService service;

	@Override
	public GenerateService getService() {
		return service;
	}


	@Test
	public void testUpdate() {

		Menu entity = mockEntity();
		service.insert(entity);
		Long id = entity.getId();

		String expect = "micmiu.com";
		Assert.assertNotSame(expect, entity.getMenuUrl());
		entity.setMenuUrl(expect);
		service.updateByPrimaryKey(entity);

		Assert.assertEquals(expect, service.selectByPrimaryKey(id).getMenuUrl());

	}

	public Menu mockEntity() {
		int randomKey = atom.addAndGet(100);
		Menu entity = new Menu();
		entity.setAliasName("demo_" + randomKey);
		entity.setMenuName("demo_" + randomKey);
		entity.setMenuType("");
		entity.setMenuUrl("demo/mybatis");
		entity.setOrderNum(randomKey);

		return entity;
	}
}
