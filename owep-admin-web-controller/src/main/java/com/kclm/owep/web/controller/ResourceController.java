package com.kclm.owep.web.controller;

import com.kclm.owep.convert.ResourceConvert;
import com.kclm.owep.convert.ResourceTypeConvert;
import com.kclm.owep.convert.ResourceTypeConvertImpl;
import com.kclm.owep.dto.*;
import com.kclm.owep.entity.*;
import com.kclm.owep.mapper.ChapterMapper;
import com.kclm.owep.mapper.SectionMapper;
import com.kclm.owep.mapper.UserMapper;
import com.kclm.owep.service.*;
import com.kclm.owep.utils.util.FileUploadUtil;
import com.kclm.owep.web.controller.ftp.FTPUtil;
import com.kclm.owep.web.controller.ftp.FtpProcessor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RequestMapping("/resources")
@Controller
public class ResourceController {

    @Autowired
    ResourceTypeService resourceTypeService;

    @Autowired
    ResourceService resourceService;

    @Autowired
    CourseService courseService;

    @Autowired
    ChapterService chapterService;

    @Autowired
    SectionService sectionService;





    @RequestMapping(value ="/resourceType")
    public String toResourceType(){
        return "resources/resourceType.html";
    }


    @PostMapping(value = "/resourceType/getResourceType" ,produces = "application/json")
    @ResponseBody
    public List<ResourceTypeDTO> getResourceType(){

        return resourceTypeService.findAllResourceType();

    }


    //添加
    @PostMapping(value = "/resourceType/addResourceType")
    @ResponseBody
    public String addResourceType(ResourceTypeDTO typeData){
        ResourceType resourceType =new ResourceType();
        resourceType = ResourceTypeConvert.INSTANCE.updatePOFromDTO(typeData,resourceType);
        resourceType.setIsDelete(1);

        resourceTypeService.addResourcrType(resourceType);


        return "添加成功";
    }

    //多选删除
    @PostMapping(value = "/resourceType/deleteSelectResourceType")
    @ResponseBody
    public String deleteSelectResourceType(@RequestBody List<ResourceTypeDTO> ids){
        if (ids!=null){

            resourceTypeService.deleteSelectResourceType1(ResourceTypeConvert.INSTANCE.updatePOsFromDTOs(ids));
            return "删除成功";
        }else{
            return"数据错误";
        }


    }

    //单个删除
    @GetMapping(value = "/resourceType/deleteResourceType" ,produces = "application/json")
    @ResponseBody
    public String deleteResourceType(int id){
       resourceTypeService.deleteResourceType(id);
        return "";

    }

    //////////////---------------------------------------------------------------------------------------------


    @RequestMapping(value ="/resourceList")
    public String toResourceList(){
        return "resources/resourceList.html";
    }

    //加载
    @PostMapping(value = "/resourceList/getResourceList",produces = "application/json")
    @ResponseBody
    public List<ResourceDTO> getResourceList(){
        return resourceService.findAllResource();

    }

    //搜索
    @PostMapping(value = "/resourceList/search",produces = "application/json")
    @ResponseBody
    public List<ResourceDTO> search(ResourceDTO resourceDTO){
        return resourceService.selectByTimeRangeAndsuffixAndname(resourceDTO);

//        final Resource resource = ResourceConvert.INSTANCE.updatePOFromDTO(resourceDTO);
//        final List<ResourceDTO> resourceName = resourceService.findResourceName(resource.getResourceName());
////        final List<ResourceDTO> resourceSuffix = resourceService.findResourceSuffix(resource.getResourceSuffix());
////        System.out.println(">>>>>>>>>>>>>>>>>>>>>suffix"+resourceSuffix.size());
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>name"+resourceName.size());
////        System.out.println(resourceSuffix);
//        System.out.println(resourceName);
////        resourceName.retainAll(resourceSuffix);
//
//        List<ResourceDTO> resultList =new LinkedList<>();
////        resourceName.forEach(a->{
////            resourceSuffix.forEach(b->{
////                if (b.equals(a)){
////                    resultList.add(b);
////
////                }
////            });
////        });
//
//       resourceName.forEach(a->{
//           if (a.getResourceSuffix().contains(resource.getResourceSuffix())){
//               resultList.add(a);
//           }
//       });
//
//
////        for (int i =0;i<resourceName.size();i++){
////            for (int j=0;j<resourceSuffix.size();j++){
////                if (resourceName.get(i)==resourceSuffix.get(j)){
////                    resultList.add(resourceName.get(i));
////                }
////            }
////
////        }
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>结果："+resultList.size());
//        return resultList;
    }


