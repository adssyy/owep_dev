/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */
package com.kclm.owep.web.controller;

import com.kclm.owep.dto.*;
import com.kclm.owep.entity.*;
import com.kclm.owep.service.*;
import com.kclm.owep.web.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.*;

/**
 * @author Artherine
 * @version v1.0
 * @date 2020/6/28 21:15
 * @description 描述权限模块跳转到指定页面
 */

@RestController
@RequestMapping("/privilege")
@Slf4j
public class PrivilegeController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private ActionService actionService;

    @Autowired
    private MenuService menuService;

    /******************************************
     * 回应用户管理页面的table刷新请求 反馈json对象
     * @return
     */
    @GetMapping(value = "/userGroup_table", produces = "application/json")
    @PreAuthorize("hasAuthority('16-21')")
    public R<List<GroupDTO>> getGroupTable(@RequestParam("offset") int offset){
        //调用业务层方法都应该做异常处理
        try {
            List<GroupDTO> groupDTOS = groupService.selectAllGroups(offset);
            //
            log.info("根据offset:{}, 查询所有的用户组： {}", offset, groupDTOS);
            //
            return R.success().setData(groupDTOS);

        } catch (RuntimeException e) {
            //记录日志
            log.error("获取所有组信息失败",e);
            return R.failure(e.getMessage());
        }
    }

    @GetMapping(value = "/userGroup/treeView", produces = "application/json")
    @PreAuthorize("hasAuthority('16-21')")
    public R<NodeDTO[]> getGroupTreeView(@RequestParam("id") int groupId){//只是个字符串，没有相对应的数据库
        //
        try {
            NodeDTO nodeDTO = groupService.selectAllRoles();//获得完整树表
            List<NodeDTO> nodeList = nodeDTO.getNodes();
            List<Integer> roleIds = groupService.selectRolesByGroupId(groupId).getRoleIds();//获得已激活选择支id
            if(roleIds!=null){
                for ( Integer id:roleIds) {
                    for ( NodeDTO node : nodeList) {// 预先勾选从数据库中得到的选择支
                        if(id.equals(node.getTags()))//nodeDto的tags就是group的id
                            node.nodeChecked();
                    }
                }
            }else{
                System.out.println("新建组，无角色队列");
            }
            NodeDTO[] result = new NodeDTO[1];//新建一个数组
            result[0] = nodeDTO;//把结果包装进数组
            //
            return R.success().setData(result);

        } catch (RuntimeException e) {
            log.error("根据组id来查询权限树节点失败", e);
            //
            return R.failure(e.getMessage());
        }
    }

    @PostMapping(value = "/userGroup/editTreeView", produces = "application/json")
    @PreAuthorize("hasAuthority('16-23')")
    public R<String> postGroupTreeViewEditAction(@RequestBody GroupRoleDTO groupRoleDTO){
        try {
            Integer groupId = groupRoleDTO.getGroupId();
            List<Integer> roleIds = groupRoleDTO.getRoleIds();
            Map<Integer, List<Integer>> groupRoleMap = new HashMap<Integer, List<Integer>>();
            groupRoleMap.put(groupId, roleIds);
            int feedback = groupService.assignRoleToGroup(groupRoleMap);
            if (feedback == -2) {
                return R.failure("同步失败，意料之外的错误");
            }
            return R.success();
        } catch (RuntimeException e) {
            //
            log.error("分配角色到组失败", e);
            //
            return R.failure("分配角色到组失败");
        }

    }

    @GetMapping(value = "/userGroup/toEdit", produces = "application/json")
    @PreAuthorize("hasAuthority('16-21')")
    public R<GroupDTO> getGroupEditInfo(@RequestParam("id") int id){//前端按下编辑键时向前端传对应id的组信息
        try {
            log.debug("根据id来查询用户信息 id:"+id);
            return R.success().setData(groupService.selectById(id));
        } catch (RuntimeException e){
            log.error("查询组信息失败", e);
            //
            return R.failure("查询失败");
        }

    }

    @PostMapping(value = "/userGroup/editGroup", produces = "application/json")
    @PreAuthorize("hasAuthority('16-23')")
    public R<String> postGroupEditAction(Group group){//前端按下编辑键时向前端传对应id的组信息
        try {
            log.debug("待更新用户组:" + group);
            groupService.saveOrUpdate(group);
            return R.success();
        } catch (RuntimeException e) {
            log.error("更新用户组失败",e);
            //
            return R.failure("更新用户组失败");
        }
    }

    @PostMapping(value = "/userGroup/addGroup", produces = "application/json")
    @PreAuthorize("hasAuthority('16-22')")
    public R<String> postGroupAddAction(Group group){//前端按下编辑键时向前端传对应id的组信息
        try {
            log.debug("添加用户组："+group);
            if (groupService.saveOrUpdate(group) != -1) {
                log.debug("添加用户组成功");
                return R.success();
            } else {
                log.error("添加用户组失败");
                return R.failure("添加用户组失败");
            }
        } catch (RuntimeException e) {
            log.error("添加用户组失败",e);
            //
            return R.failure("添加用户组失败");
        }
    }


    @GetMapping(value = "/userGroup/delete", produces = "application/json")
    @ResponseBody()
    @PreAuthorize("hasAuthority('16-24')")
    public R<String> postGroupDeleteAction(@RequestParam("id") Integer id){
        try {
            log.debug("删除用户组，id:" + id);
            List deleteList = new ArrayList<>();
            deleteList.add(id);
            if (groupService.deleteGroup(deleteList) != -1) {//返回值为-1说明删除过程中出错
                log.debug("Group id<" + id + "> deleted");
                return R.success();
            } else {
                return R.failure("删除用户组成功，但数据库中没有受影响的记录：id"+id);
            }
        } catch (RuntimeException e) {
            log.error("删除用户组失败", e);
            //
            return R.failure("删除用户组失败");
        }
    }

    @PostMapping(value = "/userGroup/deleteByGroups", produces = "application/json")
    @PreAuthorize("hasAuthority('16-24')")
    @ResponseBody()
    public R<String> postGroupDeleteByGroupsAction(@RequestBody List<Serializable>  idList){
        try {
            log.debug("删除用户组，id:" + idList);
            if (groupService.deleteGroup(idList) != -1) {//返回值为-1说明删除过程中出错
                log.debug("批量删除用户组成功");
                return R.success();
            } else {
                return R.failure("批量删除成功，但数据库中没有受影响的记录");
            }
        } catch (RuntimeException e) {
            log.error("批量删除用户组失败", e);
            //
            return R.failure("批量删除用户组失败");
        }
    }

    @GetMapping("/roleList/getTable")
    @PreAuthorize("hasAuthority('19-21')")
    public R<List<RoleDTO>> getRoleListTable(@RequestParam("offset") int offset){
        try {
            log.debug("查询所有角色");
            List<RoleDTO> roleDTOS = roleService.selectAllRoles(offset);
            //
            return R.success().setData(roleDTOS);
        } catch (RuntimeException e) {
            log.error("查询所有角色失败", e);
            //
            return R.failure("查询所有角色失败");
        }
    }

    @GetMapping("/roleList/toEditRole")
    @PreAuthorize("hasAuthority('19-21')")
    public R<RoleDTO> getRoleEditInfo(@RequestParam("id") int id){
        try {
            log.debug("依id查询角色:"+id);
            RoleDTO roleDTO = roleService.selectById(id);
            //
            return R.success().setData(roleDTO);
        } catch (RuntimeException e) {
            log.error("依id查询角色失败", e);
            //
            return R.failure("查询角色失败："+id);
        }
    }

    @PostMapping("/roleList/editRole")
    @PreAuthorize("hasAuthority('19-23')")
    public R<String> postRoleEditAction(Role role){
        try {
            log.debug("更新角色信息");
            roleService.saveOrUpdate(role);
            return R.success();
        } catch (RuntimeException e){
            log.error("更新角色失败",e);
            //
            return R.failure("更新角色失败");
        }
    }

    @PostMapping("/roleList/addRole")
    @PreAuthorize("hasAuthority('19-22')")
    public R<String> postRoleAddAction(Role role){
        try {
            log.debug("添加角色信息");
            roleService.saveOrUpdate(role);
            return R.success();
        } catch (RuntimeException e){
            log.error("添加角色失败",e);
            //
            return R.failure("添加角色失败");
        }
    }

    @PostMapping("/roleList/deleteRole")
    @PreAuthorize("hasAuthority('19-24')")
    public R<String> postRoleDeleteAction(@RequestBody Integer id){
        try {
            log.debug("依id删除角色操作："+id);
            List idList = new ArrayList();
            idList.add(id);
            if (roleService.deleteRole(idList) != -1) {
                log.debug("删除id为"+id+"的角色成功");
                return R.success();
            } else {
                return R.failure("删除id为:"+id+"角色失败");
            }
        } catch (RuntimeException e) {
            log.error("删除角色失败",e);
            return R.failure("依ID删除角色失败:"+id);
        }
    }


    @GetMapping("roleList/treeCheck")
    @PreAuthorize("hasAuthority('19-21')")
    public R<NodeDTO[]> getTreeCheckMap(@RequestParam("id") int id){
        try {
            NodeDTO nodeDTO = roleService.selectAllDTO();//获取全节点
            //设置预先勾选
            List<NodeDTO> nodes = nodeDTO.getNodes();
            RolePermissionDTO rolePermissionDTO = roleService.selectPermissionByRoleId(id);
            List<Integer> permissionIds = rolePermissionDTO.getPermissionIds();
            if (permissionIds != null) {
                for (Integer per_id : permissionIds) {
                    for (NodeDTO node : nodes) {
                        if (node.getTags().equals(per_id))
                            node.nodeChecked();
                    }
                }
            } else {
                System.out.println("empty list, new setting");
            }
            NodeDTO[] data = new NodeDTO[1];
            data[0] = nodeDTO;
            return R.success().setData(data);
        } catch (RuntimeException e) {
            log.error("依角色id查询并回显所有的权限信息失败");
            return R.failure("依角色id查询并回显所有的权限信息失败");
        }
    }

    @PostMapping(value = "roleList/treeCheck_edit", produces = "application/json")
    @PreAuthorize("hasAuthority('19-23')")
    public R<String> postRoleTreeCheckEditAction(@RequestBody RolePermissionDTO rolePermissionDTO){
        try {
            Integer roleId = rolePermissionDTO.getRoleId();
            List<Integer> permissionIds = rolePermissionDTO.getPermissionIds();
            Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
            map.put(roleId, permissionIds);
            roleService.assignPermissionToRole(map);
            return R.success();
        } catch (RuntimeException e) {
            log.error("分配权限到角色失败");
            return R.failure("分配权限到角色失败");
        }

    }

    @PostMapping(value = "/roleList/deleteByGroups", produces = "application/json")
    @PreAuthorize("hasAuthority('19-24')")
    public R<String> postRoleDeleteByGroupsAction(@RequestBody List<Serializable>  idList){
        try {
            log.debug("批量删除角色信息："+idList);
            if (roleService.deleteRole(idList) != -1) {//返回值为-1说明删除过程中出错
                log.info("批量删除角色信息成功");
                return R.success();
            } else {
                return R.failure("SQL正确执行，但是没有受影响的记录。");
            }
        } catch (RuntimeException e) {
            log.error("批量删除角色失败", e);
            return R.failure("批量删除角色失败");
        }
    }


    @GetMapping(value = "/rolePriv/getTable", produces = "application/json")
    @PreAuthorize("hasAuthority('35-21')")
    public R<List<PermissionDTO>> getPrivTable(@RequestParam("offset") int offset){
        try {
            List<PermissionDTO> permissionDTOS = permissionService.selectAllPermission(offset);
            log.debug("分页查询所有权限成功");
            return R.success().setData(permissionDTOS);
        } catch (RuntimeException e) {
            log.error("分页获取所有权限失败");
            return R.failure("获取所有权限失败");
        }
    }

    @PostMapping("/rolePriv/addPerm")
    @PreAuthorize("hasAuthority('35-22')")
    public R<String> postAddPermAction(Permission permission){
        try {
            permissionService.saveOrUpdate(permission);
            log.debug("添加权限成功");
            return R.success();
        } catch (RuntimeException e) {
            log.error("添加权限信息失败");
            return R.failure("添加权限信息失败");
        }
    }

    @GetMapping(value = "/rolePriv/toEditPerm", produces = "application/json")
    @PreAuthorize("hasAuthority('35-21')")
    public R<PermissionDTO> getEditPermInfo(@RequestParam("id") Integer id){
        try {
            PermissionDTO permissionDTO = permissionService.selectById(id);
            log.debug("依id查询权限成功");
            return R.success().setData(permissionDTO);
        } catch (RuntimeException e) {
            log.error("依id查询权限失败:"+id);
            return R.failure("依id查询权限失败");
        }
    }

    @PostMapping("/rolePriv/editPerm")
    @PreAuthorize("hasAuthority('35-23')")
    public R<String> postEditPermAction(Permission permission){
        try {
            permissionService.saveOrUpdate(permission);
            log.debug("更新权限成功");
            return R.success();
        } catch (RuntimeException e) {
            log.error("更新权限失败");
            return R.failure("更新权限失败");
        }
    }

    @PostMapping("/rolePriv/deletePerm")
    @PreAuthorize("hasAuthority('35-24')")
    public R<String> postDeletePermAction(@RequestBody Integer id){
        try {
            List idList = new ArrayList();
            idList.add(id);
            if (permissionService.deletePermission(idList) != -1) {
                return R.success();
            } else {
                return R.failure("删除权限失败");
            }
        } catch (RuntimeException e) {
            log.error("删除权限失败", e);
            return R.failure("删除权限失败:"+id);
        }
    }

    @PostMapping(value = "/rolePriv/deleteByGroup", produces = "application/json")
    @PreAuthorize("hasAuthority('35-24')")
    public R<String> postDeletePermByGroupsAction(@RequestBody List<Serializable>  idList){
        try {
            log.debug("根据组id删除权限:" + idList);
            if (permissionService.deletePermission(idList) != -1) {//返回值为-1说明删除过程中出错
                log.debug("删除成功");
                return R.success();
            } else {
                return R.failure("SQL执行成功，但没有受影响的记录数");
            }
        } catch (RuntimeException e){
            log.error("根据组id删除权限失败");
            return R.failure("根据组id删除权限失败");
        }
    }

    @GetMapping("rolePriv/treeCheck")
    @PreAuthorize("hasAuthority('35-21')")
    public R<List<NodeDTO>> getPermTreeCheckMap(@RequestParam("id") int id){
        try {
            List<NodeDTO> nodeDTOS = permissionService.selectAllMenus();//获取全节点
            List<NodeDTO> nodeList = new ArrayList<NodeDTO>();
            nodeList.addAll(nodeDTOS);
            for (NodeDTO upperNode : nodeDTOS) {//取出所有子node集合展开为一维列
                List<NodeDTO> nodes = upperNode.getNodes();
                if (nodes != null) {
                    nodeList.addAll(nodes);
                }
            }
            //设置预先勾选
            PermissionMenuDTO permissionMenuDTO = permissionService.selectMenuByPermissionId(id);
            List<Integer> menuList = permissionMenuDTO.getMenuIds();
            if (menuList != null) {//不为空
                for (Integer menu_id : menuList) {
                    for (NodeDTO node : nodeList) {
                        if (node.getTags().equals(menu_id)) {//遍历id和节点，把id一致的节点激活
                            node.nodeChecked();
                        }
                    }
                }
            } else {
                System.out.println("empty list, new setting");
            }
            return R.success().setData(nodeDTOS);

        } catch (RuntimeException e) {
            log.error("获取菜单权限失败");
            return R.failure("获取菜单权限失败");
        }
    }

    @PostMapping(value = "rolePriv/treeCheck_edit", produces = "application/json")
    @PreAuthorize("hasAuthority('35-23')")
    public R<String> postPermTreeCheckEditAction(@RequestBody PermissionMenuDTO permissionMenuDTO) {
        try {
            Integer permissionId = permissionMenuDTO.getPermissionId();
            List<Integer> menuIds = permissionMenuDTO.getMenuIds();
            Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
            map.put(permissionId, menuIds);
            permissionService.assignMenuToPermission(map);
            return R.success();
        } catch (RuntimeException e) {
            log.error("给菜单分配权限失败");
            return R.failure("给菜单分配权限失败");
        }
    }

    @GetMapping("/menuList/getTable")
    @PreAuthorize("hasAuthority('38-21')")
    public R<List<MenuDTO>> getMenuActionTable(){
        try {
            log.debug("加载所有菜单");
            List<MenuDTO> menuDTOS = menuService.selectAllMenu();
            return R.success().setData(menuDTOS);
        } catch (RuntimeException e) {
            log.error("获取所有菜单出错",e);
            return R.failure("获取所有菜单出错");
        }
    }

    @GetMapping("/menuList/treeSelect")
    @PreAuthorize("hasAuthority('38-21')")
    public R<List<NodeDTO>> getMenuListTreeSelect(){
        try {
            List<NodeDTO> nodeDTOS = permissionService.selectAllMenus();
            return R.success().setData(nodeDTOS);
        } catch (RuntimeException e) {
            log.error("加载所有菜单失败",e);
            return R.failure("List<NodeDTO>");
        }
    }

    @PostMapping("/menuList/addMenu")
    @PreAuthorize("hasAuthority('38-22')")
    public R<String> postMenuAddAction(Menu menu ,String parentMenu,Integer parentMenuId){
        try {
            Menu parent = new Menu();//做个空壳对象
            parent.setId(parentMenuId);//只存id
            parent.setMenuName(parentMenu);
            menu.setParent(parent);//作为parent保存进数据库
            menuService.saveOrUpdate(menu);
            return R.success();
        } catch (RuntimeException e) {
            log.error("添加菜单失败",e);
            return R.failure("添加菜单失败");
        }
    }


    @GetMapping(value = "/menuList/suggest", produces = "application/json")
    @PreAuthorize("hasAuthority('38-21')")
    public R<Map<String,List<PermissionDTO>>> getMenuListSuggest(){
        try {
            List<PermissionDTO> permissionDTOS = permissionService.selectAllPermission(0);
            log.debug("permissions we got:" + permissionDTOS);
            Map<String, List<PermissionDTO>> result = new HashMap();
            result.put("value", permissionDTOS);
            //
            return R.success().setData(result);
        } catch (RuntimeException e) {
            log.error("查询所有权限失败", e);
            return R.failure("查询所有权限失败");
        }
    }

    @GetMapping("/menuList/treeCheck")
    @PreAuthorize("hasAuthority('38-21')")
    public R<Object[]> getMenuActionTreeCheckMap(@RequestParam(value = "id",required = false) Integer id){//
        try {
            NodeDTO nodeDTO = menuService.selectAllAction();//获取行为全节点
            if (id != null) {
                List<NodeDTO> nodeList = new ArrayList<NodeDTO>();
                nodeList = nodeDTO.getNodes();
                //设置预先勾选
                ActionMenuPermissionDTO actionMenuPermissionDTO = menuService.selectActionAndPermissionByMenuId(id);
                List<Integer> actionIds = actionMenuPermissionDTO.getActionIds();
                if (actionIds != null) {//不为空
                    for (Integer action_id : actionIds) {
                        for (NodeDTO node : nodeList) {
                            if (node.getTags().equals(action_id)) {//遍历id和节点，把id一致的节点激活
                                node.nodeChecked();
                            }
                        }
                    }
                } else {
                    System.out.println("empty list, new setting");
                }//空表提示
            } else {
                System.out.println("id = null , node only.");
            }
            List actionNodeList = new ArrayList();
            actionNodeList.add(nodeDTO);

            Object[] dataPack = new Object[3];//包装容器
            dataPack[0] = "PermissonName";//第一位置为 string
            dataPack[1] = 14;//第二位置为 int
            dataPack[2] = actionNodeList;//第三位置为行为树状节点链

            return R.success().setData(dataPack);
        } catch (RuntimeException e) {
            log.error("菜单行为数据出错",e);
            return R.failure("菜单行为数据出错");
        }
    }

    @PostMapping(value = "/menuList/treeCheck_edit", produces = "application/json")
    @PreAuthorize("hasAuthority('38-23')")
    public R<String> postMenuActionTreeCheckEditAction(@RequestBody ActionMenuPermissionDTO actionMenuPermissionDTO){
        try {
            Integer menuId = actionMenuPermissionDTO.getMenuId();
            List<Integer> actionIds = actionMenuPermissionDTO.getActionIds();
            Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
            map.put(menuId, actionIds);
            menuService.assignActionToMenu(map);
            return R.success();
        } catch (RuntimeException e) {
            log.error("分配行为到菜单失败",e);
            return R.failure("分配行为到菜单失败");
        }
    }

    @GetMapping("/menuList/toEdit")
    @PreAuthorize("hasAuthority('38-21')")
    public R<MenuDTO> getMenuEditInfo(@RequestParam("id") int id){
        try {
            log.debug("依id查询菜单："+id);
            MenuDTO menuDTO = menuService.selectById(id);
            return R.success().setData(menuDTO);
        } catch (RuntimeException e) {
            log.error("依id查询菜单失败",e);
            return R.failure("依id查询菜单失败:"+id);
        }
    }

    @PostMapping("/menuList/editMenu")
    @PreAuthorize("hasAuthority('38-23')")
    public R<String> postMenuEditAction(Menu menu, String parentMenu, Integer parentMenuId){
        try {
            Menu parent = new Menu();//做个空壳对象
            parent.setId(parentMenuId);//只存id
            parent.setMenuName(parentMenu);
            menu.setParent(parent);//作为parent保存进数据库
            menuService.saveOrUpdate(menu);
            return R.success();
        } catch (RuntimeException e) {
            log.error("更新菜单失败");
            return R.failure("更新菜单失败");
        }
    }


    @PostMapping("/menuList/deleteMenu")
    @PreAuthorize("hasAuthority('38-24')")
    public R<String> postMenuDeleteAction(@RequestBody Integer id){
        try {
            System.out.println("priv menuList menu delete action");
            List idList = new ArrayList();
            idList.add(id);
            if (menuService.deleteMenu(idList) != -1) {
                return R.success();
            } else {
                return R.failure("SQL执行成功，但无受影响的记录");
            }
        } catch (RuntimeException e) {
            log.error("依id删除菜单失败",e);
            return R.failure("依id删除菜单失败");
        }
    }


    @GetMapping("/actionList/getTable")
    @PreAuthorize("hasAuthority('39-21')")
    public R<List<ActionDTO>> getActionListTable(@RequestParam("offset") int offset){
        try {
            List<ActionDTO> actionDTOS = actionService.selectAllAction(offset);
            return R.success().setData(actionDTOS);
        } catch (RuntimeException e) {
            log.error("加载所有行为失败", e);
            return R.failure("加载所有行为失败");
        }
    }

    @GetMapping(value = "/actionList/toEdit", produces = "application/json")
    @PreAuthorize("hasAuthority('39-21')")
    public R<ActionDTO> getActionEditInfo(@RequestParam("id") int id){
        //前端按下编辑键时向前端传对应id的组信息
        try {
            log.debug("依id查询行为："+id);
            ActionDTO actionDTO = actionService.selectById(id);
            return R.success().setData(actionDTO);
        } catch (RuntimeException e) {
            log.error("依id查询行为失败", e);
            return R.failure("依id查询行为失败");
        }
    }

    @PostMapping(value = "/actionList/edit", produces = "application/json")
    @PreAuthorize("hasAuthority('39-23')")
    public R<String> postActionEditAction(Action action){//前端按下编辑键时向前端传对应id的组信息
        try {
            log.debug("更新行为");
            if(actionService.saveOrUpdate(action) > 0) {
                log.debug("更新行为成功");
                return R.success();
            } else {
                log.warn("SQL更新成功，但是没有影响DB中的记录，请检查");
                return R.failure("SQL更新成功，但无影响的记录");
            }
        } catch (RuntimeException e) {
            log.error("更新行为失败", e);
            return R.failure("更新行为失败");
        }
    }

    @PostMapping(value = "/actionList/add", produces = "application/json")
    @PreAuthorize("hasAuthority('39-22')")
    public R<String> postActionAddAction(Action action){//前端按下编辑键时向前端传对应id的组信息
        try {
            log.debug("添加行为");
            if(actionService.saveOrUpdate(action) > 0) {
                log.debug("新增行为成功");
                return R.success();
            } else {
                log.warn("SQL执行成功，但是没有影响DB中的记录，请检查");
                return R.failure("SQL执行成功，但无影响的记录");
            }
        } catch (RuntimeException e) {
            log.error("新行行为失败", e);
            return R.failure("新增行为失败");
        }
    }

    @PostMapping(value = "/actionList/delete", produces = "application/json")
    @PreAuthorize("hasAuthority('39-24')")
    public R<String> postActionDeleteAction(@RequestBody Integer id){
        try {
            log.debug("依ID删除行为:"+id);
            List deleteList = new ArrayList<>();
            deleteList.add(id);
            if (actionService.deleteAction(deleteList) != -1) {//返回值为-1说明删除过程中出错
                return R.success();
            } else {
                return R.failure("依ID删除行为失败");
            }
        } catch (RuntimeException e) {
            log.error("依ID删除行为失败", e);
            return R.failure("依ID删除行为失败");
        }
    }

    @PostMapping(value = "/actionList/deleteByGroup", produces = "application/json")
    @PreAuthorize("hasAuthority('39-24')")
    public R<String> postActionDeleteByGroupsAction(@RequestBody List<Serializable>  idList){
        try {
            log.debug("批量删除行为: "+idList);
            if (actionService.deleteAction(idList) != -1) {
                //返回值为-1说明删除过程中出错
                return R.success();
            } else {
                return R.failure("SQL执行成功，但无受影响的记录");
            }
        } catch (RuntimeException e) {
            log.error("批量删除行为失败", e);
            return R.failure("批量删除行为失败");
        }
    }

}
