/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.dto;

import java.util.Objects;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/13 10:39
 * @description: 用户组和角色
 **/
public class GroupRoleDTO {
    /**
     * 组ID
     */
    private Integer groupId;
    /**
     * 角色ID
     */
    private Integer roleId;
    public GroupRoleDTO(Integer groupId, Integer roleId) {
        this.groupId = groupId;
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GroupRoleDTO{");
        sb.append("groupId=").append(groupId);
        sb.append(", roleId=").append(roleId);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupRoleDTO that = (GroupRoleDTO) o;
        return Objects.equals(groupId, that.groupId) &&
                Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, roleId);
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
