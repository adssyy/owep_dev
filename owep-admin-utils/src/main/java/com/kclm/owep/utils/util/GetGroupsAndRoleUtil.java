package com.kclm.owep.utils.util;

import com.kclm.owep.dto.AllUserDto;
import com.kclm.owep.entity.Group;
import com.kclm.owep.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

public class GetGroupsAndRoleUtil {

    public static List<AllUserDto> getGroupsAndRole(List<AllUserDto> allUserDto, UserMapper userMapper) {
        allUserDto.forEach(user -> {
            // 获取用户所属的用户组列表
            List<Group> groupList = userMapper.getGroupListByUserId(user.getId());

            // 定义一个Set来保存用户组ID和角色ID的组合，用于去重
            Set<List<Integer>> roleIdsSet = new HashSet<>();
            // 将去重后的roleIdsSet转换回List
            List<List<Integer>> roleIds = new ArrayList<>();

            for (Group group : groupList) {
                // 获取用户组对应的角色id列表
                List<Integer> roleIdList = userMapper.getRoleIdByUserIdAndGroupId(user.getId(), group.getId());
                // 将用户组ID和角色ID组合成 [用户组ID, 角色ID] 形式，并添加到roleIdsSet中
                for (Integer roleId : roleIdList) {
                    List<Integer> pair = Arrays.asList(group.getId(), roleId);
                    roleIdsSet.add(pair); // 添加到Set中以避免重复
                }
            }

            // 将Set转换回List
            roleIds.addAll(roleIdsSet);
            System.out.println("roleIds:====================>" + roleIds);
            user.setRoleIds(roleIds); // 设置用户的roleIds属性
        });

        return allUserDto;
    }



}
