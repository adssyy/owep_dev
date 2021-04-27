package com.kclm.owep.service.impl;

import com.kclm.owep.convert.ResourceConvert;
import com.kclm.owep.convert.ResourceTypeConvert;
import com.kclm.owep.dto.ResourceDTO;
import com.kclm.owep.dto.ResourceTypeDTO;
import com.kclm.owep.entity.Resource;
import com.kclm.owep.entity.ResourceType;
import com.kclm.owep.mapper.ResourceTypeMapper;
import com.kclm.owep.service.ResourceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Service
public class ResourceTypeServiceImpl implements ResourceTypeService {

    @Autowired
    ResourceTypeMapper resourceTypeMapper;


    @Override
    public ResourceTypeDTO findByKeywords(String keyword) {
//        List<ResourceTypeDTO> resourceTypeDTOS =new LinkedList<>();
//        if (keyword!=null){
//
//            final List<ResourceType> resourceTypes = resourceTypeMapper.findByKeywords(keyword);
//            resourceTypes.forEach(a->resourceTypeDTOS.add(ResourceTypeConvert.INSTANCE.PO2DTO(a)));
//            return
//        }else {
//
//        }
            return null;

    }

    @Override
    public ResourceType findByTypeName(String s) {
       return resourceTypeMapper.selectByTypeName(s);
    }

    @Override
    public List<ResourceTypeDTO> findAllResourceType() {
        List<ResourceTypeDTO> resourceTypeDTOS =new LinkedList<>();
        final List<ResourceType> resourceTypes = resourceTypeMapper.selectAll();
        resourceTypes.forEach(a-> resourceTypeDTOS.add(ResourceTypeConvert.INSTANCE.PO2DTO(a)));
        return resourceTypeDTOS;

    }

    @Override
    public ResourceTypeDTO findById(Serializable id) {
        final ResourceType resourceType = resourceTypeMapper.selectById(id);
        return ResourceTypeConvert.INSTANCE.PO2DTO(resourceType);
    }

    @Override
    public int deleteSelectResourceType(List<Serializable> idList) {
        if (idList!=null){

            resourceTypeMapper.deleteSelect(idList);
            return 1;
        }else{

        return 0;
        }
    }

    @Override
    public int deleteSelectResourceType1(List<ResourceType> idList) {
        if (idList!=null){

            resourceTypeMapper.deleteSelect1(idList);
            return 1;
        }else{

            return 0;
        }

}

    @Override
    public int deleteResourceType(Serializable id) {
        resourceTypeMapper.deleteById(id);
        return 1;
    }

    @Override
    public int updateResourceType(ResourceType resourceType) {
        return 0;
    }

    @Override
    public int addResourcrType(ResourceType resourceType) {
        if (resourceType!=null){
            resourceTypeMapper.save(resourceType);
            return 1;
        }else {
            return 0;
        }


    }
}
