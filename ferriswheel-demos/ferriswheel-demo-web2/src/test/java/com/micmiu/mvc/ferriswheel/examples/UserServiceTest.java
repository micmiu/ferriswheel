package com.micmiu.mvc.ferriswheel.examples;

import com.micmiu.mvc.ferriswheel.examples.core.entity.User;
import com.micmiu.mvc.ferriswheel.examples.core.service.UserService;
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
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UserService userService;

	@Test
	public void test() {
		List<User> list = userService.query("roleId", 1L);
		System.out.println("list size =:" + list.size());
		for (User user : list) {
			System.out.println(user);
		}
	}

}
