package com.kclm.owep.dto;

import java.util.List;
import java.util.Objects;

public class StudentClassDTO {
    Integer stuId;
    List<Integer> userIds;
    Integer classId;
    List<Integer> classIds;


    public StudentClassDTO() {
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getClassId() {
        return classId;
    }

    public List<Integer> getClassIds() {
        return classIds;
    }

    public void setClassIds(List<Integer> classIds) {
        this.classIds = classIds;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentClassDTO that = (StudentClassDTO) o;
        return Objects.equals(stuId, that.stuId) &&
                Objects.equals(classId, that.classId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, classId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudentClassDTO{");
        sb.append("stuId=").append(stuId);
        sb.append(", classId=").append(classId);
        sb.append('}');
        return sb.toString();
    }
}
