package com.kclm.owep.convert;

import com.kclm.owep.dto.PlanManagerCourseDTO;
import com.kclm.owep.entity.PlanManagerCourse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.factory.Mappers;

@Mapper
public interface PlanManagerCourseConvert {
    PlanManagerCourseConvert INSTANCE = Mappers.getMapper(PlanManagerCourseConvert.class);

    @Mapping(target = "planNumber",source = "planManager.planNumber")
    @Mapping(target = "courseName",source = "course.courseName")
    @Mapping(target = "stageNum",source = "stageNum")
    @Mapping(target = "stageName",source = "stageName")
    @Mapping(target = "courseOrder",source = "courseOrder")
    PlanManagerCourseDTO entityToDTO(PlanManagerCourse planManagerCourse);

    @Mapping(target = "planManager.planNumber",source = "planNumber")
    @Mapping(target = "course.courseName",source = "courseName")
    @Mapping(target = "stageNum",source = "stageNum")
    @Mapping(target = "stageName",source = "stageName")
    @Mapping(target = "courseOrder",source = "courseOrder")
    PlanManagerCourse updateEntityFromDto(PlanManagerCourseDTO peopleDTO);
}
