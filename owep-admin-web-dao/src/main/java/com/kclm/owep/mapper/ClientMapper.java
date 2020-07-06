/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.Client;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/6 14:04
 *@Description 持久层接口ClientMapper
 *
 */
public interface ClientMapper {


    /**
     * 查询所有的客户
     * @return
     */
    List<Client> findAll();

    /**
     * 分页查询部分客户
     * @param offset
     * @param limit
     * @return
     */
    List<Client> findClientLimit(int offset, int limit);


    /**
     * 通过客户属性查询客户
     * @return
     */
    List<Client> findByField(Client client);


    /**
     * 添加客户
     * @param client
     */
    void saveClient(Client client);

    /**
     * 删除多个客户
     * @param integerList
     */
    void deleteByIds(List<Integer> integerList);

    /**
     * 通过客户id 删除客户
     * @param id
     */
    void deleteById(Serializable id);

    /**
     * 更新客户信息
     * @param client
     */
    void updateClient(Client client);



}