/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.service.impl;

import com.github.pagehelper.PageHelper;
import com.kclm.owep.dto.ChapterDTO;
import com.kclm.owep.dto.CourseDTO;
import com.kclm.owep.dto.SectionDTO;
import com.kclm.owep.entity.*;
import com.kclm.owep.mapper.ChapterMapper;
import com.kclm.owep.mapper.CourseMapper;
import com.kclm.owep.mapper.SectionMapper;
import com.kclm.owep.mapper.SectionVideoMapper;
import com.kclm.owep.service.CourseService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/14 16:40
 *@Description TODO
 *
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    ChapterMapper chapterMapper;

    @Autowired
    SectionMapper sectionMapper;

    @Autowired
    SectionVideoMapper sectionVideoMapper;

    @Autowired
    MapperFactory mapperFactory;

    @Override
    public List<CourseDTO> findAllCourse() {
        List<Course> courses = courseMapper.selectAll();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();

        List<CourseDTO> list = mapperFacade.mapAsList(courses, CourseDTO.class);

        return mapperFacade.mapAsList(courses, CourseDTO.class);
    }

    /**
     * 通过课程名查询课程
     * @param courseName
     * @return
     */
    @Override
    public List<CourseDTO> findCourseByCourseName(String courseName) {
        List<Course> courses = courseMapper.selectByCourseName(courseName);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(courses, CourseDTO.class);
    }

    @Override
    public int addCourse(Course course) {
       return courseMapper.save(course);
    }

    /**
     * 修改课程信息
     * @param course
     * @return
     */
    @Override
    public int alterCourse(Course course) {
      return courseMapper.update(course);
    }

    /**
     * 通过id 删除课程
     * @param id
     * @return
     */
    @Override
    public int deleteCourseById(Serializable id) {
       return courseMapper.deleteById(id);
    }

    /**
     * 删除多个课程
     * @param id
     * @return
     */
    @Override
    public int deleteCourseByIds(List<Serializable> id) {
        return courseMapper.deleteSelect(id);
    }

    /**
     * 分页查询 课程
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<CourseDTO> findAllCourseByPaging(int page, int size) {
        PageHelper.startPage(page, size);
        List<Course> courses = courseMapper.selectAll();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
       return mapperFacade.mapAsList(courses, CourseDTO.class);
    }

    /**
     * 分页查询所有的章
     * @param courseId
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<ChapterDTO> findAllChapterByPaging(Serializable courseId, int page, int size) {
        PageHelper.startPage(page, size);
        List<Chapter> chapters = chapterMapper.selectAllById(courseId);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
       return mapperFacade.mapAsList(chapters, ChapterDTO.class);
    }

    /**
     * @param chapterId
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<SectionDTO> findAllSectionByPaging(Serializable chapterId, int page, int size) {
        PageHelper.startPage(page, size);
        List<Section> sections = sectionMapper.selectAllById(chapterId);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
       return mapperFacade.mapAsList(sections, SectionDTO.class);
    }

    /**
     * 通过课程id 查询所有的章   不分页
     * @param id
     * @return
     */
    @Override
    public List<ChapterDTO> findAllChapterByCourseId(Serializable id) {
        List<Chapter> chapters = chapterMapper.selectAllById(id);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(chapters, ChapterDTO.class);
    }

    /**
     * 修改章
     * @param chapter
     * @return
     */
    @Override
    public int alterChapter(Chapter chapter) {
        return chapterMapper.update(chapter);
    }

    /**
     * 添加章
     * @param chapter
     * @return
     */
    @Override
    public int addChapter(Chapter chapter) {
        return chapterMapper.save(chapter);
    }

    /**
     * 添加节
     * @param section
     * @return
     */
    @Override
    public int addSection(Section section) {
        return sectionMapper.save(section);
    }

    /**
     * 修改节
     * @param section
     * @return
     */
    @Override
    public int alterSection(Section section) {
        return sectionMapper.update(section);
    }

    /**
     * 删除节
     * @param id
     * @return
     */
    @Override
    public int deleteSection(Serializable id) {
        return sectionMapper.deleteById(id);
    }

    /**
     * 节中绑定视频
     * @param sectionVideo
     * @return
     */
    @Override
    public int addSectionVideo(SectionVideo sectionVideo) {
        return sectionVideoMapper.save(sectionVideo);
    }

    @Override
    public Course selectById(Serializable id) {
        return courseMapper.selectById(id);
    }

    @Override
    public int deleteChapterById(Serializable id) {
        return chapterMapper.deleteById(id);
    }


    @Override
    public int activate(Integer id) {
        try{
            Course course = courseMapper.selectById(id);
            course.setCourseStatus(1);
            courseMapper.update(course);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deactivate(Integer id) {
        try{
            Course course = courseMapper.selectById(id);
            course.setCourseStatus(0);
            courseMapper.update(course);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public Course findCourseById(Serializable id) {
        return courseMapper.selectById(id);
    }

    @Override
    public List<Section> selectAllById(Serializable id) {
        return sectionMapper.selectAllById(id);
    }


}
