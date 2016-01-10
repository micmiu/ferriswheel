package com.micmiu.mvc.ferriswheel.examples.core.service.impl;

import com.micmiu.mvc.ferriswheel.examples.core.entity.Menu;
import com.micmiu.mvc.ferriswheel.examples.core.mapper.MenuMapper;
import com.micmiu.mvc.ferriswheel.examples.core.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 1/8/2016
 * Time: 23:14
 */
public class MenuServiceMybatis implements MenuService {

	@Autowired
	private MenuMapper mapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Menu record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(Menu record) {
		return mapper.insertSelective(record);
	}

	@Override
	public Menu selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Menu record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Menu record) {
		//TODO
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Menu record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public Integer selectCountAll() {
		return mapper.selectCountAll();
	}
}
