package com.micmiu.mvc.ferriswheel.support.jackson2;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 11/20/2015
 * Time: 15:36
 */
public class DateObjectMapper2 extends ObjectMapper {

	public DateObjectMapper2() {
		super.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
	}
}
