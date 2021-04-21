package com.kclm.owep.service;

import com.kclm.owep.dto.*;
import com.kclm.owep.entity.Group;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.entity.Role;
import com.kclm.owep.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public interface UserService {

    /***
     *
     * @return
     */
    int create(@Param("user") User user);

    int update(@Param("user") User user);

    int delete(@Param("id") Integer id);

    UserDto selectById(@Param("id") Integer id);

    UserDto selectByName(@Param("name") String name);

    List<User> selectByType(@Param("type") Integer type);

    List<Integer> getGroupIds(@Param("id") Serializable id);

    int setGroups(@Param("userId") Integer userId, @Param("groupIds") List<Integer> groupIds);


    List<Permission> getPermissionListByUserId(Integer id);

    int refreshLoginTime(@Param("id") Integer id);

    boolean isAvailable(@Param("id") Integer id);

    int activate (@Param("id") Integer id);

    int deactivate (@Param("id") Integer id);

}
