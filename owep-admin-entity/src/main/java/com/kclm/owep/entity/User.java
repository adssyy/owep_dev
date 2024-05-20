/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.entity;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/*********************
 * @Author: ZhangShaowei
 * @Version : v1.0
 * @Create: 2020年7月06日
 * @Description 用户实体类类
 */
@Data
public class User {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 用户电话
     */
    private String userPhone;

    /**
     * 用户真实姓名
     */
    private String realName;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户email密文
     */
    private String emailCode;

    /**
     * 用户性别，1表示男，0表示女，-1 表示未知
     */
    private Integer gender;

    /**
     * 用户身份证
     */
    private String cardNum;

    /**
     * 用户状态，1表示启用，0表示禁用
     */
    private Integer status;

    /**
     * 用户截止有效期限
     */
    //@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime effectiveDate;

    /**
     * 管理员用户的三种类型，
     * 0 代表超级管理员
     * 1 代表老师或项目经理 【项目经理也是老师】
     * 2 代表咨询师
     *
     */
    private Integer userType;

    /**
     * 用户生日
     */
    private LocalDateTime birth;

    /**
     * 用户头像图片路径
     */
    private String imageUrl;

    /**
     * 用户描述
     */
    private String description;

    /**
     * 用户的职位
     */
    private String title;

    /**
     * 用户个人资料是否完善，1表示已完善，0表示未完善
     */
    private Integer perfectStatus;

    /**
     * 用户是否已经逻辑删除，1表示未删除，0表示已删除
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后一次访问时间
     */
    private LocalDateTime lastAccessTime;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 用户组关联
     */
    private List<Group> groups;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPerfectStatus() {
        return perfectStatus;
    }

    public void setPerfectStatus(Integer perfectStatus) {
        this.perfectStatus = perfectStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", userPwd='").append(userPwd).append('\'');
        sb.append(", userPhone='").append(userPhone).append('\'');
        sb.append(", realName='").append(realName).append('\'');
        sb.append(", userEmail='").append(userEmail).append('\'');
        sb.append(", emailCode='").append(emailCode).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", cardNum='").append(cardNum).append('\'');
        sb.append(", status=").append(status);
        sb.append(", effectiveDate=").append(effectiveDate);
        sb.append(", userType=").append(userType);
        sb.append(", birth=").append(birth);
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", perfectStatus=").append(perfectStatus);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", version=").append(version);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        User user = (User) o;
        return id.equals(user.id) &&
                userName.equals(user.userName) &&
                userPwd.equals(user.userPwd) &&
                userPhone.equals(user.userPhone) &&
                realName.equals(user.realName) &&
                userEmail.equals(user.userEmail) &&
                emailCode.equals(user.emailCode) &&
                gender.equals(user.gender) &&
                cardNum.equals(user.cardNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userPwd, userPhone, realName, userEmail, emailCode, gender, cardNum);
    }
}
