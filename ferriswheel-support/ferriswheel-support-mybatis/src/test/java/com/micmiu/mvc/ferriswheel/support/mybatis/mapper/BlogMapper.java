package com.micmiu.mvc.ferriswheel.support.mybatis.mapper;

import com.micmiu.mvc.ferriswheel.support.mybatis.entity.Blog;
import org.apache.ibatis.annotations.Select;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 6/11/2014
 * Time: 15:43
 */
public interface BlogMapper extends MybatisMapper<Blog, Long> {

	@Select("select * from t_blog where url = #{url}")
	Blog findByURL(String url);
}
