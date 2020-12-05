package com.kclm.owep.web.controller;

import com.kclm.owep.dto.ChapterDTO;
import com.kclm.owep.dto.CourseDTO;
import com.kclm.owep.dto.ResourceDTO;
import com.kclm.owep.entity.*;
import com.kclm.owep.service.CourseService;
import com.kclm.owep.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * TODO
 *
 * @author zhang_hy
 * @version v1.0
 * @date 2020-11-26 15:44
 * @description
 */

@Controller
@RequestMapping("/resources")
public class ResourceListController {

    Logger logger = LoggerFactory.getLogger(ResourceListController.class);

    private static final String FILE_UPLOAD_DIR = "D:/innerTestVideoServer/resources/";

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private CourseService courseService;


    /**
     * @author zhang_hy
     * @date 2020-11-30 13:20
     * @For 初始化显示资源列表
     */
    @RequestMapping("/resourceList")
    public String toResourceList() {

        return "resources/resourceList";
    }

    /**
     * @author zhang_hy
     * @date 2020-11-26 17:08
     * @For 显示所有列表资源
     */
    @RequestMapping(value = "/resourceList/getResourceList", produces = "application/json")
    @ResponseBody
    public Object getResourceList() {

        System.out.println("进入getResourceList()-------------------");

        return resourceService.findAllResource();
    }

    /**
     * @author zhang_hy
     * @date 2020-11-26 17:08
     * @For 增增资源文件
     */
    @RequestMapping("/resourceList/addResource")
    @ResponseBody
    public Object addResourceList(HttpServletRequest request, Resource resource, @RequestParam("file") MultipartFile resourcePath) {

        System.out.println("进入addResourceList()-------------------");

        logger.debug("**********addResourceList:  " + resource);

        //文件上传操作
        //1.完成文件上传
        //获取文件名
        final String originalFilename = resourcePath.getOriginalFilename();

        //生成薪的文件名=-----选做
        String fileName = UUID.randomUUID().toString();
        //获取原来的扩展名
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        fileName += suffix;
        //IO流操作
        try {
            resourcePath.transferTo(new File(FILE_UPLOAD_DIR + File.separatorChar + fileName));
        } catch (IOException e) {
            logger.error("上传文件失败", e);
        }

        //持久化文件
        resource.setIsDelete(1);
        resourceService.addResource(resource);

        return new Result("200", "okok");

    }

    /**
     * @author zhang_hy
     * @date 2020-11-27 10:45
     * @For 更新资源信息
     */
    @RequestMapping("/resourceList/updateResource")
    @ResponseBody
    public Object updateResource(HttpServletRequest request, Resource resource, @RequestParam("file") MultipartFile resourcePath) {

        System.out.println("进入updateResource-------------------");

        logger.debug("**********updateResource:  " + resource);

        //文件上传操作
        //1.完成文件上传
        //获取文件名
        final String originalFilename = resourcePath.getOriginalFilename();

        //生成薪的文件名=-----选做
        String fileName = UUID.randomUUID().toString();
        //获取原来的扩展名
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        fileName += suffix;
        //IO流操作
        try {
            resourcePath.transferTo(new File(FILE_UPLOAD_DIR + File.separatorChar + fileName));
        } catch (IOException e) {
            logger.error("上传文件失败", e);
        }

        //持久化文件

        resourceService.updateResource(resource);
        return new Result("200", "okok");
    }

    /**
     * @author zhang_hy
     * @date 2020-11-27 10:41
     * @For 根据ID删除单个
     */
    @RequestMapping("/resourceList/deleteResource")
    @ResponseBody
    public Object deleteResource(Integer id) {

        resourceService.deleteResource(id);

        return "success";
    }

    /**
     * @author zhang_hy
     * @date 2020-11-27 10:47
     * @For 删除选中
     */
    @RequestMapping("/resourceList/deleteSelectResource")
    @ResponseBody
    public Object deleteSelectResource(@RequestBody List<Serializable> idList) {

        resourceService.deleteSelectResource(idList);

        return "success";

    }

    /**
     * @author zhang_hy
     * @date 2020-12-2 16:27
     * @For 通过id查询课程
     */
    @RequestMapping("/resourceList/findAllCourse")
    @ResponseBody
    public Object findAllCourse() {

        final List<CourseDTO> courses = courseService.findAllCourse();

        HashMap map = new HashMap();

        map.put("value", courses);


        return map;
    }

    /**
     * @author zhang_hy
     * @date 2020-12-2 17:07
     * @For 根据课程id找到对应的章
     */
    @RequestMapping("/resourceList/findAllChapterByCourseId")
    @ResponseBody
    public Object findAllChapterByCourseId(Integer id) {

        final List<ChapterDTO> chapters = courseService.findAllChapterByCourseId(id);

        HashMap map = new HashMap();

        map.put("value", chapters);

        return map;
    }

    /**
     * @author zhang_hy
     * @date 2020-12-2 17:07
     * @For 根据章id找到对应的节
     */
    @RequestMapping("/resourceList/findAllSectionByChapterId")
    @ResponseBody
    public Object findAllSectionByChapterId(Integer id) {

        final List<Section> sections = courseService.selectAllById(id);

        HashMap map = new HashMap();

        map.put("value", sections);

        return map;
    }

    /**
     * @author zhang_hy
     * @date 2020-12-3 11:19
     * @For 查询所有的后缀
     */
    @RequestMapping(value = "/resourceList/selectResourceSuffix")
    @ResponseBody
    public Object selectResourceSuffix() {
        final List<String> resourceSuffix = resourceService.selectResourceSuffix();

        HashMap map = new HashMap();

        map.put("value", resourceSuffix);
        return map;
    }


    /**
     * @author zhang_hy
     * @date 2020-12-3 13:35
     * @For 搜索
     */
    @RequestMapping(value = "/resourceList/search")
    @ResponseBody
    public Object search(@RequestParam(value = "resourceName") String resourceName, @RequestParam(value = "resourceSuffix") String resourceSuffix) {
        System.out.println("================================");

        System.out.println(resourceName + "," + resourceSuffix);
        final List<Resource> lists = resourceService.findByKeyword(resourceName);
        ArrayList arr = new ArrayList();
        for (Resource list : lists) {
            //匹配后缀名
            if (list.getResourceSuffix().equals(resourceSuffix)) {
               arr.add(list);
            }
        }
        System.out.println("================================*************");
        System.out.println(arr);
        return arr;


    }

}
