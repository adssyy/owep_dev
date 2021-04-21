package com.kclm.owep.web.controller;

import com.kclm.owep.dto.ExamBankDTO;
import com.kclm.owep.entity.ExamBank;
import com.kclm.owep.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/examBank")
public class ExamBankController {

    @Autowired
    ExamService examService;

    /**
     * 获取题库信息
     */
    @RequestMapping(value="/allExamBank",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ExamBankDTO> allExamBank(HttpSession session){
        UserDetails user = (UserDetails) session.getAttribute("LOGIN_USER");
        String name= user.getUsername();

        return this.examService.allExamBank(name);
    }

    /**
     * 获取可用题库信息
     */
    @RequestMapping(value="/availableBank",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ExamBankDTO> availableExamBank(HttpSession session){
        UserDetails user = (UserDetails) session.getAttribute("LOGIN_USER");
        String name= user.getUsername();

        return this.examService.availableExamBank(name);
    }

    /**
     * 模糊查询获得题库信息
     */
    @RequestMapping(value = "/findAllByKeys",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ExamBankDTO> findAllByKeys(ExamBank exam,HttpSession session){
        UserDetails user = (UserDetails) session.getAttribute("LOGIN_USER");
        String name= user.getUsername();

        return this.examService.findAllByKeys(exam,name);
    }

    /**
     * 获取共享题库信息
     */
    @RequestMapping(value="/shareExamBank",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ExamBankDTO> shareExamBank(HttpSession session){
        UserDetails user = (UserDetails) session.getAttribute("LOGIN_USER");
        String name= user.getUsername();

        return this.examService.shareExamBank(name);
    }

    /**
     * 模糊查询共享题库信息
     */
    @RequestMapping(value="/findShareByKeys",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ExamBankDTO> findShareByKeys(ExamBank exam,HttpSession session){
        System.out.println(exam);
        UserDetails user = (UserDetails) session.getAttribute("LOGIN_USER");
        String name= user.getUsername();
        System.out.println("name="+name);
        System.out.println(examService.findShareByKeys(exam,name));
        return this.examService.findShareByKeys(exam,name);
    }

    /**
     * 修改题库信息
     */
    @RequestMapping(value = "/alterBank",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Map<String,Object> alterBank(ExamBank examBank){
        Map<String,Object> map = examService.alterBank(examBank);
        return map;
    }

    /**
     * 添加题库
     */
    @RequestMapping(value = "/addBank",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Map<String,Object> addBank(ExamBank examBank,HttpSession session){
        UserDetails user = (UserDetails) session.getAttribute("LOGIN_USER");
        String name= user.getUsername();
        Map<String,Object> map = examService.addBank(examBank,name);
        return map;
    }

    /**
     * 删除题库
     */
    @RequestMapping(value = "/delBank",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Map<String,Object> delBank(int id){
        Map<String,Object> map = examService.deleteBank(id);
        return map;
    }

}
