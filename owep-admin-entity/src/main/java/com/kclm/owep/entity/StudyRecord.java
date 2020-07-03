package com.kclm.owep.entity;

import java.time.LocalDateTime;

/*********************
 * @Author: ZhongLei
 * @Version : v1.0
 * @Create: 2020年7月03日
 * @Description 学习记录实体类
 */

public class StudyRecord {

    private Integer id;

    //学习进度标识 1:未观看或未观看结束 2:已观看完(只有为2时，才能观看下一个视频）
    private Integer progressStatus;

    //创建时间
    private LocalDateTime createTime;

    //学院id
    private Integer fkStudentId;

    //课程节的id
    private Integer fkSectionId;

    //课程名称
    private String courseName;

    //章名称
    private String chapterName;

    //节名称
    private String sectionName;

    //视频观看最大进度
    private Double videoRate;

    //视频时长
    private Integer videoLength;

    //版本
    private Integer version;

    //最后一次访问时间
    private LocalDateTime lastAccessTime;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getProgressStatus() {
        return progressStatus;
    }


    public void setProgressStatus(Integer progressStatus) {
        this.progressStatus = progressStatus;
    }


    public LocalDateTime getCreateTime() {
        return createTime;
    }


    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }


    public Integer getFkStudentId() {
        return fkStudentId;
    }


    public void setFkStudentId(Integer fkStudentId) {
        this.fkStudentId = fkStudentId;
    }


    public Integer getFkSectionId() {
        return fkSectionId;
    }


    public void setFkSectionId(Integer fkSectionId) {
        this.fkSectionId = fkSectionId;
    }


    public String getCourseName() {
        return courseName;
    }


    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }


    public String getChapterName() {
        return chapterName;
    }


    public void setChapterName(String chapterName) {
        this.chapterName = chapterName == null ? null : chapterName.trim();
    }


    public String getSectionName() {
        return sectionName;
    }


    public void setSectionName(String sectionName) {
        this.sectionName = sectionName == null ? null : sectionName.trim();
    }


    public Double getVideoRate() {
        return videoRate;
    }


    public void setVideoRate(Double videoRate) {
        this.videoRate = videoRate;
    }


    public Integer getVideoLength() {
        return videoLength;
    }


    public void setVideoLength(Integer videoLength) {
        this.videoLength = videoLength;
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