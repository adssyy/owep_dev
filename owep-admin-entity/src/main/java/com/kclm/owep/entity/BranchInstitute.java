package com.kclm.owep.entity;

import java.time.LocalDateTime;

public class BranchInstitute {

    private Integer id; //分支机构id

    private Integer branchName; //分支名称

    private Integer fkOrgId; //组织机构id（外键）

    private Integer version;// 版本

    private LocalDateTime createTime; //创建时间

    private LocalDateTime lastAccessTime; //最后访问时间

    //get/set方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public Integer getBranchName() {

        return branchName;
    }

    public void setBranchName(Integer branchName) {

        this.branchName = branchName;
    }

    public Integer getFkOrgId() {

        return fkOrgId;
    }

    public void setFkOrgId(Integer fkOrgId) {
        this.fkOrgId = fkOrgId;
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