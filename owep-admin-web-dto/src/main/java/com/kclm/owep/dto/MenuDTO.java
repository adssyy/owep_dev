/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.dto;

import com.kclm.owep.entity.Menu;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/13 14:53
 * @description: 菜单
 **/
public class MenuDTO extends Menu {
    private Integer id;
    /**
     * 菜单名
     */
    private String menuName;
    /**
     * 菜单描述
     */
    private String menuDescription;
    /**
     * 菜单URL
     */
    private String menuUrl;
    /**
     * 父ID
     */
    private Integer pid;

    public MenuDTO() {
    }

    public MenuDTO(Integer pid, String menuName, String menuDescription) {
        this.pid = pid;
        this.menuName = menuName;
        this.menuDescription = menuDescription;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MenuDTO{");
        sb.append("id=").append(id);
        sb.append(", menuName='").append(menuName).append('\'');
        sb.append(", menuDescription='").append(menuDescription).append('\'');
        sb.append(", menuUrl='").append(menuUrl).append('\'');
        sb.append(", pid=").append(pid);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MenuDTO menuDTO = (MenuDTO) o;
        return Objects.equals(id, menuDTO.id) &&
                Objects.equals(menuName, menuDTO.menuName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, menuName);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getMenuName() {
        return menuName;
    }

    @Override
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public String getMenuDescription() {
        return menuDescription;
    }

    @Override
    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    @Override
    public String getMenuUrl() {
        return menuUrl;
    }

    @Override
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
