package com.kclm.owep.service;

import com.kclm.owep.dto.AdminUserDto;
import com.kclm.owep.dto.UserDto;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.entity.User;

import java.util.List;

/**********************************8
 * @author yejf
 * 提供用户相关的操作
 */
public interface UserService {

    UserDto selectByName(String name);

    List<Permission> getPermissionListByUserId(Integer userId);

    int refreshLoginTime(Integer userId);

    //add by yejf
    String getUserAuthorityInfo(Integer userId);

    List<AdminUserDto> getAdminUserList();

    int updateUserStatus(Integer userId);

    int updateAdminUserInfo(AdminUserDto adminUserDto);

    int deleteUserById(Integer id);

    int addUser(AdminUserDto adminUserDto);

    int deleteSelectedUsers(List<Integer> idList);

    List<AdminUserDto> getAdminUserByUserName(String userName);

    List<AdminUserDto> getAdminUserByRealName(String realName);

    List<AdminUserDto> getAdminUserByKeywords(String userName, String realName);


}
