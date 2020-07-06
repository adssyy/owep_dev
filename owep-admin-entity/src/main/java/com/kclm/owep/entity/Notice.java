package com.kclm.owep.entity;

import java.time.LocalDateTime;

public class Notice {
    /**
     * 主键
     * @mbg.generated
     */
    private Integer id;

    /**
     * 标题
     * @mbg.generated
     */
    private String noticeTitle;

    /**
     * 内容
     * @mbg.generated
     */
    private String noticeContent;

    /**
     * 发布人
     * @mbg.generated
     */
    private String noticePublisher;

    /**
     * 创建时间
     * @mbg.generated
     */
    private LocalDateTime createTime;

    /**
     * 版本
     * @mbg.generated
     */
    private Integer version;

    /**
     * 最后访问时间
     * @mbg.generated
     */
    private LocalDateTime lastAccessTime;

    /**
     * 状态，是否被访问
     * @mbg.generated
     */
    private Integer noticeStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public String getNoticePublisher() {
        return noticePublisher;
    }

    public void setNoticePublisher(String noticePublisher) {
        this.noticePublisher = noticePublisher == null ? null : noticePublisher.trim();
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

    public Integer getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(Integer noticeStatus) {
        this.noticeStatus = noticeStatus;
    }
}