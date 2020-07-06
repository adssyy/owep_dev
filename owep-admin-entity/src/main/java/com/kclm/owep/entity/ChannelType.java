/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/3 16:05
 *@Description 渠道类型实体类
 *
 */
public class ChannelType implements Serializable {
    /**
     *渠道类型id
     */
    private Integer id;

    /**
     *渠道类型名称
     */
    private String channelTypeName;

    /**
     * 客户渠道
     */
    private List<Channel> channelList;

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
     * 空参构造
     */
    public ChannelType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelTypeName() {
        return channelTypeName;
    }

    public void setChannelTypeName(String channelTypeName) {
        this.channelTypeName = channelTypeName;
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

    public List<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<Channel> channelList) {
        this.channelList = channelList;
    }

    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ChannelType{");
        sb.append("id=").append(id);
        sb.append(", channelTypeName='").append(channelTypeName).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append('}');
        return sb.toString();
    }
}