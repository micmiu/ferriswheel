package com.micmiu.mvc.ferriswheel.support.mybatis.mapper;

import com.micmiu.mvc.ferriswheel.support.mybatis.entity.Blog2;

public interface Blog2Mapper {
    int deleteByPrimaryKey(Long id);

    int insert(Blog2 record);

    int insertSelective(Blog2 record);

    Blog2 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Blog2 record);

    int updateByPrimaryKey(Blog2 record);
}