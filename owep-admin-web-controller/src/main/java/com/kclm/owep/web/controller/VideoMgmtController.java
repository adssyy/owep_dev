package com.kclm.owep.web.controller;

import com.kclm.owep.dto.VideoDTO;
import com.kclm.owep.entity.Video;
import com.kclm.owep.service.VideoService;
import com.kclm.owep.utils.util.FileUploadUtil;
import com.kclm.owep.web.controller.ftp.FTPUtil;
import org.codehaus.commons.compiler.util.StringPattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@RequestMapping("/resources")
@Controller
public class VideoMgmtController {

    @Autowired
    VideoService videoService;

    @RequestMapping(value ="/videoMgmt")
    public String toResourceType(){
        return "resources/videoMgmt.html";
    }


    @RequestMapping(value = "/videoMgmt/getVideoMgmt" ,produces = "application/json")
    @ResponseBody
    public List<VideoDTO> getVideoMgmt(){
        List<VideoDTO> videoDTOS =new LinkedList<>();
        VideoDTO videoDTO =new VideoDTO();
        final List<Video> videos = videoService.selectAll();
//        videos.forEach(System.out::println);
        for (Video a:
             videos) {
            //System.out.println(a.getId());
            if (a.getId()!=null){

            videoDTO.setId(a.getId());
            }

            if (a.getVideoFrom()!=null){
                videoDTO.setOrigin(a.getVideoFrom());
            }

            if (a.getVideoName()!=null){
                videoDTO.setVideoMsg(a.getVideoName());
            }
            if (a.getStatus()!=null){
                if (a.getStatus()==1){
                    videoDTO.setStatus("通过审核");
                }else if (a.getStatus()==0){
                    videoDTO.setStatus("未审核");
                }

            }

            if (a.getVideoCount()>0){
                videoDTO.setTimes("共"+a.getVideoCount()+"节");
            }
            //文件夹还是视频
            //顶级文件夹
            if(a.getType()==2){
                videoDTO.setIsDir(true);
                if (a.getParentDir()!=null){
                    videoDTO.setPid(a.getParentDir().getId());
                }
            }else if (a.getType()==1){
                videoDTO.setIsDir(false);
                if (a.getParentDir()!=null){
                    videoDTO.setPid(a.getParentDir().getId());
                }
            }
//            System.out.println(videoDTO);
            videoDTOS.add(videoDTO);
            videoDTO=new VideoDTO();
        }
        videoDTOS.forEach(System.out::println);
        return  videoDTOS;
    }


    @PostMapping(value = "/videoMgmt/update")
//    @ResponseBody
    public String updateName(String fileName,Integer fileId){
        final Video video = videoService.selectById(fileId);
        Video video1 =video;
        video1.setVideoName(fileName);
        videoService.update(video1);
//        if (a==1){
//
//        return "更新成功";
//        }else {
//            return "更新失败";
//        }
        return "resources/videoMgmt.html";


    }


    //上传
    @RequestMapping(value = "/videoMgmt/uploadVideo" ,produces = "application/json")
    @ResponseBody
    public Video uploadV(HttpSession session, @RequestParam(value = "input-fa" ,required = false) MultipartFile file,
                         @RequestParam(value = "dirName",required = false) String dirName) throws IOException {
        System.out.println("进入了上传控制器");

        Video video =new Video();
        video.setVideoName(file.getOriginalFilename().substring(0,file.getOriginalFilename().lastIndexOf(".")));
        video.setCreateTime(LocalDateTime.now());
        video.setType(1);
        video.setDelete(1);
        video.setVideoCount(1);
        video.setVideoSize(file.getSize());
        video.setStatus(1);

        UserDetails user =(UserDetails) session.getAttribute("LOGIN_USER");
        video.setVideoFrom(user.getUsername());

        //重命名
        String rename = FileUploadUtil.rename(file.getOriginalFilename());

        if (dirName!=null){
            System.out.println(">>>>>>>>>>>>上传文件夹");
            Video dir =new Video();
            dir.setVideoName(dirName);
            dir.setType(2);
            dir.setCreateTime(LocalDateTime.now());
            dir.setDelete(1);
            dir.setStatus(1);
            videoService.save(dir);

            final Video pVideo = videoService.selectByVideoName(dirName);

            video.setParentDir(pVideo);
            video.setVideoUrl("/video/"+dirName+"/"+rename);
            videoService.save(video);
            //上传
            FTPUtil.uploadFile("127.0.0.1",21,"admin","admin","/","video/"+dirName ,rename,file.getInputStream());

        }
        if (dirName==null){
            System.out.println(">>>>>>>>>>>>上传视频");

            video.setVideoUrl("/video/"+rename);
            videoService.save(video);
            //使用ftp上传 ，写入必须使用英文。名
            FTPUtil.uploadFile("127.0.0.1",21,"admin","admin","/","video" ,rename,file.getInputStream());

        }
        return video;
    }


    //删除
    @GetMapping(value = "videoMgmt/deleteById")
    public String deleteById( int id){
        Video video =videoService.selectById(id);
        videoService.deleteById(id);

        System.out.println(">>>>>>>>>>>>>删除方法--");

        String realPath=video.getVideoUrl();
        String path =realPath.substring(0,realPath.lastIndexOf("/"));
        System.out.println(">>>>>>>path:"+path);

        String filename =realPath.substring(realPath.lastIndexOf("/")+1,realPath.length());
        System.out.println(">>>>>>>>filename:"+filename);
//        String[] strArray = filename.split("\\.");
//        int suffixIndex = strArray.length -1;
        String name =filename.substring(0,filename.lastIndexOf("."));

        System.out.println(">>>>>>>>>>name:"+name);

        FTPUtil.deleteFile("127.0.0.1",21,"admin","admin",path,filename);

        System.out.println(">>>>>>>>>>>>>文件删除完成----");
        return "resources/videoMgmt.html";

    }







}
