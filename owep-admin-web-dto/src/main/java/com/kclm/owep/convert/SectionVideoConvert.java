package com.kclm.owep.convert;




import com.kclm.owep.dto.SectionVideoDTO;

import com.kclm.owep.entity.SectionVideo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface SectionVideoConvert {
    SectionVideoConvert INSTANCE = Mappers.getMapper(SectionVideoConvert.class);

    @Mapping(target = "videoName",source = "video.videoName")
    @Mapping(target = "videoLength",source = "video.videoLength")
    @Mapping(target = "sectionId",source = "section.id")
    SectionVideoDTO entityToDTO(SectionVideo sectionVideo);

    @Mapping(target = "video.videoName",source = "videoName")
    @Mapping(target = "video.videoLength",source = "videoLength")
    @Mapping(target = "section.id",source = "sectionId")
    SectionVideo updateEntityFromDto(SectionVideoDTO sectionVideoDTO);
}
