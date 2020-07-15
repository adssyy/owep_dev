/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.service.impl;

import com.kclm.owep.dto.QuestionReplyDTO;
import com.kclm.owep.entity.QuestionReply;
import com.kclm.owep.service.QuestionReplyService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/*****************
 *
 * @author tanj
 * @date 2020/7/15 16:22
 * @version v1.0
 * @description 班级问题回答业务层接口
 *
 */
@Service
public class QuestionReplyServiceImpl implements QuestionReplyService {
    @Override
    public int save(QuestionReply entity) {
        return 0;
    }

    @Override
    public int update(QuestionReply entity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public QuestionReplyDTO selectById(Serializable id) {
        return null;
    }

    @Override
    public List<QuestionReplyDTO> selectAll() {
        return null;
    }
}
