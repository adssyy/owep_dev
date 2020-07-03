/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.Date;
/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/3 16:05
 *@Description 课程实体类
 *
 */
public class Course {
    /**
     *课程id
     */
    private Integer id;

    /**
     *课程编号
     */
    private String courseNumber;

    /**
     *课程名称
     */
    private String courseName;

    /**
     *课程开始时间
     */
    private Date startTime;

    /**
     *课程结束时间
     */
    private Date endTime;

    /**
     *课程学时
     */
    private Integer coursePeriod;

    /**
     *课程是否免费：0表示不免费、1 表示免费
     */
    private Boolean free;

    /**
     *课程状态 0未启用、1启用
     */
    private String courseStatus;

    /**
     *课程图片
     */
    private String courseImage;

    /**
     *课程描述
     */
    private String courseDesc;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *视频公开状态：0私有视频、1公开视频
     */
    private Integer courseOpenStatus;

    /**
     *是否允许观看：0不允许观看、1允许观看
     */
    private Integer videoStatus;

    /**
     *是否热门：0不热门、1热门
     */
    private Boolean hot;

    /**
     * 0 表示不监听、1 表示监听
     */
    private Boolean listener;

    /**
     *课程类型
     */
    private String courseType;

    /**
     *关联课程分类对象
     */
    private CourseCategory courseCategory;

    /**
     *此属性有值，代表是从总控平台传送过来的数据
     */
    private String courseSendType;

    /**
     *逻辑删除 0:未删除 1:已删除
     */
    private Integer delete;

    /**
     *版本
     */
    private Integer version;

    /**
     *最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    public Course() {
    }

    public Course(String courseNumber, String courseName, Date startTime, Date endTime, Integer coursePeriod, String courseStatus, Date createTime, Integer courseOpenStatus, Integer videoStatus, CourseCategory courseCategory) {
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.coursePeriod = coursePeriod;
        this.courseStatus = courseStatus;
        this.createTime = createTime;
        this.courseOpenStatus = courseOpenStatus;
        this.videoStatus = videoStatus;
        this.courseCategory = courseCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getCoursePeriod() {
        return coursePeriod;
    }

    public void setCoursePeriod(Integer coursePeriod) {
        this.coursePeriod = coursePeriod;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCourseOpenStatus() {
        return courseOpenStatus;
    }

    public void setCourseOpenStatus(Integer courseOpenStatus) {
        this.courseOpenStatus = courseOpenStatus;
    }

    public Integer getVideoStatus() {
        return videoStatus;
    }

    public void setVideoStatus(Integer videoStatus) {
        this.videoStatus = videoStatus;
    }

    public Boolean getHot() {
        return hot;
    }

    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    public Boolean getListener() {
        return listener;
    }

    public void setListener(Boolean listener) {
        this.listener = listener;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public CourseCategory getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(CourseCategory courseCategory) {
        this.courseCategory = courseCategory;
    }

    public String getCourseSendType() {
        return courseSendType;
    }

    public void setCourseSendType(String courseSendType) {
        this.courseSendType = courseSendType;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
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
        final StringBuffer sb = new StringBuffer("Course{");
        sb.append("id=").append(id);
        sb.append(", courseNumber='").append(courseNumber).append('\'');
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", coursePeriod=").append(coursePeriod);
        sb.append(", courseStatus='").append(courseStatus).append('\'');
        sb.append(", courseImage='").append(courseImage).append('\'');
        sb.append(", courseDesc='").append(courseDesc).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", courseOpenStatus=").append(courseOpenStatus);
        sb.append(", videoStatus=").append(videoStatus);
        sb.append(", hot=").append(hot);
        sb.append(", free=").append(free);
        sb.append(", listener=").append(listener);
        sb.append(", courseType='").append(courseType).append('\'');
        sb.append(", courseSendType='").append(courseSendType).append('\'');
        sb.append(", delete=").append(delete);
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append('}');
        return sb.toString();
    }
}