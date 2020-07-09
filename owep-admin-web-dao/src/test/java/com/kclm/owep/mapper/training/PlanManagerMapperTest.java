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

<<<<<<< HEAD
   /* @Test
    public void testInsert(){
=======
=======
>>>>>>> 4d8b0531d6b19011932fe62c6edce26e621f3d16
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
<<<<<<< HEAD
<<<<<<< HEAD:owep-admin-web-dao/src/test/java/com/kclm/owep/mapper/training/PlanManagerTest.java
    }*/
=======
    }
>>>>>>> 4d8b0531d6b19011932fe62c6edce26e621f3d16

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