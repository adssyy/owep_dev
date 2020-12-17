package com.kclm.owep.web.controller;



import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import com.alibaba.fastjson.JSONArray;
import com.kclm.owep.dto.*;

import com.kclm.owep.entity.Group;
import com.kclm.owep.entity.Result;
import com.kclm.owep.entity.Student;
import com.kclm.owep.entity.User;
import com.kclm.owep.mapper.StudentMapper;
import com.kclm.owep.service.*;
import com.kclm.owep.utils.util.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
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


/***
 * @By: Athreine
 * @For: 用户管理菜单下的后台业务控制
 */

@Controller
@RequestMapping("/user")
public class UserManController {

    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;

    @Resource
    StudentMapper studentMapper;

    @Autowired
    GroupService groupService;

    @Autowired
    RoleService roleService;

    @Autowired
    ClazzService clazzService;


    /**
     *方法级请求拦截器
     * 注释实现
     *  用户访问/操作权限限制
     *  说明：
     *  @ PreAuthorize("hasAuthority('xxxx')")
     *  在方法名上方添加此注释，指向此方法的访问请求会需要先通过一个过滤器
     *  想访问此方法的用户需要携带有'xxxx'权限字段，否则请求被拒绝 前端对应链接 404
     *  没有此注释的方法被认为是公开方法，即只要能够浏览页面(或知道url)所有登陆过的用户都可访问
     *
     *  用户的权限字段目前由 menu_id - action_id 拼接得到.
     *  例： [用户组管理](id=16) 页面的 [查询](id=21) 操作 对应的权限字为  '16-21'
     *  则方法 查询用户组信息 :
     *
     *  @ PreAuthorize("hasAuthority('16-21')")
     *  public String toPrivilegeUserGroup(){
     *      ...;
     *      ...;
     *  }
     *
     * 若需要为一个方法指定复数个权限：
     *    @ PreAuthorize("hasAnyAuthority('r1','r2')")   —— 拥有 r1 或 r2  可访问
     *    @ PreAuthorize("hasAuthority('r1','r2')") ——需要同时持有 r1 和 r2 才能访问
     */

/***
 * 行为表
 * name  -  id
 * ----------------------
 * 查询  -  21
 * 添加  -  22
 * 修改  -  23
 * 删除  -  24
 */

/***
 * 菜单表
 * name - id
 * ----------------------
 * 管理员管理 -  7
 * 学生管理   -  8
 * 教师管理   -  14
 * 咨询师管理 -  15
 */


    /***
     * @For: 跳转至管理员管理界面
     * @By: Artherine
     * @return: page_.html
     */
    @GetMapping("/adminList")
    @PreAuthorize("hasAuthority('7-21')")//查询权限
    public String toAdminListPage() {
        return "user/adminList";
    }


    /***
     * @By: Artherine
     * @param offset 在这个方法里并没有用上，原意是让mysql分页传输，不过server层并没有对应去做
     * @For: 为前端提供管理员用户表数据
     * @return List<User>
     */
    @GetMapping(value = "/adminList/getTable", produces = "application/json")
    @ResponseBody
    @PreAuthorize("hasAuthority('7-21')")//查询权限
    public Object getAdminTable(@RequestParam("offset") int offset) {

        System.out.println("User manager adminList get admin table data");

        {
            List<User> users = userService.selectByType(1);
            System.out.println("管理员用户列表：");
            users.forEach(System.out::println);
            return users;
        }//数据库
    }//method get table data


