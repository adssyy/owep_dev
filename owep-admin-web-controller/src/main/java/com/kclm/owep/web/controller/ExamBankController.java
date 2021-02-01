package com.kclm.owep.web.controller;

import com.kclm.owep.convert.UserConvert;
import com.kclm.owep.dto.UserDto;
import com.kclm.owep.entity.ExamBank;
import com.kclm.owep.entity.ExamQues;
import com.kclm.owep.entity.ExamQuesAnswerSet;
import com.kclm.owep.entity.User;
import com.kclm.owep.service.ExamBankService;
import com.kclm.owep.service.ExamQuesAnswerSetService;
import com.kclm.owep.service.ExamQuesService;
import com.kclm.owep.service.UserService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/exam")
public class ExamBankController {
    @Autowired
    private ExamBankService examBankService;
    @Autowired
    UserService userService;
    @Autowired
    private ExamQuesService examQuesService;
    @Autowired
    private ExamQuesAnswerSetService examQuesAnswerSetService;

    private User getLoginUser(HttpSession session){
        UserDetails userDetails=(UserDetails)session.getAttribute("LOGIN_USER");
        UserDto userDto = userService.selectByName(userDetails.getUsername());
        User user = UserConvert.INSTANCE.updateEntityFromDto(userDto);
        return user;
    }

    @RequestMapping("/titleList")
    public String totitleList(HttpSession session,Model model){
        //todo  ....
        User user = getLoginUser(session);
        List<ExamBank> myAllBanks=examBankService.selectMyAllBank(user.getId());
//        System.out.println(myAllBanks.size());
//        for(ExamBank examBank:myAllBanks){
//            System.out.println(examBank.getBankName()+"====="+examBank.getId());
//        }
        model.addAttribute("myAllBanks",myAllBanks);
//        session.setAttribute("MyAllBanks",list);
        return "exam/titleList";
    }

    //查找首页
    @RequestMapping("/titleList.do")
    @ResponseBody
    public List<ExamBank> dotitleList(HttpSession session){
        User user = getLoginUser(session);
        List<ExamBank> list=examBankService.selectMyAllBank(user.getId());
//        System.out.println(list);
        return list;
    }

    //查看共享题库
    @RequestMapping("/titleListshare.do")
    @ResponseBody
    public List<ExamBank> dotitleListshare(HttpSession session){
        List<ExamBank> list=examBankService.selectselectAllshare();
//        System.out.println(list);
        return list;
    }

    //创建题库
    @RequestMapping("/saveBank.do")
    @ResponseBody
    public String doSaveBank(ExamBank examBank,HttpSession session){
        System.out.println(examBank);
        User user = getLoginUser(session);
        examBank.setUser(user);
        examBank.setQuesNumber(0);
        examBank.setLastAccessTime(LocalDateTime.now());
        examBankService.save(examBank);
        return "success";
    }

    //删除题库（假删除）
    @RequestMapping("/deletebyid.do")
    @ResponseBody
    public String doDeleteById(Integer id){
        examBankService.deletebyid(id);
        return "forward:/titleList.do";
    }

    //更新我的题库
    @RequestMapping("/updateMyBank.do")
    @ResponseBody
    public String doUpdateMyBank(ExamBank examBank){
        examBank.setLastAccessTime(LocalDateTime.now());
//        System.out.println(examBank);
        examBankService.updateMyBank(examBank);
        return "forward:/exam/titleList";
    }

    //模糊找寻我的题库
    @RequestMapping("/searchMyBank.do")
    @ResponseBody
    public List<ExamBank> doSearchMyBank(HttpSession session,String word,int mhStatus,int mhSecurity){
        User user = getLoginUser(session);
        List<ExamBank> list=examBankService.searchMyBank(word,mhStatus,mhSecurity,user.getId());
//        System.out.println(list);
        return list;
    }

