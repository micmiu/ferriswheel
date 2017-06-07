package com.micmiu.mvc.ferriswheel.utils;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 6/8/2017
 * Time: 00:33
 */
public class DateTimeUtis {

	public static Date getStartTimeOfDay(Date day) {
		return new DateTime(day).withTimeAtStartOfDay().toDate();
	}

	public static Date getEndTimeOfDay(Date day) {
		return new DateTime(day).millisOfDay().withMaximumValue().toDate();
	}
}
