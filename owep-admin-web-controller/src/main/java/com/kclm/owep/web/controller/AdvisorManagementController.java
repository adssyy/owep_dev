package com.kclm.owep.web.controller;

import com.kclm.owep.dto.AllUserDto;
import com.kclm.owep.service.AdvisorService;
import com.kclm.owep.service.TeacherService;
import com.kclm.owep.service.UserService;
import com.kclm.owep.utils.constant.Constant;
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
public class AdvisorManagementController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdvisorService advisorService;


    // 咨询师类型
    int advisorType = Constant.TYPE_SALSEMAN;

    //是否删除 1 未删除
    int isDelete1 = Constant.LOGIC_DELETE_1;

    @GetMapping(value = "/advisor-user", produces = "application/json")
    public R getTeacherUserList() {
        List<AllUserDto> teacherUserList = advisorService.getAdvisorUserList(advisorType, isDelete1);
        return R.success(teacherUserList);
    }

}
