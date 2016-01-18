package com.micmiu.mvc.ferriswheel.examples.core.mybatis.service.impl;

import com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity.Blog;
import com.micmiu.mvc.ferriswheel.examples.core.mybatis.mapper.BlogMapper;
import com.micmiu.mvc.ferriswheel.examples.core.mybatis.service.BlogService;
import com.micmiu.mvc.ferriswheel.orm.mybatis.mapper.GenerateMapper;
import com.micmiu.mvc.ferriswheel.orm.mybatis.service.AbstractGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 6/11/2014
 * Time: 16:11
 */
@Service
public class BlogServiceMybatis extends AbstractGenerateService<Blog, Long> implements BlogService {

	@Autowired
	private BlogMapper mapper;

	@Override
	public GenerateMapper<Blog, Long> getMapper() {
		return mapper;
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
	public Integer selectCountAll() {
		return mapper.selectCountAll();
	}
}
