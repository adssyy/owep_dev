/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.service.impl;

import com.kclm.owep.OwepAdminServiceApplication;
import com.kclm.owep.dto.TeacherPollDTO;
import com.kclm.owep.entity.TeacherPoll;
import com.kclm.owep.service.TeacherPollService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/15 16:07
 *@Description:教师考评业务层测试类
 ***/
@SpringBootTest(classes = OwepAdminServiceApplication.class)
public class TeacherPollServiceImplTest {

    @Autowired
    private TeacherPollService teacherPollService;

    @Test
    void findByConditionTest(){
        final List<TeacherPollDTO> list = teacherPollService.findByCondition("", "软件测试", "",1,2);
        list.forEach(System.out::println);
    }

    @Test
    void findAllTeacherPollTest(){
        final List<TeacherPollDTO> allTeacherPoll = teacherPollService.findAllTeacherPoll(2, 2);
        allTeacherPoll.forEach(System.out::println);
    }

    @Test
    void findByIdTest(){
        final TeacherPollDTO teacherPollDTO = teacherPollService.findById(5);
        System.out.println(teacherPollDTO);
    }

    @Test
    void updateTest(){
        final TeacherPoll teacherPoll = new TeacherPoll();
        teacherPoll.setTeacherName("詹姆斯");
        teacherPoll.setId(5);
        teacherPollService.update(teacherPoll);
    }

    @Test
    void deleteSelectTeacherPollTest(){
        List<Serializable> list = new ArrayList<>();
        list.add(9);
        teacherPollService.deleteSelectTeacherPoll(list);
    }

    @Test
    void deleteTeacherPollTest(){

    }

    @Test
    void addTeacherPollTest(){
        TeacherPoll teacherPoll = new TeacherPoll();
        teacherPoll.setTeacherName("段誉");
        teacherPoll.setClassName("天龙八部");
        teacherPoll.setPollAddress("190.128.167.08");
        teacherPoll.setPollGrade("很厉害");
        teacherPoll.setEffectiveTime(LocalDateTime.now());
        teacherPoll.setPollCount(100);
        teacherPoll.setPollSuggest("骑着小毛驴");
        teacherPoll.setFkTemplateId(4);
        teacherPoll.setFkUserId(1);
        teacherPoll.setFkClassId(1);
        teacherPoll.setAllowIp("190.128.167.08");
        teacherPoll.setStartTime(LocalDateTime.now());
        teacherPoll.setEndTime(LocalDateTime.now());
        teacherPollService.addTeacherPoll(teacherPoll);
    }
}
