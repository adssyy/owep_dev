package com.kclm.owep.service.impl;

import com.kclm.owep.convert.ResourceConvert;
import com.kclm.owep.dto.ResourceDTO;
import com.kclm.owep.entity.Resource;
import com.kclm.owep.entity.ResourceSuffix;
import com.kclm.owep.mapper.ResourceMapper;
import com.kclm.owep.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceMapper resourceMapper;

    @Override
    public List<ResourceDTO> findResourceName(String courseName) {
        return ResourceConvert.INSTANCE.POs2DTOs(resourceMapper.selectByResourceName(courseName));
    }

    @Override
    public List<ResourceDTO> findResourceSuffix(String resourceSuffix) {
        return ResourceConvert.INSTANCE.POs2DTOs(resourceMapper.selectByResourceSuffix(resourceSuffix));
    }

    @Override
    public List<ResourceDTO> findAllResource() {
        final List<Resource> resources = resourceMapper.selectAll();

        return ResourceConvert.INSTANCE.POs2DTOs(resources);
    }

    @Override
    public List<Resource> selectAllResource() {
        return null;
    }

    @Override
    public Resource findById(Serializable id) {
        return resourceMapper.selectById(id);
    }

    @Override
    public int deleteSelectResource(List<Serializable> idList) {
        if (idList!=null){
            resourceMapper.deleteSelect(idList);
            return 1;
        }else {

        return 0;
        }

    }

    @Override
    public int deleteResource(Serializable id) {
        resourceMapper.deleteById(id);
        return 1;
    }

    @Override
    public int updateResource(Resource resource) {
        return resourceMapper.update(resource);
    }

    @Override
    public int addResource(Resource resource) {
        if (resource!=null){
            resourceMapper.save(resource);
            return 1;
        }else {

        return 0;
        }
    }

    @Override
    public List<Resource> selectResourceSuffix() {
        return resourceMapper.selectResourceSuffix();

    }

    @Override
    public List<Resource> findByKeyword(String keyword) {

        return null;
    }

    @Override
    public List<ResourceDTO> selectResourceByClassAndKeyword(Serializable cid, String resourceName, Serializable resourceType) {
        return null;
    }

    @Override
    public int deleteFromClass(Serializable cid, Serializable rid) {
        return 0;
    }

    @Override
    public int deleteSelectFromClass(Serializable cid, List<Serializable> idList) {
        return 0;
    }

    @Override
    public List<ResourceDTO> selectByTimeRangeAndsuffixAndname(ResourceDTO resourceDTO) {
        final List<Resource> resources = resourceMapper.selectByResourceDTO(resourceDTO.getResourceSuffix(), resourceDTO.getResourceName(),
                resourceDTO.getInterviewTimeStart(), resourceDTO.getInterviewTimeEnd());
        return ResourceConvert.INSTANCE.POs2DTOs(resources);

    }


}
