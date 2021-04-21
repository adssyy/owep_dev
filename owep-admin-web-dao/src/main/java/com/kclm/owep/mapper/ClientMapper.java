/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.Client;
import com.kclm.owep.entity.vo.IdAndKey;
import com.kclm.owep.entity.vo.SummaryClient;
import com.kclm.owep.entity.vo.SummaryPay;
import com.kclm.owep.entity.vo.SummaryChannel;
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
     *
     * @return
     */
    List<Client> findByField(Client client);

    /**
     * 通过客户属性和登录者身份查询客户
     */
    List<Client> findByFieldAndType(Client client,int id);

    /**
     * 分配客户
     *
     * @param ids
     * @param id
     * @return
     */
    int assigningClient(@Param("list") List<Serializable> ids, @Param("id") Serializable id);

    /**
     * 查询客户总数量
     *
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
    int deleteSelect(@Param("list") List<Serializable> idList);

    @Override
    Client selectById(Serializable id);

    @Override
    List<Client> selectAll();

    List<Client> selectAllByUserType(int userid);

    /**
     * 签约客户
     *
     * @param client
     * @return
     */
    int signClient(Client client);

    /**
     * 统计订单、贷款、预付总金额
     */
    SummaryPay summaryPay();

    /**
     * 统计渠道和该渠道的客户数量
     */
    List<SummaryChannel> summaryChannel();

    /**
     * 统计客户量情况
     */
    List<SummaryClient> summaryClient();

    /**
     * 搜索客户状态
     */
    List<IdAndKey> clientState();

    /**
     * 搜索客户归属
     */
    List<IdAndKey> clientBelong();

    /**
     * 搜索客户渠道
     */
    List<IdAndKey> clientChannel(String selectKey);

    /**
     * 搜索客户渠道类型
     */
    List<IdAndKey> clientChannelType();
}