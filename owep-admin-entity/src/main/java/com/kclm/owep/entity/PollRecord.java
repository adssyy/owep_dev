package com.kclm.owep.entity;

import java.time.LocalDateTime;
/*********************
 * @Author: ZhongLei
 * @Version : v1.0
 * @Create: 2020年7月03日
 * @Description 考评记录实体类
 */

public class PollRecord {

    private Integer id;

    //考评IP地址
    private String ipAddress;

    //考评得分
    private Double pollScore;

    //考评选项条数
    private Integer pollCount;

    //考评建议
    private String pollSuggest;

    //最后一次访问时间
    private LocalDateTime lastAccessTime;

    //版本号
    private Integer version;

    //考评时间
    private LocalDateTime createTime;

    //考评状态  0.有效 1.无效
    private Boolean pollStatus;

    //外键，教师考评id
    private Integer fkTeacherPollId;

    //所选模块中第一条,采用 条件:分值 的格式存储
    private String pollItem1;


    private String pollItem2;


    private String pollItem3;


    private String pollItem4;


    private String pollItem5;


    private String pollItem6;


    private String pollItem7;


    private String pollItem8;


    private String pollItem9;


    private String pollItem10;


    private String pollItem11;


    private String pollItem12;


    private String pollItem13;


    private String pollItem14;


    private String pollItem15;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getIpAddress() {
        return ipAddress;
    }


    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }


    public Double getPollScore() {
        return pollScore;
    }


    public void setPollScore(Double pollScore) {
        this.pollScore = pollScore;
    }


    public Integer getPollCount() {
        return pollCount;
    }


    public void setPollCount(Integer pollCount) {
        this.pollCount = pollCount;
    }


    public String getPollSuggest() {
        return pollSuggest;
    }


    public void setPollSuggest(String pollSuggest) {
        this.pollSuggest = pollSuggest == null ? null : pollSuggest.trim();
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


    public LocalDateTime getCreateTime() {
        return createTime;
    }


    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }


    public Boolean getPollStatus() {
        return pollStatus;
    }


    public void setPollStatus(Boolean pollStatus) {
        this.pollStatus = pollStatus;
    }


    public Integer getFkTeacherPollId() {
        return fkTeacherPollId;
    }


    public void setFkTeacherPollId(Integer fkTeacherPollId) {
        this.fkTeacherPollId = fkTeacherPollId;
    }


    public String getPollItem1() {
        return pollItem1;
    }


    public void setPollItem1(String pollItem1) {
        this.pollItem1 = pollItem1 == null ? null : pollItem1.trim();
    }


    public String getPollItem2() {
        return pollItem2;
    }


    public void setPollItem2(String pollItem2) {
        this.pollItem2 = pollItem2 == null ? null : pollItem2.trim();
    }


    public String getPollItem3() {
        return pollItem3;
    }


    public void setPollItem3(String pollItem3) {
        this.pollItem3 = pollItem3 == null ? null : pollItem3.trim();
    }


    public String getPollItem4() {
        return pollItem4;
    }


    public void setPollItem4(String pollItem4) {
        this.pollItem4 = pollItem4 == null ? null : pollItem4.trim();
    }


    public String getPollItem5() {
        return pollItem5;
    }


    public void setPollItem5(String pollItem5) {
        this.pollItem5 = pollItem5 == null ? null : pollItem5.trim();
    }


    public String getPollItem6() {
        return pollItem6;
    }


    public void setPollItem6(String pollItem6) {
        this.pollItem6 = pollItem6 == null ? null : pollItem6.trim();
    }


    public String getPollItem7() {
        return pollItem7;
    }


    public void setPollItem7(String pollItem7) {
        this.pollItem7 = pollItem7 == null ? null : pollItem7.trim();
    }


    public String getPollItem8() {
        return pollItem8;
    }


    public void setPollItem8(String pollItem8) {
        this.pollItem8 = pollItem8 == null ? null : pollItem8.trim();
    }


    public String getPollItem9() {
        return pollItem9;
    }


    public void setPollItem9(String pollItem9) {
        this.pollItem9 = pollItem9 == null ? null : pollItem9.trim();
    }


    public String getPollItem10() {
        return pollItem10;
    }


    public void setPollItem10(String pollItem10) {
        this.pollItem10 = pollItem10 == null ? null : pollItem10.trim();
    }


    public String getPollItem11() {
        return pollItem11;
    }


    public void setPollItem11(String pollItem11) {
        this.pollItem11 = pollItem11 == null ? null : pollItem11.trim();
    }


    public String getPollItem12() {
        return pollItem12;
    }


    public void setPollItem12(String pollItem12) {
        this.pollItem12 = pollItem12 == null ? null : pollItem12.trim();
    }


    public String getPollItem13() {
        return pollItem13;
    }


    public void setPollItem13(String pollItem13) {
        this.pollItem13 = pollItem13 == null ? null : pollItem13.trim();
    }


    public String getPollItem14() {
        return pollItem14;
    }


    public void setPollItem14(String pollItem14) {
        this.pollItem14 = pollItem14 == null ? null : pollItem14.trim();
    }


    public String getPollItem15() {
        return pollItem15;
    }


    public void setPollItem15(String pollItem15) {
        this.pollItem15 = pollItem15 == null ? null : pollItem15.trim();
    }
}