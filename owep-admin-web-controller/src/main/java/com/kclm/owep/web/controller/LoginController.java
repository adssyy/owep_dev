package com.kclm.owep.web.controller;


import com.kclm.owep.dto.MenuDTO;
import com.kclm.owep.dto.UserDto;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.service.MenuService;
import com.kclm.owep.service.PermissionService;
import com.kclm.owep.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/getMenu", produces = "application/json")
    //@PreAuthorize("hasAuthority('38-21')")
    public Object getMenu(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();//通过security 过滤器链得到目前用户凭证
        //通过authentication可以获取name,也可以获取 authorities的集合
        String name = authentication.getName();
        log.debug("---> 根据从SecurityContextHolder中取出来的认证信息来获取用户名："+name);

        //由用户name获取permissionId
        UserDto userDto = userService.selectByName(name);
        Set<Permission> permissionList = new HashSet<>(userService.getPermissionListByUserId(userDto.getId()));//使用set筛除重复元素
        //这里做一下判断，如果permisstionList为空，则没有必要执行下面的代码了
        if(CollectionUtils.isEmpty(permissionList)) {
            //
            log.debug("用户{}没有任何的权限",name);
            return new Object[0];
        }
        //
        Set<Integer> permissionIds = new HashSet<>();//以数组形式提取权限id
        permissionList.forEach(permission -> permissionIds.add(permission.getId()));
        //
        log.debug("已获得用户"+authentication.getName()+"所有权限id:"+permissionIds);
        //
        Set<Integer> menuIds = new HashSet<>();
        permissionIds.forEach(permId-> menuIds.addAll(permissionService.selectMenuByPermissionId(permId).getMenuIds()));//由权限到菜单
        //判断是否分配了菜单
        if(CollectionUtils.isEmpty(menuIds)) {
            //
            log.debug("用户{}没有分配任何的菜单",name);
            return new Object[0];
        }
        //
        Set<MenuDTO> menuSet = new HashSet<>();
        menuIds.forEach(menuId -> {
            MenuDTO menuDTO = menuService.selectById(menuId);
            List<MenuDTO> subMenus = menuDTO.getSubMenus();
            if (subMenus!=null&&subMenus.size()>0){//查询的【菜单】包括二级菜单，检查子菜单集排除二级菜单
                menuSet.add(menuDTO);//存入
            }
        });
        //返回
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("menuIds", menuIds);
        resultMap.put("menus",menuSet);
        //
        return resultMap;
    }

}
