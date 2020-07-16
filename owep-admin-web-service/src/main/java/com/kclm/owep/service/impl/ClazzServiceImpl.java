/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.service.impl;

import com.kclm.owep.dto.ClazzDTO;
import com.kclm.owep.entity.Clazz;
import com.kclm.owep.service.ClazzService;
import org.springframework.stereotype.Service;

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
public class ClazzServiceImpl implements ClazzService {
    @Override
    public int save(Clazz entity) {
        return 0;
    }

    @Override
    public int update(Clazz entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteSelect(List<Serializable> idList) {
        return 0;
    }

    @Override
    public ClazzDTO selectById(Serializable id) {
        return null;
    }

    @Override
    public List<ClazzDTO> selectAll() {
        return null;
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

    @Override
    public List<ClazzDTO> selectByNum(String classNum) {
        return null;
    }

    @Override
    public List<ClazzDTO> selectByName(String className) {
        return null;
    }

    @Override
    public List<ClazzDTO> selectByPro(int pid) {
        return null;
    }
}
