package com.kclm.owep.entity;

import java.util.Date;

public class VideoQuestionReply {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_video_question_reply.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_video_question_reply.reply_content
     *
     * @mbg.generated
     */
    private String replyContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_video_question_reply.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_video_question_reply.reply_author
     *
     * @mbg.generated
     */
    private String replyAuthor;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_video_question_reply.last_access_time
     *
     * @mbg.generated
     */
    private Date lastAccessTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_video_question_reply.version
     *
     * @mbg.generated
     */
    private Integer version;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_video_question_reply.fk_video_question_id
     *
     * @mbg.generated
     */
    private Integer fkVideoQuestionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_video_question_reply.id
     *
     * @return the value of t_video_question_reply.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_video_question_reply.id
     *
     * @param id the value for t_video_question_reply.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_video_question_reply.reply_content
     *
     * @return the value of t_video_question_reply.reply_content
     *
     * @mbg.generated
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_video_question_reply.reply_content
     *
     * @param replyContent the value for t_video_question_reply.reply_content
     *
     * @mbg.generated
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_video_question_reply.create_time
     *
     * @return the value of t_video_question_reply.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_video_question_reply.create_time
     *
     * @param createTime the value for t_video_question_reply.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_video_question_reply.reply_author
     *
     * @return the value of t_video_question_reply.reply_author
     *
     * @mbg.generated
     */
    public String getReplyAuthor() {
        return replyAuthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_video_question_reply.reply_author
     *
     * @param replyAuthor the value for t_video_question_reply.reply_author
     *
     * @mbg.generated
     */
    public void setReplyAuthor(String replyAuthor) {
        this.replyAuthor = replyAuthor == null ? null : replyAuthor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_video_question_reply.last_access_time
     *
     * @return the value of t_video_question_reply.last_access_time
     *
     * @mbg.generated
     */
    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_video_question_reply.last_access_time
     *
     * @param lastAccessTime the value for t_video_question_reply.last_access_time
     *
     * @mbg.generated
     */
    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_video_question_reply.version
     *
     * @return the value of t_video_question_reply.version
     *
     * @mbg.generated
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_video_question_reply.version
     *
     * @param version the value for t_video_question_reply.version
     *
     * @mbg.generated
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_video_question_reply.fk_video_question_id
     *
     * @return the value of t_video_question_reply.fk_video_question_id
     *
     * @mbg.generated
     */
    public Integer getFkVideoQuestionId() {
        return fkVideoQuestionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_video_question_reply.fk_video_question_id
     *
     * @param fkVideoQuestionId the value for t_video_question_reply.fk_video_question_id
     *
     * @mbg.generated
     */
    public void setFkVideoQuestionId(Integer fkVideoQuestionId) {
        this.fkVideoQuestionId = fkVideoQuestionId;
    }
}