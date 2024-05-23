package com.kclm.owep.web.security;

import com.kclm.owep.dto.ActionMenuPermissionDTO;
import com.kclm.owep.dto.UserDto;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.service.ActionService;
import com.kclm.owep.service.MenuService;
import com.kclm.owep.service.PermissionService;
import com.kclm.owep.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.locks.Lock;

/***
 * By:Artherine
 * Date:20.10.24
 * For:用户认证与授权绑定
 */

@Service
@Slf4j
public class SpringDataUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private ActionService actionService;
    @Autowired
    private MenuService menuService;

    /**
     * 根据用户名加载用户信息
     *
     * @param name 用户名
     * @return 加载到的用户信息
     * @throws UsernameNotFoundException 如果用户名不存在，则抛出此异常
     * @throws LockedException 如果用户状态为禁用，则抛出此异常
     */
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        System.out.println("==> 登录的用户名："+name);
        UserDto userDto = userService.selectByName(name);
        //判断用户是否存在
        if(userDto == null) {
            log.warn("用户名不存在: {}", name);
            throw new UsernameNotFoundException("用户【"+name+"】不存在");
        }
        //判断用户的状态是否是禁用,其中，0表示禁用
        if(userDto.getUserStatus() == 0) {
            log.warn("用户{}的状态已禁用",name);
            throw new LockedException("用户【"+name+"】的状态已禁用");
        }
        //构建UserDetails对象
        UserDetails user = User.withUsername(userDto.getUserName())
                .password(userDto.getUserPwd())
                .authorities(getUserAuthorities(userDto.getId())).build();
        //刷新用户登录时间
        userService.refreshLoginTime(userDto.getId());
        //返回
        return user;
    }

    /**
     * 根据用户ID获取用户权限列表
     *
     * @param userId 用户ID
     * @return 用户权限列表
     */
    public List<GrantedAuthority> getUserAuthorities(Integer userId) {
        String userAuthorityInfo = userService.getUserAuthorityInfo(userId);
        //采用,号分隔 -》 转换成集合  13-21,13-22,15-21,15-24,......
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(userAuthorityInfo);
        //
        log.debug("用户{}拥有的权限是：{}\n", userId, grantedAuthorities);
        //
        return grantedAuthorities;
    }
}
