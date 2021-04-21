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

import javax.naming.ldap.HasControls;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public int setGroups(Integer userId, List<Integer> groupIds) {
        mapper.deleteUserGroupAllocation(userId);
        for (Integer groupId : groupIds){
            mapper.attachGroupToUser(userId,groupId);
        }
        return 0;
    }

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
    public int update(User user) {
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
    public int delete(Integer id) {
        try{
            mapper.deleteById(id);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
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
            System.out.println("user+"+user);
           UserDto userDto = translator_User2UserDto(user);
            System.out.println("userDto:"+userDto);
            return userDto;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<User> selectByType(Integer type) {
        List<User> users = mapper.selectByType(type);
        return users;
    }

    //    @Override
//    public GroupDTO getGroupByUserId(Integer id) {
//        Integer groupId = mapper.getGroupId(id);
//        GroupDTO groupDTO = new GroupServiceImpl().selectById(groupId);
//        return groupDTO;
//    }



    @Override
    public List<Integer> getGroupIds(Serializable id) {
        List<Integer> groupIds = mapper.getGroupId(id);
        return groupIds;
    }

    @Autowired
    GroupService groupService;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;

    @Override
    public int refreshLoginTime(Integer id) {
        try{
            User user = mapper.selectById(id);
            if(user != null) {
                user.setLastAccessTime(LocalDateTime.now());
                mapper.update(user);
            }
            //
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean isAvailable(Integer id) {
        User user = mapper.selectById(id);
        Integer status = user.getStatus();
        if(status==1){//status：   1:启用  0:禁用
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int activate(Integer id) {
        try{
            User user = mapper.selectById(id);
            user.setStatus(1);
            mapper.update(user);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deactivate(Integer id) {
        try{
            User user = mapper.selectById(id);
            user.setStatus(0);
            mapper.update(user);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Permission> getPermissionListByUserId(Integer id) {
        List<Integer> groupIds = mapper.getGroupId(id);
//        System.out.println("=================>"+groupId);
        Set<Integer> roleIds = new HashSet<>();
        for (Integer groupId : groupIds){
            GroupRoleDTO groupRoleDTO = groupService.selectRolesByGroupId(groupId);
            List<Integer> roleIds1 = groupRoleDTO.getRoleIds();
            if (roleIds1!=null &&roleIds1.size() > 0 ){
                roleIds.addAll(roleIds1);//从用户组id到角色id
            }

        }
        System.out.printf("-- 用户id[%s]拥有的角色ID是：%s\n", id, roleIds);
        List<Integer> permissionIdList = new ArrayList<Integer>();
        for (Integer roleId : roleIds) {
            RolePermissionDTO rolePermissionDTO = roleService.selectPermissionByRoleId(roleId);
            System.out.println("---- 角色拥有的权限有："+rolePermissionDTO);
//            System.out.println(rolePermissionDTO+"roleDTO");
            List<Integer> permissionIds = rolePermissionDTO.getPermissionIds();
//            System.out.println(permissionIds+"permIds");
            if(permissionIds!=null) permissionIdList.addAll(permissionIds);
        }//从角色id到权限id
        System.out.println("--- persionIdList: "+permissionIdList);
        List<Permission> permissionList = new ArrayList<Permission>();
        for (Integer permissionId : permissionIdList) {
            PermissionDTO permissionDTO = permissionService.selectById(permissionId);
            permissionList.add(permissionDTO);
        }//由id取权限信息
        System.out.println("---- PermissionList: "+permissionList);
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
