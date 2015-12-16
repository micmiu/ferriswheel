package com.micmiu.mvc.ferriswheel.support.mybatis.mapper;

import com.micmiu.mvc.ferriswheel.support.mybatis.entity.Blog;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 6/11/2014
 * Time: 15:43
 */
public interface BlogMapper extends MybatisMapper{

	public void create(Blog entity);

	public Blog read(long id);

	public void update(Blog entity);

	public void delete(long id);

	public List<Blog> queryAll();

	@Select("select * from t_blog where url = #{url}")
	public Blog findByURL(String url);
}
