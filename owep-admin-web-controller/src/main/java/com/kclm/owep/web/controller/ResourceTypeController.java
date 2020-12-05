package com.kclm.owep.web.controller;

import com.kclm.owep.dto.ResourceTypeDTO;
import com.kclm.owep.entity.ResourceType;
import com.kclm.owep.service.ResourceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * TODO
 *
 * @author zhang_hy
 * @version v1.0
 * @date 2020-11-24 16:13
 * @description
 */

@Controller
@RequestMapping("/resources")
public class ResourceTypeController {

    @Autowired
    private ResourceTypeService resourceTypeService;


    @GetMapping("/resourceType")
    public String toResourceType() {
        return "resources/resourceType";
    }
    /**
     * @author zhang_hy
     * @date 2020-11-24 16:20 
     * @For 资源类型表数据
     */
    @RequestMapping(value = "/resourceType/getResourceType",produces = "application/json")
    @ResponseBody
    public Object toResourceTypeList() {

        return resourceTypeService.findAllResourceType();
    }


    /**
     * @author zhang_hy
     * @date 2020-11-25 9:46
     * @For 添加资源
     */
    @PostMapping(value = "/resourceType/addResourceType")
    @ResponseBody
    public String addResourceType(ResourceType resourceType){

        resourceType.setIsDelete(1);
        resourceTypeService.addResourcrType(resourceType);

        System.out.println("新增资源类型："+resourceType);

        String data = "success";
        return data;
    }

    /**
     * @author zhang_hy
     * @date 2020-11-25 11:13
     * @For 更新资源
     */
    @RequestMapping("/resourceType/updateResourceType")
    public Object updateResourceType(ResourceType resourceType) {

        resourceTypeService.updateResourceType(resourceType);

        return "resources/resourceType";
    }

    /**
     * @author zhang_hy
     * @date 2020-11-25 9:59
     * @For 删除单个
     */
    @RequestMapping(value = "/resourceType/deleteResourceType",produces = "application/json")
    @ResponseBody
    public Object deleteResourceType(Integer id){

        resourceTypeService.deleteResourceType(id);

        System.out.println("删除成功 id："+id);
        return "success";
    }

    /**
     * @author zhang_hy
     * @date 2020-11-25 10:52
     * @For 删除选中
     */
    @RequestMapping(value = "/resourceType/deleteSelectResourceType")
    @ResponseBody
    public Object deleteSelectResourceType(@RequestBody List<Serializable> idlist) {

        System.out.println("idlist = "+ idlist);

        resourceTypeService.deleteSelectResourceType(idlist);

        return "success";
    }

    /**
     * @author zhang_hy
     * @date 2020-11-24 17:16
     * @For 根据关键字查询
     */
    @RequestMapping(value = "/resourceType/findByKeywords", produces = "application/json")
    public Object findByKeywords(String keyword){

        final ResourceTypeDTO resourceTypeDTO = resourceTypeService.findByKeywords(keyword);

        return "resourceTypeDTO";

    }

    /**
     * @author zhang_hy
     * @date 2020-11-25 11:53
     * @For 根据主键查询
     */
    @RequestMapping("/resourceType/findById")
    public Object findById(Integer id) {
        final ResourceTypeDTO resourceTypeDTO = resourceTypeService.findById(id);
        return "resourceTypeDTO";
    }




}