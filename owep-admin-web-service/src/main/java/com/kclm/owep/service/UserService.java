package com.kclm.owep.service;

import com.kclm.owep.dto.*;
import com.kclm.owep.entity.Group;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.entity.Role;
import com.kclm.owep.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface UserService {

    /***
     *
     * @return
     */
    int create(@Param("user") User user);

    int updare(@Param("user") User user);

    UserDto selectById(@Param("id") Integer id);

    UserDto selectByName(@Param("name") String name);

//    GroupDTO getGroupByUserId(@Param("id") Integer id);

//    List<Role> getRoleListByUserId(@Param("id") Integer id);

    List<Permission> getPermissionListByUserId(Integer id);


}
