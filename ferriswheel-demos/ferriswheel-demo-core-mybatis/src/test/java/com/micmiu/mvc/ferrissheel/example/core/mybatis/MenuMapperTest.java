package com.micmiu.mvc.ferrissheel.example.core.mybatis;

import com.micmiu.mvc.ferriswheel.examples.core.entity.Menu;
import com.micmiu.mvc.ferriswheel.examples.core.service.MenuService;
import com.micmiu.mvc.ferriswheel.orm.mybatis.entity.Blog;
import com.micmiu.mvc.ferriswheel.orm.mybatis.service.BlogService;
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

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 5/26/2014
 * Time: 23:32
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

		int beforeDbCount = service.queryAll().size();
		Menu entity = mockEntity();
		service.create(entity);
		int afterDbCount = service.queryAll().size();
		Assert.assertEquals(beforeDbCount + 1, afterDbCount);
	}

	@Test
	public void testUpdate() {

		Menu entity = mockEntity();
		service.create(entity);
		Long id = entity.getId();

		String expect = "Michael";
		Assert.assertNotSame(expect, entity.getAuthor());
		entity.setAuthor(expect);
		service.update(entity);

		Assert.assertEquals(expect, service.read(id).getAuthor());

	}

	@Test
	public void testDelete() {
		Long id = service.create(mockEntity());
		int beforeDelCount = service.queryAll().size();
		service.delete(id);
		int afterDelCount = service.queryAll().size();
		Assert.assertEquals(beforeDelCount - 1, afterDelCount);
	}

	@Test
	public void testList() {

		int count1 = service.queryAll().size();
		Menu entity = mockEntity();
		service.create(entity);
		int count2 = service.queryAll().size();
		Assert.assertEquals(count1 + 1, count2);

	}

	@Test
	public void testfindByURL() {

		Menu entity = mockEntity();
		Long id = service.create(entity);
		Menu entity2 = service.findByURL(entity.getUrl());
		Assert.assertEquals(id, entity2.getId());

	}

	public Menu mockEntity() {
		long randomKey = atom.addAndGet(100);
		Menu entity = new Menu();

		return entity;
	}

}
