package com.kclm.owep.web.controller;

import cn.hutool.http.HtmlUtil;
import com.kclm.owep.dto.ExamQuesDTO;
import com.kclm.owep.entity.ExamBank;
import com.kclm.owep.entity.ExamQues;
import com.kclm.owep.entity.ExamQuesAnswerSet;
import com.kclm.owep.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/examQues")
public class ExamQuesController {

    @Autowired
    ExamService examService;

    /**
     * 创建试题
     */
    @RequestMapping(value = "/addQues", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> addQues(@RequestBody ExamQues examQues, HttpSession session) {
        UserDetails user = (UserDetails) session.getAttribute("LOGIN_USER");
        String name = user.getUsername();
        examQues.setUserName(name);
        //清除所有HTML标签
        examQues.setQuesContent(HtmlUtil.cleanHtmlTag(examQues.getQuesContent()));
        examQues.setCorrectAnswer(HtmlUtil.cleanHtmlTag(examQues.getCorrectAnswer()));
        examQues.setAnalyze(HtmlUtil.cleanHtmlTag(examQues.getAnalyze()));
        return this.examService.addQues(examQues);

    }

    /**
     * 添加附件题
     */
    @RequestMapping(value = "addFile", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> addFile(String typeName, String hardLevel, int bankId, String source,
                                       String lable, Integer status, String quesContent, String analyze,
                                       MultipartFile file, HttpSession session) {

        UserDetails user = (UserDetails) session.getAttribute("LOGIN_USER");
        String name = user.getUsername();
        ExamBank examBank = new ExamBank();
        examBank.setId(bankId);

        ExamQues examQues = new ExamQues();
        ExamQuesAnswerSet examQuesAnswerSet = new ExamQuesAnswerSet();
        //封装examQuesAnswerSet对象
        examQuesAnswerSet.setAnswerStatus(1);
        examQuesAnswerSet.setAnswerContent(uploadFile(file));
        examQuesAnswerSet.setTypeName(typeName);
        //将examQuesAnswerSet对象存入集合中
        List<ExamQuesAnswerSet> examQuesAnswerSets = new ArrayList<>();
        examQuesAnswerSets.add(examQuesAnswerSet);
        //封装examQues对象
        examQues.setUserName(name);
        examQues.setTypeName(typeName);
        examQues.setHardLevel(hardLevel);
        examQues.setExamBank(examBank);
        examQues.setSource(source);
        examQues.setLable(lable);
        examQues.setStatus(status);
        examQues.setQuesContent(HtmlUtil.cleanHtmlTag(quesContent));
        examQues.setCorrectAnswer(examQuesAnswerSet.getAnswerContent());
        examQues.setAnalyze(HtmlUtil.cleanHtmlTag(analyze));
        examQues.setAnswerSetList(examQuesAnswerSets);

        return this.examService.addQues(examQues);
    }


    /**
     * 展示所有试题
     */
    @RequestMapping(value = "quesList", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ExamQuesDTO> quesList(HttpSession session) {
        UserDetails user = (UserDetails) session.getAttribute("LOGIN_USER");
        String name = user.getUsername();

        return this.examService.allQues(name);
    }


    /**
     * 修改试题
     */
    @RequestMapping(value = "alterQues")
    @ResponseBody
    public Map<String, Object> alterQues(@RequestBody ExamQues examQues, HttpSession session) {
        UserDetails user = (UserDetails) session.getAttribute("LOGIN_USER");
        String name = user.getUsername();
        examQues.setUserName(name);
        //清除所有HTML标签
        examQues.setQuesContent(HtmlUtil.cleanHtmlTag(examQues.getQuesContent()));
        examQues.setCorrectAnswer(HtmlUtil.cleanHtmlTag(examQues.getCorrectAnswer()));
        examQues.setAnalyze(HtmlUtil.cleanHtmlTag(examQues.getAnalyze()));
        return this.examService.alterQues(examQues);

    }

    /**
     * 修改附件题
     */
    @RequestMapping(value = "alterFile", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> alterFile(int id,String typeName, String hardLevel, String bankName, String source,
                                       String lable, Integer status, String quesContent, String analyze,
                                       MultipartFile file, HttpSession session) {

        UserDetails user = (UserDetails) session.getAttribute("LOGIN_USER");
        String name = user.getUsername();
        ExamBank examBank = new ExamBank();
        examBank.setBankName(bankName);

        ExamQues examQues = new ExamQues();
        ExamQuesAnswerSet examQuesAnswerSet = new ExamQuesAnswerSet();
        //封装examQuesAnswerSet对象
        examQuesAnswerSet.setAnswerStatus(1);
        examQuesAnswerSet.setAnswerContent(uploadFile(file));
        examQuesAnswerSet.setTypeName(typeName);
        //将examQuesAnswerSet对象存入集合中
        List<ExamQuesAnswerSet> examQuesAnswerSets = new ArrayList<>();
        examQuesAnswerSets.add(examQuesAnswerSet);
        //封装examQues对象
        examQues.setId(id);
        examQues.setUserName(name);
        examQues.setTypeName(typeName);
        examQues.setHardLevel(hardLevel);
        examQues.setExamBank(examBank);
        examQues.setSource(source);
        examQues.setLable(lable);
        examQues.setStatus(status);
        examQues.setQuesContent(HtmlUtil.cleanHtmlTag(quesContent));
        examQues.setCorrectAnswer(examQuesAnswerSet.getAnswerContent());
        examQues.setAnalyze(HtmlUtil.cleanHtmlTag(analyze));
        examQues.setAnswerSetList(examQuesAnswerSets);

        return this.examService.alterQues(examQues);
    }

    /**
     * 模糊查询
     */
    @RequestMapping(value = "searchByKeys",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ExamQuesDTO> searchByKeys(String quesContent,Integer bankId,String typeName, String lable,
                                          String hardLevel,Integer status,HttpSession session){
        UserDetails user = (UserDetails) session.getAttribute("LOGIN_USER");
        String name = user.getUsername();
        //封装题库对象
        ExamBank bank = new ExamBank();
        bank.setId(bankId);
        //封装试题对象
        ExamQues ques = new ExamQues();
        ques.setQuesContent(quesContent);
        ques.setExamBank(bank);
        ques.setTypeName(typeName);
        ques.setLable(lable);
        ques.setHardLevel(hardLevel);
        ques.setStatus(status);
        ques.setUserName(name);
        return examService.selectQuesByKeys(ques);
    }


    /**
     * 共享试题
     */
    @RequestMapping(value ="shareExamQues",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ExamQuesDTO> shareQues(){
        System.out.println("==================");
        return this.examService.findShareQues();
    }








    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    public String uploadFile(MultipartFile file) {
        //获取上传文件的原名
        String filename = file.getOriginalFilename();
        int startIndex = filename.lastIndexOf(".");
        //确保 “.” 能被找到
        if (startIndex == -1) {
            return "文件格式错误!";
        }
        //得到文件的后缀
        String subffix = filename.substring(startIndex);
        //用UUID生成前缀
        String preffix = UUID.randomUUID().toString();
        //新的文件名
        String newFileName = preffix + subffix;

        //获取到项目的根目录
        ApplicationHome applicationHome = new ApplicationHome(getClass());
        final File path = applicationHome.getDir();

        File realPath = new File(path, "upload/files");
        if (!realPath.exists()) {
            realPath.mkdirs();
        }

        File filePath = new File(realPath, "/" + newFileName);
        //实现上传
        try {
            file.transferTo(filePath);

        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        }
        //文件名
        String name = newFileName;
        return name;
    }

}
