/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.service;

import com.kclm.owep.dto.ClientDTO;
import com.kclm.owep.dto.ClientNoteDTO;
import com.kclm.owep.entity.Client;
import com.kclm.owep.entity.ClientNote;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/13 11:21
 *@Description 客户业务层接口
 *
 */
public interface ClientService {

    /**
     * 通过客户属性查询客户
     * @param client
     * @return
     */
    List<ClientDTO> findClientByField(Client client);

    /**
     * 查询所有的客户
     * @return
     */
    List<ClientDTO> findAllClient();

    /**
     * 分页查询 客户
     * @param page
     * @param size
     * @return
     */
    List<ClientDTO> findAllByPaging(int page, int size);

    /**
     * 添加客户
     * @param client
     * @return
     */
    int addClient(Client client);

    /**
     * 分配客户
     * @param ids
     * @param reason
     * @param sourceId
     * @param targetId
     * @return
     */
    int assigningClient(List<Serializable> ids, String reason, Integer sourceId, Integer targetId);

    /**
     * 通过ids,删除多个客户
     * @param ids
     * @return
     */
    int deleteClientByIds(List<Serializable> ids);

    /**
     * 通过id,删除客户
     * @param id
     * @return
     */
    int deleteClientById(Serializable id);

    /**
     * 签约客户
     * @param client
     * @return
     */
    int signClient(Client client);

    /**
     * 修改客户信息
     * @param client
     * @return
     */
    int alterClient(Client client);

    /**
     * 发邮件给客户
     * @param clientEmail
     * @param content
     * @return
     */
    int sendEmailClient(String clientEmail, String content);

    /**
     * 添加跟进记录
     * @param clientNote
     * @return
     */
    int addClientNote(ClientNote clientNote);

    /**
     * 通过客户id查询跟进记录
     * @param id
     * @return
     */
    List<ClientNoteDTO> findAllByClientId(Serializable id);
}
