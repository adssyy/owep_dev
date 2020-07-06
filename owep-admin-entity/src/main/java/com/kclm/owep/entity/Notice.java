package com.kclm.owep.entity;

import java.util.Date;

public class Notice {
    /**
     * 公告管理的id
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
    private Date createTime;

    /**
     * 版本
     * @mbg.generated
     */
    private Integer version;

    /**
     * 最后访问时间
     * @mbg.generated
     */
    private Date lastAccessTime;

    /**
     * 状态，是否被访问
     * @mbg.generated
     */
    private Integer noticeStatus;

    /**
     * @return the value of t_notice.id
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the value for t_notice.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the value of t_notice.notice_title
     *
     * @mbg.generated
     */
    public String getNoticeTitle() {
        return noticeTitle;
    }

    /**
     * @param noticeTitle the value for t_notice.notice_title
     *
     * @mbg.generated
     */
    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    /**
     * @return the value of t_notice.notice_content
     *
     * @mbg.generated
     */
    public String getNoticeContent() {
        return noticeContent;
    }

    /**
     * @param noticeContent the value for t_notice.notice_content
     *
     * @mbg.generated
     */
    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    /**
     * @return the value of t_notice.notice_publisher
     *
     * @mbg.generated
     */
    public String getNoticePublisher() {
        return noticePublisher;
    }

    /**
     * @param noticePublisher the value for t_notice.notice_publisher
     *
     * @mbg.generated
     */
    public void setNoticePublisher(String noticePublisher) {
        this.noticePublisher = noticePublisher == null ? null : noticePublisher.trim();
    }

    /**
     * @return the value of t_notice.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the value for t_notice.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the value of t_notice.version
     *
     * @mbg.generated
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version the value for t_notice.version
     *
     * @mbg.generated
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return the value of t_notice.last_access_time
     *
     * @mbg.generated
     */
    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    /**
     * @param lastAccessTime the value for t_notice.last_access_time
     *
     * @mbg.generated
     */
    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    /**
     * @return the value of t_notice.notice_status
     *
     * @mbg.generated
     */
    public Integer getNoticeStatus() {
        return noticeStatus;
    }

    /**
     * @param noticeStatus the value for t_notice.notice_status
     *
     * @mbg.generated
     */
    public void setNoticeStatus(Integer noticeStatus) {
        this.noticeStatus = noticeStatus;
    }
}