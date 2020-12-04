/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.service;

import com.kclm.owep.dto.ClazzDTO;
import com.kclm.owep.dto.ResourceDTO;
import com.kclm.owep.entity.Clazz;
import java.io.Serializable;
import java.util.List;

/*****************
 *
 * @author tanj
 * @date 2020/7/13 11:43
 * @version v1.0
 * @description 班级
 *
 */
public interface ClazzService {
    /***
     * 增
     * @param entity
     * @return
     */
    int save(Clazz entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(Clazz entity);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(Serializable id);

    /***
     * 删除多个
     * @param idList
     * @return
     */
    int deleteSelect(List<Serializable> idList);

    /***
     *根据id查询
     * @param id
     * @return
     */
    ClazzDTO selectById(Serializable id);

    /**
     * 查询所有
     * @return
     */
    List<ClazzDTO> selectAll();

    /**
     * 根据班级id获取该班级中所有的资源
     * @param cid
     * @return
     */
    List<ResourceDTO> selectClazzResourceByClazzId(Serializable cid);

    /***
     * 向t_class_resource 中间表中插入数据
     * @param cid
     * @param rid
     * @return
     */
    int saveClazzResource(Serializable cid,Serializable rid);

    /***
     * 删除班级-资源中间表
     * @param cid
     * @return
     */
    int deleteClazzResource(Serializable cid,Serializable rid);
    /***
     * 向t_class_planmanage 中间表中插入数据
     * @param cid
     * @param pid
     * @return
     */
    int saveClazzPlanmanage(Serializable cid,Serializable pid);

    /***
     * 根据班级id来删除班级方案中间表
     * @param cid
     * @return
     */
    int deleteClazzPlanmanage(Serializable cid);

    /***
     * 根据班级编号查询
     * @param classNum
     * @return
     */
    List<ClazzDTO> selectByNum(String classNum);

    /***
     * 更加班级名称来查询
     * @param className
     * @return
     */
    List<ClazzDTO> selectByName(String className);

    /***
     * 根据专业方向来查询
     * @param pid
     * @return
     */
    List<ClazzDTO> selectByPro(int pid);

    List<ClazzDTO> selectByKeyword(String classNumber, String className, String instituteName, String instituteBranchName, Serializable pid);


}
