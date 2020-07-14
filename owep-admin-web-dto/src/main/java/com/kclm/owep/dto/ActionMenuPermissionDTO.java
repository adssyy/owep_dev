/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/13 16:10
 * @description: 行为菜单权限中间表
 **/
public class ActionMenuPermissionDTO implements Serializable {
    /**
     * 行为ID
     */
    private Integer actionId;
    /**
     * 菜单ID
     */
    private Integer menuId;
    private Integer permissionId;

    public ActionMenuPermissionDTO() {
    }

    public ActionMenuPermissionDTO(Integer actionId, Integer menuId, Integer permissionId) {
        this.actionId = actionId;
        this.menuId = menuId;
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ActionMenuPermissionDTO{");
        sb.append("actionId=").append(actionId);
        sb.append(", menuId=").append(menuId);
        sb.append(", permissionId=").append(permissionId);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionMenuPermissionDTO that = (ActionMenuPermissionDTO) o;
        return Objects.equals(actionId, that.actionId) &&
                Objects.equals(menuId, that.menuId) &&
                Objects.equals(permissionId, that.permissionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actionId, menuId, permissionId);
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