    //模糊查询共享题库
    @RequestMapping("/searchShareBank.do")
    @ResponseBody
    public List<ExamBank> doSearchShareBank(HttpSession session,String shareWord, int shareStatus,String userName){
            List<Integer> userIdList=new ArrayList<Integer>();
            List<User> userList=userService.selectByKeyword(userName,null);
            for (int i=0;i<userList.size();i++){
                userIdList.add(userList.get(i).getId());
            }
//            System.out.println(userIdList);

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

    //通过id值查找题库
    @RequestMapping("/SelectBankById.do")
    @ResponseBody
    public ExamBank doSelectBankById(Integer examBankId){
        System.out.println(examBankService.selectBankById(examBankId).getBankStatus());
        return examBankService.selectBankById(examBankId);
    }

    //导入试题
    @RequestMapping(value = "/addUploadFile.do",method = RequestMethod.POST)
    @ResponseBody
    public String doAddUploadFile(HttpSession session, Integer uploadBankId, @RequestParam("uploadFileName")MultipartFile uploadFile) throws Exception{
        System.out.println(uploadBankId);
        System.out.println(uploadFile.toString());
        //定义一个list 集合保存从excel解析的用户
        List<ExamQues> list = new ArrayList<>();
        //1.读取上传的文件
        InputStream inputStream = uploadFile.getInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        //2.获取工作表对象
        XSSFSheet sheet = wb.getSheetAt(0);
        //3.得到行的迭代器
        Iterator<Row> iterator = sheet.iterator();
        int rowNum = 0;
        while (iterator.hasNext()) {
            Row row = iterator.next();
            //跳过标题行
            if (rowNum == 0) {
                rowNum++;
                continue;
            }
            ExamQues examQues=new ExamQues();
            for(int i=0;i<=5;i++){
                examQues.setTypeName(row.getCell(0).getStringCellValue());
                examQues.setHardLevel(row.getCell(1).getStringCellValue());
                examQues.setQuesContent(row.getCell(2).getStringCellValue());
                examQues.setCorrectAnswer(row.getCell(3).getStringCellValue());
                examQues.setAnalyze(row.getCell(4).getStringCellValue());
                examQues.setLable(row.getCell(5).getStringCellValue());
                examQues.setLastAccessTime(LocalDateTime.now());
                examQues.setVersion(1);
                examQues.setUseCount(0);
                examQues.setSource("Excel导入");
                examQues.setUserName(getLoginUser(session).getUserName());
                examQues.setStatus(examBankService.selectBankById(uploadBankId).getBankStatus());
                examQues.setExamBank(examBankService.selectBankById(uploadBankId));
            }
            //试题存入数据库中
            examQuesService.saveExamQues(examQues);
            //创建ExamQuesAnswerSet的值
            ExamQuesAnswerSet examQuesAnswerSet=new ExamQuesAnswerSet();
            //取新添加了ID的数据的该对象
            ExamQues EQ=examQuesService.selectMyQues(examQues.getUserName()).get(0);
            //获取ques_id
            examQuesAnswerSet.setExamQues(EQ);

            //

            if (EQ.getTypeName().equals("单选题")||EQ.getTypeName().equals("多选题")){
                System.out.println(EQ);
                char choice='A';
                //
                for (int i=6;i<=9;i++){
                    //将CorrectAnswer的String切割成String数组
                    String[] str=EQ.getCorrectAnswer().split("");
                    //选项char转化为String
                    examQuesAnswerSet.setTypeName(""+choice);
                    //foreach判断answerstatus
                    for (String s:str) {
                        //如果choice不等于数组中的任何值
                            if (!s.equals(choice+"")){
                                examQuesAnswerSet.setAnswerStatus(0);
                            }else{
                                examQuesAnswerSet.setAnswerStatus(1);
                            }
                    }
                    //设置选项内容
                    examQuesAnswerSet.setAnswerContent(row.getCell(i).getStringCellValue());
                    //char类型相加
                    System.out.println(choice);
                    choice++;
                    //选项存入数据库
                    examQuesAnswerSetService.save(examQuesAnswerSet);
                }
            }

            //

            if (EQ.getTypeName().equals("回答题")||EQ.getTypeName().equals("判断题")||EQ.getTypeName().equals("附件题")){
                examQuesAnswerSet.setAnswerStatus(1);
                examQuesAnswerSet.setAnswerContent(row.getCell(3).getStringCellValue());
                System.out.println(examQuesAnswerSet);
                //选项存入数据库
                examQuesAnswerSetService.save(examQuesAnswerSet);
            }

            //

            if (EQ.getTypeName().equals("填空题")){

                String[] str=EQ.getCorrectAnswer().split(" ");
                int num=1;
                for (String s:str) {
                    examQuesAnswerSet.setAnswerStatus(1);
                    examQuesAnswerSet.setTypeName(num+"");
                    examQuesAnswerSet.setAnswerContent(s);
                    num++;
                    examQuesAnswerSetService.save(examQuesAnswerSet);
                }

            }
            System.out.println();
        }
        examBankService.updateQuesNumber(uploadBankId);
        System.out.println(">>>>>>>>>>>>> success...");
        //8.重定向到企业列表
        //return "success";String
        //return ResponseEntity.ok("success");
        return "success";
}


//    导出试题
    @RequestMapping("exportQues.do")
    @ResponseBody
    public String doExportQues(int bankId,String type) throws Exception{
        //获取ExamQues的list值
        List<ExamQues> list1=examQuesService.selectbyBankIdAndtypeName(bankId, type);

        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //新建工作表
        XSSFSheet sheet = workbook.createSheet("试题列表");
//        创建列标题;并且设置列标题
        XSSFRow row1=sheet.createRow(0);
        if (type.equals("单选题")||type.equals("多选题")){
            String[] titles={"类型","难度","题干","正确答案","答案解析","知识","选项A","选项B","选项C","选项D"};
            for (int i=0;i<titles.length;i++){
                XSSFCell cell=row1.createCell(i);
                //单元格赋值
                cell.setCellValue(titles[i]);
            }
        }else{
            String[] titles={"类型","难度","题干","正确答案","答案解析","知识"};
            for (int i=0;i<titles.length;i++){
                XSSFCell cell=row1.createCell(i);
                //单元格赋值
                cell.setCellValue(titles[i]);
            }
        }

        //将list写入excel
        if (list1!=null){
            if (type.equals("单选题")||type.equals("多选题")){
                for (int i=0;i<list1.size();i++){
                    XSSFRow row2=sheet.createRow(i+1);
                    XSSFCell cell1=row2.createCell(0);
                    cell1.setCellValue(list1.get(i).getTypeName());
                    XSSFCell cell2=row2.createCell(1);
                    cell2.setCellValue(list1.get(i).getHardLevel());
                    XSSFCell cell3=row2.createCell(2);
                    cell3.setCellValue(list1.get(i).getQuesContent());
                    XSSFCell cell4=row2.createCell(3);
                    cell4.setCellValue(list1.get(i).getCorrectAnswer());
                    XSSFCell cell5=row2.createCell(4);
                    cell5.setCellValue(list1.get(i).getAnalyze());
                    XSSFCell cell6=row2.createCell(5);
                    cell6.setCellValue(list1.get(i).getLable());
                    //获得选项list
                    List<ExamQuesAnswerSet> list2=examQuesAnswerSetService.selectByQuesId(list1.get(i).getId());
                    for (int j=0;j<list2.size();j++){
                        XSSFCell choiceCell=row2.createCell(j+6);
                        choiceCell.setCellValue(list2.get(j).getAnswerContent());
                    }
                }
            }else{
                for (int i=0;i<list1.size();i++){
                    XSSFRow row2=sheet.createRow(i+1);
                    XSSFCell cell1=row2.createCell(0);
                    cell1.setCellValue(list1.get(i).getTypeName());
                    XSSFCell cell2=row2.createCell(1);
                    cell2.setCellValue(list1.get(i).getHardLevel());
                    XSSFCell cell3=row2.createCell(2);
                    cell3.setCellValue(list1.get(i).getQuesContent());
                    XSSFCell cell4=row2.createCell(3);
                    cell4.setCellValue(list1.get(i).getCorrectAnswer());
                    XSSFCell cell5=row2.createCell(4);
                    cell5.setCellValue(list1.get(i).getAnalyze());
                    XSSFCell cell6=row2.createCell(5);
                    cell6.setCellValue(list1.get(i).getLable());
                }
            }

        }
        //输出
        FileOutputStream out = new FileOutputStream(new File("D:\\Temp\\ExportExcel\\ExportQuesTest.xlsx"));
        workbook.write(out);
        workbook.close();
        out.close();
        return "success";
    }
}
