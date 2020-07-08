package com.kclm.owep.mapper.training;

import com.kclm.owep.entity.PlanManager;
import com.kclm.owep.mapper.PlanManagerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.sql.SQLOutput;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PlanManagerTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PlanManagerMapper planManagerMapper;

    @Test
    public void testDataBases(){
        System.out.println(dataSource);
    }

   /* @Test
    public void testInsert(){
        PlanManager planManager = new PlanManager();
        planManager.setPlanName("javaee开发");
        planManager.setPlanNumber("FA_110");
        planManager.setPlanStatus(1);
        planManager.setPlanDesc("web开发");
        planManager.setCreateTime(LocalDateTime.now());
        planManagerMapper.savePlanManager(planManager);
        System.out.println(planManager);
    }*/
}