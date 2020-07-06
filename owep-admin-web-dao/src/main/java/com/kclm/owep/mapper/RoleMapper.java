/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/5 9:41
 * @description:
 **/
@Mapper
public interface RoleMapper {
    /*添加角色*/
    int saveRole(Role role);

    /*更新角色信息*/
    int updateRole(Role role);

    /*根据Id删除角色*/
    int delRoleById(List<Integer> ids);

    /*查询所有角色*/
    List<Role> findAll();

    /*根据ID查询角色*/
    Role findById(Integer id);

    /*根据角色名字查询相关信息*/
    Role findByName(String roleName);

    /*根据条件查询，参数可为NULL*/
    Role findByCondition(@Param("id") Integer id, @Param("roleName") String roleName, @Param("version") String version);


    /*自关联查询,根据父Id查询出该父角色下的所有子角色*/
    Role findChild(Integer parentId);

    /*外关联查询,某角色下的所有组*/
    List<Role> findGroupsByRoleId(Integer roleId);

    /*外关联查询,查询该角色下所分配的权限*/
    Role findPermissionInRole(Integer roleId);

    /*向角色权限中间表添加数据*/
    int saveRoleForPermission(@Param("roleId") Integer roleId, @Param("perId") Integer perId);

    /*删除该角色所分配的所有的权限*/
    int delPermissionByRoleId(List<Integer> roleIds);

    /*删除某角色下的某个权限*/
    int delPermissionByPerIdAndRoleId(@Param("roleId") Integer roleId, @Param("perId") Integer perId);

    /*统计该角色所具有的权限数量*/
    int countPermissionByRoleId(Integer roleId);

    /*统计表中数据*/
    int count();


}