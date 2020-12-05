/******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权。不得复制转发
 *
 */
package com.kclm.owep.service;

import com.kclm.owep.dto.ResourceDTO;
import com.kclm.owep.entity.Resource;

import java.io.Serializable;
import java.util.List;

/********
 *@Author WangSP
 *@Version v1.0
 *@Create 2020/7/15 0015 17:12
 *@Description 文件管理业务层
 */
public interface ResourceService {

    /**
     * 查询多个对象
     */
    List<ResourceDTO> findAllResource();

    /**
     * 依靠主键查询
     */
    ResourceDTO findById(Serializable id);

    /**
     * 依靠多个主键值，删除多行记录
     */
    int deleteSelectResource(List<Serializable> idList);

    /**
     * 依靠主键删除
     */
    int deleteResource(Serializable id);

    /**
     * 跟新实体对象
     */
    int updateResource(Resource resource);

    /**
     * 持久化一个对象
     */
    int addResource(Resource resource);

    /**
     * 修改文档管理
     */
    int alterResource(Resource resource);

    /**
     * 根据班级和关键字来查询资源
     * @param cid
     * @param resourceName
     * @param resourceType
     * @return
     */
    List<ResourceDTO> selectResourceByClassAndKeyword(Serializable cid, String resourceName, Serializable resourceType);

    int deleteFromClass(Serializable cid,Serializable rid);

    int deleteSelectFromClass(Serializable cid, List<Serializable> idList);

    int addToClass(Serializable cid, Serializable rid);

    int addSelectToClass(Serializable cid, List<Serializable> idList);

    List<ResourceDTO> selectResourceByKeyword(String resourceName,String fileType,String beginTime,String endTime);
}
