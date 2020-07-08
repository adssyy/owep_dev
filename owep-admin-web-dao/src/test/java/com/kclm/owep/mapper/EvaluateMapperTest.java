/*********************
 * 2018-2021 版权所有 CopyRight（c）
 */
package com.kclm.owep.mapper;

import com.kclm.owep.OwepAdminWebDaoApplication;
import com.kclm.owep.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/7 16:58
 * @Description TODO
 */
@SpringBootTest(classes = OwepAdminWebDaoApplication.class)
public class EvaluateMapperTest {
    @Autowired
    private EvaluateMapper evaluateMapper;
    @Autowired
    private IllegalMapper illegalMapper;
    @Autowired
    private LeaveMapper leaveMapper;

    /*
    * 以下是学生评价的测试
    *
    * */
    @Test
    void test1() {
        List<Evaluate> evaluateList = evaluateMapper.selectByClassId(1);
        System.out.println(evaluateList.size());
    }

    @Test
    void test9() {
        //int i  = evaluateMapper.save(new Evaluate(3,new User(),new Student(),new Clazz(),
         //       "shen",0));
        Evaluate e = evaluateMapper.selectById(3);
        System.out.println(e);
    }

    @Test
    void test2() {
        Evaluate e = new Evaluate();
        e.setId(2);
        e.setEvaluate("不错");
        int update = evaluateMapper.update(e);
        System.out.println(update);
    }


    /*
    *
    *
    * 以下是违规的测试
    * */
    @Test
    void test3() {
        Illegal i = new Illegal(2,new User(),new Student(),new Clazz()
                ,"shen",LocalDateTime.now());
        //i.setPresentationCondition("notnull");
        int update = illegalMapper.save(i);
        System.out.println(update);
    }

    @Test
    void test4() {
        List<Illegal> illegalList = illegalMapper.selectByClassId(1);
        System.out.println(illegalList.size());
        System.out.println(illegalList.get(0).toString());
    }

    @Test
    void test5() {
        List<Illegal> illegals = illegalMapper.selectByCondition(null,"shen", LocalDateTime.now(),null);
        System.out.println(illegals.size());
    }

    @Test
    void test6() {
        int update = illegalMapper.deleteById(1);
        System.out.println(update);
    }

    @Test
    void test11() {
        List l = new ArrayList();
        l.add(1);
        l.add(2);
        int update = illegalMapper.deleteSelect(l);
        System.out.println(update);
    }

    /*
    * 以下是请假模块的测试
    * */
    @Test
    void test7() {
        List<Leave> leaveList = leaveMapper.selectByClassId(1);
        System.out.println(leaveList.size());
    }

    @Test
    void test8() {
        Leave l = new Leave();
        l.setId(1);
        l.setApprovalStatus(1);
        int update = leaveMapper.update(l);
        System.out.println(update);
    }

    @Test
    void test10() {
        int update = leaveMapper.save(new Leave(3,LocalDateTime.now(),LocalDateTime.now()
        ,new Student(),new Clazz(),"shen"));
        System.out.println(update);
    }

}
