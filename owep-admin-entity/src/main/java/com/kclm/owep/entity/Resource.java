package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Resource {

    private Integer id;  //主键id

    private String resourceName;  //资源名称

    private Integer type;   //资源类型，1、表示课程资源，2、表示公共资源

    private String resourceSuffix;   //资源扩展名(类型)，如pdf、docx、ppt、md等

    private Integer resourceSize;  //资源大小

    private String resourceTitle;  //资源标题（空）

    private String resourcePath;  //文件路径

    private String resourceLabel;  //资源标签

    private String resourceDesc;  //资源描述

    private LocalDateTime createTime;  //创建时间

    private Integer delete;   //逻辑删除，1表示未删除，0表示已删除

    private Section section;  //节

    private Chapter chapter;   //章

    private Course course;   //课程

    private ResourceType resourceType;  //资源类型

    private Integer oldResourcename;  //旧资源名称

    private Integer version;  //版本号

    private LocalDateTime lastAccessTime;  //最后一次访问时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getResourceSuffix() {
        return resourceSuffix;
    }

    public void setResourceSuffix(String resourceSuffix) {
        this.resourceSuffix = resourceSuffix;
    }

    public Integer getResourceSize() {
        return resourceSize;
    }

    public void setResourceSize(Integer resourceSize) {
        this.resourceSize = resourceSize;
    }

    public String getResourceTitle() {
        return resourceTitle;
    }

    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getResourceLabel() {
        return resourceLabel;
    }

    public void setResourceLabel(String resourceLabel) {
        this.resourceLabel = resourceLabel;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public Integer getOldResourcename() {
        return oldResourcename;
    }

    public void setOldResourcename(Integer oldResourcename) {
        this.oldResourcename = oldResourcename;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Resource{");
        sb.append("id=").append(id);
        sb.append(", resourceName='").append(resourceName).append('\'');
        sb.append(", type=").append(type);
        sb.append(", resourceSuffix='").append(resourceSuffix).append('\'');
        sb.append(", resourceSize=").append(resourceSize);
        sb.append(", resourceTitle='").append(resourceTitle).append('\'');
        sb.append(", resourcePath='").append(resourcePath).append('\'');
        sb.append(", resourceLabel='").append(resourceLabel).append('\'');
        sb.append(", resourceDesc='").append(resourceDesc).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", delete=").append(delete);
        sb.append(", section=").append(section);
        sb.append(", chapter=").append(chapter);
        sb.append(", course=").append(course);
        sb.append(", resourceType=").append(resourceType);
        sb.append(", oldResourcename=").append(oldResourcename);
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append('}');
        return sb.toString();
    }
}