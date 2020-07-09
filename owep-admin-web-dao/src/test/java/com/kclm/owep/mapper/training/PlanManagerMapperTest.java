package com.kclm.owep.mapper.training;

import com.kclm.owep.entity.PlanManager;
import com.kclm.owep.mapper.PlanManagerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class PlanManagerMapperTest {

    @Autowired
    private PlanManagerMapper planManagerMapper;

    @Test
    void selectByField() {
    }

    @Test
    void rowTotal() {
    }

    @Test
    void save() {
        PlanManager planManager = new PlanManager();
        planManager.setPlanName("javaee开发");
        planManager.setPlanNumber("FA_110");
        planManager.setPlanStatus(1);
        planManager.setPlanDesc("web开发");
        planManager.setCreateTime(LocalDateTime.now());
        planManagerMapper.save(planManager);
        //planManagerMapper.savePlanManager(planManager);
//        planManagerMapper.savePlanManager(planManager);
        System.out.println(planManager);
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteSelect() {
    }

    @Test
    void selectAll() {
    }
}