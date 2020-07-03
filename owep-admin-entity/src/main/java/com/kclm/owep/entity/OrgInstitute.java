package com.kclm.owep.entity;

import java.time.LocalDateTime;

public class OrgInstitute {

    private Integer id; //组织机构id

    private String instituteName;  //机构名称

    private Integer instituteType; //机构类型

    private Integer delete; //是否逻辑删除，1表示未删除，0表示已删除

    private Integer version; //版本

    private LocalDateTime createTime; //创建时间

    private LocalDateTime lastAccessTime; //最后访问时间

    //get/set方法
    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName == null ? null : instituteName.trim();
    }

    public Integer getInstituteType() {
        return instituteType;
    }

    public void setInstituteType(Integer instituteType) {
        this.instituteType = instituteType;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
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


    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }


    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }
}