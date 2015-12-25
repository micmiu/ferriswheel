package com.micmiu.mvc.ferriswheel.orm.mybatis;

import com.micmiu.mvc.ferriswheel.orm.mybatis.entity.Article;
import com.micmiu.mvc.ferriswheel.orm.mybatis.mapper.ArticleMapper;
import org.junit.Assert;
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
 * Date: 5/26/2014
 * Time: 23:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-mybatis-test.xml"})
@ActiveProfiles("test")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ArticleMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ArticleMapper articleMapper;

	@Test
	public void testQuery() {
		Long authorId = 1L;
		List<Article> list = articleMapper.selectListByAuthorId(authorId);
		System.out.println(list.size());
		for (Article article : list) {
			System.out.println(article);
			Assert.assertEquals(authorId, article.getAuthorId());
		}
	}


}
