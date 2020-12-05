package com.kclm.owep.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class StudentDTO implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * 学号
     */
    private String stuNumber;

    /**
     * 学生真实姓名
     */
    private String stuRealName;

    /**
     * 学生截止有效期限
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime effectiveDate;

    /**
     * 学生状态，1表示启用，0表示禁用
     */
    private Integer status;

    public StudentDTO(Integer id, String stuNumber, String stuRealName, LocalDateTime effectiveDate, Integer status) {
        this.id = id;
        this.stuNumber = stuNumber;
        this.stuRealName = stuRealName;
        this.effectiveDate = effectiveDate;
        this.status = status;
    }

    public StudentDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDTO that = (StudentDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(stuNumber, that.stuNumber) &&
                Objects.equals(stuRealName, that.stuRealName) &&
                Objects.equals(effectiveDate, that.effectiveDate) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stuNumber, stuRealName, effectiveDate, status);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudentDTO{");
        sb.append("id=").append(id);
        sb.append(", stuNumber='").append(stuNumber).append('\'');
        sb.append(", stuRealName='").append(stuRealName).append('\'');
        sb.append(", effectiveDate=").append(effectiveDate);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getStuRealName() {
        return stuRealName;
    }

    public void setStuRealName(String stuRealName) {
        this.stuRealName = stuRealName;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
