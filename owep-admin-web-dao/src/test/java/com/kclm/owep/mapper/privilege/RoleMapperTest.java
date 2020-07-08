package com.kclm.owep.mapper.privilege;

import com.kclm.owep.entity.Role;
import com.kclm.owep.mapper.ActionMapperTest;
import com.kclm.owep.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: owep
 * @package: com.kclm.owep.mapper
 * @description:
 * @author: qi_kran
 * @create: 2020-07-06 11:22
 **/
class RoleMapperTest extends ActionMapperTest {
@Autowired
private RoleMapper roleMapper;
    /*@Test
    void saveRole() {
        Role role=new Role("工程师", "工程操作者", LocalDateTime.now(), LocalDateTime.now(), 1, null);
        roleMapper.saveRole(role);
    }*/

    @Test
    void updateRole() {
    }

    @Test
    void delRoleById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findByCondition() {
    }

    @Test
    void findChilds() {
    }

    @Test
    void findGroupsByRoleId() {
    }

    @Test
    void findPermissionInRole() {
    }

    @Test
    void saveRoleForPermission() {
    }

    @Test
    void delPermissionByRoleId() {
    }

    @Test
    void delPermissionByPerIdAndRoleId() {
    }

    @Test
    void countPermissionByRoleId() {
    }

    @Test
    void count() {
    }
}