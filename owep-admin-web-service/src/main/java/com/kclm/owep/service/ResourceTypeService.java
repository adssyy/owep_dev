/******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权。不得复制转发
 *
 */
package com.kclm.owep.service;

import com.kclm.owep.dto.ResourceTypeDTO;
import com.kclm.owep.entity.Resource;
import com.kclm.owep.entity.ResourceType;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/********
 *@Author WangSP
 *@Version v1.0
 *@Create 2020/7/15 0015 13:52
 *@Description 资源类型业务层
 */

@Service
public interface ResourceTypeService {

    /**
     * 根据关键字查询
     */
    ResourceTypeDTO findByKeywords(String keyword);

    //
    ResourceType findByTypeName(String s);

    /**
     * 查询多个对象
     */
    List<ResourceTypeDTO> findAllResourceType();

    /**
     *  依靠主键查询
     */
    ResourceTypeDTO findById(Serializable id);

    /**
     *  依靠多个主键值，删除多行记录
     */
    int deleteSelectResourceType(List<Serializable> idList);

    int deleteSelectResourceType1(List<ResourceType> idList);

    /**
     * 依靠主键删除
     */
    int deleteResourceType(Serializable id);

    /**
     * 更新实体对象
     */
    int updateResourceType(ResourceType resourceType);

    /**
     * 持久化一个对象
     */
    int addResourcrType(ResourceType resourceType);

}
