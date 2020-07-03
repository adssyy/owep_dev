package com.kclm.owep.entity;

import java.time.LocalDateTime;
/*********************
 * @Author: ZhongLei
 * @Version : v1.0
 * @Create: 2020年7月03日
 * @Description 考评模板实体类
 */

public class PollTemplate {

    private Integer id;

    //模板内容
    private String templateContent;

    //模板名称
    private String templateName;

    //模板编号
    private String templateNum;

    //模板状态  1.启用2.未启用
    private Integer templateStatus;

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


    public String getTemplateContent() {
        return templateContent;
    }


    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent == null ? null : templateContent.trim();
    }


    public String getTemplateName() {
        return templateName;
    }


    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }


    public String getTemplateNum() {
        return templateNum;
    }


    public void setTemplateNum(String templateNum) {
        this.templateNum = templateNum == null ? null : templateNum.trim();
    }


    public Integer getTemplateStatus() {
        return templateStatus;
    }


    public void setTemplateStatus(Integer templateStatus) {
        this.templateStatus = templateStatus;
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