package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class SystemConfig implements Serializable {

    private static final long serialVersionUID=1L;

    //id(主键)
    private Integer id;

    //系统名称
    private String systemName;

    //版权所属
    private String copyName;

    //登录页LOGO
    private String loginPageLogo;

    //系统页LOGO
    private String systemPageLogo;

    //创建时间
    private LocalDateTime createTime;

    //版本号
    private Integer version;

    //最后一次访问时间
    private Date lastAccessTime;

    //登录次数
    private Integer loginCount;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getSystemName() {
        return systemName;
    }


    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }


    public String getCopyName() {
        return copyName;
    }


    public void setCopyName(String copyName) {
        this.copyName = copyName == null ? null : copyName.trim();
    }


    public String getLoginPageLogo() {
        return loginPageLogo;
    }


    public void setLoginPageLogo(String loginPageLogo) {
        this.loginPageLogo = loginPageLogo == null ? null : loginPageLogo.trim();
    }


    public String getSystemPageLogo() {
        return systemPageLogo;
    }


    public void setSystemPageLogo(String systemPageLogo) {
        this.systemPageLogo = systemPageLogo == null ? null : systemPageLogo.trim();
    }


    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getVersion() {
        return version;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }


    public Date getLastAccessTime() {
        return lastAccessTime;
    }


    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }


    public Integer getLoginCount() {
        return loginCount;
    }


    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }
}