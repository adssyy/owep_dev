/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/3 17:00
 *@Description:考评选项实体类
 ***/
public class PollItem {

    //考评选项id
    private Integer id;

    //考评选项编号
    private String pollNum;

    //考评内容
    private String pollContent;

    //是否启用  1.启用 2.未启用
    private Integer status;

    //创建时间
    private LocalDateTime createTime;

    //版本
    private Integer version;

    //最后访问时间
    private LocalDateTime lastAccessTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPollNum() {
        return pollNum;
    }

    public void setPollNum(String pollNum) {
        this.pollNum = pollNum;
    }

    public String getPollContent() {
        return pollContent;
    }

    public void setPollContent(String pollContent) {
        this.pollContent = pollContent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
