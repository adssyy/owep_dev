package com.kclm.owep.entity;

import java.time.LocalDateTime;
/*********************
 * @Author: ZhongLei
 * @Version : v1.0
 * @Create: 2020年7月03日
 * @Description 教师考评实体类
 */

public class TeacherPoll {

    private Integer id;

    //老师名称
    private String teacherName;

    //班级名称
    private String className;

    //考评地址
    private String pollAddress;

    //考评成绩
    private String pollGrade;

    //有效期
    private LocalDateTime effectiveTime;

    //考评状态 1:未开始 2:进行中 3:已结束(未审核) 4:已结束(已审核)
    private String pollStatus;

    //考评人数
    private Integer pollCount;

    //考评建议
    private String pollSuggest;

    //模板id
    private Integer fkTemplateId;

    //用户id
    private Integer fkUserId;

    //班级id
    private Integer fkClassId;

    //允许ipi地址
    private String allowIp;

    //是否限定IP网段   1.表示限定 0.表示不限定
    private Integer ipLimit;

    //开始时间
    private LocalDateTime startTime;

    //结束时间
    private LocalDateTime endTime;

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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getPollAddress() {
        return pollAddress;
    }

    public void setPollAddress(String pollAddress) {
        this.pollAddress = pollAddress == null ? null : pollAddress.trim();
    }

    public String getPollGrade() {
        return pollGrade;
    }

    public void setPollGrade(String pollGrade) {
        this.pollGrade = pollGrade == null ? null : pollGrade.trim();
    }

    public LocalDateTime getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(LocalDateTime effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public String getPollStatus() {
        return pollStatus;
    }

    public void setPollStatus(String pollStatus) {
        this.pollStatus = pollStatus == null ? null : pollStatus.trim();
    }

    public Integer getPollCount() {
        return pollCount;
    }

    public void setPollCount(Integer pollCount) {
        this.pollCount = pollCount;
    }

    public String getPollSuggest() {
        return pollSuggest;
    }

    public void setPollSuggest(String pollSuggest) {
        this.pollSuggest = pollSuggest == null ? null : pollSuggest.trim();
    }

    public Integer getFkTemplateId() {
        return fkTemplateId;
    }

    public void setFkTemplateId(Integer fkTemplateId) {
        this.fkTemplateId = fkTemplateId;
    }

    public Integer getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(Integer fkUserId) {
        this.fkUserId = fkUserId;
    }

    public Integer getFkClassId() {
        return fkClassId;
    }

    public void setFkClassId(Integer fkClassId) {
        this.fkClassId = fkClassId;
    }

    public String getAllowIp() {
        return allowIp;
    }

    public void setAllowIp(String allowIp) {
        this.allowIp = allowIp == null ? null : allowIp.trim();
    }

    public Integer getIpLimit() {
        return ipLimit;
    }

    public void setIpLimit(Integer ipLimit) {
        this.ipLimit = ipLimit;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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