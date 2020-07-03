package com.kclm.owep.entity;

import java.time.LocalDateTime;

public class SystLog {
    //id
    private Integer id;

    //日志主题(菜单标题)
    private String title;

    //操作模块名
    private String moduleName;

    //操作菜单名
    private String menuName;

    //ip地址
    private String ipAddr;

    //请求方法
    private String method;

    //请求地址
    private String requestUrl;

    //类型
    private String type;

    //登录用户名
    private String loginUserName;

    //最后访问时间
    private LocalDateTime lastAccessTime;

    //创建时间
    private LocalDateTime createTime;

    //版本
    private Integer version;

    public LocalDateTime getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(LocalDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }


    public String getModuleName() {
        return moduleName;
    }


    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }


    public String getMenuName() {
        return menuName;
    }


    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }


    public String getIpAddr() {
        return ipAddr;
    }


    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr == null ? null : ipAddr.trim();
    }


    public String getMethod() {
        return method;
    }


    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }


    public String getRequestUrl() {
        return requestUrl;
    }


    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl == null ? null : requestUrl.trim();
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }


    public String getLoginUserName() {
        return loginUserName;
    }


    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName == null ? null : loginUserName.trim();
    }


    public Integer getVersion() {
        return version;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }
}