package com.kclm.owep.web.controller;

import com.kclm.owep.dto.AllUserDto;
import com.kclm.owep.service.UserService;
import com.kclm.owep.utils.constant.Constant;
import com.kclm.owep.web.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user-management")
public class TeacherManagementController {
    @Autowired
    private UserService userService;

    // 老师类型
    int teacherType = Constant.TYPE_TEACHER;

    //是否删除 1 未删除
    int isDelete1 = Constant.LOGIC_DELETE_1;

    /**
     * 获取老师列表
     *
     * @return 包含老师列表信息的响应对象
     */
    @GetMapping(value = "/teacher-user", produces = "application/json")
    public R getTeacherUserList() {
        List<AllUserDto> teacherUserList = userService.getAllUserList(teacherType, isDelete1);
        return R.success(teacherUserList);
    }

    /**
     * 根据用户名或真实姓名模糊查询老师用户列表
     *
     * @param userName 用户名，可以为null
     * @param realName 真实姓名，可以为null
     * @return 包含老师用户信息的列表，若查询成功则返回包含管理员用户信息的列表，否则返回空列表
     */
    @PostMapping(value = "/search-teacher-users-by-keywords", produces = "application/json")
    public R searchAdminUserByKeywords(String userName, String realName) {
        if (userName != null && realName == null) {
            List<AllUserDto> adminUserList = userService.getAdminUserByUserName(userName, isDelete1, teacherType);
            return R.success(adminUserList);
        } else if (userName == null && realName != null) {
            List<AllUserDto> adminUserList = userService.getAdminUserByRealName(realName, isDelete1, teacherType);
            return R.success(adminUserList);
        } else {
            List<AllUserDto> adminUserList = userService.getAdminUserByKeywords(userName, realName, isDelete1, teacherType);
            return R.success(adminUserList);
        }

    }

}
