package com.micmiu.mvc.ferriswheel.examples.core.mybatis;

import com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity.User;
import com.micmiu.mvc.ferriswheel.examples.core.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 1/18/2016
 * Time: 16:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-mybatis-test.xml"})
@ActiveProfiles("test")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UserService userService;

	@Test
	public void test() {

		User user = userService.selectOneByLoginName("admin");
		System.out.println(" ============ ");
		System.out.println(user);

	}
}
