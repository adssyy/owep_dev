package com.kclm.owep.service.impl;

import com.kclm.owep.convert.ChapterConvert;
import com.kclm.owep.convert.CourseConvert;
import com.kclm.owep.dto.ChapterDTO;
import com.kclm.owep.dto.CourseDTO;
import com.kclm.owep.dto.SectionDTO;
import com.kclm.owep.entity.Chapter;
import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.Section;
import com.kclm.owep.entity.SectionVideo;
import com.kclm.owep.mapper.ChapterMapper;
import com.kclm.owep.mapper.CourseMapper;
import com.kclm.owep.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Autowired
    ChapterMapper chapterMapper;

    @Override
    public List<CourseDTO> findAllCourse() {
        return CourseConvert.INSTANCE.POs2DTOs(courseMapper.selectAll());
    }

    @Override
    public List<CourseDTO> findCourseByCourseName(String courseName) {
        return null;
    }

    @Override
    public int addCourse(Course course) {
        return 0;
    }

    @Override
    public int alterCourse(Course course) {
        return 0;
    }

    @Override
    public int deleteCourseById(Serializable id) {
        return 0;
    }

    @Override
    public int deleteCourseByIds(List<Serializable> id) {
        return 0;
    }

    @Override
    public List<CourseDTO> findAllCourseByPaging(int page, int size) {
        return null;
    }

    @Override
    public List<ChapterDTO> findAllChapterByPaging(Serializable courseId, int page, int size) {
        return null;
    }

    @Override
    public List<SectionDTO> findAllSectionByPaging(Serializable chapterId, int page, int size) {
        return null;
    }

    @Override
    public List<ChapterDTO> findAllChapterByCourseId(Serializable id) {

        return ChapterConvert.INSTANCE.POs2DTOs(chapterMapper.selectAllById(id));
    }

    @Override
    public int alterChapter(Chapter chapter) {
        return 0;
    }

    @Override
    public int addChapter(Chapter chapter) {
        return 0;
    }

    @Override
    public int deleteChapterById(Serializable id) {
        return 0;
    }

    @Override
    public int addSection(Section section) {
        return 0;
    }

    @Override
    public int alterSection(Section section) {
        return 0;
    }

    @Override
    public int deleteSection(Serializable id) {
        return 0;
    }

    @Override
    public int addSectionVideo(SectionVideo sectionVideo) {
        return 0;
    }

    @Override
    public Course selectById(Serializable id) {
        return null;
    }

    @Override
    public int activate(Integer id) {
        return 0;
    }

    @Override
    public int deactivate(Integer id) {
        return 0;
    }

    @Override
    public Course findCourseById(Serializable id) {
       return courseMapper.selectById(id);

    }

    @Override
    public List<Section> selectAllById(Serializable id) {
        return null;
    }

    @Override
    public Course findByCourseName(String name) {
        return courseMapper.findByCourseName(name);
    }

    //


}
