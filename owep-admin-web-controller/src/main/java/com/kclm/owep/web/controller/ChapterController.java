package com.kclm.owep.web.controller;

import com.kclm.owep.dto.ChapterDTO;
import com.kclm.owep.entity.Chapter;
import com.kclm.owep.entity.Course;
import com.kclm.owep.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/training/chapter")
public class ChapterController {
    @Autowired
    CourseService courseService;

    /**
     * 获取所有章
     * @param courseId
     * @return
     */
    @RequestMapping(value = "/getAllChapter",produces = "application/json")
    @ResponseBody
    public Object getAllChapter(Integer courseId){
        System.out.println("============================================="+courseId);
        List<ChapterDTO> allChapterByCourseId = courseService.findAllChapterByCourseId(courseId);
        return allChapterByCourseId;
    }

    /**
     * 添加章
     * @param chapterNumber
     * @param chapterName
     * @param chapterStatus
     * @param chapterDesc
     * @param courseId
     * @return
     */
    @RequestMapping("/saveChapter")
    @ResponseBody
    //public String savaChapter(@RequestBody Chapter chapter){
    public String saveChapter(String chapterNumber, String chapterName, Integer chapterStatus,String chapterDesc, Integer courseId){
        System.out.println("***************************************"+courseId);
        Course course = courseService.selectById(courseId);
        Chapter chapter = new Chapter();
        chapter.setChapterNumber(chapterNumber);
        System.out.println("*********************************"+chapter.getChapterNumber());
        chapter.setChapterName(chapterName);
        chapter.setChapterStatus(chapterStatus);
        chapter.setCourse(course);
        chapter.setChapterDesc(chapterDesc);
        chapter.setIsDelete(1);
        courseService.addChapter(chapter);
        return "success";

    }

    /**
     * 修改章
     * @param chapter
     * @return
     */
    @RequestMapping("/updateChapter")
    @ResponseBody
    public String updateChapter(@RequestBody Chapter chapter){
        courseService.alterChapter(chapter);
        return "success";
    }

    /**
     * 通过id删除章
     * @param id
     * @return
     */
    @RequestMapping("/deleteChapterById")
    @ResponseBody
    public String deleteChapterById(@RequestParam("id" ) Integer id){
        courseService.deleteChapterById(id);
        return "success";
    }

}
