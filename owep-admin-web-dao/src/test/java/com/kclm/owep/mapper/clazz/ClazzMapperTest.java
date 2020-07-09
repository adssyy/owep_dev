package com.kclm.owep.mapper.clazz;

import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.PlanManager;
import com.kclm.owep.entity.Resource;
import com.kclm.owep.mapper.ClazzMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClazzMapperTest {

    @Autowired
    private ClazzMapper clazzMapper;
    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteSelect() {
    }

    @Test
    void selectById() {
        Clazz clazz = clazzMapper.selectById(1);
        System.out.println(clazz);
    }

    @Test
    void selectAll() {
    }
  /*  @Test
    void selectClazzAndResAndPlan(){
        Clazz clazz = clazzMapper.selectClazzAndRes(1);
        List<Resource> resourceList = clazz.getResourceList();
        System.out.println(clazz);
        resourceList.forEach(System.out::println);
    }
    @Test
    void selectClazzAndPlan(){
        Clazz clazz = clazzMapper.selectClazzAndPlan(1);
        List<PlanManager> planManagerList = clazz.getPlanManagerList();
        planManagerList.forEach(System.out::println);
    }*/
    @Test
    void selectByNum(){
        List<Clazz> clazzes = clazzMapper.selectByNum("2020");
        List<Resource> resourceList = clazzes.get(0).getResourceList();
        clazzes.forEach(System.out::println);
        resourceList.forEach(System.out::println);
    }
    @Test
    void selectByName(){
        List<Clazz> clazzes = clazzMapper.selectByName("企业级");
        clazzes.forEach(System.out::println);
    }
    @Test
    void selectByPro(){
        List<Clazz> clazzes = clazzMapper.selectByPro(1);
        clazzes.forEach(System.out::println);
    }
}