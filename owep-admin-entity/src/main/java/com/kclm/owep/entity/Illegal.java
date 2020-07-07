/*********************
 * 2018-2021 版权所有 CopyRight（c） 快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/6 16:17
 * @Description 违纪处理
 */
public class Illegal implements Serializable {
    /**
     *主键
     */
    private Integer id;
    //版本
    /**
     *视频观看状态：0不允许观看、1允许观看
     */
    private Integer version;
    /**
     *创建时间
     */
    private LocalDate createTime;
    /**
     *最后修改时间
     */
    private LocalDate lastAccessTime;
    /**
     *老师外键
     */
    private User user;
    //学生id
    /**
     *学生外键
     */
    private Student student;
    /**
     *fk_class_id
     */
    private Integer fkClassId;
    /**
     *违纪学生姓名
     */
    private String studentName;
    /**
     *违规时间
     */
    private LocalDate disciplineTime;
    /**
     *情况说明
     */
    private String presentationCondition;
    /**
     *证据文件，以学员名#id.扩展名 命名
     */
    private String attachment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Illegal illegal = (Illegal) o;
        return Objects.equals(id, illegal.id) &&
                Objects.equals(version, illegal.version) &&
                Objects.equals(createTime, illegal.createTime) &&
                Objects.equals(lastAccessTime, illegal.lastAccessTime) &&
                Objects.equals(user, illegal.user) &&
                Objects.equals(student, illegal.student) &&
                Objects.equals(fkClassId, illegal.fkClassId) &&
                Objects.equals(studentName, illegal.studentName) &&
                Objects.equals(disciplineTime, illegal.disciplineTime) &&
                Objects.equals(presentationCondition, illegal.presentationCondition) &&
                Objects.equals(attachment, illegal.attachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, createTime, lastAccessTime, user, student, fkClassId, studentName, disciplineTime, presentationCondition, attachment);
    }

    public Integer getFkClassId() { return fkClassId; }

    public void setFkClassId(Integer fkClassId) { this.fkClassId = fkClassId; }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public LocalDate getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(LocalDate lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public LocalDate getDisciplineTime() {
        return disciplineTime;
    }

    public void setDisciplineTime(LocalDate disciplineTime) {
        this.disciplineTime = disciplineTime;
    }

    public String getPresentationCondition() {
        return presentationCondition;
    }

    public void setPresentationCondition(String presentationCondition) {
        this.presentationCondition = presentationCondition == null ? null : presentationCondition.trim();
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }
}