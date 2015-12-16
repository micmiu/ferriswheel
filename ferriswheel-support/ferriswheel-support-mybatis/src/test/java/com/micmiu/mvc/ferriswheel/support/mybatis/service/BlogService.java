package com.micmiu.mvc.ferriswheel.support.mybatis.service;


import com.micmiu.mvc.ferriswheel.support.mybatis.entity.Blog;

import java.util.List;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 6/11/2014
 * Time: 15:44
 */
public interface BlogService {

	Long create(Blog user);

	Blog read(Long id);

	void update(Blog user);

	void delete(Long id);

	Blog findByURL(String url);

	List<Blog> queryAll();

	void testTran();
}
