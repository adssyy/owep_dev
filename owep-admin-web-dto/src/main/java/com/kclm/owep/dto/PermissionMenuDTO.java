/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.dto;

import java.util.Objects;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/13 15:24
 * @description: 权限菜单中间表DTO
 **/
public class PermissionMenuDTO {
    /**
     * 权限ID
     */
    private Integer permissionId;
    /**
     * 菜单ID
     */
    private Integer menuId;

    public PermissionMenuDTO() {
    }

    public PermissionMenuDTO(Integer permissionId, Integer menuId) {
        this.permissionId = permissionId;
        this.menuId = menuId;
    }

    @Override
    public String
    toString() {
        final StringBuilder sb = new StringBuilder("PermissionMenuDTO{");
        sb.append("permissionId=").append(permissionId);
        sb.append(", menuId=").append(menuId);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermissionMenuDTO that = (PermissionMenuDTO) o;
        return Objects.equals(permissionId, that.permissionId) &&
                Objects.equals(menuId, that.menuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissionId, menuId);
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

}
