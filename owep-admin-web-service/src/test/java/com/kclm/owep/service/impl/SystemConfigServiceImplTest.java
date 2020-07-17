package com.kclm.owep.service.impl;

import com.kclm.owep.OwepAdminServiceApplication;
import com.kclm.owep.dto.SystemConfigDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/************
 *@Author chenxin
 *@Version v1.0
 *@Create 2020/7/17 16:40
 *@Description 系统信息业务层测试类
 */
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = OwepAdminServiceApplication.class)
class SystemConfigServiceImplTest {

    @Autowired
    SystemConfigServiceImpl systemConfigService;

    /**
     * 查询所有的系统信息
     */
    @Test
    void findAll() {
        List<SystemConfigDTO> allSystemConfig=systemConfigService.findAll();
        allSystemConfig.forEach(System.out::println);
    }

    @Test
    void save() {
    }
}