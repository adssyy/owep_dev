/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.service.impl;

import com.kclm.owep.dto.HomeworkDTO;
import com.kclm.owep.entity.Homework;
import com.kclm.owep.service.HomeworkService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/*****************
 *
 * @author tanj
 * @date 2020/7/15 16:20
 * @version v1.0
 * @description 班级作业业务层接口
 *
 */
@Service
public class HomeworkServiceImpl implements HomeworkService {
    @Override
    public int save(Homework entity) {
        return 0;
    }

    @Override
    public int update(Homework entity) {
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
    public HomeworkDTO selectById(Serializable id) {
        return null;
    }

    @Override
    public List<HomeworkDTO> selectAll() {
        return null;
    }

    @Override
    public List<HomeworkDTO> selectByCourseName(String courseName) {
        return null;
    }
}
