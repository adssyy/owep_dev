/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.ChannelType;

import java.util.List;


/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/6 14:04
 *@Description 持久层接口ChannelTypeMapper
 *
 */
public interface ChannelTypeMapper {


    /**
     * 查询所有的渠道类型
     * @return
     */
    List<ChannelType> findAll();


    /**
     * 通过id查询渠道类型
     * @return
     */
    ChannelType findById();

    /**
     * 通过id删除渠道类型
     */
    void deleteById();


    /**
     * 通过id跟新渠道类型
     * @param channelType
     */
    void updateById(ChannelType channelType);


    /**
     * 添加渠道类型
     * @param channelType
     */
    void saveChannelType(ChannelType channelType);



}