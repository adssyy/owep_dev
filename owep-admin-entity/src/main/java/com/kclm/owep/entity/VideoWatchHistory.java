package com.kclm.owep.entity;

import java.time.LocalDateTime;
/*********************
 * @Author: ZhongLei
 * @Version : v1.0
 * @Create: 2020年7月03日
 * @Description 视频观看历史
 */

public class VideoWatchHistory {

    private Integer id;

    //学员id
    private Integer fkStudyRecordId;

    //已观看时间（单位：秒）
    private Double watchPosition;

    //创建时间
    private LocalDateTime createTime;

    //最后访问时间
    private LocalDateTime lastAccessTime;

    //版本
    private Integer version;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getFkStudyRecordId() {
        return fkStudyRecordId;
    }


    public void setFkStudyRecordId(Integer fkStudyRecordId) {
        this.fkStudyRecordId = fkStudyRecordId;
    }


    public Double getWatchPosition() {
        return watchPosition;
    }


    public void setWatchPosition(Double watchPosition) {
        this.watchPosition = watchPosition;
    }


    public LocalDateTime getCreateTime() {
        return createTime;
    }


    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }


    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }


    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }


    public Integer getVersion() {
        return version;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }
}