    /***
     * @By: Artherine
     * @For: 根据前端的用户名信息返回用户对象(表 单一元素)
     * @param userName
     * @param realName
     * @return User
     */
    @GetMapping(value = "/adminList/search", produces = "application/json")
    @ResponseBody
    public Object postAdminSearch(@RequestParam("userName") String userName, @RequestParam("realName") String realName) {
        System.out.println("搜索用户：" + userName + "-" + realName);//todo
        List<User> users = userService.selectByType(1);
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                System.out.println("userName match:" + userName);
                if (user.getRealName().equals(realName)) {
                    System.out.println("realName match" + realName);
                    System.out.println("user found " + user);
                    ArrayList<Object> result = new ArrayList<>();
                    result.add(user);
                    return result;
                }
            }
        }
        return "return:{'msg':'User not found'}";

    }


    /***
     * @By: Artherine
     * @For: 处理新增用户业务
     * @param user
     * @return msg
     */
    @PostMapping(value = "/adminList/addAdmin")
    @ResponseBody
    public String postAdminAddAction(@RequestBody User user) {
        user.setUserType(1);//  userType 1 代表管理员账户
        userService.create(user);
        System.out.println("增加管理员用户：" + user);//todo
        String feedback = "success";
        return feedback;
    }

    /***
     * @By Artherine
     * @For 删除用户(真的删 ， 不是概念删除)
     * @param id 需要删除的用户id
     * @return msg
     */
    @GetMapping(value = "/adminList/delete", produces = "application/json")
    @ResponseBody
    public String postAdminDeleteAction(@RequestParam("id") Integer id) {//@RequestParam解析表单，Json得用@RequestBody转译,或者干脆点什么都不加
        userService.delete(id);
        System.out.println("删除用户：" + id);//todo
        return "";
    }

    /***
     * @By Artherine
     * @For 集群删除 删除选中
     * @param userIds
     * @return null
     */
    @PostMapping("/adminList/deleteByGroup")
    @ResponseBody
    public String postAdminDeleteByGroup(@RequestBody ArrayList<Integer> userIds) {
        System.out.println("delete by group - ids:" + userIds);
        for (Integer id : userIds) {
            System.out.println("delete userId:" + id);
            userService.delete(id);
        }
        return "";
    }

    /***
     * @By Artherine
     * @For 编辑用户信息
     * @param user
     * @return msg
     */
    @PostMapping(value = "/adminList/edit")
    @ResponseBody
    public String postAdminEditAction(User user) {
        System.out.println("编辑管理员用户：" + user);//todo
        userService.update(user);
        String feedback = "success";
        return feedback;
    }

    /***
     * @By Artherine
     * @For 同步账户激活状态
     * @param userId
     * @param status
     */
    @GetMapping("/adminList/switch")
    @ResponseBody
    public void postAdminValidSwitch(@RequestParam Integer userId, @RequestParam Integer status) {
        System.out.println("switching admin user validation:" + userId + "," + status);
        if (status == null) {
            System.out.println("Warning： status value is null, nothing to do here");
            return;
        }
        if (status == 1) {
            System.out.println("user admin validation activated");
            userService.activate(userId);
        } else {
            System.out.println("user admin validation canceled");
            userService.deactivate(userId);
        }
    }

    /***
     * @By Artherine
     * @For 修改 对应用户的 用户-用户组 关系
     * @param userGroupDTO
     * @return msg
     */
    @PostMapping(value = "/adminList/treeCheck_edit")
    @ResponseBody
    public Object postTreeCheckEdit(@RequestBody UserGroupDTO userGroupDTO) {
        System.out.println("U-G dto: " + userGroupDTO);
        Integer userId = userGroupDTO.getUserId();
        List<Integer> groupIds = userGroupDTO.getGroupIds();
        userService.setGroups(userId, groupIds);
        String result = "success";
        return result;
    }


    /***
     * @By Artherine
     * @For 为前端提供用户组多选框表 并预设当前用户的用户组关系
     * @param userId
     * @return NodeDTO(..., List < NodeDTO > nodes)
     */
    @GetMapping(value = "/adminList/treeCheck", produces = "application/json")
    @ResponseBody
    public Object getTreeCheckData(@RequestParam("id") Integer userId) {
        System.out.println("User manager adminList get Tree&Check Data");
        {//数据库数据 TODO
            List<GroupDTO> groupDTOS = groupService.selectAllGroups(0);//从库中获得所有对象
            List<Integer> groupIds = userService.getGroupIds(userId);//查询用户之前归属的用户组id
            List<NodeDTO> nodes = new ArrayList<>();
            for (GroupDTO group : groupDTOS) {//封装为NodeDTO
                NodeDTO subNode = new NodeDTO();
                Integer groupId = group.getId();
                subNode.setTags(groupId);
                subNode.setText(group.getGroupName());
                if (groupIds.contains(groupId)) {//id在记录列表中则激活此节点
                    subNode.nodeChecked();
                }
                nodes.add(subNode);//节点入列
            }
            NodeDTO topNode = new NodeDTO();//把用户组节点包装在一个父节点下
            topNode.setTags(0);
            topNode.setText("用户组");
            topNode.setNodes(nodes);
            NodeDTO[] nodeArr = new NodeDTO[1];
            nodeArr[0] = topNode;
            System.out.println("用户组节点树和状态：" + nodeArr[0]);//todo
            return nodeArr;

        }
    }
