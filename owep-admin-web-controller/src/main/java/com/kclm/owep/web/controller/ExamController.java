package com.kclm.owep.web.controller;

import com.kclm.owep.convert.UserConvert;
import com.kclm.owep.dto.UserDto;
import com.kclm.owep.entity.ExamBank;
import com.kclm.owep.entity.User;
import com.kclm.owep.service.ExamBankService;
import com.kclm.owep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private ExamBankService examBankService;
    @Autowired
    UserService userService;

    private User getLoginUser(HttpSession session){
        UserDetails userDetails=(UserDetails)session.getAttribute("LOGIN_USER");
        UserDto userDto = userService.selectByName(userDetails.getUsername());
        User user = UserConvert.INSTANCE.updateEntityFromDto(userDto);
        return user;
    }
    @RequestMapping("/titleList")
    public String totitleList(){
        return "exam/titleList";
    }
    @RequestMapping("/testItemList")
    public String totestItemList(){
        return "exam/testItemList";
    }
    @RequestMapping("/paperManagementList")
    public String topaperManagementList(){
        return "exam/paperManagementList";
    }
    @RequestMapping("/examManagementList")
    public String toexamManagementList(){
        return "exam/examManagementList";
    }

    //查找首页
    @RequestMapping("/titleList.do")
    @ResponseBody
    public List<ExamBank> dotitleList(HttpSession session){
        User user = getLoginUser(session);
        List<ExamBank> list=examBankService.selectMyAllBank(user.getId());
        System.out.println(list);
        return list;
    }
    //查看共享题库
    @RequestMapping("/titleListshare.do")
    @ResponseBody
    public List<ExamBank> dotitleListshare(HttpSession session){
        List<ExamBank> list=examBankService.selectselectAllshare();
        System.out.println(list);
        return list;
    }
    //创建题库
    @RequestMapping("/saveBank.do")
    public String dosaveBank(ExamBank examBank,HttpSession session){
        User user = getLoginUser(session);
        examBank.setUser(user);
        examBank.setQuesNumber(0);
        examBank.setLastAccessTime(LocalDateTime.now());
        examBankService.save(examBank);
        return "forward:/exam/titleList";
    }
    //删除题库（假删除）
    @RequestMapping("/deletebyid.do")
    @ResponseBody
    public String dodeletebyid(Integer id){
        examBankService.deletebyid(id);
        return "forward:/titleList.do";
    }

    //更新我的题库
    @RequestMapping("/updateMyBank.do")
    @ResponseBody
    public String doUpdateMyBank(ExamBank examBank){
        examBank.setLastAccessTime(LocalDateTime.now());
        System.out.println(examBank);
        examBankService.updateMyBank(examBank);
        return "forward:/exam/titleList";
    }
    //模糊找寻我的题库
    @RequestMapping("/searchMyBank.do")
    @ResponseBody
    public List<ExamBank> doSearchMyBank(HttpSession session,String word,int mhStatus,int mhSecurity){
        User user = getLoginUser(session);
        List<ExamBank> list=examBankService.searchMyBank(word,mhStatus,mhSecurity,user.getId());
        System.out.println(list);
        return list;
    }
    //模糊查询共享题库
    @RequestMapping("/searchShareBank.do")
    @ResponseBody
    public List<ExamBank> doSearchShareBank(HttpSession session,String shareWord, int shareStatus,String userName){
        List<User> userList=userService.selectByKeyword(userName,null);
        List<Integer> userIdList=new ArrayList<Integer>();
        for (int i=0;i<userList.size();i++){
            userIdList.add(userList.get(i).getId());
        }
        System.out.println(userIdList);
        return examBankService.searchShareBank(shareWord,shareStatus,userIdList);
    }
    //我的题库SWITCHERY的更新bankStatus的状态
    @RequestMapping("/switcheryMyBank.do")
    @ResponseBody
    public String doSwitchMyBank(int id,int bankStatus){
        int bs=0;
        if (bankStatus==bs){
            examBankService.updateBankStatusbyid(id, bs+1);
        }else {
            examBankService.updateBankStatusbyid(id,bs);
        }
        return "success";
    }
    //修改共享题库
    @RequestMapping("/updateShareBank.do")
    @ResponseBody
    public String doUpdateShareBank(ExamBank examBank){
        examBankService.updateShareBank(examBank);
        return "success";
    }

}
