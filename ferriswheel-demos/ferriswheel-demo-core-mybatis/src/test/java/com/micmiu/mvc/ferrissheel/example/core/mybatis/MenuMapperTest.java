package com.micmiu.mvc.ferrissheel.example.core.mybatis;

import com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity.Menu;
import com.micmiu.mvc.ferriswheel.examples.core.mybatis.service.MenuService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-mybatis-test.xml"})
@ActiveProfiles("test")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class MenuMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	AtomicInteger atom = new AtomicInteger();

	@Autowired
	private MenuService service;

	@Test
	public void testCreate() {

		int beforeDbCount = service.selectCountAll();
		Menu entity = mockEntity();
		System.out.println(entity.getId());
		int size = service.insert(entity);
		System.out.println(size);
		System.out.println(entity.getId());
		int afterDbCount = service.selectCountAll();
		Assert.assertEquals(beforeDbCount + 1, afterDbCount);
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

	@Test
	public void testDelete() {
		Menu entity = mockEntity();
		service.insert(entity);
		int beforeDelCount = service.selectCountAll();
		service.deleteByPrimaryKey(entity.getId());
		int afterDelCount = service.selectCountAll();
		Assert.assertEquals(beforeDelCount - 1, afterDelCount);
	}

	@Test
	public void testList() {

		int count1 = service.selectCountAll();
		Menu entity = mockEntity();
		service.insert(entity);
		int count2 = service.selectCountAll();
		Assert.assertEquals(count1 + 1, count2);

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
