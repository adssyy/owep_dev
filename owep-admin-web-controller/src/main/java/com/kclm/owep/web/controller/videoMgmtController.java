package com.kclm.owep.web.controller;

import com.kclm.owep.entity.Video;
import com.kclm.owep.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.List;

/**
 * TODO
 *
 * @author zhang_hy
 * @version v1.0
 * @date 2020-11-30 11:26
 * @description  视频管理控制层
 */

@Controller
@RequestMapping("/resources")
public class videoMgmtController {

    @Autowired
    private VideoService videoService;

    /**
     * @author zhang_hy
     * @date 2020-11-30 13:16
     * @For  初始化显示视频资源
     */
    @GetMapping("/videoMgmt")
    public String toVideoMgmt() {

        return "resources/videoMgmt";
    }

    /**
     * @author zhang_hy
     * @date 2020-11-30 13:19
     * @For 查看所有视频
     */
    @RequestMapping(value = "/videoMgmt/getVideoMgmt")
    @ResponseBody
    public Object getVideoMgmt() {

        return videoService.selectAll();
    }

    /**
     * @author zhang_hy
     * @date 2020-11-30 13:23
     * @For 增加视频资源
     */
    @RequestMapping("/videoMgmt/addVideoMgmt")
    @ResponseBody
    public Object addVideoMgmt(Video video){

        video.setDelete(1);

        videoService.save(video);

        return "success";

    }

    /**
     * @author zhang_hy
     * @date 2020-11-30 13:26
     * @For 删除单个视频资源
     */
    @RequestMapping("/videoMgmt/deleteById")
    @ResponseBody
    public Object deleteById(Serializable id) {

        videoService.deleteById(id);

        return "success";
    }

    /**
     * @author zhang_hy
     * @date 2020-11-30 13:29
     * @For 删除选中
     */
    @RequestMapping("/videoMgmt/deleteSelect")
    @ResponseBody
    public Object deleteSelect(List<Serializable> idList) {

        videoService.deleteSelect(idList);

        return "success";
    }

    /**
     * @author zhang_hy
     * @date 2020-11-30 13:31
     * @For 更新视频资源
     */
    @RequestMapping("/videoMgmt/update")
    @ResponseBody
    public Object update(Video video) {

        videoService.update(video);

        return "success";
    }

}