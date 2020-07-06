package com.kclm.owep.entity;

import java.util.Date;

public class News {
    /**
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
     * 新闻路劲
     * @mbg.generated
     */
    private String newsUrl;

    /**
     * 阅读量
     * @mbg.generated
     */
    private Integer readSize;

    /**
     * @return the value of t_news.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the value for t_news.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the value of t_news.news_title
     *
     * @mbg.generated
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * @param newsTitle the value for t_news.news_title
     *
     * @mbg.generated
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    /**
     * @return the value of t_news.news_content
     *
     * @mbg.generated
     */
    public String getNewsContent() {
        return newsContent;
    }

    /**
     * @param newsContent the value for t_news.news_content
     *
     * @mbg.generated
     */
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }

    /**
     * @return the value of t_news.news_type
     *
     * @mbg.generated
     */
    public Integer getNewsType() {
        return newsType;
    }

    /**
     * @param newsType the value for t_news.news_type
     *
     * @mbg.generated
     */
    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    /**
     * @return the value of t_news.news_publisher
     *
     * @mbg.generated
     */
    public String getNewsPublisher() {
        return newsPublisher;
    }

    /**
     * @param newsPublisher the value for t_news.news_publisher
     *
     * @mbg.generated
     */
    public void setNewsPublisher(String newsPublisher) {
        this.newsPublisher = newsPublisher == null ? null : newsPublisher.trim();
    }

    /**
     * @return the value of t_news.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the value for t_news.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the value of t_news.version
     *
     * @mbg.generated
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version the value for t_news.version
     *
     * @mbg.generated
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return the value of t_news.last_access_time
     *
     * @mbg.generated
     */
    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    /**
     * @param lastAccessTime the value for t_news.last_access_time
     *
     * @mbg.generated
     */
    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    /**
     * @return the value of t_news.news_url
     *
     * @mbg.generated
     */
    public String getNewsUrl() {
        return newsUrl;
    }

    /**
     * @param newsUrl the value for t_news.news_url
     *
     * @mbg.generated
     */
    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl == null ? null : newsUrl.trim();
    }

    /**
     * @return the value of t_news.read_size
     *
     * @mbg.generated
     */
    public Integer getReadSize() {
        return readSize;
    }

    /**
     * @param readSize the value for t_news.read_size
     *
     * @mbg.generated
     */
    public void setReadSize(Integer readSize) {
        this.readSize = readSize;
    }
}