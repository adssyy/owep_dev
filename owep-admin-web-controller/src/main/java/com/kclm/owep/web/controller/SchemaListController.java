package com.kclm.owep.web.controller;

import com.kclm.owep.dto.CourseCategoryDTO;
import com.kclm.owep.dto.CourseDTO;
import com.kclm.owep.dto.PlanManagerCourseDTO;
import com.kclm.owep.dto.PlanManagerDTO;
import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.PlanManager;
import com.kclm.owep.entity.PlanManagerCourse;
import com.kclm.owep.service.CourseService;
import com.kclm.owep.service.PlanManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/training/schemaList")
public class SchemaListController {
    @Autowired
    private PlanManagerService planManagerService;
    @Autowired
    private CourseService courseService;

    /**
     * 获取所有方案
     * @return
     */
    @RequestMapping(value = "/getSchemaList",produces = "application/json")
    @ResponseBody
    public Object getSchemaList(){
        List<PlanManagerDTO> allPlanManager = planManagerService.findAllPlanManager();
        return allPlanManager;
    }

    /**
     * 添加方案
     * @param planManager
     * @return
     */
    @RequestMapping("/addPlanManager")
    @ResponseBody
    public String addPlanManager(@RequestBody(required = false) PlanManager planManager){
        System.out.println("==========================*****************************************===============================");
        planManager.setIsDelete(1);
        planManagerService.addPlanManager(planManager);
        /*return "forward:/owep/training/schemaList";*/
        return "success";
    }

    /**
     * 通过id删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteById(@RequestParam("id") Integer id){
        System.out.println("***************************************************************************"+id);
        planManagerService.deletePlanManagerById(id);
        //return "forward:/owep/training/courseList";
        return "success";
    }

    /**
     * 删除选中
     * @param ids
     * @return
     */
    @RequestMapping("/deleteSelected")
    @ResponseBody
    public String deleteSelected(@RequestBody List<Integer> ids){
        //courseService.deleteCourseByIds(ids);
        for(Integer id : ids){
            System.out.println("delete userId:"+id);
            planManagerService.deletePlanManagerById(id);
        }
        return "success";
    }

    /**
     * 修改方案
     * @param planManager
     * @return
     */
    @RequestMapping("/updatePlanManager")
    @ResponseBody
    public String updatePlanManager(@RequestBody PlanManager planManager){
        planManagerService.alterPlanManager(planManager);
        return "success";
    }

    /**
     * 通过方案id获取方案课程
     * @param planManagerId
     * @return
     */
    @RequestMapping(value="/findCourseById",produces = "application/json")
    @ResponseBody
    public Object findCourseById(@RequestParam("planManagerId") Integer planManagerId){
        System.out.println("**************************************"+planManagerId);
        List<PlanManagerCourseDTO> all = planManagerService.findAllPlanManagerCourse(planManagerId);
        return all;
    }

    /**
     * 获取所有课程
     * @return
     */
    @RequestMapping(value="/getCourseList" ,produces = "application/json")
    @ResponseBody
    public Object getCourseList(){
        List<CourseDTO> allCourse = courseService.findAllCourse();
        allCourse.forEach(System.out::println);
        return allCourse;
    }

    /**
     * 设置方案
     * @param planManagerId
     * @param courseId
     * @param stageNum
     * @param stageName
     * @param model
     * @return
     */
    @RequestMapping("/addCourseToPlanManager")
    @ResponseBody
    public String addCourseToPlanManager(Integer planManagerId, Integer courseId, Integer stageNum, Integer stageName, Model model){
        PlanManagerCourse planManagerCourse = new PlanManagerCourse();
        planManagerCourse.setStageNum(stageNum);
        planManagerCourse.setStageName(stageName);
        Course course = courseService.selectById(courseId);
        planManagerCourse.setCourse(course);
        PlanManager planManager = planManagerService.selectById(planManagerId);
        model.addAttribute("planManagerId",planManager);
        planManagerCourse.setPlanManager(planManager);
        Integer courseOrder = planManagerService.findMaxCourseOrder(planManagerCourse);
        if(courseOrder==null){
            planManagerCourse.setCourseOrder(1);
        }else{
            planManagerCourse.setCourseOrder(courseOrder+1);
        }

        planManagerCourse.setIsDelete(1);

        planManagerService.addPlanManagerCourse(planManagerCourse);
        return "success";
    }

    /**
     * 通过id删除方案中的课程
     * @param id
     * @return
     */
    @RequestMapping("/deletePlanManagerCourseById")
    @ResponseBody
    public String deletePlanManagerCourseById(Integer id){
        System.out.println(id);
        planManagerService.deltePlanManagerCourseById(id);
        return "success";
    }

    /**
     * 课程上移
     * @param courseOrder
     * @param stageNum
     * @param planManagerId
     * @return
     */
    @RequestMapping(value="/courseMoveUp",produces = "application/json")
    @ResponseBody
    public Object courseMoveUp(Integer courseOrder,Integer stageNum,Integer planManagerId){
        PlanManager planManager = planManagerService.selectById(planManagerId);
        PlanManagerCourse up = planManagerService.findByCourseOrder(courseOrder,stageNum,planManager);
        PlanManagerCourse down = planManagerService.findByCourseOrder(courseOrder-1,stageNum,planManager);
        planManagerService.shiftCellsUpOrDown(up,down);
        List<PlanManagerCourseDTO> all = planManagerService.findAllPlanManagerCourse(planManagerId);

        return all;
    }

    /**
     * 课程下移
     * @param courseOrder
     * @param stageNum
     * @param planManagerId
     * @return
     */
    @RequestMapping(value="/courseMoveDown",produces = "application/json")
    @ResponseBody
    public Object courseMoveDown(Integer courseOrder,Integer stageNum,Integer planManagerId){
        PlanManager planManager = planManagerService.selectById(planManagerId);
        PlanManagerCourse up = planManagerService.findByCourseOrder(courseOrder+1,stageNum,planManager);
        PlanManagerCourse down = planManagerService.findByCourseOrder(courseOrder,stageNum,planManager);
        planManagerService.shiftCellsUpOrDown(up,down);
        List<PlanManagerCourseDTO> all = planManagerService.findAllPlanManagerCourse(planManagerId);
        return all;
    }

    @GetMapping("/switch")
    @ResponseBody
    public void postAdminValidSwitch(@RequestParam Integer planManagerId, @RequestParam Integer status){
        System.out.println("switching admin user validation:" + planManagerId+","+status);
        if(status==null){
            System.out.println("Warning： status value is null, nothing to do here");
            return;
        }
        if (status==1){
            System.out.println("user admin validation activated");
            planManagerService.activate(planManagerId);
        }else{
            System.out.println("user admin validation canceled");
            planManagerService.deactivate(planManagerId);
        }
    }

    @RequestMapping(value = "/search")
    @ResponseBody
    public Object search(String planNumber,String planName){
       PlanManager planManage = new PlanManager();
       planManage.setPlanNumber(planNumber);
       planManage.setPlanName(planName);


        List<PlanManagerDTO> planManagerDTOS = planManagerService.findPlanManagerByField(planManage);

        return planManagerDTOS;
    }
}