    //多选删除
    @PostMapping(value = "/resourceList/deleteSelectResource")
    @ResponseBody
    public String deleteSelectResource(@RequestBody List<Serializable> idlist){
        System.out.println(">>>>>>>>>>>>>>>>");
       // final List<Resource> resources = ResourceConvert.INSTANCE.updatePOsFromDTOs(idlist);
        for (Serializable id :
                idlist) {
            final Resource re = resourceService.findById(id);
            String realPath =re.getResourcePath();
            String path =realPath.substring(0,realPath.lastIndexOf("/"));
            String filename =realPath.substring(realPath.lastIndexOf("/")+1,realPath.length());
            FTPUtil.deleteFile("127.0.0.1",21,"admin","admin",path,filename);

        }



       // resources.forEach(a->ids.add(a.getId()));
        resourceService.deleteSelectResource(idlist);

        return "删除成功";
    }
//
//    @Autowired
//    FtpProcessor ftpProcessor;

    //添加
    @PostMapping(value = "/resourceList/addResource" )
    @ResponseBody
    public String addResource(@RequestParam(value = "type",required = false)String type ,
                                @RequestParam(value = "resourceName",required = false)String resourceName,
                                @RequestParam(value = "course",required = false)String course ,
                              @RequestParam(value = "chapter",required = false)String chapter,
                              @RequestParam(value = "section",required = false) String section,
                              @RequestParam(value = "add_resourceDesc",required = false) String resourceDesc,
                               @RequestParam(value = "file")MultipartFile file) throws IOException {
//        ResourceDTO resourceDTO,
//        System.out.println(resourceDTO);
//        final Resource resource = ResourceConvert.INSTANCE.updatePOFromDTO(resourceDTO);

//        String type , String resourceName,
        Resource resource =new Resource();
        resource.setResourceName(resourceName);
        resource.setType(resourceTypeService.findByTypeName(type).getId());

        if (resourceDesc!=null){
            resource.setResourceDesc(resourceDesc);
        }

        if (course!=null ){
            resource.setCourse(courseService.findByCourseName(course));
            System.out.println("course>>>>>>>>>>"+courseService.findByCourseName(course));
        }
        if (chapter!=null){
            resource.setChapter(chapterService.findByChapterName(chapter));
            System.out.println("chapter>>>>>>>"+chapterService.findByChapterName(chapter));
        }

        if (section!=null){
            resource.setSection(sectionService.findBySectionName(section));
            System.out.println(" section>>>>>>>" + sectionService.findBySectionName(section));
        }

        Long l =file.getSize();
        resource.setResourceSize(l.intValue());

        //获取最后一个.的位置
        int lastIndexOf = file.getOriginalFilename().lastIndexOf(".");
        //获取文件的后缀名 .jpg
        String suffix = file.getOriginalFilename().substring(lastIndexOf);
        resource.setResourceSuffix(suffix);
        resource.setIsDelete(1);

        //重命名
        String rename = FileUploadUtil.rename(file.getOriginalFilename());

        resource.setResourcePath("/fileManage/"+rename);


        resourceService.addResource(resource);
        //todo 保存文件
        FTPUtil.uploadFile("127.0.0.1",21,"admin","admin","/","/fileManage",rename,file.getInputStream());

        return "添加成功";
    }


