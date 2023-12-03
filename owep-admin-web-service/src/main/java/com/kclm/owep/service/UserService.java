package com.kclm.owep.service;

import com.kclm.owep.dto.UserDto;
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
}
