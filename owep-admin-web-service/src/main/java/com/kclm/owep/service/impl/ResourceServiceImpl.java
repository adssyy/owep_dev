package com.kclm.owep.service.impl;

<<<<<<< HEAD
import com.kclm.owep.convert.ResourceConvert;
=======
>>>>>>> 75899b060a36f819ecbe5b385aeb675e51a0ea55
import com.kclm.owep.dto.ResourceDTO;
import com.kclm.owep.entity.Resource;
import com.kclm.owep.mapper.ResourceMapper;
import com.kclm.owep.service.ResourceService;
<<<<<<< HEAD
=======
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
>>>>>>> 75899b060a36f819ecbe5b385aeb675e51a0ea55
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zhang_hy
 * @version v1.0
 * @date 2020-11-26 16:21
 * @description  文档管理业务层实现
 */

=======
import java.util.List;

>>>>>>> 75899b060a36f819ecbe5b385aeb675e51a0ea55
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

<<<<<<< HEAD
    @Override
    public List<ResourceDTO> findAllResource() {

        List<Resource> lists = resourceMapper.selectAll();

        List<ResourceDTO> listDTO = new ArrayList<>();

        for (Resource list : lists) {

            // 将 Resource 类型变量 转为 ResourceDTO 类型变量
            listDTO.add(ResourceConvert.INSTANCE.PO2DTO(list));
        }
        return listDTO;
=======
    @Autowired
    private MapperFactory mapperFactory;

    @Override
    public List<ResourceDTO> findAllResource() {
        return null;
>>>>>>> 75899b060a36f819ecbe5b385aeb675e51a0ea55
    }

    @Override
    public ResourceDTO findById(Serializable id) {
<<<<<<< HEAD
        final Resource resource = resourceMapper.selectById(id);

        // 将 Resource 类型变量 转为 ResourceDTO 类型变量
        ResourceDTO resourceDTO = ResourceConvert.INSTANCE.PO2DTO(resource);

        return resourceDTO;
=======
        return null;
>>>>>>> 75899b060a36f819ecbe5b385aeb675e51a0ea55
    }

    @Override
    public int deleteSelectResource(List<Serializable> idList) {
<<<<<<< HEAD

        return resourceMapper.deleteSelect(idList);
=======
        return 0;
>>>>>>> 75899b060a36f819ecbe5b385aeb675e51a0ea55
    }

    @Override
    public int deleteResource(Serializable id) {
<<<<<<< HEAD
        return resourceMapper.deleteById(id);
=======
        return 0;
>>>>>>> 75899b060a36f819ecbe5b385aeb675e51a0ea55
    }

    @Override
    public int updateResource(Resource resource) {
<<<<<<< HEAD
        return resourceMapper.update(resource);
=======
        return 0;
>>>>>>> 75899b060a36f819ecbe5b385aeb675e51a0ea55
    }

    @Override
    public int addResource(Resource resource) {
<<<<<<< HEAD
        return resourceMapper.save(resource);
    }

    @Override
    public List<Resource> findByKeyword(String keyword) {
        return resourceMapper.findByKeyword(keyword);
    }

    @Override
    public List<String> selectResourceSuffix() {
        return resourceMapper.selectResourceSuffix();
    }
}
=======
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
>>>>>>> 75899b060a36f819ecbe5b385aeb675e51a0ea55
