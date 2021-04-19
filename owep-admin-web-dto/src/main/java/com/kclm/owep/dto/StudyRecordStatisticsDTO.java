package com.kclm.owep.dto;

import com.kclm.owep.entity.Student;

import java.util.Objects;

public class StudyRecordStatisticsDTO {

    /**
     * 学员
     */
    private Student student;

    /***
     * 视频观看总时长
     */
    private Double totalVideoRate;

    /***
     * 视频总时长
     */
    private Integer totalVideoLength;

    /***
     * 视频观看最大进度
     */
    private Double videoProcess;

    /***
     * 作业进度
     */
    private Double homeworkProcess;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudyRecordStatisticsDTO that = (StudyRecordStatisticsDTO) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(totalVideoRate, that.totalVideoRate) &&
                Objects.equals(totalVideoLength, that.totalVideoLength) &&
                Objects.equals(videoProcess, that.videoProcess) &&
                Objects.equals(homeworkProcess, that.homeworkProcess);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, totalVideoRate, totalVideoLength, videoProcess, homeworkProcess);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudyRecordStaticsDTO{");
        sb.append("student=").append(student);
        sb.append(", totalVideoRate=").append(totalVideoRate);
        sb.append(", totalVideoLength=").append(totalVideoLength);
        sb.append(", videoProcess=").append(videoProcess);
        sb.append(", homeworkProcess=").append(homeworkProcess);
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

    public Double getVideoProcess() {
        return videoProcess;
    }

    public void setVideoProcess(Double videoProcess) {
        this.videoProcess = videoProcess;
    }

    public Double getHomeworkProcess() {
        return homeworkProcess;
    }

    public void setHomeworkProcess(Double homeworkProcess) {
        this.homeworkProcess = homeworkProcess;
    }

    public StudyRecordStatisticsDTO() {
    }

    public StudyRecordStatisticsDTO(Student student, Double totalVideoRate, Integer totalVideoLength, Double videoProcess, Double homeworkProcess) {
        this.student = student;
        this.totalVideoRate = totalVideoRate;
        this.totalVideoLength = totalVideoLength;
        this.videoProcess = videoProcess;
        this.homeworkProcess = homeworkProcess;
    }
}
