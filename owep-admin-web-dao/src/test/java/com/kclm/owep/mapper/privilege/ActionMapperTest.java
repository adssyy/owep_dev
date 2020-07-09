package com.kclm.owep.mapper.privilege;

import com.kclm.owep.entity.Action;
import com.kclm.owep.mapper.ActionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @program: owep
 * @package: com.kclm.owep.mapper.privilege
 * @description:
 * @author: qi_kran
 * @create: 2020-07-08 15:32
 **/
class ActionMapperTest extends com.kclm.owep.mapper.ActionMapperTest {
    @Autowired
     private  ActionMapper actionMapper;
    @Test
    void save() {
        actionMapper.save(new Action("行为1", "测试行为1", "/action1", "b11", 01000));
        actionMapper.save(new Action("行为2", "测试行为2", "/action2", "b12", 011));
        actionMapper.save(new Action("行为3", "测试行为3", "/action3", "b13", 0111));
        actionMapper.save(new Action("行为4", "测试行为4", "/action4", "b14", 0110));
        actionMapper.save(new Action("行为5", "测试行为5", "/action5", "b15", 0101));
        actionMapper.save(new Action("行为6", "测试行为6", "/action6", "b16", 1010));

    }

    @Test
    void update() {
        Action action = actionMapper.selectById(6);
        action.setActionCode("asd");
        action.setActionDescription("asd");
        action.setActionName("asd");
        action.setActionUrl("asd");
        action.setActionValue(123);
        action.setVersion(2);
        action.setLastAccessTime(LocalDateTime.now());


    }

    @Test
    void findAll() {
        List<Action> actions = actionMapper.selectAll();
        actions.forEach(System.out::println);
    }

    @Test
    void findById() {
        Action action = actionMapper.selectById(2);
        System.out.println(action);
    }

    @Test
    void delete() {
        List<Serializable> integers = Arrays.asList(14, 15, 16, 17, 18, 19);
        actionMapper.deleteSelect(integers);

    }

    @Test
    void count() {
        int count = actionMapper.count();
        System.out.println(count);
    }

    @Test
    void findByActionName() {
        actionMapper.selectByActionName("1");
    }
}