package com.kclm.owep.web.controller;

import com.kclm.owep.dto.AdminUserDto;
import com.kclm.owep.service.UserService;
import com.kclm.owep.utils.util.BuildingResultErrorUtil;
import com.kclm.owep.web.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user-management")
public class UserManagementController {

    @Autowired
    private UserService userService;

    /**
     * 获取管理员用户列表
     *
     * @return 返回管理员用户列表的响应结果
     */
    @GetMapping(value = "/admin-user", produces = "application/json")
    public R getAdminUserList() {
        List<AdminUserDto> adminUserList = userService.getAdminUserList();
        return R.success(adminUserList);
    }

    // TODO  编辑更新管理员用户信息
    @PostMapping(value = "/update-admin-user-info", produces = "application/json")
    public R updateAdminUserInfo(@Valid AdminUserDto adminUserDto, BindingResult bindingResult) {
        System.out.println(adminUserDto.toString());
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            List<String> sortedErrorMessages = BuildingResultErrorUtil.getUpdateAdminUserInfoErrorMessages(fieldErrors);
            // 返回所有错误信息
            return R.failure(sortedErrorMessages.toString());
        } else {
            int updateAdminUserInfo = userService.updateAdminUserInfo(adminUserDto);
            if (updateAdminUserInfo > 0) {
                return R.success();
            } else {
                return R.failure("更新失败");
            }
        }
    }

    /**
     * 添加管理员用户
     *
     * @param adminUserDto  管理员用户信息DTO
     * @param bindingResult 绑定结果对象，用于验证DTO字段
     * @return 返回添加结果，成功返回R.success()，失败返回R.failure()并附带错误信息
     */
    @PostMapping(value = "/add-admin-user", produces = "application/json")
    public R addAdminUser(@RequestBody @Valid AdminUserDto adminUserDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            List<String> sortedErrorMessages = BuildingResultErrorUtil.getUpdateAdminUserInfoErrorMessages(fieldErrors);
            // 返回所有错误信息
            return R.failure(sortedErrorMessages.toString());
        } else {
            int addUser = userService.addUser(adminUserDto);
            if (addUser > 0) {
                return R.success();
            } else {
                return R.failure("添加失败");
            }
        }
    }

    // TODO  模糊查询管理员用户列表
    @PostMapping(value = "/search-users-by-keywords", produces = "application/json")
    public R searchAdminUserByKeywords(String userName, String realName) {
        if (userName != null && realName == null) {
            List<AdminUserDto> adminUserList = userService.getAdminUserByUserName(userName);
            return R.success(adminUserList);
        } else if (userName == null && realName != null) {
            List<AdminUserDto> adminUserList = userService.getAdminUserByRealName(realName);
            return R.success(adminUserList);
        } else {
            List<AdminUserDto> adminUserList = userService.getAdminUserByKeywords(userName, realName);
            return R.success(adminUserList);
        }

    }


    /**
     * 逻辑删除用户
     * 管理员 老师等逻辑删除都调用此接口
     *
     * @param id 用户ID
     * @return 返回删除结果
     */
    @DeleteMapping(value = "/delete-user-by-id/{id}", produces = "application/json")
    public R deleteUserById(@PathVariable Integer id) {
        int deleteUserById = userService.deleteUserById(id);
        if (deleteUserById > 0) {
            return R.success();
        } else {
            return R.failure("删除失败");
        }
    }

    /**
     * 批量逻辑删除用户
     * 逻辑 批量删除用户  管理员 老师等逻辑删除都调用此接口
     *
     * @param idList 待删除用户的ID列表
     * @return 返回操作结果，包括操作是否成功等信息
     * @throws Exception 抛出异常，表示删除过程中发生错误
     */
    @PostMapping(value = "/delete-selected-users", produces = "application/json")
    public R deleteSelectedUsers(@RequestBody List<Integer> idList) {
        int deleteSelectedUsers = userService.deleteSelectedUsers(idList);
        if (deleteSelectedUsers > 0) {
            return R.success();
        } else {
            return R.failure("删除失败");
        }
    }

    /**
     * 更改用户状态
     * 管理员、老师、咨询师都可以调用此接口
     *
     * @param id 用户ID
     * @return R 响应结果，包括操作是否成功等信息
     */
    @PostMapping(value = "/update-user-status", produces = "application/json")
    public R updateUserStatus(Integer id) {
        int status = userService.updateUserStatus(id);
        if (status > 0) {
            return R.success();
        } else {
            return R.failure("更新失败");
        }
    }
}

