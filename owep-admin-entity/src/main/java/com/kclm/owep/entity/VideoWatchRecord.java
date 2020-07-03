package com.kclm.owep.entity;

import java.time.LocalDateTime;
/*********************
 * @Author: ZhongLei
 * @Version : v1.0
 * @Create: 2020年7月03日
 * @Description 视频观看记录
 */

public class VideoWatchRecord {

    //观看绝对历史id
    private Integer id;

    //开始时间
    private LocalDateTime startTime;

    //开始位置（记录第几章节）
    private String startPosition;

    //结束时间
    private LocalDateTime endTime;

    //结束位置
    private String endPosition;

    //视频id
    private Integer fkVideoId;

    //学习记录id
    private Integer fkStudyrecordId;

    //当前视频看到的位置，以秒为单位
    private Double currentProgress;

    //创建时间
    private LocalDateTime createTime;

    //最后一次访问时间
    private LocalDateTime lastAccessTime;

    //版本
    private Integer version;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public LocalDateTime getStartTime() {
        return startTime;
    }


    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }


    public String getStartPosition() {
        return startPosition;
    }


    public void setStartPosition(String startPosition) {
        this.startPosition = startPosition == null ? null : startPosition.trim();
    }


    public LocalDateTime getEndTime() {
        return endTime;
    }


    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }


    public String getEndPosition() {
        return endPosition;
    }


    public void setEndPosition(String endPosition) {
        this.endPosition = endPosition == null ? null : endPosition.trim();
    }


    public Integer getFkVideoId() {
        return fkVideoId;
    }


    public void setFkVideoId(Integer fkVideoId) {
        this.fkVideoId = fkVideoId;
    }


    public Integer getFkStudyrecordId() {
        return fkStudyrecordId;
    }


    public void setFkStudyrecordId(Integer fkStudyrecordId) {
        this.fkStudyrecordId = fkStudyrecordId;
    }


    public Double getCurrentProgress() {
        return currentProgress;
    }


    public void setCurrentProgress(Double currentProgress) {
        this.currentProgress = currentProgress;
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