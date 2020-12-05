package com.kclm.owep.convert;

import com.kclm.owep.dto.OrgInstituteDTO;
import com.kclm.owep.entity.OrgInstitute;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrgInstituteConvert {

    OrgInstituteConvert INSTANCE = Mappers.getMapper(OrgInstituteConvert.class);

    @Mapping(target = "instituteId",source = "id")
    OrgInstituteDTO entityToDTO(OrgInstitute entity);

    @Mapping(target = "id",source = "instituteId")
    void updateEntityFromDto(OrgInstituteDTO orgInstituteDTO,@MappingTarget OrgInstitute entity);
}
