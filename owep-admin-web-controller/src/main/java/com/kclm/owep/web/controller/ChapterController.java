package com.kclm.owep.web.controller;

import com.kclm.owep.dto.ChapterDTO;
import com.kclm.owep.dto.SectionVideoDTO;
import com.kclm.owep.entity.*;
import com.kclm.owep.service.CourseService;
import com.kclm.owep.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/training/chapter")
public class ChapterController {
    @Autowired
    CourseService courseService;
    @Autowired
    VideoService videoService;

    private static final String FILE_UPLOAD_DIR = "D:/innerTestVideoServer/resources/";


    /**
     * 获取所有章
     * @param courseId
     * @return
     */
    @RequestMapping(value = "/getAllChapter",produces = "application/json")
    @ResponseBody
    public Object getAllChapter(Integer courseId){
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
        Course course = courseService.selectById(courseId);
        Chapter chapter = new Chapter();
        chapter.setChapterNumber(chapterNumber);
        chapter.setChapterName(chapterName);
        chapter.setChapterStatus(chapterStatus);
        chapter.setCourse(course);
        chapter.setChapterDesc(chapterDesc);
        chapter.setIsDelete(1);
        courseService.addChapter(chapter);
        return "添加成功";

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
        return "修改成功";
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

    /**
     * 添加节
     * @param section
     * @param experimentDucumentFile
     * @param request
     * @return
     */
    @RequestMapping("/addSection")
    @ResponseBody
    public Object addSection(Section section,@RequestParam("file") MultipartFile experimentDucumentFile, HttpServletRequest request ){
        String chapterId = request.getParameter("chapterId");

        Chapter chapter = courseService.selectChapterById(Integer.valueOf(chapterId));
        section.setChapter(chapter);

        if(section.getExperiment()==1) {
            final String originalFilename = experimentDucumentFile.getOriginalFilename();

            //生成薪的文件名=-----选做
            String fileName = UUID.randomUUID().toString();
            //获取原来的扩展名
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            fileName += suffix;
            section.setExperimentDucumentFile(fileName);
            //IO流操作
            try {
                experimentDucumentFile.transferTo(new File(FILE_UPLOAD_DIR + File.separatorChar + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //持久化文件
        section.setIsDelete(1);
        section.setLookVideoStatus(1);
        courseService.addSection(section);

        return new Result("200","ok");
    }

    /**
     * 通过id获得节
     * @param id
     * @return
     */
    @RequestMapping(value = "/getSectionById",produces = "application/json")
    @ResponseBody
    public Object getSectionById(Integer id){
        List<Section> sections = courseService.selectAllById(id);
        return sections;
    }

    /**
     * 修改节
     * @param section
     * @param experimentDucumentFile
     * @param request
     * @return
     */
    @RequestMapping("/updateSection")
    @ResponseBody
    public Object updateSection(Section section,@RequestParam("file") MultipartFile experimentDucumentFile, HttpServletRequest request ){
        String chapterId = request.getParameter("alterChapterId");

        Chapter chapter = courseService.selectChapterById(Integer.valueOf(chapterId));
        section.setChapter(chapter);


        if(section.getExperiment()==1) {
            final String originalFilename = experimentDucumentFile.getOriginalFilename();
            section.setExperimentDucumentFile(originalFilename);
            //生成薪的文件名=-----选做
            String fileName = UUID.randomUUID().toString();
            //获取原来的扩展名
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            fileName += suffix;
            //IO流操作
            try {
                experimentDucumentFile.transferTo(new File(FILE_UPLOAD_DIR + File.separatorChar + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //持久化文件
        section.setIsDelete(1);
        courseService.alterSection(section);

        return new Result("200","ok");
    }

    /**
     * 通过id删除节
     * @param id
     * @return
     */
    @RequestMapping("/deleteSectionById")
    @ResponseBody
    public String deleteById(Integer id){
        courseService.deleteSection(id);
        return "success";
    }

    /**
     * 获取所有视频
     * @return
     */
    @RequestMapping(value="/getVideo",produces = "application/json")
    @ResponseBody
    public Object getVideo(){
        List<Video> videos = videoService.selectAll();
        return videos;
    }

    /**
     * 通过节id查找视频
     * @param id
     * @return
     */
    @RequestMapping(value="/getVideoById",produces = "application/json")
    @ResponseBody
    public Object getVideoById(Integer id){
        List<SectionVideoDTO> videos = courseService.selectVideoById(id);

        return videos;
    }

    /**
     * 给节绑定视频
     * @param videoId
     * @param sectionId
     * @return
     */
    @RequestMapping("/addVideoToSection")
    @ResponseBody
    public Object addVideoToSection(Integer videoId,Integer sectionId){
        SectionVideo sectionVideo = new SectionVideo();
        Section section = courseService.selectSectionById(sectionId);
        Video video = videoService.selectById(videoId);
        sectionVideo.setSection(section);
        sectionVideo.setVideo(video);
        courseService.addSectionVideo(sectionVideo);
        List<SectionVideoDTO> videos = courseService.selectVideoById(sectionId);
        return videos;
    }

    /**
     * 通过id删除绑定
     * @param id
     * @param sectionId
     * @return
     */
    @RequestMapping(value = "/deleteVideoById",produces="application/json")
    @ResponseBody
    public Object deleteVideoById(Integer id,Integer sectionId){
        courseService.deleteVideoById(id);
        List<SectionVideoDTO> videoDTOS = courseService.selectVideoById(sectionId);
        return videoDTOS;
    }

    /**
     * 改变视频观看状态
     * @param sectionId
     * @param videoStatus
     */
    @GetMapping("/changeVideoStatus")
    @ResponseBody
    public void postAdminValidSwitch( Integer sectionId,  Integer videoStatus){

        if(videoStatus==null){

            return;
        }
        if (videoStatus==1){

            courseService.unlock(sectionId);
        }else{

            courseService.lock(sectionId);
        }
    }

    /**
     * 滑动按钮改变状态
     * @param chapterId
     * @param status
     */
    @GetMapping("/switch")
    @ResponseBody
    public void chapterSwitch(@RequestParam Integer chapterId, @RequestParam Integer status){

        if(status==null){

            return;
        }
        if (status==1){

            courseService.unlockChapter(chapterId);
        }else{

            courseService.lockChapter(chapterId);
        }
    }
}
