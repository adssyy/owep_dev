/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kclm.owep.dto.*;
import com.kclm.owep.entity.*;
import com.kclm.owep.service.*;
import ma.glasnost.orika.MapperFacade;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*****************
 *
 * @author tanj
 * @date 2020/6/28 21:43
 * @version v1.0
 * @description 班级列表功 能的具体控制层
 *
 */
@RestController()
@RequestMapping("clazz")
public class ClazzListController {

    @Autowired
    private ClazzService clazzService;

    @Autowired
    private PlanManagerService planManagerService;

    @Autowired
    private ProfessionService professionService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "allClazz",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ClazzDTO> list(){

        return this.clazzService.selectAll();
    }

    @RequestMapping(value = "saveClazz",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String save(Clazz clazz,String professionName,String planManagerName){

        Profession profession = this.professionService.selectByName(professionName);
        clazz.setProfession(profession);
        PlanManager planManager = new PlanManager();
        planManager.setPlanName(planManagerName);
        List<PlanManager> planManagers = this.planManagerService.findPlanManager(planManager);
        clazz.setPlanManagerList(planManagers);
        if (this.clazzService.save(clazz) > 0){
            return "添加成功";
        }else {
            return "添加失败";
        }

    }

    @RequestMapping(value = "deleteClazz",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String delete(Integer id){

        if (this.clazzService.deleteById(id) > 0){
            return "成功";
        }else {
            return "失败";
        }

    }

    @RequestMapping(value = "deleteSelectClazz",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String deleteSelect(@RequestBody List<Integer> idList){

        List<Serializable> list = new ArrayList<>();
        for (Integer id:idList){
            list.add(id);
        }
        if (this.clazzService.deleteSelect(list)> 0){
            return "删除成功！";
        }else {
            return "删除失败！";
        }
    }

    @RequestMapping(value = "toUpdateClazz",produces = "application/json")
    @ResponseBody
    public ClazzDTO toUpdate(Integer id){
        return this.clazzService.selectById(id);
    }

    @RequestMapping(value = "updateClazz",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String update(Clazz clazz,String professionName,String planManagerName){

        Profession profession = this.professionService.selectByName(professionName);
        clazz.setProfession(profession);
        PlanManager planManager = new PlanManager();
        planManager.setPlanName(planManagerName);
        List<PlanManager> planManagers = this.planManagerService.findPlanManager(planManager);
        clazz.setPlanManagerList(planManagers);
        if (this.clazzService.update(clazz) > 0){
            return "更新成功";
        }else {
            return "更新失败";
        }

    }

    @RequestMapping(value = "clazzTrigger",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String trigger(String check,Integer id){
        Clazz clazz = new Clazz();
        clazz.setId(id);
        if (check.equals("false")){
            clazz.setClassStatus(0);
            clazzService.update(clazz);
            return "已关闭";
        }else {
            clazz.setClassStatus(1);
            clazzService.update(clazz);
            return "已启用";
        }
    }

    @RequestMapping(value = "findAllPlanManager",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Map findAllPlanManager(){

        List<PlanManagerDTO> allPlanManager = this.planManagerService.findAllPlanManager();
        Map map = new HashMap();
        map.put("value",allPlanManager);
        return map;
    }

    @RequestMapping(value = "findAllCourseByPlan",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<CourseDTO> findAllCourseByPlan(Integer id){
        List<PlanManagerCourseDTO> allPlanManagerCourse = this.planManagerService.findAllPlanManagerCourse(id);
        System.out.println(allPlanManagerCourse.size());
        List<CourseDTO> courseDTOS = new ArrayList<>();
        if (allPlanManagerCourse != null && !allPlanManagerCourse.isEmpty()){
            for (PlanManagerCourseDTO planManagerCourseDTO : allPlanManagerCourse){
                courseDTOS.add(planManagerCourseDTO.getCourseDTO());
                System.out.println(planManagerCourseDTO.getCourseDTO().getCourseNumber());
            }
        }
        return courseDTOS;
    }

    @RequestMapping(value = "findStudentByClassId",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<StudentDTO> findStudentByClassId(Integer id){

        return this.studentService.selectStudentByClassId(id);
    }

    @RequestMapping(value = "findStudentByKeyword",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<StudentDTO> findStudentByKeyword(Integer id,String studentNumber, String studentName){

        return this.studentService.selectStudentByKeyword(id,studentNumber,studentName);
    }

    @RequestMapping(value = "deleteSelectStudent",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String deleteSelectedStudent(@RequestBody List<Integer> idList){

        List<Serializable> list = new ArrayList<>();
        for (Integer id:idList){
            list.add(id);
        }
        if (this.studentService.deleteSelect(list)> 0){
            return "删除成功！";
        }else {
            return "删除失败！";
        }
    }

    @RequestMapping(value = "addStudentToClass",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String addStudentToClass(@RequestParam("stu_file") MultipartFile mFile,@RequestParam("cid") Integer classId){

        // 获取上传文件的输入流
        try {
            String fileName = mFile.getOriginalFilename();
            InputStream inputStream = mFile.getInputStream();
            if (!fileName.matches("^.+\\.(?i)(xlsx)$")){
                return "文件格式有误";
            }
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            XSSFSheet sheet = workbook.getSheetAt(0);
            // 得到标题行
            Row titleRow = sheet.getRow(0);

            int lastRowNum = sheet.getLastRowNum();
            int lastCellNum = titleRow.getLastCellNum();

            List<Map<String, Object>> list = new ArrayList<>();

            for(int i = 1; i <= lastRowNum; i++ ){
                Map<String, Object> map = new HashMap<>();
                XSSFRow row = sheet.getRow(i);
                Student student = new Student();
                for(int j = 0; j < lastCellNum; j++){
                    // 得到列名
                    String key = titleRow.getCell(j).getStringCellValue();
                    System.out.println(key);
                    XSSFCell cell = row.getCell(j);
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    if (cell != null){
                        if (key.equals("effectiveDate") || key.equals("birth")){
                            Instant instant = cell.getDateCellValue().toInstant();
                            ZoneId zoneId = ZoneId.systemDefault();
                            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
                            map.put(key,LocalDateTime.parse(df.format(localDateTime),df));
                        }else {
                            cell.setCellType(CellType.STRING);
                            map.put(key, cell.getStringCellValue());
                        }
                    }
                }
                list.add(map);
            }
            workbook.close();
           /* ObjectMapper objMapper = new ObjectMapper();
            String infos = objMapper.writeValueAsString(list);
            List<Student> students = objMapper.readValue(infos, new TypeReference<List<Student>>() {});*/
            JSONArray jsonArray = new JSONArray();
            jsonArray.addAll(list);
            List<Student> students = jsonArray.toJavaList(Student.class);
            for (Student student : students){
                Clazz clazz = new Clazz();
                clazz.setId(classId);
                student.setClazz(clazz);
                System.out.println(student.toString());
            }
            if (this.studentService.insertAllStudentToClass(students) > 0){
                return "插入成功";
            }else {
                return "插入失败";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "插入失败";
    }

    @RequestMapping(value = "findResourceByClassId",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ResourceDTO> findResourceByClassId(Integer classId){

        return this.clazzService.selectClazzResourceByClazzId(classId);
    }

    @RequestMapping(value = "findResourceByClassIdAndKeyword",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ResourceDTO> findResourceByClassId(Integer classId,String resourceName,Integer typeId){

        return this.resourceService.selectResourceByClassAndKeyword(classId,resourceName,typeId);
    }

    @RequestMapping(value = "findClassByClassNum" ,method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ClazzDTO> findClassByClassNum(String classNumber){
        return this.clazzService.selectByNum(classNumber);
    }

    @RequestMapping(value = "findClassByKeyword" ,method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ClazzDTO> findClassByKeyword(String classNumber, String className, String instituteName, String instituteBranchName, Integer professionId){
        this.clazzService.selectByNum(classNumber);
        return this.clazzService.selectByKeyword(classNumber,className,instituteName,instituteBranchName,professionId);

    }

    @RequestMapping(value = "deleteResourceFromClass" ,method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String deleteResourceFromClass(Integer cid,Integer rid){
        int result = this.resourceService.deleteFromClass(cid,rid);
        System.out.println(result);
        if (result > 0){
            return "删除成功";
        }else {
            return "删除失败";
        }

    }

    @RequestMapping(value = "deleteSelectResourceFromClass" ,method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String deleteSelectResourceFromClass(Integer cid,@RequestBody List<Integer> idList){
        List<Serializable> list = new ArrayList<>();
        for (Integer id:idList){
            list.add(id);
        }
        if (this.resourceService.deleteSelectFromClass(cid,list)> 0){
            return "删除成功！";
        }else {
            return "删除失败！";
        }
    }

    @RequestMapping(value = "selectResourceByClassAndKeyword" ,method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ResourceDTO> selectResourceByClassAndKeyword(@RequestParam("cid") Integer cid,@RequestParam("resourceName") String resourceName, @RequestParam("resourceType") Integer resourceType){
        List<ResourceDTO> resourceDTOS = this.resourceService.selectResourceByClassAndKeyword(cid, resourceName, resourceType);
        return resourceDTOS;
    }

    @RequestMapping(value = "selectAllResource" ,method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ResourceDTO> selectAllResource(){
        return this.resourceService.findAllResource();
    }

    @RequestMapping(value = "addResourceToClass" ,method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String addResourceToClass(Integer cid,Integer rid){
        int result = this.resourceService.addToClass(cid, rid);
        if (result > 0){
            return "分配成功";
        }else {
            return "该资源已被分配到该班级";
        }
    }

    @RequestMapping(value = "addSelectResourceToClass" ,method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String addSelectResourceToClass(Integer cid,@RequestBody List<Integer> idList){
        List<Serializable> list = new ArrayList<>();
        for (Integer id:idList){
            list.add(id);
        }
        if (this.resourceService.addSelectToClass(cid,list) > 0){
            return "分配成功";
        }else {
            return "该资源已被分配到该班级";
        }
    }

    @RequestMapping(value = "selectResourceByKeyword" ,method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ResourceDTO> selectResourceByKeyword(String resourceName,String fileType,String beginTime,String endTime){
        List<ResourceDTO> resourceDTOS = this.resourceService.selectResourceByKeyword(resourceName,fileType,beginTime,endTime);
        return resourceDTOS;
    }


}
