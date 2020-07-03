/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.time.LocalDateTime;
/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/3 16:05
 *@Description 渠道实体类
 *
 */
public class Channel {
    /**
     *主键
     */
    private Integer id;

    /**
     *渠道名称
     */
    private String channelName;

    /**
     *创建时间
     */
    private LocalDateTime createTime;

    /**
     *版本
     */
    private Integer version;

    /**
     *最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    /**
     *渠道类型
     */
    private ChannelType channelType;

    public Channel() {
    }

    public Channel(String channelName, LocalDateTime createTime, ChannelType channelType) {
        this.channelName = channelName;
        this.createTime = createTime;
        this.channelType = channelType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelType channelType) {
        this.channelType = channelType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Channel{");
        sb.append("id=").append(id);
        sb.append(", channelName='").append(channelName).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", channelType=").append(channelType);
        sb.append('}');
        return sb.toString();
    }
}