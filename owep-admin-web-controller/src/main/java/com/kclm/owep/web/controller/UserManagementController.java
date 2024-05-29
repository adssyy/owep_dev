package com.kclm.owep.web.controller;

import com.kclm.owep.dto.AllUserDto;
import com.kclm.owep.dto.UserGroupAndRoleDto;
import com.kclm.owep.service.UserService;
import com.kclm.owep.utils.constant.Constant;
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

    // 管理员类型
    int adminType = Constant.TYPE_MANAGER;

    // 老师类型
    int teacherType = Constant.TYPE_TEACHER;

    //是否删除 1 未删除
    int isDelete1 = Constant.LOGIC_DELETE_1;

    /**
     * 获取管理员用户列表
     *
     * @return 返回管理员用户列表的响应结果
     */
    @GetMapping(value = "/admin-user", produces = "application/json")
    public R getAdminUserList() {
        List<AllUserDto> adminUserList = userService.getAllUserList(adminType, isDelete1);
        return R.success(adminUserList);
    }


    /**
     * 编辑更新管理员\咨询师用户信息
     *
     * @param allUserDto 管理员用户信息DTO
     * @param bindingResult 数据绑定结果
     * @return 响应结果R，更新成功返回成功状态，更新失败返回失败状态并附带错误信息
     */
    @PostMapping(value = "/update-admin-user-info", produces = "application/json")
    public R updateAdminUserInfo(@Valid AllUserDto allUserDto, BindingResult bindingResult) {
        System.out.println(allUserDto.toString());
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            List<String> sortedErrorMessages = BuildingResultErrorUtil.getUpdateAdminUserInfoErrorMessages(fieldErrors);
            // 返回所有错误信息
            return R.failure(sortedErrorMessages.toString());
        } else {
            int updateAdminUserInfo = userService.updateAdminUserInfo(allUserDto,isDelete1);
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
     * @param allUserDto  管理员用户信息DTO
     * @param bindingResult 绑定结果对象，用于验证DTO字段
     * @return 返回添加结果，成功返回R.success()，失败返回R.failure()并附带错误信息
     */
    @PostMapping(value = "/add-admin-user", produces = "application/json")
    public R addAdminUser(@RequestBody @Valid AllUserDto allUserDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            List<String> sortedErrorMessages = BuildingResultErrorUtil.getUpdateAdminUserInfoErrorMessages(fieldErrors);
            // 返回所有错误信息
            return R.failure(sortedErrorMessages.toString());
        } else {
            int addUser = userService.addUser(allUserDto,adminType);
            if (addUser > 0) {
                return R.success();
            } else {
                return R.failure("添加失败");
            }
        }
    }

    /**
     * 模糊查询管理员用户列表
     *
     * @param userName 用户名（可为null）
     * @param realName 真实姓名（可为null）
     * @return 管理员用户列表，若查询成功则返回包含管理员用户信息的列表，否则返回空列表
     */
    @PostMapping(value = "/search-admin-users-by-keywords", produces = "application/json")
    public R searchAdminUserByKeywords(String userName, String realName) {
        if (userName != null && realName == null) {
            List<AllUserDto> adminUserList = userService.getAdminUserByUserName(userName, isDelete1, adminType);
            return R.success(adminUserList);
        } else if (userName == null && realName != null) {
            List<AllUserDto> adminUserList = userService.getAdminUserByRealName(realName, isDelete1, adminType);
            return R.success(adminUserList);
        } else {
            List<AllUserDto> adminUserList = userService.getAdminUserByKeywords(userName, realName, isDelete1, adminType);
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
        int deleteUserById = userService.deleteUserById(id,isDelete1);
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
        int deleteSelectedUsers = userService.deleteSelectedUsers(idList,isDelete1);
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
        int status = userService.updateUserStatus(id,isDelete1);
        if (status > 0) {
            return R.success();
        } else {
            return R.failure("更新失败");
        }
    }

    /**
     * 获取用户组及所属角色信息
     *
     * @return 包含用户组及所属角色信息的列表
     */
    @PostMapping(value = "/get-user-group-and-role-list", produces = "application/json")
    public R getUserGroupAndRoleList() {
        List<UserGroupAndRoleDto> list = userService.getUserGroupAndRoleList();
        return R.success(list);
    }
}

