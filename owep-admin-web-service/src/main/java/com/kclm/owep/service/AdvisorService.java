package com.kclm.owep.service;

import com.kclm.owep.dto.AllUserDto;

import java.util.List;

public interface AdvisorService {

    List<AllUserDto> getAdvisorUserList(int userType, int isDelete1);

}
