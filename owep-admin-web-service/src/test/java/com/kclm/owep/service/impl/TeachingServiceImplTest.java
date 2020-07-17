/*********************
 * 2018-2021 版权所有 CopyRight（c）
 */
package com.kclm.owep.service.impl;

import com.kclm.owep.OwepAdminServiceApplication;
import com.kclm.owep.dto.ClassDTO;
import com.kclm.owep.dto.EvaluateDTO;
import com.kclm.owep.dto.QuestionDTO;
import com.kclm.owep.dto.TeachingDTO;
import com.kclm.owep.entity.Evaluate;
import com.kclm.owep.entity.Illegal;
import com.kclm.owep.entity.Leave;
import com.kclm.owep.service.TeachingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/14 9:17
 * @Description 授课管理业务层测试
 */
@SpringBootTest(classes = OwepAdminServiceApplication.class)
public class TeachingServiceImplTest {
    @Autowired
    TeachingService teachingService;

    @Test
    void testFindClass(){
        final List<ClassDTO> allClass = teachingService.findAllClass(1,5);
        allClass.forEach(System.out::println);
    }


    @Test
    void testFindQuestionById(){
        QuestionDTO question = teachingService.findQuestionById(5);
        System.out.println(question);
    }

    @Test
    void testFindEvaluateById(){
        EvaluateDTO evaluate = teachingService.findEvaluateById(8);
        System.out.println(evaluate);
    }

    @Test
    void testUpdateEvaluate(){
        Evaluate e = new Evaluate();
        e.setId(10);
        e.setEvaluate("加油");
        teachingService.updateEvaluate(e);
    }

    @Test
    void testUpdateApprovalStatus(){
        Leave l = new Leave();
        l.setId(8);
        l.setApprovalStatus(3);
        teachingService.updateApprovalStatus(l);
    }

    @Test
    void testDeleteIllegalById(){
        teachingService.deleteIllegalById(3);
    }

    @Test
    void testSaveIllegal(){
        teachingService.saveIllegal(new Illegal(1,"qian", LocalDateTime.now()));
    }

    @Test
    void testGetTeachingDTO(){
        TeachingDTO teachingDTO = teachingService.getTeachingDTO(1, 1, 2);
        System.out.println(teachingDTO.getId());
        System.out.println((teachingDTO.getClassDesc()));
        System.out.println(teachingDTO.getQuestionDTOS());
        System.out.println(teachingDTO.getHomeworkAnswerDTOS());
        System.out.println(teachingDTO.getResourceDTOS());
        System.out.println(teachingDTO.getEvaluateDTOs().size());
        System.out.println(teachingDTO.getIllegalDTOs().size());
        System.out.println(teachingDTO.getLeaveDTOs().size());
    }

}
