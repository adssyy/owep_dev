/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.service.impl;

import com.kclm.owep.dto.ClazzDTO;
import com.kclm.owep.dto.ResourceDTO;
import com.kclm.owep.entity.Clazz;
import com.kclm.owep.entity.Resource;
import com.kclm.owep.entity.ResourceType;
import com.kclm.owep.mapper.ClazzMapper;
import com.kclm.owep.mapper.ResourceMapper;
import com.kclm.owep.mapper.ResourceTypeMapper;
import com.kclm.owep.service.ClazzService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/*****************
 *
 * @author tanj
 * @date 2020/7/15 16:18
 * @version v1.0
 * @description 班级管理业务层接口
 *
 */
@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private ResourceTypeMapper resourceTypeMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private MapperFactory mapperFactory;

    /***
     * 添加班级
     * @param entity
     * @return
     */
    @Override
    public int save(Clazz entity) {
        //保存entity
        int save = clazzMapper.save(entity);
        //获取班级id
        int classId=clazzMapper.selectByName(entity.getClassName()).get(0).getId();
        //添加班级-方案中间表
        for (int i=0;i<entity.getPlanManagerList().size();i++){
            clazzMapper.saveClazzPlanmanage(entity.getPlanManagerList().get(i).getId(),classId);
        }
        //添加班级-资源中间表
        /*for (int i=0;i<entity.getResourceList().size();i++){
            clazzMapper.saveClazzResource(classId,entity.getResourceList().get(i).getId());
        }*/
        //返回班级表影响的行数
        return save;
    }

    /***
     * 更新班级
     * @param entity
     * @return
     */
    @Override
    public int update(Clazz entity) {

        int update = clazzMapper.update(entity);
        //获取班级id
        int classId=entity.getId();
        //修改班级-方案中间表
        clazzMapper.deleteClazzPlanmanage(classId);
        System.out.println(entity.getPlanManagerList() != null);
        if (entity.getPlanManagerList() != null){
            for (int i=0;i<entity.getPlanManagerList().size();i++){

                clazzMapper.saveClazzPlanmanage(entity.getPlanManagerList().get(i).getId(),classId);
            }
        }
        return update;
    }

    /***
     * 根据id删除班级
     * @param id
     * @return
     */
    @Override
    public int deleteById(Serializable id) {
        return clazzMapper.deleteById(id);
    }

    /**
     * 删除多个id
     * @param idList
     * @return
     */
    @Override
    public int deleteSelect(List<Serializable> idList) {
        return clazzMapper.deleteSelect(idList);
    }

    /***
     * 根据班级id来查找班级
     * @param id
     * @return
     */
    @Override
    public ClazzDTO selectById(Serializable id) {
        Clazz clazz = clazzMapper.selectById(id);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        ClazzDTO clazzDTO = mapperFacade.map(clazz, ClazzDTO.class);
        return clazzDTO;
    }

    /**
     * 查询所有班级
     * @return
     */
    @Override
    public List<ClazzDTO> selectAll() {
        List<Clazz> clazzes = clazzMapper.selectAll();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<ClazzDTO> clazzDTOS = mapperFacade.mapAsList(clazzes, ClazzDTO.class);
        return clazzDTOS;
    }

    @Override
    public List<ResourceDTO> selectClazzResourceByClazzId(Serializable cid){
        List<Resource> resourceList = resourceMapper.selectByClassId(cid);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<ResourceDTO> resourceDTOS = mapperFacade.mapAsList(resourceList, ResourceDTO.class);
        for (ResourceDTO resourceDTO:resourceDTOS){
            System.out.println(resourceDTO.toString());
        }
        return resourceDTOS;
    }

    @Override
    public int saveClazzResource(Serializable cid, Serializable rid) {
        return 0;
    }

    @Override
    public int deleteClazzResource(Serializable cid, Serializable rid) {
        return 0;
    }

    @Override
    public int saveClazzPlanmanage(Serializable cid, Serializable pid) {
        return 0;
    }

    @Override
    public int deleteClazzPlanmanage(Serializable cid) {
        return 0;
    }

    /***
     * 根据班级编号查询班级
     * @param classNum
     * @return
     */
    @Override
    public List<ClazzDTO> selectByNum(String classNum) {
        List<Clazz> clazzes = clazzMapper.selectByNum(classNum);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<ClazzDTO> clazzDTOS = mapperFacade.mapAsList(clazzes, ClazzDTO.class);
        return clazzDTOS;
    }

    /***
     * 根据班级名称来查询班级
     * @param className
     * @return
     */
    @Override
    public List<ClazzDTO> selectByName(String className) {
        List<Clazz> clazzes = clazzMapper.selectByName(className);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<ClazzDTO> clazzDTOS = mapperFacade.mapAsList(clazzes, ClazzDTO.class);
        return clazzDTOS;
    }

    /**
     * 根据专业方向id 来查询班级
     * @param pid
     * @return
     */
    @Override
    public List<ClazzDTO> selectByPro(int pid) {
        List<Clazz> clazzes = clazzMapper.selectByPro(pid);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<ClazzDTO> clazzDTOS = mapperFacade.mapAsList(clazzes, ClazzDTO.class);
        return clazzDTOS;
    }

    /**
     * 根据关键词来查询班级
     * @param classNumber
     * @param className
     * @param instituteName
     * @param instituteBranchName
     * @param pid
     * @return
     */
    @Override
    public List<ClazzDTO> selectByKeyword(String classNumber, String className, String instituteName, String instituteBranchName, Serializable pid){
        List<Clazz> clazzes = clazzMapper.selectByKeyword(classNumber, className, instituteName, instituteBranchName, pid);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<ClazzDTO> clazzDTOS = mapperFacade.mapAsList(clazzes, ClazzDTO.class);
        return clazzDTOS;
    }


}
