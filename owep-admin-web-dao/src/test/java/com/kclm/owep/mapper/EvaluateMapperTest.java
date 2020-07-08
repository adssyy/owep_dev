/*********************
 * 2018-2021 版权所有 CopyRight（c）
 */
package com.kclm.owep.mapper;

import com.kclm.owep.OwepAdminWebDaoApplication;
import com.kclm.owep.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    void test1() {
        List<Evaluate> evaluateList = evaluateMapper.selectByClassId(1);
        System.out.println(evaluateList.size());
    }

    @Test
    void test9() {
        User u = new User();
        u.setId(1);
        Student s = new Student();
        s.setId(1);
        int i  = evaluateMapper.save(new Evaluate(1,u,s,
                1,"shen",0));
        System.out.println(i);
    }

    @Test
    void test2() {
        int update = evaluateMapper.update(new Evaluate());
        System.out.println(update);
    }

    @Test
    void test3() {
        int update = illegalMapper.save(new Illegal());
        System.out.println(update);
    }

    @Test
    void test4() {
        List<Illegal> illegalList = illegalMapper.selectByClassId(1);
        System.out.println(illegalList.size());
    }

    @Test
    void test5() {
        List<Illegal> illegals = illegalMapper.selectByCondition(null,"shen",null,null);
        System.out.println(illegals.size());
    }

    @Test
    void test6() {
        int update = illegalMapper.deleteById(1);
        System.out.println(update);
    }

    @Test
    void test7() {
        List<Leave> leaveList = leaveMapper.selectByClassId(1);
        System.out.println(leaveList.size());
    }

    @Test
    void test8() {
        int update = leaveMapper.update(new Leave());
        System.out.println(update);
    }
}
