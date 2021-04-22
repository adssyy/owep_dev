package com.kclm.owep.web.controller;

import com.kclm.owep.convert.ResourceConvert;
import com.kclm.owep.convert.ResourceTypeConvert;
import com.kclm.owep.convert.ResourceTypeConvertImpl;
import com.kclm.owep.dto.ResourceDTO;
import com.kclm.owep.dto.ResourceTypeDTO;
import com.kclm.owep.entity.Resource;
import com.kclm.owep.entity.ResourceType;
import com.kclm.owep.mapper.UserMapper;
import com.kclm.owep.service.ResourceService;
import com.kclm.owep.service.ResourceTypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@RequestMapping("/resources")
@Controller
public class ResourceController {

    @Autowired
    ResourceTypeService resourceTypeService;

    @Autowired
    ResourceService resourceService;


    @PostMapping(value = "/resourceType/getResourceType" ,produces = "application/json")
    @ResponseBody
    public List<ResourceTypeDTO> getResourceType(){
        return resourceTypeService.findAllResourceType();
    }


    //添加
    @PostMapping(value = "/resourceType/addResourceType")
    @ResponseBody
    public String addResourceType(ResourceTypeDTO typeData){
        ResourceType resourceType =new ResourceType();
        resourceType = ResourceTypeConvert.INSTANCE.updatePOFromDTO(typeData,resourceType);
        resourceTypeService.addResourcrType(resourceType);


        return "添加成功";
    }

    //多选删除
    @PostMapping(value = "/resourceType/deleteSelectResourceType")
    @ResponseBody
    public String deleteSelectResourceType(List<ResourceTypeDTO> ids){
        if (ids!=null){
            ids.forEach(a->resourceTypeService.deleteResourceType(a));
            return "删除成功";
        }else{
            return"数据错误";
        }


    }

    //单个删除
    @GetMapping(value = "/resourceType/deleteResourceType" ,produces = "application/json")
    @ResponseBody
    public ResourceTypeDTO deleteResourceType(int id){
        final ResourceTypeDTO resourceTypeDTO = resourceTypeService.findById(id);
        return resourceTypeDTO;

    }

    //////////////---------------------------------------------------------------------------------------------

    //搜索
    @PostMapping(value = "/resourceList/search",produces = "application/json")
    @ResponseBody
    public List<ResourceDTO> search(){
        //todo
        return null;
    }


    //多选删除
    @PostMapping(value = "/resourceList/deleteSelectResource",produces = "application/json")
    @ResponseBody
    public List<Serializable> deleteSelectResource(List<ResourceDTO> idlist){
        final List<Resource> resources = ResourceConvert.INSTANCE.updatePOsFromDTOs(idlist);
        List<Serializable> ids =new LinkedList<>();
        resources.forEach(a->ids.add(a.getId()));
        resourceService.deleteSelectResource(ids);

        return ids;
    }

    //添加
    @PostMapping(value = "/resourceList/addResource" )
    @ResponseBody
    public String addResource(ResourceDTO resourceDTO, @RequestParam("file")MultipartFile file){
        final Resource resource = ResourceConvert.INSTANCE.updatePOFromDTO(resourceDTO);
        resourceService.addResource(resource);
        //todo 保存文件

        return "";
    }





}
