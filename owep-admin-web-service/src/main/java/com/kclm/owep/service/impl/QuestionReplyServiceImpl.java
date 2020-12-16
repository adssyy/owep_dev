/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.service.impl;

import com.kclm.owep.dto.QuestionReplyDTO;
import com.kclm.owep.entity.QuestionReply;
import com.kclm.owep.mapper.QuestionReplyMapper;
import com.kclm.owep.service.QuestionReplyService;
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
 * @date 2020/7/15 16:22
 * @version v1.0
 * @description 班级问题回答业务层接口
 *
 */
@Service
@Transactional
public class QuestionReplyServiceImpl implements QuestionReplyService {
    @Autowired
    private QuestionReplyMapper questionReplyMapper;
    @Autowired
    private MapperFactory mapperFactory;

    /**
     * 保存
     * @param entity
     * @return
     */
    @Override
    public int save(QuestionReply entity) {
        return questionReplyMapper.save(entity);
    }

    /**
     * 更新
     * @param entity
     * @return
     */
    @Override
    public int update(QuestionReply entity) {
        return questionReplyMapper.update(entity);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Override
    public int deleteById(Serializable id) {
        return questionReplyMapper.deleteById(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public QuestionReplyDTO selectById(Serializable id) {
        QuestionReply questionReply = questionReplyMapper.selectById(id);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        return mapperFacade.map(questionReply,QuestionReplyDTO.class);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<QuestionReplyDTO> selectAll() {
        List<QuestionReply> questionReplies = questionReplyMapper.selectAll();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(questionReplies,QuestionReplyDTO.class);
    }

    /**
     * 根据Question的id查询
     * @param id
     * @return
     */
    @Override
    public List<QuestionReplyDTO> selectByQuestionId(Serializable id){
        List<QuestionReply> questionReplies = questionReplyMapper.selectByQuestionId(id);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(questionReplies,QuestionReplyDTO.class);
    }
}
