package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Leave implements Serializable {
    //主键
    private Integer id;
    //版本
    private Integer version;
    //创建时间
    private LocalDate createTime;
    //最后修改时间
    private LocalDate lastAccessTime;
    //请假时间
    private LocalDate leaveTime;
    //结束时间
    private LocalDate endTime;
    //请假事由
    private String reasonLeave;
    //审核状态,1.待审核， 2， 审核通过， 0 未通过
    private Integer approvalStatus;
    //学生
    private Student student;
    //意见
    private String option;
    //学生姓名
    private String studentName;
    //请假类型
    private String leaveType;
    //序号
    private Integer serialNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leave leave = (Leave) o;
        return Objects.equals(id, leave.id) &&
                Objects.equals(version, leave.version) &&
                Objects.equals(createTime, leave.createTime) &&
                Objects.equals(lastAccessTime, leave.lastAccessTime) &&
                Objects.equals(leaveTime, leave.leaveTime) &&
                Objects.equals(endTime, leave.endTime) &&
                Objects.equals(reasonLeave, leave.reasonLeave) &&
                Objects.equals(approvalStatus, leave.approvalStatus) &&
                Objects.equals(student, leave.student) &&
                Objects.equals(option, leave.option) &&
                Objects.equals(studentName, leave.studentName) &&
                Objects.equals(leaveType, leave.leaveType) &&
                Objects.equals(serialNumber, leave.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, createTime, lastAccessTime, leaveTime, endTime, reasonLeave, approvalStatus, student, option, studentName, leaveType, serialNumber);
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

    public LocalDate getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(LocalDate leaveTime) {
        this.leaveTime = leaveTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public String getReasonLeave() {
        return reasonLeave;
    }

    public void setReasonLeave(String reasonLeave) {
        this.reasonLeave = reasonLeave == null ? null : reasonLeave.trim();
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option == null ? null : option.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType == null ? null : leaveType.trim();
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }
}