package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/*********************
 * @Author: tanj
 * @Version : v1.0
 * @Create: 2020年7月03日 上午13:30:40
 * @Description 班级问题
 */
public class ClassQuestion {

    private Integer id; //班级问题id

    private String questionTitle; //问题标题

    private String questionDesc;    //问题内容

    private Integer questionStatus; //回复状态 1:未回复 2：已回复'

    private String correlatedCourse;    //相关的课程名

    private Student student;     //学生 问题提问者

    private Video video;        //视频

    private Course course;      //课程

    private String courseNumber; //课程名称

    private LocalDateTime createTime;

    private Integer version;

    private LocalDateTime lastAccessTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionDesc() {
        return questionDesc;
    }

    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc;
    }

    public Integer getQuestionStatus() {
        return questionStatus;
    }

    public void setQuestionStatus(Integer questionStatus) {
        this.questionStatus = questionStatus;
    }

    public String getCorrelatedCourse() {
        return correlatedCourse;
    }

    public void setCorrelatedCourse(String correlatedCourse) {
        this.correlatedCourse = correlatedCourse;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassQuestion that = (ClassQuestion) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(questionTitle, that.questionTitle) &&
                Objects.equals(questionDesc, that.questionDesc) &&
                Objects.equals(courseNumber, that.courseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questionTitle, questionDesc, courseNumber);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ClassQuestion{");
        sb.append("id=").append(id);
        sb.append(", questionTitle='").append(questionTitle).append('\'');
        sb.append(", questionDesc='").append(questionDesc).append('\'');
        sb.append(", questionStatus=").append(questionStatus);
        sb.append(", correlatedCourse='").append(correlatedCourse).append('\'');
        sb.append(", student=").append(student);
        sb.append(", video=").append(video);
        sb.append(", course=").append(course);
        sb.append(", courseNumber='").append(courseNumber).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append('}');
        return sb.toString();
    }
}