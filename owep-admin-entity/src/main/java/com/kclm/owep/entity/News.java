package com.kclm.owep.entity;

import java.time.LocalDateTime;

public class News {
    /**
     * 主键
     * @mbg.generated
     */
    private Integer id;

    /**
     * 新闻标题
     * @mbg.generated
     */
    private String newsTitle;

    /**
     * 新闻内容
     * @mbg.generated
     */
    private String newsContent;

    /**
     * 新闻类型
     * @mbg.generated
     */
    private Integer newsType;

    /**
     *新闻发布人
     * @mbg.generated
     */
    private String newsPublisher;

    /**
     * 新闻创建时间
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
     * 新闻路劲
     * @mbg.generated
     */
    private String newsUrl;

    /**
     * 阅读量
     * @mbg.generated
     */
    private Integer readSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    public String getNewsPublisher() {
        return newsPublisher;
    }

    public void setNewsPublisher(String newsPublisher) {
        this.newsPublisher = newsPublisher == null ? null : newsPublisher.trim();
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

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl == null ? null : newsUrl.trim();
    }

    public Integer getReadSize() {
        return readSize;
    }

    public void setReadSize(Integer readSize) {
        this.readSize = readSize;
    }
}