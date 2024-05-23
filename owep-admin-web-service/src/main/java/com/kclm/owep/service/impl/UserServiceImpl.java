package com.kclm.owep.service.impl;

import com.kclm.owep.convert.UserConvert;
import com.kclm.owep.dto.*;
import com.kclm.owep.entity.Permission;
import com.kclm.owep.entity.User;
import com.kclm.owep.mapper.UserMapper;
import com.kclm.owep.service.*;
import com.kclm.owep.utils.util.GetCurrentUserNameUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserConvert userConvert;
    @Autowired
    private GroupService groupService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private MenuService menuService;


    /**
     * 根据用户名查询用户信息并转换为UserDto对象返回
     *
     * @param name 用户名
     * @return UserDto类型的用户信息对象，若查询失败则返回null
     */
    @Override
    public UserDto selectByName(String name) {
        try{
            User user = userMapper.selectByName(name);
            log.info("user: {}", user);
            UserDto userDto = userConvert.toUserDto(user);
            log.info("userDto: {}", userDto);
            return userDto;
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 根据用户ID获取用户权限列表
     *
     * @param userId 用户ID
     * @return 用户权限列表
     */
    @Override
    public List<Permission> getPermissionListByUserId(Integer userId) {
        List<Integer> groupIds = userMapper.getGroupId(userId);
        log.debug("用户{}的groupIds是:{}", userId, groupIds);
        Set<Integer> roleIds = new HashSet<>();
        for (Integer groupId : groupIds){
            GroupRoleDTO groupRoleDTO = groupService.selectRolesByGroupId(groupId);
            List<Integer> roleIds1 = groupRoleDTO.getRoleIds();
            if (roleIds1!=null &&roleIds1.size() > 0 ){
                //从用户组id到角色id
                roleIds.addAll(roleIds1);
            }

        }
        log.debug("-- 用户id{}拥有的角色ID是：{}", userId, roleIds);
        List<Integer> permissionIdList = new ArrayList<Integer>();
        for (Integer roleId : roleIds) {
            RolePermissionDTO rolePermissionDTO = roleService.selectPermissionByRoleId(roleId);
            log.debug("---- 角色拥有的权限有：{}", rolePermissionDTO);
            List<Integer> permissionIds = rolePermissionDTO.getPermissionIds();
            if(permissionIds!=null) {
                permissionIdList.addAll(permissionIds);
            }
        }
        //从角色id到权限id
        log.debug("--- persionIdList: {}", permissionIdList);
        List<Permission> permissionList = new ArrayList<Permission>();
        for (Integer permissionId : permissionIdList) {
            PermissionDTO permissionDTO = permissionService.selectById(permissionId);
            permissionList.add(permissionDTO);
        }//由id取权限信息
        log.debug("---- PermissionList: {}",permissionList);
        //返回权限集合
        return permissionList;
    }

    /**
     * 刷新用户登录时间
     *
     * @param userId 用户ID
     * @return 更新成功返回1，更新失败返回-1，发生异常返回-2
     */
    @Override
    public int refreshLoginTime(Integer userId) {

        try{
            //
            User user = userMapper.selectById(userId);
            //
            if(user != null) {
                user.setLastAccessTime(LocalDateTime.now());
                return userMapper.update(user);
            }
            //
            return -1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -2;
    }

    /****************************
     * 根据用户的id来查询出用户的权限，此系统从用户到权限的路径是
     * 用户 -> 用户组 -> 角色 -> 权限 -> 菜单 [Menu]
     *                           \-> 行为 [Action]
     *  本方法把用户拥有的菜单id和行为id以"_"进行拼接，多个之间使用","分隔。如：
     *  13-21,13-22,15-21,15-24,......
     * @param userId
     * @return
     */
    @Override
    public String getUserAuthorityInfo(Integer userId) {
        String result = "";
        //1. 根据用户id来查询出拥有的权限
        Set<Permission> permissionSet = new HashSet<>(this.getPermissionListByUserId(userId));//使用set筛除重复元素
        //2. 判断是否拥有权限
        if(permissionSet.size()>0){
            //创建一个集合来存放权限包含的菜单
            Set<ActionMenuPermissionDTO> actMenuSumSet= new HashSet<>();
            for(Permission perm:permissionSet) {
                Set<ActionMenuPermissionDTO> actionMenuSet = menuService.selectActionByPermissionIdFromAMP(perm.getId());
                actMenuSumSet.addAll(actionMenuSet);
            }
            StringBuilder builder = new StringBuilder();
            //
            for(ActionMenuPermissionDTO am :actMenuSumSet){
                Integer menuId = am.getMenuId();
                Integer actionId = am.getActionId();
                //
                builder.append(menuId).append("-").append(actionId).append(",");
            }
            //删除最后一个,
            builder.deleteCharAt(builder.length()- 1);
            //
            result = builder.toString();
            //
            log.debug("用户："+userId+"拥有的权限列表："+result);
            return result;
        }else{
            System.out.println("用户"+userId+"没有分配任何权限");
        }
        return result;
    }

    /**
     * 根据用户类型查询不同的用户列表
     *
     * @return 返回管理员用户列表的DTO对象集合
     */
    @Override
    public List<AdminUserDto> getAdminUserList() {
        List<User> userList = userMapper.getAdminUser();
        System.out.println("List<User>>:===>" + userList);
        List<AdminUserDto> adminUserList = userConvert.toAdminUserDto(userList);
        System.out.println("List<AdminUserDto>:===>" + adminUserList);
        return adminUserList;
    }


    /**
     * 更新用户状态信息
     *
     * @param userId 用户ID
     * @return 更新成功返回1，更新失败返回0
     * @throws RuntimeException 当用户不存在或尝试修改管理员自己的状态信息时抛出
     */
    @Override
    public int updateUserStatus(Integer userId) {
        User user = userMapper.checkUserExistsById(userId);
        if(user.getUserName() == null){
            throw new RuntimeException("用户不存在");
        }
        String currentUserName = GetCurrentUserNameUtil.getCurrentUserName();
        if(currentUserName.equals(user.getUserName())){
            throw new RuntimeException("不能修改管理员自己的状态信息");
        }
        int status = userMapper.updateUserStatus(userId);
        if(status > 0){
            return 1;
        }else{
            return -1;
        }
    }

    /**
     * 更新管理员用户信息
     *
     * @param adminUserDto 管理员用户信息传输对象
     * @return 更新成功返回更新的记录数，更新失败返回0
     * @throws RuntimeException 当管理员尝试修改自己的状态信息或有效日期早于当前日期时抛出
     */
    @Override
    public int updateAdminUserInfo(AdminUserDto adminUserDto) {
        String currentUserName = GetCurrentUserNameUtil.getCurrentUserName();
        Integer id = adminUserDto.getId();
        User user = new User();
        user.setId(id);
        user.setRealName(adminUserDto.getRealName());
        user.setUserPhone(adminUserDto.getUserPhone());
        user.setUserEmail(adminUserDto.getUserEmail());
        int status = userMapper.getUserStatus(id);
        if(currentUserName.equals(adminUserDto.getUserName()) && status != adminUserDto.getStatus()){
            throw new RuntimeException("不能自己的修改状态信息");
        }
        user.setStatus(adminUserDto.getStatus());
        String gender = adminUserDto.getSex();
        if(gender.equals("男")){
            user.setGender(1);
        }else{
            user.setGender(0);
        }

        String effectiveDate = adminUserDto.getDueDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(effectiveDate, formatter);
        LocalDateTime now = LocalDateTime.now();
        if(dateTime.isBefore(now)){
            throw new RuntimeException("有效日期不能早于当前日期");
        }
        user.setEffectiveDate(dateTime);
        System.out.println(user);
        int updateInfo = userMapper.upadteAdminUser(user);
        if(updateInfo > 0){
            return updateInfo;
        }else{
           return -1;
        }
    }

    /**
     * 根据用户ID逻辑删除用户
     * 逻辑删除用户   管理员 老师等角色的用户都调用此方法
     *
     * @param id 用户ID
     * @return 如果删除成功返回1，否则返回-1
     * @throws RuntimeException 如果用户不存在或者当前用户试图删除自己，则抛出运行时异常
     */
    @Override
    public int deleteUserById(Integer id) {
        String currentUserName = GetCurrentUserNameUtil.getCurrentUserName();
        User user = userMapper.checkUserExistsById(id);
        if(user.getUserName() == null){
            throw new RuntimeException("用户不存在");
        }else if(currentUserName.equals(user.getUserName())){
            throw new RuntimeException("不能删除自己");
        }else{
            int delete = userMapper.deleteById(id);
            if(delete > 0){
                return 1;
            }else{
                return -1;
            }
        }
    }

    /**
     * 添加管理员等用户
     *
     * @param adminUserDto 管理员用户信息DTO
     * @return 添加结果，成功返回add，失败返回-1
     * @throws RuntimeException 当用户名已存在时抛出异常
     */
    @Override
    public int addUser(AdminUserDto adminUserDto) {
        System.out.println("adminUserDto:======================>" + adminUserDto);
        String userName = adminUserDto.getUserName();
        User hasUser = userMapper.selectByName(userName);
        if(hasUser != null){
            throw new RuntimeException("用户名已存在");
        }
        User user = new User();
        user.setUserName(userName);
        user.setRealName(adminUserDto.getRealName());
        user.setUserPhone(adminUserDto.getUserPhone());
        user.setUserEmail(adminUserDto.getUserEmail());
        String gender = adminUserDto.getSex();
        user.setGender(gender.equals("男") ? 1 : 0);
        user.setStatus(adminUserDto.getStatus());
        String effectiveDate = adminUserDto.getDueDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(effectiveDate, formatter);
        user.setEffectiveDate(dateTime);
        System.out.println(user);
        int add = userMapper.addAdminUser(user);
        if(add > 0){
            return add;
        }else{
            return -1;
        }
    }

    // TODO 批量删除管理员 老师等用户   管理员 老师等角色的用户都调用此方法
    @Override
    public int deleteSelectedUsers(List<Integer> idList) {
        if(idList.size() == 0){
            throw new RuntimeException("请选择要删除的用户");
        }
        int delete = userMapper.deleteSelectedUser(idList);
        if(delete > 0){
            return 1;
        }else{
            return -1;
        }
    }

    // TODO 模糊查询管理员

    @Override
    public List<AdminUserDto> getAdminUserByUserName(String userName) {
        List<User> userList = userMapper.selectAdminUserByUserName(userName);
        List<AdminUserDto> adminUserDto = userConvert.toAdminUserDto(userList);
        return adminUserDto;
    }

    @Override
    public List<AdminUserDto> getAdminUserByRealName(String realName) {
        List<User> userList = userMapper.selectAdminUserByRealName(realName);
        List<AdminUserDto> adminUserDto = userConvert.toAdminUserDto(userList);
        return adminUserDto;
    }

    @Override
    public List<AdminUserDto> getAdminUserByKeywords(String userName, String realName) {
        List<User> userList = userMapper.selectAdminUserByUserNameAndRealName(userName,realName);
        List<AdminUserDto> adminUserDto = userConvert.toAdminUserDto(userList);
        return adminUserDto;
    }


}
