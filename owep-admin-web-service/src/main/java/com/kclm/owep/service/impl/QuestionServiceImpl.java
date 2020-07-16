/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.service.impl;

import com.kclm.owep.dto.QuestionDTO;
import com.kclm.owep.entity.Question;
import com.kclm.owep.service.QuestionService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/*****************
 *
 * @author tanj
 * @date 2020/7/15 16:21
 * @version v1.0
 * @description 班级问题业务层接口
 *
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Override
    public int save(Question entity) {
        return 0;
    }

    @Override
    public int update(Question entity) {
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
    public QuestionDTO selectById(Serializable id) {
        return null;
    }

    @Override
    public List<QuestionDTO> selectAll() {
        return null;
    }

    @Override
    public List<QuestionDTO> selectByName() {
        return null;
    }
}
