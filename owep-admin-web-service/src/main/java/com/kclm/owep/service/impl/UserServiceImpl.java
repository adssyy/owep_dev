package com.kclm.owep.service.impl;

import com.kclm.owep.convert.UserConvert;
import com.kclm.owep.dto.*;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.entity.User;
import com.kclm.owep.mapper.UserMapper;
import com.kclm.owep.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserConvert userConvert;

    @Autowired
    private GroupService groupService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private MenuService menuService;

    @Override
    public UserDto selectByName(String name) {
        try{
            User user = userMapper.selectByName(name);
            log.info("user: {}", user);
            UserDto userDto = userConvert.toUserDto(user);
            log.info("userDto: {}", userDto);
            return userDto;
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<Permission> getPermissionListByUserId(Integer userId) {
        List<Integer> groupIds = userMapper.getGroupId(userId);
        log.debug("用户{}的groupIds是:{}", userId, groupIds);
        Set<Integer> roleIds = new HashSet<>();
        for (Integer groupId : groupIds){
            GroupRoleDTO groupRoleDTO = groupService.selectRolesByGroupId(groupId);
            List<Integer> roleIds1 = groupRoleDTO.getRoleIds();
            if (roleIds1!=null &&roleIds1.size() > 0 ){
                //从用户组id到角色id
                roleIds.addAll(roleIds1);
            }

        }
        log.debug("-- 用户id{}拥有的角色ID是：{}", userId, roleIds);
        List<Integer> permissionIdList = new ArrayList<Integer>();
        for (Integer roleId : roleIds) {
            RolePermissionDTO rolePermissionDTO = roleService.selectPermissionByRoleId(roleId);
            log.debug("---- 角色拥有的权限有：{}", rolePermissionDTO);
            List<Integer> permissionIds = rolePermissionDTO.getPermissionIds();
            if(permissionIds!=null) {
                permissionIdList.addAll(permissionIds);
            }
        }
        //从角色id到权限id
        log.debug("--- persionIdList: {}", permissionIdList);
        List<Permission> permissionList = new ArrayList<Permission>();
        for (Integer permissionId : permissionIdList) {
            PermissionDTO permissionDTO = permissionService.selectById(permissionId);
            permissionList.add(permissionDTO);
        }//由id取权限信息
        log.debug("---- PermissionList: {}",permissionList);
        //返回权限集合
        return permissionList;
    }

    @Override
    public int refreshLoginTime(Integer userId) {

        try{
            //
            User user = userMapper.selectById(userId);
            //
            if(user != null) {
                user.setLastAccessTime(LocalDateTime.now());
                return userMapper.update(user);
            }
            //
            return -1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -2;
    }

    /****************************
     * 根据用户的id来查询出用户的权限，此系统从用户到权限的路径是
     * 用户 -> 用户组 -> 角色 -> 权限 -> 菜单 [Menu]
     *                           \-> 行为 [Action]
     *  本方法把用户拥有的菜单id和行为id以"_"进行拼接，多个之间使用","分隔。如：
     *  13-21,13-22,15-21,15-24,......
     * @param userId
     * @return
     */
    @Override
    public String getUserAuthorityInfo(Integer userId) {
        String result = "";
        //1. 根据用户id来查询出拥有的权限
        Set<Permission> permissionSet = new HashSet<>(this.getPermissionListByUserId(userId));//使用set筛除重复元素
        //2. 判断是否拥有权限
        if(permissionSet.size()>0){
            //创建一个集合来存放权限包含的菜单
            Set<ActionMenuPermissionDTO> actMenuSumSet= new HashSet<>();
            for(Permission perm:permissionSet) {
                Set<ActionMenuPermissionDTO> actionMenuSet = menuService.selectActionByPermissionIdFromAMP(perm.getId());
                actMenuSumSet.addAll(actionMenuSet);
            }
            StringBuilder builder = new StringBuilder();
            //
            for(ActionMenuPermissionDTO am :actMenuSumSet){
                Integer menuId = am.getMenuId();
                Integer actionId = am.getActionId();
                //
                builder.append(menuId).append("-").append(actionId).append(",");
            }
            //删除最后一个,
            builder.deleteCharAt(builder.length()- 1);
            //
            result = builder.toString();
            //
            log.debug("用户："+userId+"拥有的权限列表："+result);
            return result;
        }else{
            System.out.println("用户"+userId+"没有分配任何权限");
        }
        return result;
    }
}
