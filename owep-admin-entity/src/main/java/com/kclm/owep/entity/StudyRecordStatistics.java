package com.kclm.owep.entity;

import java.io.Serializable;
import java.util.Objects;

public class StudyRecordStatistics implements Serializable {

    /**
     * 学员
     */
    private Student student;

    /***
     * 视频观看总进度
     */
    private Double totalVideoRate;

    /***
     * 视频总时长
     */
    private Integer totalVideoLength;

    public StudyRecordStatistics(Student student, Double totalVideoRate, Integer totalVideoLength) {
        this.student = student;
        this.totalVideoRate = totalVideoRate;
        this.totalVideoLength = totalVideoLength;
    }

    public StudyRecordStatistics() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudyRecordStatistics that = (StudyRecordStatistics) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(totalVideoRate, that.totalVideoRate) &&
                Objects.equals(totalVideoLength, that.totalVideoLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, totalVideoRate, totalVideoLength);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudyRecordStatistics{");
        sb.append("student=").append(student);
        sb.append(", totalVideoRate=").append(totalVideoRate);
        sb.append(", totalVideoLength=").append(totalVideoLength);
        sb.append('}');
        return sb.toString();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getTotalVideoRate() {
        return totalVideoRate;
    }

    public void setTotalVideoRate(Double totalVideoRate) {
        this.totalVideoRate = totalVideoRate;
    }

    public Integer getTotalVideoLength() {
        return totalVideoLength;
    }

    public void setTotalVideoLength(Integer totalVideoLength) {
        this.totalVideoLength = totalVideoLength;
    }
}
