package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * author：ZhangQi
 * module：privilege
 * description:行为实体,关联权限和菜单
 * version：v0.1
 * time：2020/7/3
 */
public class Action implements Serializable {
    private Integer id;
    private String actionName;//行为名
    private String actionDescription;//行为描述
    private String actionUrl;//行为URL
    private LocalDateTime createTime;//创建时间
    private LocalDateTime lastAccessTime;//最后一次访问时间
    private Integer version;//版本号
    private String actionCode;//行为代号
    private Integer actionValue;//用二进制值来代表行为。
    private List<Menu> menuList;//关联菜单
    private List<Permission> permissions;//关联权限.

    public Action() {
    }

    public Action(Integer id, String actionName, String actionDescription, String actionUrl, LocalDateTime createTime, LocalDateTime lastAccessTime, Integer version, String actionCode, Integer actionValue) {
        this.id = id;
        this.actionName = actionName;
        this.actionDescription = actionDescription;
        this.actionUrl = actionUrl;
        this.createTime = createTime;
        this.lastAccessTime = lastAccessTime;
        this.version = version;
        this.actionCode = actionCode;
        this.actionValue = actionValue;
    }

    public Action(String actionName, String actionDescription, String actionUrl, LocalDateTime createTime, LocalDateTime lastAccessTime, Integer version, String actionCode, Integer actionValue) {
        this.actionName = actionName;
        this.actionDescription = actionDescription;
        this.actionUrl = actionUrl;
        this.createTime = createTime;
        this.lastAccessTime = lastAccessTime;
        this.version = version;
        this.actionCode = actionCode;
        this.actionValue = actionValue;
    }

    public Action(Integer id, String actionName, String actionDescription, String actionUrl, LocalDateTime createTime, LocalDateTime lastAccessTime, Integer version, String actionCode, Integer actionValue, List<Menu> menuList, List<Permission> permissions) {
        this.id = id;
        this.actionName = actionName;
        this.actionDescription = actionDescription;
        this.actionUrl = actionUrl;
        this.createTime = createTime;
        this.lastAccessTime = lastAccessTime;
        this.version = version;
        this.actionCode = actionCode;
        this.actionValue = actionValue;
        this.menuList = menuList;
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return Objects.equals(id, action.id) &&
                Objects.equals(actionUrl, action.actionUrl) &&
                Objects.equals(actionCode, action.actionCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actionUrl, actionCode);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Action{");
        sb.append("id=").append(id);
        sb.append(", actionName='").append(actionName).append('\'');
        sb.append(", actionDescription='").append(actionDescription).append('\'');
        sb.append(", actionUrl='").append(actionUrl).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", version=").append(version);
        sb.append(", actionCode='").append(actionCode).append('\'');
        sb.append(", actionValue=").append(actionValue);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName == null ? null : actionName.trim();
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription == null ? null : actionDescription.trim();
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl == null ? null : actionUrl.trim();
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode == null ? null : actionCode.trim();
    }

    public Integer getActionValue() {
        return actionValue;
    }

    public void setActionValue(Integer actionValue) {
        this.actionValue = actionValue;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}