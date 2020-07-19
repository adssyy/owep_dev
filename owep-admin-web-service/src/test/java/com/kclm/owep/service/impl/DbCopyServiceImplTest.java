package com.kclm.owep.service.impl;

import com.kclm.owep.OwepAdminServiceApplication;
import com.kclm.owep.dto.DbCopyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/************
 *@Author chenxin
 *@Version v1.0
 *@Create 2020/7/17 17:08
 *@Description 数据库备份测试类
 */
@SpringBootTest(classes = OwepAdminServiceApplication.class)
class DbCopyServiceImplTest {

    @Autowired
    DbCopyServiceImpl dbCopyService;

    /**
     * 查询所有数据库备份记录
     */
    @Test
    void findAll() {
        List<DbCopyDTO> allDbCopy=dbCopyService.findAll();
        allDbCopy.forEach(System.out::println);
    }

    @Test
    void findByTime() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void downloadById() {
    }

    @Test
    void deleteSelect() {
    }

    @Test
    void backup() {
    }
}