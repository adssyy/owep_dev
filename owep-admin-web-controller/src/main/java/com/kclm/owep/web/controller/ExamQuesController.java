package com.kclm.owep.web.controller;

import com.kclm.owep.convert.UserConvert;
import com.kclm.owep.dto.UserDto;
import com.kclm.owep.entity.ExamBank;
import com.kclm.owep.entity.ExamQues;
import com.kclm.owep.entity.ExamQuesAnswerSet;
import com.kclm.owep.entity.User;
import com.kclm.owep.mapper.ExamBankMapper;
import com.kclm.owep.service.ExamBankService;
import com.kclm.owep.service.ExamQuesAnswerSetService;
import com.kclm.owep.service.ExamQuesService;
import com.kclm.owep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/exam")
public class ExamQuesController {
    @Autowired
    private ExamBankService examBankService;
    @Autowired
    private ExamQuesService examQuesService;
    @Autowired
    private ExamQuesAnswerSetService examQuesAnswerSetService;
    @Autowired
    UserService userService;

    private User getLoginUser(HttpSession session){
        UserDetails userDetails=(UserDetails)session.getAttribute("LOGIN_USER");
        UserDto userDto = userService.selectByName(userDetails.getUsername());
        User user = UserConvert.INSTANCE.updateEntityFromDto(userDto);
        return user;
    }

    @RequestMapping("/testItemList")
    public String totestItemList(Model model){
        //todo ..
        List<ExamBank> list=examBankService.selectAll();
        model.addAttribute("EBs",list);
        return "exam/testItemList";
    }

    //查看我的试题
    @RequestMapping("/testItemList.do")
    @ResponseBody
    public List<ExamQues> doTestItemList(HttpSession session){
        User user=getLoginUser(session);
        System.out.println(examQuesService.selectMyQues(user.getUserName()));
        return examQuesService.selectMyQues(user.getUserName());
    }

    //查看共享试题
    @RequestMapping("/testItemListShare.do")
    @ResponseBody
    public List<ExamQues> doTestItemListShare(){
        return examQuesService.selectShareQues();
    }

    //查看答案设置
    @RequestMapping("/searchAnswerSet.do")
    @ResponseBody
    public List<ExamQuesAnswerSet> doSearchAnserSet(HttpSession session, Integer quesId){
        List<ExamQuesAnswerSet> list=examQuesService.selectExamQuesAnswerSet(quesId);
        session.setAttribute("QuesAnswerSet",list);
        return list;
    }

    //创建试题
    @RequestMapping("/saveQues.do")
    @ResponseBody
    public String doSaveQues(HttpSession session,int examBankId,ExamQues examQues,ExamQuesAnswerSet examQuesAnswerSet){
        //必要代码
        examQues.setUserName(getLoginUser(session).getUserName());
        examQues.setUseCount(0);
        examQues.setLastAccessTime(LocalDateTime.now());
        examQues.setExamBank(examBankService.selectBankById(examBankId));
        System.out.println(examQues.getTypeName());
        System.out.println(examQuesAnswerSet);
        System.out.println("==========================================");
        if (examQues.getTypeName().equals("单选题")){
            //保存examQues表获取id
            examQuesService.saveExamQues(examQues);
            //获取新添加数据的Id值
            ExamQues examQues2=examQuesService.selectMyQues(getLoginUser(session).getUserName()).get(0);
            String[] strs=examQuesAnswerSet.getAnswerContent().split(",");
            char choice='A';
            for (String str:strs) {
                ExamQuesAnswerSet examQuesAnswerSet2=new ExamQuesAnswerSet();
                examQuesAnswerSet2.setExamQues(examQues2);
                if (String.valueOf(choice).equals(examQues2.getCorrectAnswer())){
                    examQuesAnswerSet2.setAnswerStatus(1);
                }else{
                    examQuesAnswerSet2.setAnswerStatus(0);
                }
                examQuesAnswerSet2.setTypeName((choice++) +"");
                examQuesAnswerSet2.setAnswerContent(str);
                //保存examexamQuesAnswerSet2在mysql数据库
                examQuesAnswerSetService.save(examQuesAnswerSet2);
            }
        }
        if (examQues.getTypeName().equals("多选题")){
            //保存examQues表获取id
            examQuesService.saveExamQues(examQues);
            //获取新添加数据的Id值
            ExamQues examQues2=examQuesService.selectMyQues(getLoginUser(session).getUserName()).get(0);
            //获取多选的正确答案数组
            String[] str1=examQues2.getCorrectAnswer().split(",");
            //获取选项内容
            String[] str2=examQuesAnswerSet.getAnswerContent().split(",");
            char choice='A';
            for (String s:str2) {
                ExamQuesAnswerSet examQuesAnswerSet2=new ExamQuesAnswerSet();
                examQuesAnswerSet2.setExamQues(examQues2);
                for (String s2:str1) {
                    if (String.valueOf(choice+"").equals(s2)){
                        examQuesAnswerSet2.setAnswerStatus(1);
                        break;
                    }else{
                        examQuesAnswerSet2.setAnswerStatus(0);
                    }
                }
                examQuesAnswerSet2.setTypeName((choice++) +"");
                examQuesAnswerSet2.setAnswerContent(s);
                //保存examexamQuesAnswerSet2在mysql数据库
                examQuesAnswerSetService.save(examQuesAnswerSet2);
            }
        }
        if (examQues.getTypeName().equals("填空题")){
            //保存examQues表获取id
            examQuesService.saveExamQues(examQues);
            //获取新添加数据的Id值
            ExamQues examQues2=examQuesService.selectMyQues(getLoginUser(session).getUserName()).get(0);
            //获取填空题的正确答案数组
            String[] str1=examQues2.getCorrectAnswer().split(",");
            int num=1;
            for (String s:str1) {
                ExamQuesAnswerSet examQuesAnswerSet2=new ExamQuesAnswerSet();
                examQuesAnswerSet2.setExamQues(examQues2);
                examQuesAnswerSet2.setAnswerStatus(1);
                examQuesAnswerSet2.setTypeName((num++)+"");
                examQuesAnswerSet2.setAnswerContent(s);
                examQuesAnswerSetService.save(examQuesAnswerSet2);
            }
        }
        if ((examQues.getTypeName().equals("判断题"))||(examQues.getTypeName().equals("问答题"))){
            //保存examQues表获取id
            examQuesService.saveExamQues(examQues);
            //获取新添加数据的Id值
            ExamQues examQues2=examQuesService.selectMyQues(getLoginUser(session).getUserName()).get(0);
            ExamQuesAnswerSet examQuesAnswerSet2=new ExamQuesAnswerSet();
            examQuesAnswerSet2.setExamQues(examQues2);
            examQuesAnswerSet2.setAnswerContent(examQues2.getCorrectAnswer());
            examQuesAnswerSet2.setAnswerStatus(1);
            //保存examexamQuesAnswerSet2在mysql数据库
            examQuesAnswerSetService.save(examQuesAnswerSet2);
        }
        if (examQues.getTypeName().equals("附件题")){
            //保存examQues表获取id
            examQuesService.saveExamQues(examQues);
            //获取新添加数据的Id值
            ExamQues examQues2=examQuesService.selectMyQues(getLoginUser(session).getUserName()).get(0);
            ExamQuesAnswerSet examQuesAnswerSet2=new ExamQuesAnswerSet();
            examQuesAnswerSet2.setExamQues(examQues2);
            examQuesAnswerSet2.setAnswerStatus(1);
        }
        examBankService.updateQuesNumber(examBankId);
        return "success";
    }
}
