package com.micmiu.mvc.ferriswheel;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("aaaa");
        list.add("bbbb");

        String[] arr = new String[]{"zzzz","xxxx"};


        System.out.println(list.getClass().getCanonicalName());
        System.out.println(arr.getClass().getCanonicalName());

        System.out.println(list instanceof  List);
        System.out.println(arr.getClass().isArray());
    }
}
