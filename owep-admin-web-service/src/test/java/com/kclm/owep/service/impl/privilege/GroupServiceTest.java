package com.kclm.owep.service.impl.privilege;


import com.alibaba.fastjson.JSON;
import com.kclm.owep.dto.GroupDTO;
import com.kclm.owep.dto.GroupRoleDTO;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.entity.Group;
import com.kclm.owep.service.GroupService;
import com.kclm.owep.service.impl.SysStatisticsServiceImplTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: owep
 * @package: com.kclm.owep.service.impl.privilege
 * @description:
 * @author: qi_kran
 * @create: 2020-07-14 14:46
 **/
class GroupServiceTest extends SysStatisticsServiceImplTest {
    @Autowired
    private GroupService groupService;

    @Test
    void saveOrUpdate() {
        Group group = new Group();
 /*       group.setId(7);
        group.setGroupName("aqqq");
        group.setGroupDescription("qqqq");*/
        groupService.saveOrUpdate(group);
    }

    @Test
    void deleteGroup() {
        groupService.deleteGroup(Arrays.asList(7));
    }

    @Test
    void selectByName() {
        System.out.println(groupService.selectByName(""));
    }

    @Test
    void selectById() {
        GroupDTO dto = groupService.selectById(1);
        System.out.println(dto);
    }

    @Test
    void selectAllGroups() {
        List<GroupDTO> groupDTOS = groupService.selectAllGroups(1);
        groupDTOS.forEach(System.out::println);
    }

    @Test
    void selectRolesByGroupId() {
        GroupRoleDTO groupRoleDTO = groupService.selectRolesByGroupId(1);
       groupRoleDTO.getRoleIds().forEach(System.out::println);
        System.out.println(groupRoleDTO);
    }

    @Test
    void assignRoleToGroup() {
        Map<Integer, List<Integer>> map=new HashMap<>();
        map.put(1, Arrays.asList(1,2));
        groupService.assignRoleToGroup(map);
    }

    @Test
    void selectAllRoles() {
        NodeDTO nodeDTO = groupService.selectAllRoles();
        System.out.println(nodeDTO);
    }
}