package com.kclm.owep.service;

import com.kclm.owep.dto.AllUserDto;
import com.kclm.owep.dto.OrganizationAndClassDto;

import java.util.List;

public interface TeacherService {

    int updateTeacherUserInfo(AllUserDto allUserDto,int isDelete1);

    List<AllUserDto> getTeacherUserList(int userType, int isDelete1);

    List<OrganizationAndClassDto> getOrganizationAndClassList(Integer isDelete1);

}
