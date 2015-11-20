package com.micmiu.mvc.ferriswheel.core.i18n;

import java.util.Locale;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 11/12/2015
 * Time: 09:59
 */
public interface LocalMessage {

	String getMessage(String code, Locale locale);

	String getMessage(String code, Object[] args, Locale locale);
}
