/******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权。不得复制转发
 *
 */
package com.kclm.owep.service;

import com.kclm.owep.dto.ResourceDTO;
import com.kclm.owep.entity.Resource;
import com.kclm.owep.entity.ResourceSuffix;
import org.springframework.stereotype.Service;

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
     * 通过资源名称
     */
    List<ResourceDTO> findResourceName(String courseName);

    /**
    *d通过类型搜索
     */
    List<ResourceDTO> findResourceSuffix(String resourceSuffix);

    /**
     * 查询多个对象
     */
    List<ResourceDTO> findAllResource();

    List<Resource> selectAllResource();

    /**
     * 依靠主键查询
     */
    Resource findById(Serializable id);

    /**
     * 依靠多个主键值，删除多行记录
     */
    int deleteSelectResource(List<Serializable> idList);

    /**
     * 依靠主键删除
     */
    int deleteResource(Serializable id);

    /**
     * 更新实体对象
     */
    int updateResource(Resource resource);

    /**
     * 持久化一个对象
     */
    int addResource(Resource resource);

    /**
     * 修改文档管理
     *
     * 未实现
     */
   /* int alterResource(Resource resource);*/

    /**

     * @author zhang_hy
     * @date 2020-12-3 11:17
     * @For 查询所有后缀
     */
    List<Resource> selectResourceSuffix();

    /**
     * @author zhang_hy
     * @date 2020-12-3 11:36
     * @For 根据关键字模糊搜索
     */
    List<Resource> findByKeyword(String keyword);
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

    //selectbydto
    List<ResourceDTO> selectByTimeRangeAndsuffixAndname(ResourceDTO resourceDTO);

}
