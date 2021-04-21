/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.service;

import com.kclm.owep.dto.QuestionReplyDTO;
import com.kclm.owep.entity.QuestionReply;
import java.io.Serializable;
import java.util.List;

/*****************
 *
 * @author tanj
 * @date 2020/7/13 11:50
 * @version v1.0
 * @description 问题回答
 *
 */
public interface QuestionReplyService {
    /***
     * 保存一条记录
     * @param entity
     * @return
     */
    int save(QuestionReply entity);

    /***
     * 更新一条记录
     * @param entity
     * @return
     */
    int update(QuestionReply entity);

    /***
     * 根据id来删除一条记录
     * @param id
     * @return
     */
    int deleteById(Serializable id);

    /***
     * 根据id来查询一条记录
     * @param id
     * @return
     */
    QuestionReplyDTO selectById(Serializable id);

    /***
     * 查询所有的记录
     * @return
     */
    List<QuestionReplyDTO> selectAll();
}
