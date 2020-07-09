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

<<<<<<< HEAD:owep-admin-web-dao/src/test/java/com/kclm/owep/mapper/training/PlanManagerTest.java
   /* @Test
    public void testInsert(){
=======
    @Test
    void save() {
>>>>>>> ce462c4a60311824f748cf72b7f8fbd375302bd8:owep-admin-web-dao/src/test/java/com/kclm/owep/mapper/training/PlanManagerMapperTest.java
        PlanManager planManager = new PlanManager();
        planManager.setPlanName("javaee开发");
        planManager.setPlanNumber("FA_110");
        planManager.setPlanStatus(1);
        planManager.setPlanDesc("web开发");
        planManager.setCreateTime(LocalDateTime.now());
<<<<<<< HEAD:owep-admin-web-dao/src/test/java/com/kclm/owep/mapper/training/PlanManagerMapperTest.java
        planManagerMapper.save(planManager);
=======
        //planManagerMapper.savePlanManager(planManager);
>>>>>>> c8822ef2d608aeb0201b56d58ce5b93fdcc69760:owep-admin-web-dao/src/test/java/com/kclm/owep/mapper/training/PlanManagerTest.java
        System.out.println(planManager);
<<<<<<< HEAD:owep-admin-web-dao/src/test/java/com/kclm/owep/mapper/training/PlanManagerTest.java
    }*/
=======
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
>>>>>>> ce462c4a60311824f748cf72b7f8fbd375302bd8:owep-admin-web-dao/src/test/java/com/kclm/owep/mapper/training/PlanManagerMapperTest.java
}