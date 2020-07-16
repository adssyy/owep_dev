/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.service.impl;

import com.github.pagehelper.PageHelper;
import com.kclm.owep.dto.ClientDTO;
import com.kclm.owep.dto.ClientNoteDTO;
import com.kclm.owep.entity.AssignRecord;
import com.kclm.owep.entity.Client;
import com.kclm.owep.entity.ClientNote;
import com.kclm.owep.entity.User;
import com.kclm.owep.mapper.AssignRecordMapper;
import com.kclm.owep.mapper.ClientMapper;
import com.kclm.owep.mapper.ClientNoteMapper;
import com.kclm.owep.service.ClientService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/14 16:39
 *@Description TODO
 *
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientMapper clientMapper;

    @Autowired
    AssignRecordMapper assignRecordMapper;

    @Autowired
    ClientNoteMapper clientNoteMapper;

    @Autowired
    MapperFactory mapperFactory;

    /**
     * 通过客户属性查询客户
     * @param client
     * @return
     */
    @Override
    public List<ClientDTO> findClientByField(Client client) {
        List<Client> byField = clientMapper.findByField(client);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(byField, ClientDTO.class);
    }

    /**
     * 查询所有客户
     * @return
     */
    @Override
    public List<ClientDTO> findAllClient() {
        List<Client> clients = clientMapper.selectAll();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
       return mapperFacade.mapAsList(clients, ClientDTO.class);
    }

    /**
     * 分页查询 客户
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<ClientDTO> findAllByPaging(int page, int size) {
        PageHelper.startPage(page, size);
        List<Client> clients = clientMapper.selectAll();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(clients, ClientDTO.class);
    }

    /**
     * 添加客户
     * @param client
     * @return
     */
    @Override
    public int addClient(Client client) {
      return  clientMapper.save(client);
    }

    /**
     * 把客户转给其他咨询师
     * @param ids  被转出的客户
     * @param sourceId 转出咨询师的id
     * @param targetId 接收咨询师的id
     * @return
     */
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @Override
    public int assigningClient(List<Serializable> ids, String reason, Integer sourceId, Integer targetId) {
        //先把客户分给咨询师
        int updateCount = clientMapper.assigningClient(ids, targetId);
        //再将转出记录保存
        for(int i = 0; i<ids.size();i++){
            AssignRecord assignRecord = new AssignRecord();
            User toUser = new User();
            toUser.setId(targetId);
            User fromUser = new User();
            fromUser.setId(sourceId);
            assignRecord.setFromUser(fromUser);
            assignRecord.setToUser(toUser);
            Client client = new Client();
            client.setId((Integer)ids.get(i));
            assignRecord.setClient(client);
            assignRecord.setReason(reason);
            assignRecordMapper.save(assignRecord);
        }
        return updateCount;
    }

    /**
     *
     * 删除所选的用户
     * @param ids
     * @return
     */
    @Override
    public int deleteClientByIds(List<Serializable> ids) {
        return clientMapper.deleteSelect(ids);
    }

    /**
     * 删除单个客户
     * @param id
     * @return
     */
    @Override
    public int deleteClientById(Serializable id) {
        return clientMapper.deleteById(id);
    }

    /**
     * 签约客户
     * @param client
     * @return
     */
    @Override
    public int signClient(Client client) {
        return clientMapper.signClient(client);
    }

    /**
     * 修改客户信息
     * @param client
     * @return
     */
    @Override
    public int alterClient(Client client) {
        return clientMapper.update(client);
    }

    /**
     * 发邮寄给客户 邀请面试
     * @param clientEmail
     * @param content
     * @return
     */
    @Override
    public int sendEmailClient(String clientEmail, String content) {
        //TODO
        return 0;
    }

    /**
     * 添加客户跟进记录
     * @param clientNote
     * @return
     */
    @Override
    public int addClientNote(ClientNote clientNote) {
       return clientNoteMapper.save(clientNote);
    }

    /**
     * 通过客户id ,查询所有的跟进记录
     * @param id
     * @return
     */
    @Override
    public List<ClientNoteDTO> findAllByClientId(Serializable id) {
        List<ClientNote> clientNotes = clientNoteMapper.selectAllById(id);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(clientNotes, ClientNoteDTO.class);
    }
}
