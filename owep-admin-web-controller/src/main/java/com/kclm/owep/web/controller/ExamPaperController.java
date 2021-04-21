package com.kclm.owep.web.controller;

import com.kclm.owep.dto.ExamPaperDTO;
import com.kclm.owep.entity.ExamPaper;
import com.kclm.owep.entity.vo.ExamPaperVo;
import com.kclm.owep.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/examPaper")
public class ExamPaperController {

    @Autowired
    ExamService examService;

    /**
     * 创建试卷
     */
    @RequestMapping(value = "/addPaper", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String,Object> addPaper(@RequestBody ExamPaperVo paperVo, HttpSession session){
        UserDetails user = (UserDetails) session.getAttribute("LOGIN_USER");
        String name = user.getUsername();
        ExamPaper examPaper = paperVo.getExamPaper();
        examPaper.setUserName(name);
        paperVo.setExamPaper(examPaper);

        return examService.addPaper(paperVo);
    }

    /**
     * 查询所有试卷
     */
    @RequestMapping(value = "findAllPaper",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ExamPaperDTO> examPapers(HttpSession session){
        UserDetails user = (UserDetails) session.getAttribute("LOGIN_USER");
        String name = user.getUsername();

        return examService.findAllPapers(name);
    }

    /**
     * 根据id查询试卷
     */
    @RequestMapping(value = "findPaperById",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ExamPaperDTO> examPapers(HttpSession session,Integer id){
        UserDetails user = (UserDetails) session.getAttribute("LOGIN_USER");
        String name = user.getUsername();

        return examService.findPaperById(id,name);
    }

    /**
     * 修改试卷
     */
    @RequestMapping(value = "alterPaper",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Map<String,Object> alterPaper(@RequestBody ExamPaperVo paperVo, HttpSession session){
        UserDetails user = (UserDetails) session.getAttribute("LOGIN_USER");
        String name = user.getUsername();
        ExamPaper examPaper = paperVo.getExamPaper();
        examPaper.setUserName(name);
        paperVo.setExamPaper(examPaper);

        return examService.alterPaper(paperVo);
    }
}
