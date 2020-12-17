package com.kclm.owep.dto;

import java.util.List;
import java.util.Objects;

public class UserClassDTO {
    Integer userId;
    List<Integer> userIds;
    Integer classId;
    List<Integer> classIds;

    public UserClassDTO() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public List<Integer> getClassIds() {
        return classIds;
    }

    public void setClassIds(List<Integer> classIds) {
        this.classIds = classIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserClassDTO that = (UserClassDTO) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(userIds, that.userIds) &&
                Objects.equals(classId, that.classId) &&
                Objects.equals(classIds, that.classIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userIds, classId, classIds);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserClassDTO{");
        sb.append("userId=").append(userId);
        sb.append(", userIds=").append(userIds);
        sb.append(", classId=").append(classId);
        sb.append(", classIds=").append(classIds);
        sb.append('}');
        return sb.toString();
    }
}
