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
 * @Description 授课管理测试
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
    /*测试通过classid查询学生评价数据*/
    @Test
    void test1() {
        List<Evaluate> evaluateList = evaluateMapper.selectByClassId(1);
        System.out.println(evaluateList.size());
        System.out.println(evaluateList.get(0).getStudent());
        System.out.println(evaluateList.get(0));
    }
    /*测试根据id查询学生评价实体*/
    @Test
    void test9() {
        //int i  = evaluateMapper.save(new Evaluate(3,new User(),new Student(),new Clazz(),
         //       "shen",0));
        Evaluate e = evaluateMapper.selectById(3);
        System.out.println(e);
    }

    /*测试更新学生评价的评价内容*/
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
    * 以下是违规的测试
    * */
    /*测试违规处理的，插入数据*/
    @Test
    void test3() {
        Illegal i = new Illegal(2,new User(),new Student(),new Clazz()
                ,"shen",LocalDateTime.now());
        //i.setPresentationCondition("notnull");
        int update = illegalMapper.save(i);
        System.out.println(update);
    }

    /*测试违规处理的，通过classid获取违规处理的全部数据*/
    @Test
    void test4() {
        List<Illegal> illegalList = illegalMapper.selectByClassId(1);
        System.out.println(illegalList.size());
        System.out.println(illegalList.get(0).getStudent());
    }

    /*测试违规处理的，根据条件查询*/
    @Test
    void test5() {
        List<Illegal> illegals = illegalMapper.selectByCondition(null,"shen", LocalDateTime.now(),null);
        System.out.println(illegals.size());
    }

    /*测试违规处理的根据 id删除数据*/
    @Test
    void test6() {
        int update = illegalMapper.deleteById(1);
        System.out.println(update);
    }

    /*测试违规处理的删除选中数据*/
    @Test
    void test11() {
        List l = new ArrayList();
        l.add(1);
        l.add(2);
        int update = illegalMapper.deleteSelect(l);
        System.out.println(update);
    }

    /*测试违规处理的更新数据*/
    @Test
    void testUpdate() {
        Illegal z = new Illegal(3, "zhang", LocalDateTime.now());
        int update = illegalMapper.update(z);
        System.out.println(update);
    }

    /*
    * 以下是请假模块的测试
    * */
    /*测试请假处理 根据classid查找数据*/
    @Test
    void test7() {
        List<Leave> leaveList = leaveMapper.selectByClassId(1);
        System.out.println(leaveList.size());
        System.out.println(leaveList.get(0));
        System.out.println(leaveList.get(0).getStudent());
    }

    /*测试请假处理，更新请假的审批状态*/
    @Test
    void test8() {
        Leave l = new Leave();
        l.setId(1);
        l.setApprovalStatus(1);
        int update = leaveMapper.update(l);
        System.out.println(update);
    }


    /*测试请假处理 的插入数据*/
    @Test
    void test10() {
        int update = leaveMapper.save(new Leave(3,LocalDateTime.now(),LocalDateTime.now()
        ,new Student(),new Clazz(),"shen"));
        System.out.println(update);
    }

}
