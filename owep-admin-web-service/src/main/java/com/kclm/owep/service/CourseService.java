/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.service;

import com.kclm.owep.dto.ChapterDTO;
import com.kclm.owep.dto.CourseDTO;
import com.kclm.owep.dto.SectionDTO;
import com.kclm.owep.entity.Chapter;
import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.Section;
import com.kclm.owep.entity.SectionVideo;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/13 10:16
 *@Description 课程业务接口
 *
 */
public interface CourseService {

    /**
     * 查找所有课程
     * @return
     */
    List<CourseDTO> findAllCourse();

    /**
     * 通过课程名查询课程
     */
    List<CourseDTO> findCourseByCourseName(String courseName);

    /**
     * 添加课程
     * @param course
     * @return
     */
    int addCourse(Course course);

    /**
     * 修改课程
     * @param course
     * @return
     */
    int alterCourse(Course course);

    /**
     * 通过id 删除课程
     * @param id
     * @return
     */
    int deleteCourseById(Serializable id);

    /**
     * 通过ids 删除多个课程
     * @param id
     * @return
     */
    int deleteCourseByIds(List<Serializable> id);


    /**
     * 分页查询 课程
     * @param page
     * @param size
     * @return
     */
    List<CourseDTO> findAllCourseByPaging(int page, int size);


    /**
     * 分页查询 章
     * @param page
     * @param size
     * @return
     */
    List<ChapterDTO> findAllChapterByPaging(Serializable courseId, int page, int size);


    /**
     * 分页查询 节
     * @param chapterId
     * @param page
     * @param size
     * @return
     */
    List<SectionDTO> findAllSectionByPaging(Serializable chapterId, int page, int size);

    /**
     * 通过课程id 查询所有的章
     */
    List<ChapterDTO> findAllChapterByCourseId(Serializable id);

    /**
     * 修改章
     * @param chapter
     * @return
     */
    int alterChapter(Chapter chapter);

    /**
     * 通过ChapterId,添加章
     * @param chapter
     * @return
     */
    int addChapter(Chapter chapter);
    /**
     * 通过id删除章
     *
     */
    int deleteChapterById(Serializable id);
    /**
     * 添加 节
     * @param section
     * @return
     */
    int addSection(Section section);

    /**
     * 修改节
     * @param section
     * @return
     */
    int alterSection(Section section);

    /**
     * 通过节id 删除节
     * @param id
     * @return
     */
    int deleteSection(Serializable id);

    /**
     * 给节 绑定视频
     * @param sectionVideo
     * @return
     */
    int addSectionVideo(SectionVideo sectionVideo);

    Course selectById(Serializable id);


    int activate(Integer id);
    int deactivate(Integer id);
    /**
     * @author zhang_hy
     * @date 2020-12-2 16:47
     * @For  根据id查询课程
     */
    Course findCourseById(Serializable id);

    /**
     * @author zhang_hy
     * @date 2020-12-2 17:29
     * @For 根据id查询章节
     */

    List<Section> selectAllById(Serializable id);
    //

    Course findByCourseName(String name);


}
