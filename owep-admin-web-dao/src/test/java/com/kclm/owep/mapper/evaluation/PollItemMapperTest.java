/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.mapper.evaluation;

import com.kclm.owep.OwepAdminWebDaoApplication;
import com.kclm.owep.entity.PollItem;
import com.kclm.owep.mapper.PollItemMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/8 10:19
 *@Description: 考评选项测试类
 ***/

@SpringBootTest(classes = OwepAdminWebDaoApplication.class)
public class PollItemMapperTest {

    @Autowired
    private PollItemMapper pollItemMapper;

    @Test
    void testSave(){
        final PollItem pollItem = new PollItem("1", "这是测试", 1);
        final PollItem pollItem1 = new PollItem("2", "测试选项2", 1);
        final int test1 = pollItemMapper.save(pollItem);
        final int test2 = pollItemMapper.save(pollItem1);
        System.out.println(test1+test2);
    }

    @Test
    void testUpdate(){
        final PollItem pollItem = pollItemMapper.selectById(1);
        pollItem.setPollContent("修改后的测试用例");
        final int update = pollItemMapper.update(pollItem);
        System.out.println(update);
    }

    @Test
    void testSelectById(){
        final PollItem pollItem = pollItemMapper.selectById(1);
        System.out.println(pollItem);
    }

    @Test
    void testAll(){
        final List<PollItem> pollItemsList = pollItemMapper.selectAll();
        System.out.println(pollItemsList);
    }

    @Test
    void deleteById(){
        pollItemMapper.deleteById(3);
    }

    @Test
    void deleteSelect(){
        final List<Serializable> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        pollItemMapper.deleteSelect(list);
    }

    @Test
    void testFindByKeywords(){
        String keyword = "2";
        final List<PollItem> result = pollItemMapper.findByKeywords(keyword);
        System.out.println("===========测试结果============="+result);
    }

    @Test
    void testcountPollItem(){
        final int num = pollItemMapper.countPollItem();
        System.out.println("考评选项数量为："+num);
    }
}
