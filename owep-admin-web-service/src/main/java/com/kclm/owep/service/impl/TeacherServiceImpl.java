package com.kclm.owep.service.impl;

import com.kclm.owep.convert.UserConvert;
import com.kclm.owep.dto.AllUserDto;
import com.kclm.owep.dto.ClassDTO;
import com.kclm.owep.dto.OrganizationAndClassDto;
import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.OrgInstitute;
import com.kclm.owep.entity.User;
import com.kclm.owep.mapper.UserMapper;
import com.kclm.owep.service.TeacherService;
import com.kclm.owep.utils.util.GetGroupsAndRoleUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserConvert userConvert;



    /**
     * 更新老师信息
     *
     * @param allUserDto 老师信息DTO
     * @param isDelete1 是否删除标志，1表示未删除，0表示已删除
     * @return 更新成功返回更新的记录数，更新失败返回-1
     * @throws RuntimeException 如果有效日期早于当前日期则抛出异常
     */
    @Override
    public int updateTeacherUserInfo(AllUserDto allUserDto, int isDelete1) {
        User user = new User();
        user.setId(allUserDto.getId());
        user.setRealName(allUserDto.getRealName());
        user.setGender(allUserDto.getSex() == "男" ? 1 : 0);
        user.setUserPhone(allUserDto.getUserPhone());
        user.setUserEmail(allUserDto.getUserEmail());
        String effectiveDate = allUserDto.getDueDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(effectiveDate, formatter);
        LocalDateTime now = LocalDateTime.now();
        if (dateTime.isBefore(now)) {
            throw new RuntimeException("有效日期不能早于当前日期");
        }
        user.setEffectiveDate(dateTime);
        user.setTitle(allUserDto.getTitle());
        user.setStatus(allUserDto.getStatus());
//        if(allUserDto.getChecked() == true){
//
//        }
        user.setEffectiveDate(dateTime);
        log.debug("user====>: " + user);
        int updateInfo = userMapper.upadteTeacherUser(user, isDelete1);
        if (updateInfo > 0) {
            return updateInfo;
        } else {
            return -1;
        }

    }

    /**
     * 获取老师列表
     *
     * @param userType 用户类型
     * @param isDelete1 是否删除标志，1表示未删除，0表示已删除
     * @return 包含老师信息的DTO列表
     */
    @Override
    public List<AllUserDto> getTeacherUserList(int userType, int isDelete1) {
        List<User> teacherUserList = userMapper.getAdminUser(userType, isDelete1);
        System.out.println("List<User>>:===>" + teacherUserList);
        List<AllUserDto> allteacherUserLists = userConvert.toAllUserDto(teacherUserList);
        System.out.println("List<allUserDto>:===>" + allteacherUserLists);

        List<AllUserDto> allteacherUserList = GetGroupsAndRoleUtil.getGroupsAndRole(allteacherUserLists,userMapper);
        log.debug("adminUserLists======>" + allteacherUserList);

        return allteacherUserList;
    }

    /**
     * 获取机构以及对应班级列表
     *
     * @param isDelete1 是否删除标志，1表示未删除，0表示已删除
     * @return 包含机构以及对应班级列表信息的DTO列表
     */
    @Override
    public List<OrganizationAndClassDto> getOrganizationAndClassList(Integer isDelete1) {
        //  获取机构列表
        List<OrgInstitute> orgInstituteLists = userMapper.getAllOrgInstitutes(isDelete1);
        log.debug("orgInstituteLists======>" + orgInstituteLists);
        return orgInstituteLists.stream().map(orgInstituteList -> {
            OrganizationAndClassDto organizationAndClassDto = new OrganizationAndClassDto();
            organizationAndClassDto.setId(orgInstituteList.getId());
            organizationAndClassDto.setOrganizationName(orgInstituteList.getInstituteName());

            //查询机构对应的班级
            List<Course> courseList = userMapper.getCourseListByOrgName(orgInstituteList.getInstituteName(), isDelete1);
            System.out.println("courseList===>" + courseList);
            List<ClassDTO> classDto = courseList.stream().map(course -> {
                ClassDTO classDTO = new ClassDTO();
                classDTO.setId(course.getId());
                classDTO.setClassName(course.getCourseName());
                return classDTO;
            }).collect(Collectors.toList());
            organizationAndClassDto.setChileClassList(classDto);
            log.debug("organizationAndClassDto======>" + organizationAndClassDto);
            return organizationAndClassDto;
        }).collect(Collectors.toList());

    }
}
