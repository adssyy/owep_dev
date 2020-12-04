package com.kclm.owep.service.impl;

import com.kclm.owep.dto.ResourceDTO;
import com.kclm.owep.entity.Resource;
import com.kclm.owep.mapper.ResourceMapper;
import com.kclm.owep.service.ResourceService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private MapperFactory mapperFactory;

    @Override
    public List<ResourceDTO> findAllResource() {
        return null;
    }

    @Override
    public ResourceDTO findById(Serializable id) {
        return null;
    }

    @Override
    public int deleteSelectResource(List<Serializable> idList) {
        return 0;
    }

    @Override
    public int deleteResource(Serializable id) {
        return 0;
    }

    @Override
    public int updateResource(Resource resource) {
        return 0;
    }

    @Override
    public int addResource(Resource resource) {
        return 0;
    }

    @Override
    public int alterResource(Resource resource) {
        return 0;
    }

    @Override
    public List<ResourceDTO> selectResourceByClassAndKeyword(Serializable cid, String resourceName, Serializable resourceType) {
        List<Resource> resources = resourceMapper.selectByClassAndKeyword(cid, resourceName, resourceType);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<ResourceDTO> resourceDTOS = mapperFacade.mapAsList(resources, ResourceDTO.class);
        return resourceDTOS;
    }

    @Override
    public int deleteFromClass(Serializable cid, Serializable rid) {
        return this.resourceMapper.deleteFromClass(cid,rid);
    }

    @Override
    public int deleteSelectFromClass(Serializable cid, List<Serializable> idList){
        return this.resourceMapper.deleteSelectFromClass(cid,idList);
    }
}
