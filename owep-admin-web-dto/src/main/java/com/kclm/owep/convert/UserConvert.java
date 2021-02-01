package com.kclm.owep.convert;

import com.kclm.owep.dto.UserDto;
import com.kclm.owep.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    @Mapping(target = "id",source = "id")
    @Mapping(target = "userName",source = "userName")
    @Mapping(target = "userPwd",source = "userPwd")
    UserDto entityToDTO(User user);

    @Mapping(target = "id",source = "id")
    @Mapping(target = "userName",source = "userName")
    @Mapping(target = "userPwd",source = "userPwd")
    User updateEntityFromDto(UserDto userDto);
}
