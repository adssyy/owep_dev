package com.kclm.owep.entity;

import java.time.LocalDateTime;

public class Advice {
    /**
     * 主键
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
    private LocalDateTime createTime;

    /**
     * 最后访问时间
     * @mbg.generated
     */
    private LocalDateTime lastAccessTime;

    /**
     * 版本
     * @mbg.generated
     */
    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAdviceContent() {
        return adviceContent;
    }

    public void setAdviceContent(String adviceContent) {
        this.adviceContent = adviceContent == null ? null : adviceContent.trim();
    }

    public Integer getSuggestName() {
        return suggestName;
    }

    public void setSuggestName(Integer suggestName) {
        this.suggestName = suggestName;
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