/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */

package com.kclm.owep.service.impl;

import com.kclm.owep.dto.ActionMenuPermissionDTO;
import com.kclm.owep.dto.MenuDTO;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.entity.Action;
import com.kclm.owep.entity.Menu;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.mapper.ActionMapper;
import com.kclm.owep.mapper.MenuMapper;
import com.kclm.owep.mapper.PermissionMapper;
import com.kclm.owep.service.MenuService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/15 14:00
 * @description:
 **/
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MapperFactory mapperFactory;
    @Autowired
    private ActionMapper actionMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int saveOrUpdate(Menu menu) {
        Assert.notNull(menu.getMenuName(), "对象不能为空");
        Integer id = menu.getId();
        if (id == null) {
            return menuMapper.save(menu);

        } else if (id > 0) {
            return menuMapper.update(menu);
        }
        return -1;
    }

    @Override
    public int deleteMenu(List<Serializable> ids) {
        Assert.notNull(ids, "ids对象不能为空");
        menuMapper.deleteByMenuIdInAPM(ids);
        permissionMapper.deleteMenusByMenuId(ids);
        if (ids.size() == 1) {
            return menuMapper.deleteById(ids.get(0));
        } else if (ids.size() > 1) {
            return menuMapper.deleteSelect(ids);
        }
        return -1;
    }

    @Override
    public MenuDTO selectById(Serializable id) {
        if (id != null) {
            Menu menu = menuMapper.selectById(id);
            MapperFacade mapperFacade = mapperFactory.getMapperFacade();
            MenuDTO menuDTO = mapperFacade.map(menu, MenuDTO.class);
            return menuDTO;
        } else {
            throw new IllegalArgumentException("id值不合法");
        }
    }

    @Override
    public List<MenuDTO> selectAllMenu() {
        List<Menu> menus = menuMapper.selectParent(0);
        mapperFactory.classMap(Menu.class, MenuDTO.class)
                .field("parent.id", "pid")
                .byDefault()
                .register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<MenuDTO> menuDTOS = mapperFacade.mapAsList(menus, MenuDTO.class);
        return menuDTOS;

    }

    @Override
    public int assignActionToMenu(Map<Integer, List<Integer>> map) {
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        try {
            for (Map.Entry<Integer, List<Integer>> next : entries) {
                Integer key = next.getKey();
                menuMapper.deleteByMenuIdInAPM(Arrays.asList(key));
                List<Menu> menus = menuMapper.selectPermissionInMenu(key);
                List<Permission> permissions = menus.get(0).getPermissions();
                List<Integer> value = next.getValue();
                for (Permission p : permissions) {
                    value.forEach(e -> menuMapper.assignActionToMenuAndPermission(key, e, p.getId()));
                }
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    public ActionMenuPermissionDTO selectActionAndPermissionByMenuId(Serializable menuId) {
        Assert.notNull(menuId, "menuId不能为空");
        List<Menu> menus = menuMapper.selectAllInAPM(menuId, 0, 0);

        mapperFactory.classMap(Menu.class, ActionMenuPermissionDTO.class)
                .field("id", "menuId")
                .field("permissions{id}", "permissionIds{}")
                .field("actions{id}", "actionIds{}")
                .register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        ActionMenuPermissionDTO map = mapperFacade.map(menus.get(0), ActionMenuPermissionDTO.class);
        return map;
    }

    @Override
    public ActionMenuPermissionDTO selectActionByPermissionId(Serializable perId, Serializable menuId) {
        List<Menu> menus = menuMapper.selectAllInAPM(menuId, perId, 0);
        mapperFactory.classMap(Menu.class, ActionMenuPermissionDTO.class)
                .field("id", "menuId")
                .field("actions{id}", "actionIds{}")
                .register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        ActionMenuPermissionDTO map = mapperFacade.map(menus.get(0), ActionMenuPermissionDTO.class);
        return map;
    }

    @Override
    public NodeDTO selectAllAction() {
        List<Action> actions = actionMapper.selectAll();
        mapperFactory.classMap(Action.class, NodeDTO.class)
                .field("id", "tags")
                .field("actionName", "text")
                .register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<NodeDTO> nodeDTOS = mapperFacade.mapAsList(actions, NodeDTO.class);
        NodeDTO nodeDTO = new NodeDTO();
        nodeDTO.setTags(0);
        nodeDTO.setText("分配行为");
        nodeDTO.setNodes(nodeDTOS);
        return nodeDTO;
    }

    @Override
    public NodeDTO selectActionByMenuIdAndPermissionId(Serializable menuId, Serializable perId) {
        List<Menu> menus = menuMapper.selectAllInAPM(menuId, perId, 0);
        mapperFactory.classMap(Action.class, NodeDTO.class)
                .field("id", "tags")
                .field("actionName", "text")
                .register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<NodeDTO> nodeDTOS = mapperFacade.mapAsList(menus.get(0).getActions(), NodeDTO.class);
        NodeDTO nodeDTO = new NodeDTO();
        nodeDTO.setTags(0);
        nodeDTO.setText("分配行为");
        nodeDTO.setNodes(nodeDTOS);
        return nodeDTO;
    }

    @Override
    public NodeDTO selectActionByMenuId(Serializable menuId) {
        List<Menu> menus = menuMapper.selectActionInMenu(menuId);
        mapperFactory.classMap(Action.class, NodeDTO.class)
                .field("id", "tags")
                .field("actionName", "text")
                .register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<NodeDTO> nodeDTOS = mapperFacade.mapAsList(menus.get(0).getActions(), NodeDTO.class);
        NodeDTO nodeDTO = new NodeDTO();
        nodeDTO.setTags(0);
        nodeDTO.setText("分配行为");
        nodeDTO.setNodes(nodeDTOS);
        return nodeDTO;
    }
}
