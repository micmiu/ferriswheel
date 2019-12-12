package com.micmiu.mvc.ferriswheel.examples.core.mybatis;

import com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity.Blog;
import com.micmiu.mvc.ferriswheel.examples.core.mybatis.service.BlogService;
import com.micmiu.mvc.ferriswheel.orm.mybatis.service.GenerateService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 1/18/2016
 * Time: 16:34
 */
public class BlogServiceTest extends AbstractMybatisServiceTest<Blog,Long> {

	@Autowired
	private BlogService blogService;

	@Override
	public GenerateService getService() {
		return blogService;
	}


	@Test
	public void testUpdate() {

		Blog entity = mockEntity();
		getService().insert(entity);
		String expect = "Michael";
		Assert.assertNotSame(expect, entity.getAuthor());
		entity.setAuthor(expect);
		System.out.println(entity);
		getService().updateByPrimaryKey(entity);

		Assert.assertEquals(expect, blogService.selectByPrimaryKey(entity.getId()).getAuthor());

	}

	@Test
	public void testfindByURL() {

		Blog entity = mockEntity();
		int size = getService().insert(entity);
		Assert.assertEquals(1, size);
		Blog entity2 = blogService.findByURL(entity.getUrl());
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
