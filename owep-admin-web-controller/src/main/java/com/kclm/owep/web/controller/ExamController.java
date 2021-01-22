package com.kclm.owep.web.controller;

import com.kclm.owep.convert.UserConvert;
import com.kclm.owep.dto.UserDto;
import com.kclm.owep.entity.ExamBank;
import com.kclm.owep.entity.ExamQues;
import com.kclm.owep.entity.ExamQuesAnswerSet;
import com.kclm.owep.entity.User;
import com.kclm.owep.service.ExamBankService;
import com.kclm.owep.service.ExamQuesService;
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

    @RequestMapping("/paperManagementList")
    public String topaperManagementList(){
        return "exam/paperManagementList";
    }
    @RequestMapping("/examManagementList")
    public String toexamManagementList(){
        return "exam/examManagementList";
    }

}
