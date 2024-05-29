package com.kclm.owep.utils.util;

import com.kclm.owep.dto.AllUserDto;
import com.kclm.owep.entity.Group;
import com.kclm.owep.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetGroupsAndRoleUtil {

    public static List<AllUserDto> getGroupsAndRole(List<AllUserDto> allUserDto, UserMapper userMapper) {
        allUserDto.forEach(userLists -> {
            //获取用户所属的用户组列表
            List<Group> groupList = userMapper.getGroupListByUserId(userLists.getId());

            List<List<Integer>> roleIds = new ArrayList<>();
            for (Group group : groupList) {
                //获取用户组对应的的角色id列表
                List<Integer> roleIdList = userMapper.getRoleIdListByGroupId(group.getId());
                // 将用户组ID和角色ID组合成 [用户组ID, 角色ID] 形式，并添加到roleGroupIds中
                for (Integer roleId : roleIdList) {
                    List<Integer> pair = Arrays.asList(group.getId(), roleId);
                    roleIds.add(pair);
                }
            }
            System.out.println("roleIds:====================>" + roleIds);
            userLists.setRoleIds(roleIds);
        });
       return allUserDto;
    }


}
