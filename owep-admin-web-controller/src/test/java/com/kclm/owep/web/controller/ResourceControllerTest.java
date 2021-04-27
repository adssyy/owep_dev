package com.kclm.owep.web.controller;

import com.kclm.owep.dto.ResourceDTO;
import com.kclm.owep.entity.Resource;
import com.kclm.owep.entity.ResourceSuffix;
import com.kclm.owep.mapper.ResourceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class ResourceControllerTest {

    @Test
    void selectResourceSuffix() {
        ResourceController resourceController =new ResourceController();
        final Map<String, List<ResourceDTO>> stringListMap = resourceController.selectResourceSuffix();
        System.out.println(stringListMap);
    }

    @Autowired
    ResourceMapper resourceMapper;

    @Test
    void selectResourceSuffix1() {
        System.out.println(resourceMapper);
        final List<Resource> strings = resourceMapper.selectResourceSuffix();
        System.out.println(strings);

    }

}