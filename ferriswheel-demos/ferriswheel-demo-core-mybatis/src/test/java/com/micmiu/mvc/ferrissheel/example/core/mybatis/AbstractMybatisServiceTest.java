package com.micmiu.mvc.ferrissheel.example.core.mybatis;

import com.micmiu.mvc.ferriswheel.orm.mybatis.entity.MybatisEntity;
import com.micmiu.mvc.ferriswheel.orm.mybatis.service.GenerateService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
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
public abstract class AbstractMybatisServiceTest<T extends MybatisEntity, ID extends Serializable> extends AbstractTransactionalJUnit4SpringContextTests {

	AtomicInteger atom = new AtomicInteger();

	public abstract GenerateService getService();

	public abstract T mockEntity();


	@Test
	public void testCreate() {

		int beforeDbCount = getService().selectCountAll();
		T entity = mockEntity();
		int size = getService().insert(entity);
		Assert.assertEquals(1, size);
		int afterDbCount = getService().selectCountAll();
		Assert.assertEquals(beforeDbCount + 1, afterDbCount);
	}


	@Test
	public void testDelete() {
		T entity = mockEntity();
		Integer id = getService().insert(entity);
		int beforeDelCount = getService().selectCountAll();
		getService().deleteByPrimaryKey(entity.getId());
		int afterDelCount = getService().selectCountAll();
		Assert.assertEquals(beforeDelCount - 1, afterDelCount);
	}

	@Test
	public void testList() {

		int count1 = getService().selectCountAll();
		T entity = mockEntity();
		getService().insert(entity);
		int count2 = getService().selectCountAll();
		Assert.assertEquals(count1 + 1, count2);

	}


}
