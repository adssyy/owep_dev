package com.kclm.owep.service.impl;

import com.kclm.owep.dto.*;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.entity.Role;
import com.kclm.owep.entity.User;
import com.kclm.owep.mapper.UserMapper;
import com.kclm.owep.service.GroupService;
import com.kclm.owep.service.PermissionService;
import com.kclm.owep.service.RoleService;
import com.kclm.owep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public int create(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setTitle("none");
        try {
            mapper.save(user);
        }catch (Exception e){
            return 0;
        }
        return 1;

    }

    @Override
    public int updare(User user) {
        if (user.getId()==null||mapper.selectById(user.getId())==null){
            System.out.println("Id not exist, switch to create.");
            create(user);
            return 1;
        }
        try {
            mapper.update(user);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

    @Override
    public UserDto selectById(Integer id) {
        try {
            User user = mapper.selectById(id);
            UserDto userDto = translator_User2UserDto(user);
            return userDto;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public UserDto selectByName(String name) {
        try{
            User user = mapper.selectByName(name);
           UserDto userDto = translator_User2UserDto(user);
            return userDto;
        }catch (Exception e){
            return null;
        }
    }

//    @Override
//    public GroupDTO getGroupByUserId(Integer id) {
//        Integer groupId = mapper.getGroupId(id);
//        GroupDTO groupDTO = new GroupServiceImpl().selectById(groupId);
//        return groupDTO;
//    }

    @Autowired
    GroupService groupService;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;

    @Override
    public List<Permission> getPermissionListByUserId(Integer id) {
        Integer groupId = mapper.getGroupId(id);
//        System.out.println("=================>"+groupId);
        GroupRoleDTO groupRoleDTO = groupService.selectRolesByGroupId(groupId);
        List<Integer> roleIds = groupRoleDTO.getRoleIds();//从用户组id到角色id
        List<Integer> permissionIdList = new ArrayList<Integer>();
        for (Integer roleId : roleIds) {
            RolePermissionDTO rolePermissionDTO = roleService.selectPermissionByRoleId(roleId);

//            System.out.println(rolePermissionDTO+"roleDTO");
            List<Integer> permissionIds = rolePermissionDTO.getPermissionIds();
//            System.out.println(permissionIds+"permIds");
            if(permissionIds!=null) permissionIdList.addAll(permissionIds);
        }//从角色id到权限id

        List<Permission> permissionList = new ArrayList<Permission>();
        for (Integer permissionId : permissionIdList) {
            PermissionDTO permissionDTO = permissionService.selectById(permissionId);
            permissionList.add(permissionDTO);
        }//由id取权限信息

        return permissionList;//返回权限集合
    }

//    @Override
//    public List<Permission> getPermissionListByUserId(Integer id) {
//        List<Role> roles = getRoleListByUserId(id);
//        {
//            List<Permission> permissionList = new ArrayList<Permission>();
//
//            for (Role role : roles) {
//                List<Permission> permissions = role.getPermissions();
//                permissionList.addAll(permissions);
//            }
//            return permissionList;
//        }
//    }

    /***
     * 格式转化器，手动编辑，无脚本，中间方案。
     * @param user
     * @return
     */
    public UserDto translator_User2UserDto(User user){
        try{
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setUserName(user.getUserName());
            userDto.setUserPwd(user.getUserPwd());
            return userDto;
        }catch (Exception e){
            return null;
        }
    }
}
