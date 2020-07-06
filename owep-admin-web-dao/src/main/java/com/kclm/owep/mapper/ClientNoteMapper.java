/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.ClientNote;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/6 14:04
 *@Description 持久层接口ClientNoteMapper
 *
 */
public interface ClientNoteMapper {

    /**
     * 查询单个客户的所有的跟踪记录
     * @return
     */
    List<ClientNote> findAll();

    /**
     * 通过跟踪记录id 删除跟踪记录
     * @param id
     */
    void deleteById(Serializable id);

    /**
     * 更新跟踪记录信息
     * @param clientNote
     */
    void updateClientNote(ClientNote clientNote);

    /**
     * 添加跟踪记录
     * @param clientNote
     */
    void saveClientNote(ClientNote clientNote);



}