package com.micmiu.mvc.ferriswheel.support.spring.mvc.views;

import com.micmiu.mvc.ferriswheel.support.spring.mvc.ControllerConstant;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 11/16/2015
 * Time: 12:19
 */
public class FileNameUtils {

	public static String formatFileName(String type, String parmName, String defaultName) {
		String fileName = (null == parmName || parmName.length() == 0) ? ControllerConstant.KEY_DEFAULT_FILENAME : parmName;
		if (!fileName.toLowerCase().endsWith(type)) {
			fileName += type;
		}
		return fileName;
	}
}
