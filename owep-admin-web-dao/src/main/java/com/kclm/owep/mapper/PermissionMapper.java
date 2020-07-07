package com.kclm.owep.mapper;

import com.kclm.owep.entity.Permission;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PermissionMapper {
    /**
     * 根据Id删除
     */
    int deleteById(Integer id);

    /**
     * 插入权限
     */
    int insert(Permission record);

    /*更新记录*/
    int update(Permission record);

    /**
     * 根据Id的查询
     */
    Permission findById(Integer id);

    /**
     * 查询所有
     */
    List<Permission> findByAll();

    /**
     * 根据名字查询
     */
    List<Permission> findByName(String name);

    /**
     * 外联查询 查询关联某个权限的所有角色 可传Id进行条件查询。不传则默认查询所有
     */
    List<Permission> findRoleInPermission(Integer perId);

    /**
     * 外联查询 查询权限下所关联的菜单 可传Id进行条件查询。不传则默认查询所有
     */
    List<Permission> findMenuInPermission(Integer perId);

    /**
     * 外联查询 查询权限下所关联的行为 可传Id进行条件查询。不传则默认查询所有
     */
    List<Permission> findActionInPermission(Integer perId);

    /**
     * 向中间表插入数据 给权限分配菜单
     */
//TODO 分配数据统一用assign
    int assignMenuToPermission(@Param("perId") Integer perId, @Param("menuId") Integer menuId);

    /**
     * 向中间表删除数据 根据权限Id删除关联的菜单
     */
    int deleteMenusByPermissionId(List<Integer> perIds);

    /**
     * 向中间表插入数据 给权限分配行为
     */
/*
    int assignActionToPermission(@Param("perId") Integer perId, @Param("menuId") Integer menuId,@Param("actionId") Integer actionId);
*/

}