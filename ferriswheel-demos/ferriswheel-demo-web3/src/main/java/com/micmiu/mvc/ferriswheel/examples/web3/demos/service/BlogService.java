package com.micmiu.mvc.ferriswheel.examples.web3.demos.service;


import com.micmiu.mvc.ferriswheel.core.service.BaseService;
import com.micmiu.mvc.ferriswheel.examples.web3.demos.entity.Blog;

import java.util.List;

/**
 * 博客service
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public interface BlogService extends BaseService<Blog, Long> {
	List queryStatic();
}
