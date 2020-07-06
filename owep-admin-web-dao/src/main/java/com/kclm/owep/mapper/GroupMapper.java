/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/4 10:36
 * @description:
 **/
@Mapper
public interface GroupMapper {
    /*统计表中数据*/
    int count();

    /*查询表中所有数据*/
    List<Group> findByAll();

    /*根据组名称查询*/
    List<Group> findByGroupName(String groupName);

    /*根据Id查询组*/
    Group findByGroupId(Integer id);

    /*添加用户组*/
    int saveGroup(Group group);

    /*更新用户组信息*/
    int updateGroup(Group group);

    /*删除用户组支持多个删除和单个删除*/
    int deleteByIds(List<Integer> ids);

    /*为用户组添加角色，向中间表添加数据*/
    int saveRoleForGroup(@Param("groupId") Integer groupId, @Param("roleId") Integer roleId);

    /*删除中间表中的某个组已分配的角色*/
    int deleteByGroupId(List<Integer> groupIds);

    /*删除某个组下的某个角色*/
    int delByGroupIdAndRoleId(@Param("groupId") Integer groupId, @Param("roleId") Integer roleId);

    /*查询某个用户组已经分配好的角色*/
    Group findRolesByGroupId(Integer groupId);

    /*查询该组所关联的所有用户*/
    Group findUserInGroup(Integer groupId);

    /*统计用户组中已经分配的角色*/
    int countRolesByGroupId(Integer groupId);
}