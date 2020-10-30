package com.kclm.owep.web;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestJson {

    @Test
    public void testM1() {
        System.out.println("hehe");
        //
        String str = "[8,11]";

        //
        final List<Integer> abc = JSON.parseArray(str, Integer.class);
        //
        abc.forEach(System.out::println);
    }
}
