package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Evaluate implements Serializable {
    //主键
    private Integer id;
    //版本
    private Integer version;
    //创建时间
    private LocalDate createTime;
    //最后修改时间
    private LocalDate lastAccessTime;
    //老师ID
    private User user;
    //学员ID
    private Student student;
    //学生姓名
    private String studentName;
    //状态,1 表示有效，0表示无效
    private Integer evaluateStatus;
    //评价内容
    private String evaluate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evaluate evaluate1 = (Evaluate) o;
        return Objects.equals(id, evaluate1.id) &&
                Objects.equals(version, evaluate1.version) &&
                Objects.equals(createTime, evaluate1.createTime) &&
                Objects.equals(lastAccessTime, evaluate1.lastAccessTime) &&
                Objects.equals(user, evaluate1.user) &&
                Objects.equals(student, evaluate1.student) &&
                Objects.equals(studentName, evaluate1.studentName) &&
                Objects.equals(evaluateStatus, evaluate1.evaluateStatus) &&
                Objects.equals(evaluate, evaluate1.evaluate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, createTime, lastAccessTime, user, student, studentName, evaluateStatus, evaluate);
    }

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

    public Integer getEvaluateStatus() {
        return evaluateStatus;
    }

    public void setEvaluateStatus(Integer evaluateStatus) {
        this.evaluateStatus = evaluateStatus;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate == null ? null : evaluate.trim();
    }
}