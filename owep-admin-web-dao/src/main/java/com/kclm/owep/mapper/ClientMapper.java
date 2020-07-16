/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.Client;
import com.kclm.owep.mapper.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/6 14:04
 *@Description 持久层接口ClientMapper
 *
 */
@Mapper
public interface ClientMapper extends BaseMapper<Client> {


    /**
     * 通过客户属性查询客户
     * @return
     */
    List<Client> findByField(Client client);

    /**
     * 分配客户
     * @param ids
     * @param id
     * @return
     */
    int assigningClient(@Param("list") List<Serializable> ids,@Param("id") Serializable id);

    /**
     * 查询客户总数量
     * @return
     */
    long rowTotal();

    @Override
    int save(Client entity);

    @Override
    int update(Client entity);

    @Override
    int deleteById(Serializable id);

    @Override
    int deleteSelect(List<Serializable> idList);

    @Override
    Client selectById(Serializable id);

    @Override
    List<Client> selectAll();

    /**
     * 签约客户
     * @param client
     * @return
     */
    int signClient(Client client);
}