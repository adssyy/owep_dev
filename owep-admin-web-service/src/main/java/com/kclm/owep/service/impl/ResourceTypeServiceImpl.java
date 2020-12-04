package com.kclm.owep.service.impl;

import com.kclm.owep.dto.ResourceTypeDTO;
import com.kclm.owep.entity.ResourceType;
import com.kclm.owep.mapper.ResourceTypeMapper;
import com.kclm.owep.service.ResourceTypeService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ResourceTypeServiceImpl implements ResourceTypeService {

    @Autowired
    private ResourceTypeMapper resourceTypeMapper;

    @Autowired
    private MapperFactory mapperFactory;

    @Override
    public ResourceTypeDTO findByKeywords(String keyword) {
        return null;
    }

    @Override
    public List<ResourceTypeDTO> findAllResourceType() {
        return null;
    }

    @Override
    public ResourceTypeDTO findById(Serializable id) {
        ResourceType resourceType = this.resourceTypeMapper.selectById(id);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        ResourceTypeDTO resourceTypeDTO = mapperFacade.map(resourceType, ResourceTypeDTO.class);
        return resourceTypeDTO;
    }

    @Override
    public int deleteSelectResourceType(List<Serializable> idList) {
        return 0;
    }

    @Override
    public int deleteResourceType(Serializable id) {
        return 0;
    }

    @Override
    public int updateResourceType(ResourceType resourceType) {
        return 0;
    }

    @Override
    public int addResourcrType(ResourceType resourceType) {
        return 0;
    }
}
