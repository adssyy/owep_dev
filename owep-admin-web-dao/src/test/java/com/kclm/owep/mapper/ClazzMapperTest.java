package com.kclm.owep.mapper;

import com.kclm.owep.entity.Clazz;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

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
        System.out.println(clazz.toString());
    }

    @Test
    void selectAll() {
    }

    @Test
    void saveClazzResource() {
    }

    @Test
    void deleteClazzResource() {
    }

    @Test
    void saveClazzPlanmanage() {
    }

    @Test
    void deleteClazzPlanmanage() {
    }

    @Test
    void selectByNum() {
    }

    @Test
    void selectByName() {
    }

    @Test
    void selectByPro() {
    }

    @Test
    void selectByKeyword() {
    }
}