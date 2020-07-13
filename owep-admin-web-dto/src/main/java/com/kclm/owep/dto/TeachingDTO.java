/*********************
 * 2018-2021 版权所有 CopyRight（c）
 */
package com.kclm.owep.dto;

import java.time.LocalDateTime;

/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/13 9:44
 * @Description 授课管理的dto
 */
public class TeachingDTO {
    /**
     * 班级描述
     */
    private String classDesc;
    /**
     * 资源名称
     */
    private String resourceName;
    /**
     * 资源类型，0.表示课程资源，1.表示公共资源
     */
    private Integer type;
    /**
     * 资源大小
     */
    private Integer resourceSize;
    /**
     * 问答时间
     */
    private LocalDateTime createTime;
    /**
     * 问答内容
     */
    private String questionContent;
    /**
     * 提问者
     */
    private String questionAuthor;
    /**
     * 作业标题
     */
    private String workTitle;
    /**
     * 作业内容
     */
    private String workContent;
    /**
     *答案内容
     */
    private String answerContent;
    /**
     *学号
     */
    private String stuNumber;
    /**
     *姓名
     */
    private String studentName;
    /**
     *性别
     */
    private Integer gender;
    /**
     *手机
     */
    private String stuPhone;
    /**
     *邮箱
     */
    private String stuEmail;
    /**
     *有效日期
     */
    private LocalDateTime effectiveDate;
    /**
     *状态
     */
    private Integer evaluateStatus;
    /**
     *评价内容
     */
    private String evaluate;
    /**
     *序号
     */
    private Integer serialNumber;
    /**
     *请假时间
     */
    private LocalDateTime leaveTime;
    /**
     *结束时间
     */
    private LocalDateTime endTime;
    /**
     *请假事由
     */
    private String reasonLeave;
    /**
     *审核状态,1.待审核， 2， 审核通过， 0 未通过
     */
    private Integer approvalStatus;
    /**
     *违规时间
     */
    private LocalDateTime disciplineTime;
    /**
     *情况说明
     */
    private String presentationCondition;
    /**
     *证据文件，以学员名#id.扩展名 命名
     */
    private String attachment;

    public String getClassDesc() { return classDesc; }

    public void setClassDesc(String classDesc) { this.classDesc = classDesc; }

    public String getResourceName() { return resourceName; }

    public void setResourceName(String resourceName) { this.resourceName = resourceName; }

    public Integer getType() { return type; }

    public void setType(Integer type) { this.type = type; }

    public Integer getResourceSize() { return resourceSize; }

    public void setResourceSize(Integer resourceSize) { this.resourceSize = resourceSize; }

    public LocalDateTime getCreateTime() { return createTime; }

    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }

    public String getQuestionContent() { return questionContent; }

    public void setQuestionContent(String questionContent) { this.questionContent = questionContent; }

    public String getQuestionAuthor() { return questionAuthor; }

    public void setQuestionAuthor(String questionAuthor) { this.questionAuthor = questionAuthor; }

    public String getWorkTitle() { return workTitle; }

    public void setWorkTitle(String workTitle) { this.workTitle = workTitle; }

    public String getWorkContent() { return workContent; }

    public void setWorkContent(String workContent) { this.workContent = workContent; }

    public String getAnswerContent() { return answerContent; }

    public void setAnswerContent(String answerContent) { this.answerContent = answerContent; }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
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
        this.evaluate = evaluate;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDateTime getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(LocalDateTime leaveTime) {
        this.leaveTime = leaveTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getReasonLeave() {
        return reasonLeave;
    }

    public void setReasonLeave(String reasonLeave) {
        this.reasonLeave = reasonLeave;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public LocalDateTime getDisciplineTime() {
        return disciplineTime;
    }

    public void setDisciplineTime(LocalDateTime disciplineTime) {
        this.disciplineTime = disciplineTime;
    }

    public String getPresentationCondition() {
        return presentationCondition;
    }

    public void setPresentationCondition(String presentationCondition) { this.presentationCondition = presentationCondition; }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
