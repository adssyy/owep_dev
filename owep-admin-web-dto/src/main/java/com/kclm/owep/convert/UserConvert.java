package com.kclm.owep.convert;

import com.kclm.owep.dto.*;
import com.kclm.owep.entity.Group;
import com.kclm.owep.entity.Role;
import com.kclm.owep.entity.User;
import lombok.Data;
import lombok.experimental.Accessors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/********************
 * @author yejf
 * 此接口是基于mapstruct组件技术来完成实体类与DTO之前的映射，包含集合或集合属性都可以。
 */
@Mapper(componentModel = "spring")
public interface UserConvert {

    /** 实例:用spring IOC管理时，此句可以不用写 */
    UserConvert instance = Mappers.getMapper(UserConvert.class);

    /*************************************************************
     *
     * @param user
     * @return
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "userPwd", target = "userPwd")
    @Mapping(source = "status", target = "userStatus")
    UserDto toUserDto(User user);


    List<AdminUserDto> toAdminUserDto(List<User> user);


    @Mapping(target = "sex",expression = "java(genderToSex(user.getGender()))")
//    @Mapping(source = "effectiveDate", target = "dueDate")
    @Mapping(target = "dueDate",expression = "java(timeToDate(user.getEffectiveDate()))")
    @Mapping(target = "lastLoginDate",expression = "java(timeToDate(user.getLastAccessTime()))")
//    @Mapping(source = "lastAccessTime", target = "lastLoginDate")
    public AdminUserDto toAdminUserDto(User user);


    /**
     * 将性别对应的数字转换为性别文字描述
     *
     * @param gender 性别数字，1表示男，0表示女，其他表示未知
     * @return 返回性别文字描述，男、女或未知
     */
    default String genderToSex(Integer gender){
        if(gender == 1){
            return "男";
        }else if(gender == 0){
            return "女";
        }else{
            return "未知";
        }
    }


    /**
     * 将LocalDateTime对象转换为指定格式的日期字符串
     *
     * @param localDateTime 需要转换的LocalDateTime对象
     * @return 转换后的日期字符串，格式为"yyyy-MM-dd HH:mm:ss"
     */
    default String timeToDate(LocalDateTime localDateTime){
        // 定义日期时间格式，应与courseDateAndTimeStr的格式匹配
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss");
        String date = localDateTime.format(formatter);
        return date;
    }


    public RoleDTO toRoleDto(Role role);

    public List<RoleDTO> toRoleDto(List<Role> role);

//    public UserGroupAndRoleDto toUserGroupAndRoleDto(Group group);
//
//    public List<UserGroupAndRoleDto> toUserGroupAndRoleDto(List<Group> group);

}
