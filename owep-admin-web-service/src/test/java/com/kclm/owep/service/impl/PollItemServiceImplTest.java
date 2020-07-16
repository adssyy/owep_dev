/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.service.impl;

import com.kclm.owep.OwepAdminServiceApplication;
import com.kclm.owep.dto.PollItemDTO;
import com.kclm.owep.entity.PollItem;
import com.kclm.owep.service.PollItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/15 14:24
 *@Description:考评选项测试类
 ***/
@SpringBootTest(classes = OwepAdminServiceApplication.class)
public class PollItemServiceImplTest {


    @Autowired
    private PollItemService pollItemService;

    @Test
    void findAllPollItemTest(){
        final List<PollItemDTO> allPollItem = pollItemService.findAllPollItem(1, 5);
        allPollItem.forEach(System.out::println);
    }

    @Test
    void findByIdTest(){
        final PollItemDTO pollItemDTO = pollItemService.findById(4);
        System.out.println(pollItemDTO);
    }

    @Test
    void findByKeywords(){
        final List<PollItemDTO> pollItemDTOS = pollItemService.findByKeywords("测试",1,5);
        pollItemDTOS.forEach(System.out::println);
    }

    @Test
    void addPollItemTest(){
        final PollItem pollItem = new PollItem();
        pollItem.setPollNum("4");
        pollItem.setPollContent("测试业务层");
        pollItem.setPollStatus(1);
        final int i = pollItemService.addPollItem(pollItem);
        System.out.printf("成功添加了%s条考评选项",i);
    }

    @Test
    void updatePollItemTest(){
        final PollItem pollItem = new PollItem();
        pollItem.setPollNum("4");
        pollItem.setPollContent("修改后的测试业务层内容");
        pollItem.setPollStatus(1);
        pollItem.setId(11);
        pollItemService.updatePollItem(pollItem);
    }

    @Test
    void deletePollItemTest(){
        pollItemService.deletePollItem(4);
    }

    @Test
    void deleteSelectPollItemTest(){
        final ArrayList<Serializable> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        pollItemService.deleteSelectPollItem(list);
    }
}
