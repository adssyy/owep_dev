package com.kclm.owep.entity;

import java.util.Date;
import java.util.List;

public class User {


    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.user_name
     *
     * @mbg.generated
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.user_pwd
     *
     * @mbg.generated
     */
    private String userPwd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.user_phone
     *
     * @mbg.generated
     */
    private String userPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.real_name
     *
     * @mbg.generated
     */
    private String realName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.user_email
     *
     * @mbg.generated
     */
    private String userEmail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.email_code
     *
     * @mbg.generated
     */
    private String emailCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.gender
     *
     * @mbg.generated
     */
    private Integer gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.card_num
     *
     * @mbg.generated
     */
    private String cardNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.effective_date
     *
     * @mbg.generated
     */
    private Date effectiveDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.user_type
     *
     * @mbg.generated
     */
    private Integer userType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.birth
     *
     * @mbg.generated
     */
    private Date birth;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.image_url
     *
     * @mbg.generated
     */
    private String imageUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.title
     *
     * @mbg.generated
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.perfect_status
     *
     * @mbg.generated
     */
    private Integer perfectStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.is_delete
     *
     * @mbg.generated
     */
    private Integer isDelete;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.last_access_time
     *
     * @mbg.generated
     */
    private Date lastAccessTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.version
     *
     * @mbg.generated
     */
    private Integer version;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.id
     *
     * @return the value of t_user.id
     *
     * @mbg.generated
     */

    private List<Group> groups;//关联用户组
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.id
     *
     * @param id the value for t_user.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.user_name
     *
     * @return the value of t_user.user_name
     *
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.user_name
     *
     * @param userName the value for t_user.user_name
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.user_pwd
     *
     * @return the value of t_user.user_pwd
     *
     * @mbg.generated
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.user_pwd
     *
     * @param userPwd the value for t_user.user_pwd
     *
     * @mbg.generated
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.user_phone
     *
     * @return the value of t_user.user_phone
     *
     * @mbg.generated
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.user_phone
     *
     * @param userPhone the value for t_user.user_phone
     *
     * @mbg.generated
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.real_name
     *
     * @return the value of t_user.real_name
     *
     * @mbg.generated
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.real_name
     *
     * @param realName the value for t_user.real_name
     *
     * @mbg.generated
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.user_email
     *
     * @return the value of t_user.user_email
     *
     * @mbg.generated
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.user_email
     *
     * @param userEmail the value for t_user.user_email
     *
     * @mbg.generated
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.email_code
     *
     * @return the value of t_user.email_code
     *
     * @mbg.generated
     */
    public String getEmailCode() {
        return emailCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.email_code
     *
     * @param emailCode the value for t_user.email_code
     *
     * @mbg.generated
     */
    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode == null ? null : emailCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.gender
     *
     * @return the value of t_user.gender
     *
     * @mbg.generated
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.gender
     *
     * @param gender the value for t_user.gender
     *
     * @mbg.generated
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.card_num
     *
     * @return the value of t_user.card_num
     *
     * @mbg.generated
     */
    public String getCardNum() {
        return cardNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.card_num
     *
     * @param cardNum the value for t_user.card_num
     *
     * @mbg.generated
     */
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum == null ? null : cardNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.status
     *
     * @return the value of t_user.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.status
     *
     * @param status the value for t_user.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.effective_date
     *
     * @return the value of t_user.effective_date
     *
     * @mbg.generated
     */
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.effective_date
     *
     * @param effectiveDate the value for t_user.effective_date
     *
     * @mbg.generated
     */
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.user_type
     *
     * @return the value of t_user.user_type
     *
     * @mbg.generated
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.user_type
     *
     * @param userType the value for t_user.user_type
     *
     * @mbg.generated
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.birth
     *
     * @return the value of t_user.birth
     *
     * @mbg.generated
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.birth
     *
     * @param birth the value for t_user.birth
     *
     * @mbg.generated
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.image_url
     *
     * @return the value of t_user.image_url
     *
     * @mbg.generated
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.image_url
     *
     * @param imageUrl the value for t_user.image_url
     *
     * @mbg.generated
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.description
     *
     * @return the value of t_user.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.description
     *
     * @param description the value for t_user.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.title
     *
     * @return the value of t_user.title
     *
     * @mbg.generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.title
     *
     * @param title the value for t_user.title
     *
     * @mbg.generated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.perfect_status
     *
     * @return the value of t_user.perfect_status
     *
     * @mbg.generated
     */
    public Integer getPerfectStatus() {
        return perfectStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.perfect_status
     *
     * @param perfectStatus the value for t_user.perfect_status
     *
     * @mbg.generated
     */
    public void setPerfectStatus(Integer perfectStatus) {
        this.perfectStatus = perfectStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.is_delete
     *
     * @return the value of t_user.is_delete
     *
     * @mbg.generated
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.is_delete
     *
     * @param isDelete the value for t_user.is_delete
     *
     * @mbg.generated
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.create_time
     *
     * @return the value of t_user.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.create_time
     *
     * @param createTime the value for t_user.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.last_access_time
     *
     * @return the value of t_user.last_access_time
     *
     * @mbg.generated
     */
    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.last_access_time
     *
     * @param lastAccessTime the value for t_user.last_access_time
     *
     * @mbg.generated
     */
    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.version
     *
     * @return the value of t_user.version
     *
     * @mbg.generated
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.version
     *
     * @param version the value for t_user.version
     *
     * @mbg.generated
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}