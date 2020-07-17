/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.service.impl;

import com.github.pagehelper.PageHelper;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.dto.PermissionDTO;
import com.kclm.owep.dto.PermissionMenuDTO;
import com.kclm.owep.entity.Menu;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.mapper.MenuMapper;
import com.kclm.owep.mapper.PermissionMapper;
import com.kclm.owep.service.PermissionService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/15 12:01
 * @description:
 **/
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MapperFactory mapperFactory;

    @Override
    public int saveOrUpdate(Permission permission) {
        Assert.notNull(permission.getPermissionName(), "对象不能为空");
        Integer id = permission.getId();
        if (id == null) {
            return permissionMapper.save(permission);

        } else if (id > 0) {
            return permissionMapper.update(permission);
        }
        return -1;
    }

    @Override
    public int deletePermission(List<Serializable> ids) {
        Assert.notNull(ids, "ids对象不能为空");
        if (ids.size() == 1) {
            return permissionMapper.deleteById(ids.get(0));
        } else if (ids.size() > 1) {
            return permissionMapper.deleteSelect(ids);
        }
        return -1;
    }

    @Override
    public PermissionDTO selectById(Serializable id) {
        if (id != null) {
            Permission permission = permissionMapper.selectById(id);
            MapperFacade mapperFacade = mapperFactory.getMapperFacade();
            PermissionDTO map = mapperFacade.map(permission, PermissionDTO.class);
            return map;
        } else {
            throw new IllegalArgumentException("id值不合法");
        }
    }

    @Override
    public List<PermissionDTO> selectByName(String name) {
        Assert.notNull(name, "name为空");
        List<Permission> permissions = permissionMapper.selectByName(name);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<PermissionDTO> permissionDTOS = mapperFacade.mapAsList(permissions, PermissionDTO.class);
        return permissionDTOS;
    }

    @Override
    public List<PermissionDTO> selectAllPermission(int pageNum) {
        if (pageNum >= 0) {
            PageHelper.startPage(pageNum, PAGE_SIZE);
            List<Permission> permissions = permissionMapper.selectAll();
            MapperFacade mapperFacade = mapperFactory.getMapperFacade();
            List<PermissionDTO> permissionDTOS = mapperFacade.mapAsList(permissions, PermissionDTO.class);
            return permissionDTOS;
        } else {
            throw new IllegalArgumentException("pageNum值不合法");
        }
    }

    @Override
    public PermissionMenuDTO selectMenuByPermissionId(Serializable perId) {
        if (perId != null) {
            List<Permission> permissions = permissionMapper.selectMenuInPermission(perId);
            Permission permission = permissions.get(0);
            mapperFactory.classMap(Permission.class, PermissionMenuDTO.class)
                    .field("id", "permissionId")
                    .field("menus{id}", "menuIds{}")
                    .register();
            MapperFacade mapperFacade = mapperFactory.getMapperFacade();
            PermissionMenuDTO map = mapperFacade.map(permission, PermissionMenuDTO.class);
            return map;
        } else throw new IllegalArgumentException("perId值不合法");
    }

    @Override
    public List<NodeDTO> selectAllMenus() {
        mapperFactory.classMap(Menu.class, NodeDTO.class)
                .field("menuName", "text")
                .field("id", "tags")
                .field("childMenus{id}", "nodes{tags}")
                .field("childMenus{menuName}", "nodes{text}")
                .register();
        List<Menu> menus = menuMapper.selectAll();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<NodeDTO> nodeDTOS = mapperFacade.mapAsList(menus, NodeDTO.class);
        return nodeDTOS;
    }

    @Override
    public int assignMenuToPermission(Map<Integer, List<Integer>> map) {
        Assert.notNull(map, "map对象不能为空");
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        try {
            for (Map.Entry<Integer, List<Integer>> next : entries) {
                Integer key = next.getKey();
                List<Integer> value = next.getValue();
                permissionMapper.deleteMenusByPermissionId(Arrays.asList(key));
                value.forEach(e -> permissionMapper.assignMenuToPermission(key, e));
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;

        }
    }
}
