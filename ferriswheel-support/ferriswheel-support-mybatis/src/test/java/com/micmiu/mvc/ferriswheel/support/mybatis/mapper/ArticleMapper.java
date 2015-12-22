package com.micmiu.mvc.ferriswheel.support.mybatis.mapper;

import com.micmiu.mvc.ferriswheel.support.mybatis.entity.Article;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> selectListByAuthorId(Long authorId);
}