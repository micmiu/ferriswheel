package com.micmiu.mvc.ferrissheel.example.core.mybatis;

import com.micmiu.mvc.ferriswheel.examples.core.entity.User;
import com.micmiu.mvc.ferriswheel.examples.core.service.UserService;
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
 * Created User test
 * User: <a href="http://micmiu.com">micmiu</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-mybatis-test.xml"})
@ActiveProfiles("test")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UserMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	AtomicInteger atom = new AtomicInteger();

	@Autowired
	private UserService service;

	@Test
	public void testCreate() {

		int beforeDbCount = service.selectCountAll();
		User entity = mockEntity();
		System.out.println(entity.getId());
		int size = service.insert(entity);
		System.out.println(size);
		System.out.println(entity.getId());
		int afterDbCount = service.selectCountAll();
		Assert.assertEquals(beforeDbCount + 1, afterDbCount);
	}

	@Test
	public void testUpdate() {

		User entity = mockEntity();
		service.insert(entity);
		Long id = entity.getId();

		String expect = "micmiu.com";
		Assert.assertNotSame(expect, entity.getOther());
		entity.setOther(expect);
		service.updateByPrimaryKey(entity);

		Assert.assertEquals(expect, service.selectByPrimaryKey(id).getOther());

	}

	@Test
	public void testDelete() {
		User entity = mockEntity();
		service.insert(entity);
		int beforeDelCount = service.selectCountAll();
		service.deleteByPrimaryKey(entity.getId());
		int afterDelCount = service.selectCountAll();
		Assert.assertEquals(beforeDelCount - 1, afterDelCount);
	}

	@Test
	public void testList() {

		int count1 = service.selectCountAll();
		User entity = mockEntity();
		service.insert(entity);
		int count2 = service.selectCountAll();
		Assert.assertEquals(count1 + 1, count2);

	}

	public User mockEntity() {
		long randomKey = atom.addAndGet(100);
		User entity = new User();
		entity.setLoginName("micmiu_" + randomKey);
		entity.setEmail(randomKey + "@micmiu.com");
		entity.setName("micmiu_" + randomKey);
		entity.setPassword("password");
		entity.setOther("junit test.");
		return entity;
	}

}
