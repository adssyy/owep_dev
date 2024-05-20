package com.kclm.owep.web.controller;

import com.kclm.owep.dto.AdminUserDto;
import com.kclm.owep.service.UserService;
import com.kclm.owep.web.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user-management")
public class UserManagementController {

    @Autowired
    private UserService userService;

    @GetMapping(value ="/admin-user", produces = "application/json")

    public R getAdminUserList(){
        List<AdminUserDto> adminUserList = userService.getAdminUserList();
        return R.success(adminUserList);
    }

}

