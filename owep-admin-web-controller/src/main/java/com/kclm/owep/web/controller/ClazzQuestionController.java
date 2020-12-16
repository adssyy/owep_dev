/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kclm.owep.dto.*;
import com.kclm.owep.entity.PlanManager;
import com.kclm.owep.entity.Question;
import com.kclm.owep.entity.QuestionReply;
import com.kclm.owep.entity.User;
import com.kclm.owep.service.ClazzService;
import com.kclm.owep.service.PlanManagerService;
import com.kclm.owep.service.QuestionReplyService;
import com.kclm.owep.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*****************
 *
 * @author tanj
 * @date 2020/6/28 21:45
 * @version v1.0
 * @description 班级问题 功能具体控制层
 *
 */
@RestController
@RequestMapping("clazz")
public class ClazzQuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionReplyService questionReplyService;

    @Autowired
    private ClazzService clazzService;

    @Autowired
    private PlanManagerService planManagerService;

    @RequestMapping(value = "allQuestion",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<QuestionDTO> selectAll(){

        return this.questionService.selectAll();
    }

    @RequestMapping(value = "deleteQuestion",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String delete(Integer id){

        if (this.questionService.deleteById(id) > 0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    @RequestMapping(value = "deleteSelectQuestion",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String deleteSelect(@RequestBody List<Integer> idList){

        List<Serializable> list = new ArrayList<>();
        for (Integer id:idList){
            list.add(id);
        }
        if (this.questionService.deleteSelect(list)> 0){
            return "删除成功！";
        }else {
            return "删除失败！";
        }
    }

    @RequestMapping(value = "findClassByProfession" ,method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Map findClassByProfession(Integer professionId){

        List<ClazzDTO> clazzDTOS = this.clazzService.selectByPro(professionId);
        Map map = new HashMap();
        map.put("value",clazzDTOS);
        return map;
    }

    @RequestMapping(value = "findCourseByClass" ,method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Map findCourseByClass(Integer classId){

        List<CourseDTO> courseDTOS = new ArrayList<>();
        ClazzDTO clazzDTO = this.clazzService.selectById(classId);
        List<PlanManager> planManagerList = clazzDTO.getPlanManagerList();
        if (planManagerList != null){
            List<PlanManagerCourseDTO> allPlanManagerCourse = this.planManagerService.findAllPlanManagerCourse(planManagerList.get(0).getId());
            System.out.println(allPlanManagerCourse.toString());
            for (PlanManagerCourseDTO planManagerCourseDTO : allPlanManagerCourse){
                courseDTOS.add(planManagerCourseDTO.getCourseDTO());
            }
        }
        Map map = new HashMap();
        map.put("value",courseDTOS);
        return map;
    }

    @RequestMapping(value = "selectQuestionByKeyword" ,method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<QuestionDTO> selectQuestionByKeyword(String orgName,String branchName,Integer professionId,Integer classId,Integer courseId){

        return this.questionService.selectByKeyword(orgName,branchName,professionId,classId,courseId);
    }

    @RequestMapping(value = "selectQuestionReplyByQuestionId" ,method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Map selectQuestionReplyByQuestionId(Integer questionId){

        QuestionDTO questionDTO = this.questionService.selectById(questionId);
        System.out.println(questionDTO.toString());
        Object o = JSONObject.toJSON(questionDTO);
        List<QuestionReplyDTO> questionReplyDTOS = this.questionReplyService.selectByQuestionId(questionId);
        Map map = new HashMap();
        map.put(o,questionReplyDTOS);
        return map;
    }

    @RequestMapping(value = "saveQuestionReply" ,method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public String saveQuestionReply(HttpServletRequest request,@RequestParam("questionId") Integer questionId,@RequestParam("reply") String reply){
        QuestionReply questionReply = new QuestionReply();
        Question question = new Question();
        UserDetails login_user = (UserDetails) request.getSession().getAttribute("LOGIN_USER");
        question.setId(questionId);
        questionReply.setReplyContent(reply);
        questionReply.setQuestion(question);
        questionReply.setReplyAuthor(login_user.getUsername());
        if (this.questionReplyService.save(questionReply)>0){
            return "成功";
        }else {
            return "失败";
        }

    }
}
