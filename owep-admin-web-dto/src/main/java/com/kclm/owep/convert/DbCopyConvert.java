package com.kclm.owep.convert;

import com.kclm.owep.dto.DbCopyDTO;
import com.kclm.owep.entity.DbCopy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DbCopyConvert {

    DbCopyDTO toDbCopyDTO(DbCopy dbCopy);


    List<DbCopyDTO> toDbCopyDTOList(List<DbCopy> dbCopyList);


}
