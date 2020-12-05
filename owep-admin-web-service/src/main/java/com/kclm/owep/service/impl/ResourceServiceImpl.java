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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private MapperFactory mapperFactory;

    @Override
    public List<ResourceDTO> findAllResource() {
        List<Resource> resources = this.resourceMapper.selectAll();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<ResourceDTO> resourceDTOS = mapperFacade.mapAsList(resources, ResourceDTO.class);
        return resourceDTOS;
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

    @Override
    public int addToClass(Serializable cid, Serializable rid){
        return this.resourceMapper.addToClass(cid, rid);
    }

    @Override
    public int addSelectToClass(Serializable cid, List<Serializable> idList){
        return this.resourceMapper.addSelectToClass(cid,idList);
    }

    @Override
    public List<ResourceDTO> selectResourceByKeyword(String resourceName,String fileType,String beginTime,String endTime){
        String beginDate = beginTime + " 00:00:00";
        String endDate = endTime + " 23:59:59";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime begin = LocalDateTime.parse(beginDate,df);
        LocalDateTime end = LocalDateTime.parse(endDate,df);
        List<Resource> resources = this.resourceMapper.selectByKeyword(resourceName, fileType, begin, end);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<ResourceDTO> resourceDTOS = mapperFacade.mapAsList(resources, ResourceDTO.class);
        return resourceDTOS;
    }
}
