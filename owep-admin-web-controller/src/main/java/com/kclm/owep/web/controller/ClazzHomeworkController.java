/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.web.controller;

import com.kclm.owep.dto.ChapterDTO;
import com.kclm.owep.dto.ClazzDTO;
import com.kclm.owep.dto.CourseDTO;
import com.kclm.owep.dto.HomeworkDTO;
import com.kclm.owep.entity.*;
import com.kclm.owep.service.ClazzService;
import com.kclm.owep.service.CourseService;
import com.kclm.owep.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/*****************
 *
 * @author tanj
 * @date 2020/6/28 21:45
 * @version v1.0
 * @description 布置作业 功能具体控制层
 *
 */
@RestController
@RequestMapping("clazz")
public class ClazzHomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ClazzService clazzService;

    private static final String FILE_UPLOAD_DIR = "D:\\szkj";

    @RequestMapping(value = "allHomework",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<HomeworkDTO> list(){

        return this.homeworkService.selectAll();
    }

    @RequestMapping(value = "saveHomework",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public String save(Homework homework, Integer clazzId, Integer courseId, Integer chapterId, Integer sectionId, MultipartFile workFile){

        //1.完成文件的上传
        final String originalFilename = workFile.getOriginalFilename();
        if (originalFilename != null && !originalFilename.equals("")){
            //生成一个新的文件名
            String fileName = UUID.randomUUID().toString();
            //获取原来文件的扩展名
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            fileName += suffix;
            //IO流操作
            try {
                workFile.transferTo(new File(FILE_UPLOAD_DIR + File.separatorChar + fileName));
                System.out.println("上传成功，文件名为" + fileName);
                //
            } catch (IOException e) {
                e.printStackTrace();
                //...
            }
            homework.setWorkFileName(fileName);
        }

        Clazz clazz = new Clazz();
        clazz.setId(clazzId);
        Course course = new Course();
        course.setId(courseId);
        Chapter chapter = new Chapter();
        chapter.setId(chapterId);
        Section section = new Section();
        section.setId(sectionId);
        homework.setClazz(clazz);
        homework.setCourse(course);
        homework.setChapter(chapter);
        homework.setSection(section);
        if (this.homeworkService.save(homework) > 0){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }
    @RequestMapping(value = "deleteHomework",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String delete(Integer id){

        if (this.homeworkService.deleteById(id) > 0){
            return "成功";
        }else {
            return "失败";
        }

    }

    @RequestMapping(value = "selectByCourseId",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<HomeworkDTO> selectByCourseId(Integer courseId){
        return this.homeworkService.selectByCourseId(courseId);
    }

    @RequestMapping(value = "updateHomework",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String update(Homework homework, Integer clazzId, Integer courseId, Integer chapterId, Integer sectionId, MultipartFile workFile){

        //1.完成文件的上传
        final String originalFilename = workFile.getOriginalFilename();
        if (originalFilename != null && !originalFilename.equals("")){
            //生成一个新的文件名
            String fileName = UUID.randomUUID().toString();
            //获取原来文件的扩展名
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            fileName += suffix;
            //IO流操作
            try {
                workFile.transferTo(new File(FILE_UPLOAD_DIR + File.separatorChar + fileName));
                System.out.println("上传成功，文件名为" + fileName);
                //
            } catch (IOException e) {
                e.printStackTrace();
                //...
            }
            homework.setWorkFileName(fileName);
        }

        Clazz clazz = new Clazz();
        clazz.setId(clazzId);
        Course course = new Course();
        course.setId(courseId);
        Chapter chapter = new Chapter();
        chapter.setId(chapterId);
        Section section = new Section();
        section.setId(sectionId);
        homework.setClazz(clazz);
        homework.setCourse(course);
        homework.setChapter(chapter);
        homework.setSection(section);
        if (this.homeworkService.update(homework) > 0){
            return "成功";
        }else {
            return "失败";
        }
    }

    @RequestMapping(value = "deleteSelectHomework",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String deleteSelect(@RequestBody List<Integer> idList){

        List<Serializable> list = new ArrayList<>();
        for (Integer id:idList){
            list.add(id);
        }
        if (this.homeworkService.deleteSelect(list)> 0){
            return "删除成功！";
        }else {
            return "删除失败！";
        }
    }

    @RequestMapping(value = "toUpdateHomework",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Homework toUpdate(Integer id){
        return homeworkService.toUpdate(id);
    }

    @RequestMapping(value = "selectAllCourse",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Map selectAllCourse(){
        List<CourseDTO> allCourse = this.courseService.findAllCourse();
        Map map = new HashMap();
        map.put("value",allCourse);
        return map;
    }

    @RequestMapping(value = "selectAllClass",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Map selectAllClass(){
        List<ClazzDTO> clazzDTOS = this.clazzService.selectAll();
        Map map = new HashMap();
        map.put("value",clazzDTOS);
        return map;
    }

    @RequestMapping(value = "selectChapterByCourseId",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Map selectChapterByCourseId(Integer courseId){
        List<ChapterDTO> chapterDTOS = this.courseService.findAllChapterByCourseId(courseId);
        Map map = new HashMap();
        map.put("value",chapterDTOS);
        return map;
    }

    @RequestMapping(value = "selectSectionByChapterId",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Map selectSectionByChapterId(Integer chapterId){
        List<Section> sections = this.courseService.selectAllById(chapterId);
        Map map = new HashMap();
        map.put("value",sections);
        return map;
    }
}
