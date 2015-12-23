package com.micmiu.mvc.ferriswheel.support.mybatis;

import com.micmiu.mvc.ferriswheel.support.mybatis.entity.Article;
import com.micmiu.mvc.ferriswheel.support.mybatis.entity.Author;
import com.micmiu.mvc.ferriswheel.support.mybatis.mapper.AuthorMapper;
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
public class AuthorMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private AuthorMapper authorMapper;

	@Test
	public void testQueryOne2Many() {
		Long id = 1L;
		Author author = authorMapper.selectAuthorAriticleById(id);
		Assert.assertNotNull(author);
		for (Article article : author.getArticleList()) {
			//System.out.println(article);
			Assert.assertEquals(id, article.getAuthorId());
		}

	}

	@Test
	public void testQueryOne2Many2() {
		Long id = 1L;
		Author author = authorMapper.selectAuthorAriticleById2(id);
		//System.out.println(author);
		Assert.assertNotNull(author);
		for (Article article : author.getArticleList()) {
			//System.out.println(article);
			Assert.assertEquals(id, article.getAuthorId());
		}

	}


}
