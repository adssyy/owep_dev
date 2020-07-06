package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * author：ZhangQi
 * module：privilege
 * description:角色实体 与权限、用户组多对多关联；同时还与自己关联。
 * version：v0.1
 * time：2020/7/3
 */
public class Role implements Serializable {
    private Integer id;
    private String roleName;//角色名
    private String roleDescription;//角色描述
    private LocalDateTime createTime;//创建时间
    private LocalDateTime lastAccessTime;//最后一次访问时间
    private Integer version;//版本号
    private Role parent;//父角色
    private List<Role> childRoles;//子角色
    private List<Group> groups;//关联用户组
    private List<Permission> permissions;//关联权限表

    public Role() {
    }

    public Role(Integer id, String roleName, String roleDescription, LocalDateTime createTime, LocalDateTime lastAccessTime, Integer version, Role parent) {
        this.id = id;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.createTime = createTime;
        this.lastAccessTime = lastAccessTime;
        this.version = version;
        this.parent = parent;
    }

    public Role(String roleName, String roleDescription, LocalDateTime createTime, LocalDateTime lastAccessTime, Integer version, Role parent) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.createTime = createTime;
        this.lastAccessTime = lastAccessTime;
        this.version = version;
        this.parent = parent;
    }

    public Role(Integer id, String roleName, String roleDescription, LocalDateTime createTime, LocalDateTime lastAccessTime, Integer version, Role parent, List<Role> childRoles, List<Group> groups, List<Permission> permissions) {
        this.id = id;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.createTime = createTime;
        this.lastAccessTime = lastAccessTime;
        this.version = version;
        this.parent = parent;
        this.childRoles = childRoles;
        this.groups = groups;
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append("id=").append(id);
        sb.append(", roleName='").append(roleName).append('\'');
        sb.append(", roleDescription='").append(roleDescription).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", version=").append(version);
        sb.append(", parent=").append(parent.id);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription == null ? null : roleDescription.trim();
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

    public Role getParent() {
        return parent;
    }

    public void setParent(Role parent) {
        this.parent = parent;
    }

    public List<Role> getChildRoles() {
        return childRoles;
    }

    public void setChildRoles(List<Role> childRoles) {
        this.childRoles = childRoles;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}