/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.Channel;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/6 14:04
 *@Description 持久层接口ChannelMapper
 *
 */
public interface ChannelMapper {

    /**
     * 通过渠道类型的id获取,获取相应的渠道
     * @return
     */
    List<Channel> findByChannelTypeId(Serializable id);

    /**
     * 通过渠道记录id,来更新渠道名称
     */
    void updateByChannelId(Channel channel);

    /**
     * 通过渠道记录id,来删除渠道名称
     */
    void deleteByChannelId(Serializable id);

    /**
     *通过渠道记录id,来查询渠道信息
     * @return
     */
    Channel findByChannelId(Serializable id);


    /**
     * 添加渠道
     * @param channel
     */
    void saveChannel(Channel channel);
}