    //单个删除
    @GetMapping(value = "/resourceList/deleteResource")
//    @ResponseBody
    public String deleteResource(int id){
        final Resource re = resourceService.findById(id);
        String realPath =re.getResourcePath();
        String path =realPath.substring(0,realPath.lastIndexOf("/"));
        String filename =realPath.substring(realPath.lastIndexOf("/")+1,realPath.length());
        FTPUtil.deleteFile("127.0.0.1",21,"admin","admin",path,filename);

        resourceService.deleteResource(id);
        return "resources/resourceList.html";

    }

    //添加----选择课程
    @RequestMapping(value = "/resourceList/findAllCourse" ,produces = "application/json")
    @ResponseBody
    public Map<String,List<CourseDTO>> findAllCourse(){
        final List<CourseDTO> allCourse = courseService.findAllCourse();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+courseService.findAllCourse().size());
        Map<String,List<CourseDTO>> map =new HashMap<>();
        map.put("value",allCourse);
        return map;

    }

    //选择章
    @RequestMapping(value = "/resourceList/findAllChapterByCourseId" ,produces = "application/json")
    @ResponseBody
    public Map<String,List<ChapterDTO>> findAllChapterByCourseId(int id){
        final List<ChapterDTO> allChapterByCourseId = courseService.findAllChapterByCourseId(id);
        Map<String,List<ChapterDTO>> map =new HashMap<>();
        map.put("value",allChapterByCourseId);
        return map;
    }

    //选择节
    @RequestMapping(value = "/resourceList/findAllSectionByChapterId",produces = "application/json")
    @ResponseBody
    public Map<String,List<SectionDTO>> findAllSectionByChapterId(int id){
        final List<SectionDTO> sectionsByChapterId = chapterService.findSectionsByChapterId(id);
        Map<String,List<SectionDTO>> map =new HashMap<>();
        map.put("value",sectionsByChapterId);
        return map;


    }


    @RequestMapping(value = "/resourceList/selectResourceSuffix" ,produces = "application/json")
    @ResponseBody
    public  Map<String,List<ResourceDTO>> selectResourceSuffix(){
        Map<String,List<ResourceDTO>> map =new HashMap<>();
//        final List<String> strings = resourceService.selectResourceSuffix();

//        final List<ResourceSuffix> strings = resourceService.selectResourceSuffix();
        final List<ResourceDTO> allresourceDTOS = ResourceConvert.INSTANCE.POs2DTOs(resourceService.selectResourceSuffix());
//        List<ResourceDTO> resourceDTOS =new LinkedList<>();
//        ResourceDTO  resourceDTO =new ResourceDTO();
//        System.out.println("suffixs:"+resourceDTOS);
        //
        List<ResourceDTO> resourceDTOS =new LinkedList<>();
        allresourceDTOS.forEach(a->{
            if (a!=null){
                resourceDTOS.add(a);
            }
        });

        System.out.println("后缀种类"+resourceDTOS.size());
//        strings.forEach(a->{
//            resourceDTO.setResourceSuffix(a);
//            resourceDTOS.add(resourceDTO);
//
//
//        });
        map.put("value",resourceDTOS);
        return map;

    }

    @PostMapping(value = "/resourceList/updateResource")
    public String updateResource(ResourceDTO resourceDTO){
        resourceService.updateResource(ResourceConvert.INSTANCE.updatePOFromDTO(resourceDTO));
        return "resources/resourceList.html";

    }


//    //添加resource
//    @PostMapping(value = "/resourceList/addResource")
//    @ResponseBody
//    public String addResource(ResourceDTO resourceDTO , @RequestParam("file") MultipartFile file){
//
//        resourceService.addResource(ResourceConvert.INSTANCE.updatePOFromDTO(resourceDTO));
//
//
//        return "";
//    }





}
