package com.micmiu.mvc.ferriswheel.orm.mybatis;

import com.micmiu.mvc.ferriswheel.orm.mybatis.service.BlogService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 5/26/2014
 * Time: 23:22
 */
public class TestMain {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "test");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-mybatis-test.xml");
		BlogService service = (BlogService) ctx.getBean("blogService");
		service.testTran();

	}


}
