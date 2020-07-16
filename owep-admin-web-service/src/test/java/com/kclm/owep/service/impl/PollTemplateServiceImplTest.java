/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.service.impl;

import com.kclm.owep.OwepAdminServiceApplication;
import com.kclm.owep.dto.PollTemplateDTO;
import com.kclm.owep.entity.PollTemplate;
import com.kclm.owep.service.PollTemplateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/15 15:23
 *@Description:考评模板业务层测试类
 ***/
@SpringBootTest(classes = OwepAdminServiceApplication.class)
public class PollTemplateServiceImplTest {

    @Autowired
    private PollTemplateService pollTemplateService;

    @Test
    void findByKeywordsTest(){
        final List<PollTemplateDTO> pollTemplateDTOs = pollTemplateService.findByKeywords("测试", 1, 5);
        pollTemplateDTOs.forEach(System.out::println);
    }

    @Test
    void findAllPollTemplatesTest(){
        final List<PollTemplateDTO> allPollTemplates = pollTemplateService.findAllPollTemplates(2, 5);
        allPollTemplates.forEach(System.out::println);
    }

    @Test
    void findByIdTest(){
        final PollTemplateDTO templateDTO = pollTemplateService.findById(4);
        System.out.println(templateDTO);
    }

    @Test
    void addPollTemplateTest(){
        final PollTemplate pollTemplate = new PollTemplate();
        pollTemplate.setTemplateContent("业务层测试内容");
        pollTemplate.setTemplateName("测试名称");
        pollTemplate.setTemplateNum("10");
        pollTemplate.setTemplateStatus(1);
        pollTemplateService.addPollTemplate(pollTemplate);
    }

    @Test
    void deleteSelectPollTemplateTest(){
        List<Serializable> list = new ArrayList<>();
        list.add(5);
        pollTemplateService.deleteSelectPollTemplate(list);
    }

    @Test
    void updatePollTemplateTest(){
        final PollTemplate pollTemplate = new PollTemplate();
        pollTemplate.setTemplateStatus(0);
        pollTemplate.setId(13);
        pollTemplateService.updatePollTemplate(pollTemplate);
    }

    @Test
    void deletePollTemplateTest(){
        pollTemplateService.deletePollTemplate(6);
    }
}
