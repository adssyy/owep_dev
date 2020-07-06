/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.Objects;

/*********************
 * @Author: tanj
 * @Version : v1.0
 * @Create: 2020年7月03日 下午16:24:40
 * @Description 班级问题回复表
 */
public class QuestionReply {
    private Integer id;     //

    private String replyName;   //回复人名字

    private String replyContent;    //回复内容

    private LocalDateTime createTime;        //回复时间

    private LocalDateTime lastAccessTime;    //最后一次修改时间

    private Integer version;        //版本号

    private ClassQuestion classQuestion;  //班级问题

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public ClassQuestion getClassQuestion() {
        return classQuestion;
    }

    public void setClassQuestion(ClassQuestion classQuestion) {
        this.classQuestion = classQuestion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionReply that = (QuestionReply) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(replyName, that.replyName) &&
                Objects.equals(replyContent, that.replyContent) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, replyName, replyContent, createTime);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("QuestionReply{");
        sb.append("id=").append(id);
        sb.append(", replyName='").append(replyName).append('\'');
        sb.append(", replyContent='").append(replyContent).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", version=").append(version);
        sb.append('}');
        return sb.toString();
    }
}