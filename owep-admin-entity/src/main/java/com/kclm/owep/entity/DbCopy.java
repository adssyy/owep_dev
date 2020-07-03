package com.kclm.owep.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class DbCopy {

    //主键
    private Integer id;

    //备份的sql文件名
    private String fileName;

    //备份的sql文件路径
    private String filePath;

    //备份的状态，1表示成功，0表示失败
    private Boolean status;

    //备份的时间
    private LocalDateTime createTime;

    //版本号
    private Integer version;

    //最后一次访问时间
    private LocalDateTime lastAccessTime;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getFileName() {
        return fileName;
    }


    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }


    public String getFilePath() {
        return filePath;
    }


    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }


    public Boolean getStatus() {
        return status;
    }


    public void setStatus(Boolean status) {
        this.status = status;
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