package com.kclm.owep.service;

import com.kclm.owep.dto.AllUserDto;
import com.kclm.owep.dto.UserDto;
import com.kclm.owep.dto.UserGroupAndRoleDto;
import com.kclm.owep.entity.Permission;

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

    List<AllUserDto> getAllUserList(int userType, int isDelete1);

    int updateUserStatus(Integer userId,int isDelete1);

    int updateAdminUserInfo(AllUserDto allUserDto,int isDelete1);

    int deleteUserById(Integer id,int isDelete1);

    int addUser(AllUserDto allUserDto,int userType);

    int deleteSelectedUsers(List<Integer> idList,int isDelete1);

    List<AllUserDto> getAdminUserByUserName(String userName,int isDelete1, int userType);

    List<AllUserDto> getAdminUserByRealName(String realName,int isDelete1,int userType);

    List<AllUserDto> getAdminUserByKeywords(String userName, String realName,int isDelete1,int userType);

    List<UserGroupAndRoleDto> getUserGroupAndRoleList();


}
