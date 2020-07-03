/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.List;
/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/3 16:05
 *@Description 分类实体类
 *
 */
public class CourseCategory {
    /**
     *课程分类id
     */
    private Integer id;

    /**
     *分类名称
     */
    private String categoryName;

    /**
     *分类描述
     */
    private String categoryDesc;

    /**
     *自关联  下级分类对象
     */
    private List<CourseCategory> courseCategoryList;

    /**
     *创建时间
     */
    private LocalDateTime createTime;

    /**
     *逻辑删除 0未删除，1已删除
     */
    private String delete;

    /**
     *版本
     */
    private Integer version;

    /**
     *最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public List<CourseCategory> getCourseCategoryList() {
        return courseCategoryList;
    }

    public void setCourseCategoryList(List<CourseCategory> courseCategoryList) {
        this.courseCategoryList = courseCategoryList;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
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
        final StringBuffer sb = new StringBuffer("CourseCategory{");
        sb.append("id=").append(id);
        sb.append(", categoryName='").append(categoryName).append('\'');
        sb.append(", categoryDesc='").append(categoryDesc).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", delete='").append(delete).append('\'');
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append('}');
        return sb.toString();
    }
}