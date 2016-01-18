package com.micmiu.mvc.ferriswheel.examples.core.mybatis.service;


import com.micmiu.mvc.ferriswheel.examples.core.mybatis.entity.Blog;
import com.micmiu.mvc.ferriswheel.orm.mybatis.service.GenerateService;

import java.util.List;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 6/11/2014
 * Time: 15:44
 */
public interface BlogService extends GenerateService<Blog, Long> {

	Blog findByURL(String url);

	List<Blog> queryAll();

}
