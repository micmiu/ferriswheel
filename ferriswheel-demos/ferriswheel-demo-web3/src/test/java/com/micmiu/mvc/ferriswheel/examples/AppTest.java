package com.micmiu.mvc.ferriswheel.examples;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created
 * User: <a href="http://micmiu.com">micmiu</a>
 * Date: 6/8/2017
 * Time: 00:15
 */
public class AppTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("aaaa");
		list.add("bbbb");

		String[] arr = new String[]{"zzzz","xxxx"};

		Integer[] arr2 = new Integer[]{100,99,108};

		System.out.println(Joiner.on(",").join(list));
		System.out.println(Joiner.on(",").join(arr));
		System.out.println(Joiner.on(",").join(arr2));
	}
}
