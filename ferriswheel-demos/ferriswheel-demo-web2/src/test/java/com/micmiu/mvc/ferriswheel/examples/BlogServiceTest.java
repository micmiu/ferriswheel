package com.micmiu.mvc.ferriswheel.examples;

import com.micmiu.mvc.ferriswheel.examples.web2.demos.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 5/4/2017
 * Time: 04:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@ActiveProfiles("dev")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BlogServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private BlogService blogService;

	@Test
	public void test() {
		List<Object[]> list = blogService.queryStatic();
		for (Object[] arr : list) {
			System.out.println(arr[0]+" -- "+arr[1]);
		}

	}

}
