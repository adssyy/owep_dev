package com.kclm.owep.web.controller;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, Map<String,String>> test = new HashMap<>();
        Map<String,String> c1 = new HashMap<>();
        c1.put("classify10","java核心技术2（测试）");
        test.put("86",c1);
        Map<String,String> c11 = new HashMap<>();
        c11.put( "1001","java高级应用");
        c11.put( "1002","java高级应用2");
        test.put("classify10",c11);
        c1.put("classify20","服务器环境搭建");

        Map<String,String> c12 = new HashMap<>();
        c12.put( "2001","java高级应用3");
        c12.put( "2002","java高级应用4");
        test.put("classify20",c12);
        System.out.println(test);
    }
}
