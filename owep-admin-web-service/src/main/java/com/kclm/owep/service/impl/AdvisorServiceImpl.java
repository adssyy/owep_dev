package com.kclm.owep.service.impl;

import com.kclm.owep.convert.UserConvert;
import com.kclm.owep.dto.AllUserDto;
import com.kclm.owep.entity.User;
import com.kclm.owep.mapper.UserMapper;
import com.kclm.owep.service.AdvisorService;
import com.kclm.owep.utils.util.GetGroupsAndRoleUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class AdvisorServiceImpl implements AdvisorService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserConvert userConvert;



    /**
     * 获取咨询师列表
     *
     * @param userType 用户类型
     * @param isDelete1 是否删除标志，1表示未删除，0表示已删除
     * @return 咨询师列表的DTO对象集合
     */
    @Override
    public List<AllUserDto> getAdvisorUserList(int userType, int isDelete1) {
        List<User> advisorUserList = userMapper.getAdminUser(userType, isDelete1);
        System.out.println("List<User>>:===>" + advisorUserList);
        List<AllUserDto> allAdvisorUserLists = userConvert.toAllUserDto(advisorUserList);
        System.out.println("List<allUserDto>:===>" + allAdvisorUserLists);

        List<AllUserDto> allAdvisorUserList = GetGroupsAndRoleUtil.getGroupsAndRole(allAdvisorUserLists,userMapper);
        log.debug("adminUserLists======>" + allAdvisorUserList);

        return allAdvisorUserList;
    }
}
