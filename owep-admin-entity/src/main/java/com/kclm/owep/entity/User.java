package com.kclm.owep.entity;


import java.io.Serializable;
import java.time.LocalDateTime;

/******************
 * @Author yejf
 * @Description TODO
 */
public class User implements Serializable {

    private Integer id;

    private String userName;  //登录用户名,唯一且非空

    private String password;  //登录密码

    private String mobilePhone; //手机号，唯一且非空

    private UserStatus status; //用户状态

    private String realName; //真实姓名

    private LocalDateTime createDate;  //创建时间

    private LocalDateTime updateDate; //更新时间

    private LocalDateTime lastLoginDate;  //最后一次登录时间

    private String avatarUrl;  //头像地址

    public User() {
    }

    public User(String userName, String password, String mobilePhone, UserStatus status, String realName, LocalDateTime createDate, LocalDateTime updateDate, LocalDateTime lastLoginDate, String avatarUrl) {
        this.userName = userName;
        this.password = password;
        this.mobilePhone = mobilePhone;
        this.status = status;
        this.realName = realName;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.lastLoginDate = lastLoginDate;
        this.avatarUrl = avatarUrl;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", mobilePhone='").append(mobilePhone).append('\'');
        sb.append(", status=").append(status);
        sb.append(", realName='").append(realName).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", lastLoginDate=").append(lastLoginDate);
        sb.append(", avatarUrl='").append(avatarUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
