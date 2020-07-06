package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class ResourceType {

    private Integer id;     //主键id

    private String typeName;  //资源类型名称/资源管理

    private String typeDesc;  //资源描述

    private LocalDateTime createTime;    //创建时间

    private Integer delete;    //逻辑删除，1表示未删除，0表示已删除

    private Integer version;   //版本数

    private LocalDateTime lastAccessTime;    //最后一次访问时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
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

    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ResourceType{");
        sb.append("id=").append(id);
        sb.append(", typeName='").append(typeName).append('\'');
        sb.append(", typeDesc='").append(typeDesc).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", delete=").append(delete);
        sb.append(", version=").append(version);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append('}');
        return sb.toString();
    }
}