package com.kclm.owep.entity;

import java.util.Date;

public class Advice {
    /**
     * 反馈人id
     * @mbg.generated
     */
    private Integer id;

    /**
     * 反馈人的email
     * @mbg.generated
     */
    private String email;

    /**
     * 反馈内容
     * @mbg.generated
     */
    private String adviceContent;

    /**
     *
     * @mbg.generated
     */
    private Integer suggestName;

    /**
     * 创建时间
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 最后访问时间
     * @mbg.generated
     */
    private Date lastAccessTime;

    /**
     * 版本
     * @mbg.generated
     */
    private Integer version;

    /**
     * @return the value of t_advice.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the value for t_advice.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the value of t_advice.email
     *
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the value for t_advice.email
     *
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return the value of t_advice.advice_content
     *
     * @mbg.generated
     */
    public String getAdviceContent() {
        return adviceContent;
    }

    /**
     * @param adviceContent the value for t_advice.advice_content
     *
     * @mbg.generated
     */
    public void setAdviceContent(String adviceContent) {
        this.adviceContent = adviceContent == null ? null : adviceContent.trim();
    }

    /**
     * @return the value of t_advice.suggest_name
     *
     * @mbg.generated
     */
    public Integer getSuggestName() {
        return suggestName;
    }

    /**
     * @param suggestName the value for t_advice.suggest_name
     *
     * @mbg.generated
     */
    public void setSuggestName(Integer suggestName) {
        this.suggestName = suggestName;
    }

    /**
     * @return the value of t_advice.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the value for t_advice.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the value of t_advice.last_access_time
     *
     * @mbg.generated
     */
    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    /**
     * @param lastAccessTime the value for t_advice.last_access_time
     *
     * @mbg.generated
     */
    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    /**
     * @return the value of t_advice.version
     *
     * @mbg.generated
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version the value for t_advice.version
     *
     * @mbg.generated
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}