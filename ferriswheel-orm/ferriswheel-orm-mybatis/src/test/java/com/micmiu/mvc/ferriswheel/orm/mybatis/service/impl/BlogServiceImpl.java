package com.micmiu.mvc.ferriswheel.orm.mybatis.service.impl;

import com.micmiu.mvc.ferriswheel.orm.mybatis.entity.Blog;
import com.micmiu.mvc.ferriswheel.orm.mybatis.mapper.BlogMapper;
import com.micmiu.mvc.ferriswheel.orm.mybatis.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 6/11/2014
 * Time: 16:11
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogMapper mapper;

	@Override
	public Long create(Blog entity) {
		mapper.create(entity);
		return entity.getId();
	}

	@Override
	public Blog read(Long id) {
		return mapper.read(id);
	}

	@Override
	public void update(Blog entity) {
		mapper.update(entity);
	}

	@Override
	public void delete(Long id) {
		mapper.delete(id);
	}

	@Override
	public Blog findByURL(String url) {
		return mapper.findByURL(url);
	}

	@Override
	public List<Blog> queryAll() {
		return mapper.queryAll();
	}

	@Override
	public void testTran() {
		Blog entity = new Blog();
		entity.setTitle("mvc");
		entity.setAuthor("micmiu");
		entity.setCategory("J2EE-MVC");
		entity.setUrl("http://micmiu.com/j2ee/mvc");
		entity.setPublishDate(new Date());
		mapper.create(entity);
		int x = 1 / 0;
		System.out.print(x);
	}


}
