package com.kclm.owep.dto;

import com.kclm.owep.entity.Student;

import java.time.LocalDateTime;
import java.util.Objects;

public class StudyRecordDTO {
    /***
     * 主键
     */
    private Integer id;

    /***
     * 学习进度标识 0:未观看或未观看结束 1:已观看完(只有为1时，才能观看下一个视频）
     */
    private Integer progressStatus;

    /***
     * 创建时间
     */
    private LocalDateTime createTime;

    /***
     * 学员id
     */
    //private Integer fkStudentId;
    /**
     * 学员
     */
    private Student student;

    /***
     * 课程节的id
     */
    private Integer fkSectionId;

    /***
     * 课程名称
     */
    private String courseName;

    /***
     * 章名称
     */
    private String chapterName;

    /***
     * 节名称
     */
    private String sectionName;

    /***
     * 视频观看最大进度
     */
    private Double videoRate;

    /***
     * 视频时长
     */
    private Integer videoLength;

    /***
     * 视频观看最大进度
     */
    private Double videoProcess;

    /***
     * 作业进度
     */
    private Double homeworkProcess;

    /***
     * 版本
     */
    private Integer version;

    /***
     * 最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudyRecordDTO that = (StudyRecordDTO) o;
        return Objects.equals(progressStatus, that.progressStatus) &&
                Objects.equals(fkSectionId, that.fkSectionId) &&
                Objects.equals(courseName, that.courseName) &&
                Objects.equals(chapterName, that.chapterName) &&
                Objects.equals(sectionName, that.sectionName) &&
                Objects.equals(videoProcess, that.videoProcess) &&
                Objects.equals(homeworkProcess, that.homeworkProcess);
    }

    @Override
    public int hashCode() {
        return Objects.hash(progressStatus, fkSectionId, courseName, chapterName, sectionName, videoProcess, homeworkProcess);
    }

    public StudyRecordDTO() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudyRecordDTO{");
        sb.append("id=").append(id);
        sb.append(", progressStatus=").append(progressStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", student=").append(student);
        sb.append(", fkSectionId=").append(fkSectionId);
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append(", chapterName='").append(chapterName).append('\'');
        sb.append(", sectionName='").append(sectionName).append('\'');
        sb.append(", videoProcess=").append(videoProcess);
        sb.append(", homeworkProcess=").append(homeworkProcess);
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(Integer progressStatus) {
        this.progressStatus = progressStatus;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getFkSectionId() {
        return fkSectionId;
    }

    public void setFkSectionId(Integer fkSectionId) {
        this.fkSectionId = fkSectionId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Double getVideoRate() {
        return videoRate;
    }

    public void setVideoRate(Double videoRate) {
        this.videoRate = videoRate;
    }

    public Integer getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(Integer videoLength) {
        this.videoLength = videoLength;
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
}
