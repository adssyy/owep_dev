package com.kclm.owep.service.impl;

import com.kclm.owep.OwepAdminServiceApplication;
import com.kclm.owep.dto.SystLogDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/************
 *@Author chenxin
 *@Version v1.0
 *@Create 2020/7/17 16:58
 *@Description 系统日志业务层测试类
 */
@SpringBootTest(classes = OwepAdminServiceApplication.class)
class SystLogServiceImplTest {

    @Autowired
    SystLogServiceImpl systLogService;

    /**
     * 查询所有日志记录
     */
    @Test
    void findAll() {
        List<SystLogDTO> allSystLog=systLogService.findAll();
        allSystLog.forEach(System.out::println);
    }

    @Test
    void findByTime() {
    }
}