package com.micmiu.mvc.ferrissheel.example.core.mybatis;

import com.micmiu.mvc.ferriswheel.examples.core.entity.Blog;
import com.micmiu.mvc.ferriswheel.examples.core.service.BlogService;
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
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-mybatis-test.xml"})
@ActiveProfiles("test")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BlogMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	AtomicInteger atom = new AtomicInteger();

	@Autowired
	private BlogService service;

	@Test
	public void testCreate() {

		int beforeDbCount = service.queryAll().size();
		Blog entity = mockEntity();
		int size = service.insert(entity);
		Assert.assertEquals(1, size);
		int afterDbCount = service.queryAll().size();
		Assert.assertEquals(beforeDbCount + 1, afterDbCount);
	}

	@Test
	public void testUpdate() {

		Blog entity = mockEntity();
		service.insert(entity);
		Long id = entity.getId();

		String expect = "Michael";
		Assert.assertNotSame(expect, entity.getAuthor());
		entity.setAuthor(expect);
		System.out.println(entity);
		service.updateByPrimaryKey(entity);

		Assert.assertEquals(expect, service.selectByPrimaryKey(id).getAuthor());

	}

	@Test
	public void testDelete() {
		Integer id = service.insert(mockEntity());
		int beforeDelCount = service.queryAll().size();
		service.deleteByPrimaryKey(id.longValue());
		int afterDelCount = service.queryAll().size();
		Assert.assertEquals(beforeDelCount - 1, afterDelCount);
	}

	@Test
	public void testList() {

		int count1 = service.queryAll().size();
		Blog entity = mockEntity();
		service.insert(entity);
		int count2 = service.queryAll().size();
		Assert.assertEquals(count1 + 1, count2);

	}

	@Test
	public void testfindByURL() {

		Blog entity = mockEntity();
		int size = service.insert(entity);
		Assert.assertEquals(1, size);
		Blog entity2 = service.findByURL(entity.getUrl());
		Assert.assertEquals(entity.getId(), entity2.getId());

	}

	public Blog mockEntity() {
		long randomKey = atom.addAndGet(100);
		Blog entity = new Blog();
		entity.setTitle("mvc" + randomKey);
		entity.setAuthor("micmiu");
		entity.setCategory("J2EE/MVC");
		entity.setUrl("http://micmiu.com/j2ee/mvc" + randomKey);
		entity.setPublishDate(new Date());
		return entity;
	}

}
