package com.micmiu.mvc.ferriswheel.support.mybatis;

import com.micmiu.mvc.ferriswheel.support.mybatis.entity.Blog;
import com.micmiu.mvc.ferriswheel.support.mybatis.service.BlogService;
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
public class BlogMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	AtomicInteger atom = new AtomicInteger();

	@Autowired
	private BlogService service;

	@Test
	public void testCreate() {

		int beforeDbCount = service.queryAll().size();
		Blog entity = mockEntity();
		service.create(entity);
		int afterDbCount = service.queryAll().size();
		Assert.assertEquals(beforeDbCount + 1, afterDbCount);
	}

	@Test
	public void testUpdate() {

		Blog entity = mockEntity();
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
		Blog entity = mockEntity();
		service.create(entity);
		int count2 = service.queryAll().size();
		Assert.assertEquals(count1 + 1, count2);

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
