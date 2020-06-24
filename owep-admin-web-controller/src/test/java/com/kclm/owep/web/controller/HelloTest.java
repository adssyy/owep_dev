package com.kclm.owep.web.controller;

import com.kclm.owep.OwepAdminWebControllerApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/****
 * 控制器测试
 */
@SpringBootTest(classes = OwepAdminWebControllerApplication.class)
class HelloTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    public void setUp() {
        System.out.println("wac = "+wac);
        //初始化MockMvc
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        System.out.println("mockMvc = " + mockMvc);
    }

    @Test
    void hello() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void findAll() {

    }

    @Test
    void helloThymeleaf() {

    }
}