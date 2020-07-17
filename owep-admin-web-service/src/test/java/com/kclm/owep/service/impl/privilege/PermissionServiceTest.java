package com.kclm.owep.service.impl.privilege;

import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.dto.PermissionDTO;
import com.kclm.owep.dto.PermissionMenuDTO;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.service.PermissionService;
import com.kclm.owep.service.impl.SysStatisticsServiceImplTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: owep
 * @package: com.kclm.owep.service
 * @description:
 * @author: qi_kran
 * @create: 2020-07-17 10:34
 **/
class PermissionServiceTest extends SysStatisticsServiceImplTest {
    @Autowired
    private PermissionService permissionService;

    @Test
    void saveOrUpdate() {
        Permission permission = new Permission("asd", "baba");
        permission.setId(10);
        permissionService.saveOrUpdate(permission);
    }

    @Test
    void deletePermission() {
        permissionService.deletePermission(Arrays.asList(10));
    }

    @Test
    void selectById() {
        PermissionDTO permissionDTO = permissionService.selectById(10);
        System.out.println(permissionDTO);
    }

    @Test
    void selectByName() {
        List<PermissionDTO> a = permissionService.selectByName("a");
        a.forEach(System.out::println);
    }

    @Test
    void selectAllPermission() {
        List<PermissionDTO> permissionDTOS = permissionService.selectAllPermission(0);
        permissionDTOS.forEach(System.out::println);
    }

    @Test
    void selectMenuByPermissionId() {
        PermissionMenuDTO permissionMenuDTO = permissionService.selectMenuByPermissionId(1);
        System.out.println(permissionMenuDTO);
        permissionMenuDTO.getMenuIds().forEach(System.out::println);
    }

    @Test
    void selectAllMenus() {
        List<NodeDTO> nodeDTOS = permissionService.selectAllMenus();
        nodeDTOS.forEach(System.out::println);
    }

    @Test
    void assignMenuToPermission() {
        Map<Integer,List<Integer>> map=new HashMap<>();
        map.put(1, Arrays.asList(1,2));
        permissionService.assignMenuToPermission(map);
    }
}