/*----------------------------------------------------------------------学生方法---------------------------------------------------------------------------------------------------------*/

    /***
     * @By: Artherine
     * @For: 跳转至学生管理页面
     * @return: page_.html
     */
    @GetMapping("/stuList")
    public String toStuListPage() {

        return "user/stuList";
    }

    /**
     * @param offset
     * @return List<Student>
     * @By:SakuraFallen
     * @for 为前端提供学生用户表数据
     */
    @GetMapping(value = "/stuList/getTable", produces = "application/json")
    @ResponseBody
    public Object getStuListTableData(@RequestParam("offset") int offset) {

        System.out.println("User manager stuList get students table data");
        {
            List<Student> students = studentService.selectAll();
            System.out.println("学生用户列表：");
            students.forEach(System.out::println);
            return students;
        }//数据库
    }

    @GetMapping(value = "/stuList/getTableNoClass", produces = "application/json")
    @ResponseBody
    public Object getStuListTableDataNoClass(@RequestParam("offset") int offset) {

        System.out.println("User manager stuList get NoClassStudents table data");
        {
            List<Student> students = studentService.selectNoClass();
            System.out.println("没有班级的学生用户列表：");
            students.forEach(System.out::println);
            return students;
        }//数据库
    }
    /***
     * @By:SakuraFallen
     * @param student
     * @for 实现学生的添加功能
     * @return msg
     */
    @PostMapping(value = "/stuList/addStudent")
    @ResponseBody
    public String postStudentAddAction(@RequestBody Student student) {
        student.setIsDelete(1);
        studentService.create(student);
        System.out.println("增加学生用户" + student);
       // String feedback = "success";
        return "success";
    }

    /***
     * @By SakuraFallen
     * @param id    需要删除的用户id
     * @For 实现学生的删除功能(真的删 ， 不是概念删除)
     * @Return msg
     */
    @GetMapping(value = "/stuList/delete", produces = "application/json")
    @ResponseBody
    public String postStudentDeleteAction(@RequestParam("id") Integer id) {//@RequestParam解析表单，Json得用@RequestBody转译,或者干脆点什么都不加
        studentService.delete(id);
        System.out.println("删除用户：" + id);//todo
        return "success";
    }

    /***
     * @By SakuraFallen
     * @For 编辑学生信息
     * @param student
     * @return msg
     */
    @PostMapping(value = "/stuList/edit")
    @ResponseBody
    public Object postStudentEditAction(@RequestBody Student student) {
        System.out.println("编辑学生信息：" + student);//todo
        studentService.update(student);
        return   new Result("200","OK");
    }

    /***
     * @By Artherine
     * @For 学生页面的集群删除 删除选中
     * @param stuIds
     * @return null
     */
    @PostMapping("/stuList/deleteByGroup")
    @ResponseBody
    public String postStudentDeleteByGroup(@RequestBody ArrayList<Integer> stuIds) {
        System.out.println("delete by group - ids:" + stuIds);
        for (Integer id : stuIds) {
            System.out.println("delete stuIds:" + id);
            studentMapper.delete(id);
        }
        return "";
    }

    @GetMapping(value = "/stuList/search", produces = "application/json")
    @ResponseBody
    public Object postStudentSearch( String className,  String stuName,
                                    String schoolName, String collegeName ,
                                    String interviewTimeStart, String interviewTimeEnd) {
        System.out.println("---------------------------------------------------------------------------------------------------");
        final LocalDateTime start=DateUtil.stringToLocalDateTime(interviewTimeStart);
        final LocalDateTime end = DateUtil.stringToLocalDateTime(interviewTimeEnd);
        System.out.println(className+","+stuName+","+schoolName+","+collegeName);
        final List<Student> list=studentService.findByKeyword(stuName);
        ArrayList arr = new ArrayList();
        for (Student lists : list) {
            //匹配姓名
            if (lists.getStuName().equals(stuName)) {
                //用时间判断
                if(lists.getCreateTime().isAfter(start) && lists.getCreateTime().isBefore(end)) {
                    arr.add(list);
                }
            }
        }
        System.out.println("================================*************");
        System.out.println(arr);
        return arr;
    }

    /***
     * @By Artherine
     * @For 同步账户激活状态
     * @param userId
     * @param status
     */
    @GetMapping("/stuList/switch")
    @ResponseBody
    public void StudentValidSwitch(@RequestParam Integer userId, @RequestParam Integer status) {
        System.out.println("switching student validation:" + userId + "," + status);
        if (status == null) {
            System.out.println("Warning： status value is null, nothing to do here");
            return;
        }
        if (status == 1) {
            System.out.println("student  validation activated");
            studentService.activate(userId);
        } else {
            System.out.println("student  validation activated");
            studentService.deactivate(userId);
        }
    }




    /**
     *
     * @return
     */
    @RequestMapping("/stuList/findAllClass")
    @ResponseBody
    public Object findAllClass(){
        final List<ClazzDTO> className=clazzService.selectAll();
        HashMap map=new HashMap();
        map.put("value",className);
        System.out.println(map);
        return map;
    }

    /**
     *
     * @return
     */
    @RequestMapping("/stuList/findAllStudent")
    @ResponseBody
    public  Object findAllStudent(){
        final  List<Student> students=studentService.selectAll();
        HashMap map=new HashMap();
        map.put("value",students);
        return map;
    }


    @RequestMapping("/stuList/findAllSchool")
    @ResponseBody
    public  Object findAllSchool(){
        final List<Student> schools=studentService.selectAllSchool();
        HashMap map=new HashMap();
        map.put("value",schools);
        System.out.println(map);
        return map;
    }


    @RequestMapping("/stuList/findAllCollege")
    @ResponseBody
    public  Object findAllCollege(){
        final List<Student> colleges=studentService.selectAllCollege();
        HashMap map=new HashMap();
        map.put("value",colleges);
        return map;
    }

    @RequestMapping("/stuList/findClassName")
    @ResponseBody
    public String findClassName(Integer id){
        return studentService.selectById(id).getClazz().getClassName();
    }

    @RequestMapping("/stuList/import")
    @ResponseBody
    public String studentImport(@RequestParam("file")MultipartFile file) throws IOException{
        // 获取上传文件的输入流
       try{
           String fileName=file.getOriginalFilename();
           InputStream inputStream=file.getInputStream();
           if(!fileName.matches("^.+\\.(?i)(xlsx)$")){
               return "文件格式有误";
           }
           XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
           XSSFSheet sheet=workbook.getSheetAt(0);
           Row titleRow=sheet.getRow(0);
           int lastRpwNum =sheet.getLastRowNum();
           int lastCellNum=titleRow.getLastCellNum();

           List<Map<String,Object>> list=new ArrayList<>();
           for (int i=1;i<lastRpwNum;i++){
               Map<String, Object> map = new HashMap<>();
               XSSFRow row = sheet.getRow(i);
              // Student student = new Student();
               for(int j = 0; j < lastCellNum; j++){
                   // 得到列名
                   String key = titleRow.getCell(j).getStringCellValue();
                   System.out.println(key);
                   XSSFCell cell = row.getCell(j);
                   DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                   if (cell != null){
                       if (key.equals("effectiveDate") || key.equals("birth")){
                           cell.setCellType(CellType.STRING);
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
           JSONArray jsonArray = new JSONArray();
           jsonArray.addAll(list);
           List<Student> students = jsonArray.toJavaList(Student.class);
        if(this.studentService.insertAllStudent(students)>0){
            return "插入成功";
        }else {
            return "插入失败";
        }
       } catch (IOException e) {
           e.printStackTrace();
       }
       return "插入失败";
    }

    /***
     * @By Artherine
     * @For 为前端提供学生多选框表 并预设当前学生的班级组关系
     * @param stuId
     * @return NodeDTO(..., List < NodeDTO > nodes)
     */
    @GetMapping(value = "/stuList/classTreeCheck", produces = "application/json")
    @ResponseBody
    public Object studentGetClassTreeCheckData(@RequestParam("id") Integer stuId) {
        System.out.println(stuId);
        System.out.println("Student manager teacherList get Tree&Check Data");

        {//数据库数据 TODOTe
            List<ClazzDTO> classDTOS = clazzService.selectAll();
            List<Integer> classIds = studentService.getClassIds(stuId);
            List<NodeDTO> nodes = new ArrayList<>();
            for (ClazzDTO clazz : classDTOS) {
                NodeDTO subNode = new NodeDTO();
                Integer classId = clazz.getId();
                System.out.println(classId);
                subNode.setTags(classId);
                subNode.setText(clazz.getClassName());
                if (classIds.contains(classId)) {        //id在记录列表中则激活此节点
                    subNode.nodeChecked();
                }
                nodes.add(subNode);//节点入列
            }
            NodeDTO topNode = new NodeDTO();//把用户组节点包装在一个父节点下
            topNode.setTags(0);
            topNode.setText("班级组");
            topNode.setNodes(nodes);
            NodeDTO[] nodeArr = new NodeDTO[1];
            nodeArr[0] = topNode;
            System.out.println("班级组节点树和状态：" + nodeArr[0]);//todo
            return nodeArr;
        }
    }

    /***
     * @By Artherine
     * @For 修改 对应学生的 班级组 关系
     * @param
     * @return msg
     */
    @PostMapping(value = "/stuList/treeCheck_edit")
    @ResponseBody
    public Object postStudentTreeCheckEdit(@RequestBody StudentClassDTO studentClassDTO) {
        System.out.println("SCD " + studentClassDTO);
        Integer stuId = studentClassDTO.getStuId();
        List<Integer> classIds = studentClassDTO.getClassIds();
        studentService.setClass(stuId,classIds.get(0));
        return "success";
    }


    public String changeClass(Student student){
        return "" ;
    }





    /*--------------------------------------以下为为教师界面的方法----------------------------------------------------------------------*/
    /***
     * @By: Artherine
     * @For: 跳转至教师管理页面
     * @return: page_.html
     */
    @GetMapping("/teacherList")
    public String toTeacherList() {

        return "user/teacherList";
    }

    /***
     * @for 为前端提供教师用户表数据
     * @param offset
     * @return user
     */
    @GetMapping(value = "/teacherList/getTable", produces = "application/json")
    @ResponseBody
    public Object getTeacherTable(@RequestParam("offset") int offset) {
        System.out.println("Teacher Manager teacherList get a teacher table data");
        {
            List<User> users = userService.selectByType(2);       //userType 2表示教师
            System.out.println("教师用户列表");
            users.forEach(System.out::println);
            return users;
        }
    }

    /***
     * @for 处理新增教师用户业务
     * @param user
     * @return
     */
    @PostMapping(value = "/teacherList/addTeacher")
    @ResponseBody
    public String postTeacherAddAction(@RequestBody User user) {
        user.setUserType(2);//  userType 2 代表老师账户
        userService.create(user);
        System.out.println("增加教师用户：" + user);//todo
        String feedback = "success";
        return feedback;
    }

    /***
     *  教师页面的删除功能
     * @param id
     * @return
     */
    @GetMapping(value = "/teacherList/delete", produces = "application/json")
    @ResponseBody
    public String postTeacherDeleteAction(@RequestParam("id") List<Serializable> id) throws Exception{//@RequestParam解析表单，Json得用@RequestBody转译,或者干脆点什么都不加
        try {
            userService.deleteSelect(id);
            System.out.println("删除教师用户：" + id);//todo
        } catch (Exception e) {
            return "该单位有分配";
        }
        return "";
    }

    /**
     * 教师界面的集群删除功能
     *
     * @param userIds
     * @return
     */
    @PostMapping("/teacherList/deleteByGroup")
    @ResponseBody
    public String postTeacherDeleteByGroup(@RequestBody ArrayList<Integer> userIds) {
        System.out.println("delete by group - ids:" + userIds);
        for (Integer id : userIds) {
            System.out.println("delete userId:" + id);
            userService.delete(id);
        }
        return "";
    }

//    /**
//     * 教师界面的集群删除功能
//     *
//     * @param userIds
//     * @return
//     */
//    @PostMapping("/teacherList/deleteByGroup")
//    @ResponseBody
//    public String postTeacherDeleteByGroup(@RequestBody List<Serializable> userIds) {
//        System.out.println("delete by group - ids:" + userIds);
//            userService.deleteSelect(userIds);
//        return "";
//    }
    /***
     *
     *  教师页面的 修改功能
     * @param user
     * @return
     */
    @PostMapping(value = "/teacherList/edit")
    @ResponseBody
    public String postTeacherEditAction(User user) {
        System.out.println("编辑教师用户：" + user);//todo
        userService.update(user);
        String feedback = "success";
        return feedback;
    }

    /***
     * @By Artherine
     * @For 修改 对应教师的 用户-用户组 关系
     * @param userGroupDTO
     * @return msg
     */
    @PostMapping(value = "/teacherList/treeCheck_edit")
    @ResponseBody
    public Object postTeacherTreeCheckEdit(@RequestBody UserGroupDTO userGroupDTO) {
        System.out.println("U-G dto: " + userGroupDTO);
        Integer userId = userGroupDTO.getUserId();
        List<Integer> groupIds = userGroupDTO.getGroupIds();
        userService.setGroups(userId, groupIds);
        String result = "success";
        return result;
    }


    /***
     * @By Artherine
     * @For 为前端提供用户组多选框表 并预设当前用户的用户组关系
     * @param userId
     * @return NodeDTO(..., List < NodeDTO > nodes)
     */
    @GetMapping(value = "/teacherList/treeCheck", produces = "application/json")
    @ResponseBody
    public Object getTeacherTreeCheckData(@RequestParam("id") Integer userId) {

        System.out.println("User manager teacherList get Tree&Check Data");

        {//数据库数据 TODOTe
            List<GroupDTO> groupDTOS = groupService.selectAllGroups(0);//从库中获得所有对象
            List<Integer> groupIds = userService.getGroupIds(userId);//查询用户之前归属的用户组id
            List<NodeDTO> nodes = new ArrayList<>();
            for (GroupDTO group : groupDTOS) {//封装为NodeDTO
                NodeDTO subNode = new NodeDTO();
                Integer groupId = group.getId();
                subNode.setTags(groupId);
                subNode.setText(group.getGroupName());
                if (groupIds.contains(groupId)) {//id在记录列表中则激活此节点
                    subNode.nodeChecked();
                }
                nodes.add(subNode);//节点入列
            }
            NodeDTO topNode = new NodeDTO();//把用户组节点包装在一个父节点下
            topNode.setTags(0);
            topNode.setText("用户组");
            topNode.setNodes(nodes);
            NodeDTO[] nodeArr = new NodeDTO[1];
            nodeArr[0] = topNode;
            System.out.println("用户组节点树和状态：" + nodeArr[0]);//todo
            return nodeArr;

        }
    }

    /***
     * @By Artherine
     * @For 修改 对应教师的 班级-班级组组 关系
     * @param
     * @return msg
     */
    @PostMapping(value = "/teacherList/classTreeCheck_edit")
    @ResponseBody
    public Object postTeacherClassTreeCheckEdit(@RequestBody UserClassDTO userClassDTO) {
        System.out.println("U-C dto: " + userClassDTO);
        Integer userId= userClassDTO.getUserId();
        List<Integer> classIds=userClassDTO.getClassIds();
        userService.setClass(userId,classIds);
        String result = "success";
        return result;
    }



    /***
     * @By Artherine
     * @For 为前端提供教师组多选框表 并预设当前教师的班级组关系
     * @param userId
     * @return NodeDTO(..., List < NodeDTO > nodes)
     */
    @GetMapping(value = "/teacherList/classTreeCheck", produces = "application/json")
    @ResponseBody
    public Object getClassTreeCheckData(@RequestParam("id") Integer userId) {
        System.out.println(userId);
        System.out.println("User manager teacherList get Tree&Check Data");

        {//数据库数据 TODOTe
            List<ClazzDTO> classDTOS = clazzService.selectAll();
            System.out.println(classDTOS);
            List<Integer> classIds = userService.getClassIds(userId);
            List<NodeDTO> nodes = new ArrayList<>();
            for (ClazzDTO clazz : classDTOS) {
                NodeDTO subNode = new NodeDTO();
                Integer classId = clazz.getId();
                subNode.setTags(classId);
                subNode.setText(clazz.getClassName());
                if (classIds.contains(classId)) {        //id在记录列表中则激活此节点
                    subNode.nodeChecked();
                }
                nodes.add(subNode);//节点入列
            }
            NodeDTO topNode = new NodeDTO();//把用户组节点包装在一个父节点下
            topNode.setTags(0);
            topNode.setText("班级组");
            topNode.setNodes(nodes);
            NodeDTO[] nodeArr = new NodeDTO[1];
            nodeArr[0] = topNode;
            System.out.println("班级组节点树和状态：" + nodeArr[0]);//todo
            return nodeArr;
        }
    }

    /***
     * @By: Artherine
     * @For: 根据前端的用户名信息返回用户对象(表 单一元素)
     * @param userName
     * @param realName
     * @return User
     */
    @GetMapping(value = "/teacherList/search", produces = "application/json")
    @ResponseBody
    public Object postTeacherSearch(@Param("userName") String userName, @Param("realName") String realName) {
        System.out.println(userName + realName);
        List<User> list = userService.selectByKeyword(userName, realName);
        list.forEach(System.out::println);
        return list;
    }

    /** 导出数据的方法，也就是下载Excel文件，把数据库里的文件通过流的方式读取，在存入
     *  由ExcelWrite创建的xls中，存放在内存中，
     *  最后通过通过Location传递URl的方法提供下载功能
     * @param response
     * @throws IOException
     */
    @RequestMapping("export")
    public void export(HttpServletResponse response) throws IOException {
        List<User> list = userService.selectByType(2);
        System.out.println(list);
        /* 通过工具类创建writer，默认创建xls格式 */
        ExcelWriter writer = ExcelUtil.getWriter();
        /* 自定义标题别名 测试完记得转会工具类*/
        writer.addHeaderAlias("userName", "用户名");
        writer.addHeaderAlias("userPwd", "密码");
        writer.addHeaderAlias("userPhone", "手机");
        writer.addHeaderAlias("realName", "姓名");
        writer.addHeaderAlias("userEmail", "邮箱");
        writer.addHeaderAlias("gender", "性别");

        /* 一次性写出内容，使用默认样式，强制输出标题 */
        writer.write(list, true);
        System.out.println(writer);
        /* out为OutputStream，需要写出到的目标流 */
        /* response为HttpServletResponse对象 */
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        /* test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码 */
        String name = "测试";
        response.setHeader("Content-Disposition", "attachment;filename=" + name + ".xls");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            writer.flush(out, true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /* 关闭writer，释放内存 */
            writer.close();
        }
        IoUtil.close(out);
    }

/*-----------------------------------------------以下是咨询师页面的方法--------------------------------------------------------------------------------*/
    /***
     * @By: Artherine
     * @For: 跳转至咨询师管理页面
     * @return: page_.html
     */
    @GetMapping("/advisorList")
    public String toAdvisorList() {
        return "user/advisorList";
    }

    /***
     *  为前端提供咨询师的列表
     * @param offset
     * @return
     */
    @GetMapping(value = "/advisorList/getTable", produces = "application/json")
    @ResponseBody
    public Object getAdvisorListTable(@RequestParam("offset") int offset) {
        System.out.println("Advisor Manager advisorList get a advisor table data");
        {
            List<User> users = userService.selectByType(3);       //userType 3  表示咨询师
            System.out.println("咨询师列表");
            users.forEach(System.out::println);
            return users;
        }
    }

    /***
     *  咨询师的添加功能
     * @param user
     * @return msg
     */
    @PostMapping(value = "/advisorList/addAdvisor")
    @ResponseBody
    public String postAdvisorAddAction(@RequestBody User user) {
        user.setUserType(3);//  userType 3 代表咨询师账户
        userService.create(user);
        System.out.println("增加咨询师用户：" + user);//todo
        String feedback = "success";
        return feedback;
    }

    /***
     *
     * @param userGroupDTO
     * @return
     */
    @PostMapping(value = "/advisorList/treeCheck_edit")
    @ResponseBody
    public Object postAdvisorTreeCheckEdit(@RequestBody UserGroupDTO userGroupDTO) {
        System.out.println("U-G dto: " + userGroupDTO);
        Integer userId = userGroupDTO.getUserId();
        List<Integer> groupIds = userGroupDTO.getGroupIds();
        userService.setGroups(userId, groupIds);
        String result = "success";
        return result;
    }

    /**
     * @param user
     * @return
     */
    @PostMapping(value = "/advisorList/edit")
    @ResponseBody
    public String postAdvisorEditAction(User user) {
        System.out.println("编辑咨询师用户：" + user);//todo
        userService.update(user);
        String feedback = "success";
        return feedback;
    }

    /**
     * @param id
     * @return
     */
    @GetMapping(value = "/advisorList/delete", produces = "application/json")
    @ResponseBody
    public String postAdvisorDeleteAction(@RequestParam("id") List<Serializable> id) {
        userService.deleteSelect(id);
        System.out.println("删除咨询师：" + id);//todo
        return "";
    }

    /**
     * @param userIds
     * @return
     */
    @PostMapping("/advisorList/deleteByGroup")
    @ResponseBody
    public String postAdvisorDeleteByGroup(@RequestBody ArrayList<Integer> userIds) {
        System.out.println("delete by group - ids:" + userIds);
        for (Integer id : userIds) {
            System.out.println("delete userId:" + id);
            userService.delete(id);
        }
        return "";
    }

    @GetMapping(value = "/advisorList/search", produces = "application/json")
    @ResponseBody
    public Object postAdvisorSearch(@Param("userName") String userName, @Param("realName") String realName) {
        System.out.println(userName + realName);
        List<User> list = userService.selectByKeywordAtAdvisor(userName, realName);
        list.forEach(System.out::println);
        return list;
    }

    /**
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping("/advisor/export")
    public void advisorExport(HttpServletResponse response) throws IOException {
        List<User> list = userService.selectByType(3);
        /* 通过工具类创建writer，默认创建xls格式 */
        ExcelWriter writer = ExcelUtil.getWriter();
        /* 自定义标题别名 测试完记得转会工具类*/
        writer.addHeaderAlias("userName", "用户名");
        writer.addHeaderAlias("userPwd", "密码");
        writer.addHeaderAlias("userPhone", "手机");
        writer.addHeaderAlias("realName", "姓名");
        writer.addHeaderAlias("userEmail", "邮箱");
        writer.addHeaderAlias("gender", "性别(“1”代表男，“0”代表女)");

        /* 一次性写出内容，使用默认样式，强制输出标题 */
        writer.write(list, true);
        System.out.println(writer);
        /* out为OutputStream，需要写出到的目标流 */
        /* response为HttpServletResponse对象 */
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        /* test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码 */
        String name = "advisor";
        response.setHeader("Content-Disposition", "attachment;filename=" + name + ".xls");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            writer.flush(out, true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /* 关闭writer，释放内存 */
            writer.close();
        }
        IoUtil.close(out);
    }


}
