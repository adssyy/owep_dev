/*********************
 * 2018-2021 版权所有 CopyRight（c） 快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/6 16:18
 * @Description 学生评价
 */
public class Evaluate implements Serializable {
    /**
     *主键
     */
    private Integer id;
    /**
     *版本
     */
    private Integer version;
    /**
     *创建时间
     */
    private LocalDateTime createTime;
    /**
     *最后修改时间
     */
    private LocalDateTime lastAccessTime;
    /**
     *老师ID外键
     */
    private User user;
    /**
     *学员外键
     */
    private Student student;
    /**
     *fk_class_id
     */
    private Integer fkClassId;
    /**
     *学生姓名
     */
    private String studentName;
    /**
     *状态,1 表示有效，0表示无效
     */
    private Integer evaluateStatus;
    /**
     *评价内容
     */
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
                Objects.equals(fkClassId, evaluate1.fkClassId) &&
                Objects.equals(studentName, evaluate1.studentName) &&
                Objects.equals(evaluateStatus, evaluate1.evaluateStatus) &&
                Objects.equals(evaluate, evaluate1.evaluate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, createTime, lastAccessTime, user, student, fkClassId, studentName, evaluateStatus, evaluate);
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