/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.Client;
import com.kclm.owep.mapper.common.BaseMapper;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/6 14:04
 *@Description 持久层接口ClientMapper
 *
 */
public interface ClientMapper extends BaseMapper<Client> {


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




}