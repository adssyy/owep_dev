/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */
package com.kclm.owep.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * author：ZhangQi
 * module：privilege
 * description:用户组实体类 与用户、角色有多对多关联
 * version：v0.1
 * time：2020/7/3
 */
public class Group implements Serializable {
    private Integer id;
    private String groupName;/** 组名*/
    private String groupDescription;/** 组描述*/
    private LocalDateTime createTime;/** 创建时间*/
    private LocalDateTime lastAccessTime;/** 最后一次访问时间*/
    private Integer version;/** 版本号*/
    private Integer maxCount;/** 最多支持分配多少个角色*/
    private List<Role> roles;/** 关联角色表*/
    private List<User> users;/** 关联用户*/


    public Group() {
    }

    public Group(Integer id, String groupName, String groupDescription, LocalDateTime createTime, LocalDateTime lastAccessTime, Integer version, Integer maxCount) {
        this.id = id;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.createTime = createTime;
        this.lastAccessTime = lastAccessTime;
        this.version = version;
        this.maxCount = maxCount;
    }

    public Group(String groupName, String groupDescription, LocalDateTime createTime, LocalDateTime lastAccessTime, Integer version, Integer maxCount) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.createTime = createTime;
        this.lastAccessTime = lastAccessTime;
        this.version = version;
        this.maxCount = maxCount;
    }

    public Group(Integer id, String groupName, String groupDescription, LocalDateTime createTime, LocalDateTime lastAccessTime, Integer version, Integer maxCount, List<Role> roles, List<User> users) {
        this.id = id;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.createTime = createTime;
        this.lastAccessTime = lastAccessTime;
        this.version = version;
        this.maxCount = maxCount;
        this.roles = roles;
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id) &&
                Objects.equals(groupName, group.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Group{");
        sb.append("id=").append(id);
        sb.append(", groupName='").append(groupName).append('\'');
        sb.append(", groupDescription='").append(groupDescription).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", version=").append(version);
        sb.append(", maxCount=").append(maxCount);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription == null ? null : groupDescription.trim();
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

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}