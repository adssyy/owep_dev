package com.kclm.owep.web.controller;


import com.alibaba.fastjson.JSON;
import com.kclm.owep.dto.GroupDTO;
import com.kclm.owep.dto.NodeDTO;
import com.kclm.owep.dto.UserDto;
import com.kclm.owep.dto.UserGroupDTO;
import com.kclm.owep.entity.Group;
import com.kclm.owep.entity.Student;
import com.kclm.owep.entity.User;
import com.kclm.owep.mapper.StudentMapper;
import com.kclm.owep.service.GroupService;
import com.kclm.owep.service.RoleService;
import com.kclm.owep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/***
 * @By: Athreine
 * @For: 用户管理菜单下的后台业务控制
 */

@Controller
@RequestMapping("/user")
public class UserManController {

    @Autowired
    UserService userService;

    @Resource
    StudentMapper studentMapper;

    @Autowired
    GroupService groupService;

    @Autowired
    RoleService roleService;

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
    public String toAdminListPage(){
        return "user/adminList";
    }


    /***
     * @By: Artherine
     * @param offset 在这个方法里并没有用上，原意是让mysql分页传输，不过server层并没有对应去做
     * @For: 为前端提供管理员用户表数据
     * @return List<User>
     */
    @GetMapping(value = "/adminList/getTable",produces = "application/json")
    @ResponseBody
    @PreAuthorize("hasAuthority('7-21')")//查询权限
    public Object getAdminTable(@RequestParam("offset") int offset){

        System.out.println("User manager adminList get admin table data");

        {
            List<User> users = userService.selectByType(1);
            System.out.println("管理员用户列表：");
            users.forEach( System.out::println);
            return  users;
        }//数据库

//        {
//            return "[\n" +
//                    "  {\n" +
//                    "    \"id\": 1,\n" +
//                    "    \"class\": \"17软件(2)班\",\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15678889830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"不启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 2,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"女\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 3,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"女\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 4,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 5,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"不启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 6,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 7,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 8,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 9,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 10,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 11,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 12,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 13,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 14,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 15,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 16,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 17,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 18,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 19,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  },\n" +
//                    "  {\n" +
//                    "    \"id\": 20,\n" +
//                    "    \"serialNumber\": \"2020061101\",\n" +
//                    "    \"major\": \"JAVA开发工程师\",\n" +
//                    "    \"customerBelongs\": \"开发部\",\n" +
//                    "    \"stuId\": \"zbstu200324000006\",\n" +
//                    "    \"sex\": \"男\",\n" +
//                    "    \"userName\": \"MaoJiuWei\",\n" +
//                    "    \"name\": \"MaoJiuWei\",\n" +
//                    "    \"phone\": \"15679999830\",\n" +
//                    "    \"email\": \"3628761@qq.com\",\n" +
//                    "    \"startUsing\": \"启用\",\n" +
//                    "    \"lastLandingTime\": \"2020-06-11 11:37:29\",\n" +
//                    "    \"operation\": \"我是按钮\"\n" +
//                    "  }\n" +
//                    "]";
//        }//静态
    }//method get table data


    /***
     * @By: Artherine
     * @For: 根据前端的用户名信息返回用户对象(表 单一元素)
     * @param userName
     * @param realName
     * @return User
     */
    @GetMapping(value = "/adminList/search",produces = "application/json")
    @ResponseBody
    public Object postAdminSearch(@RequestParam("userName") String userName , @RequestParam("realName") String realName){

        System.out.println("搜索用户："+userName+"-"+realName);//todo
        List<User> users = userService.selectByType(1);
        for (User user :users){
            if (user.getUserName().equals(userName)){
                System.out.println("userName match:"+userName);
                if (user.getRealName().equals(realName)){
                    System.out.println("realName match"+realName);
                    System.out.println("user found "+user);
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
    public String postAdminAddAction(@RequestBody User user){
        user.setUserType(1);//userType 1 代表管理员账户
        userService.create(user);
        System.out.println("增加管理员用户："+user);//todo
        String feedback = "success";
        return feedback;
    }

    /***
     * @By Artherine
     * @For 删除用户(真的删，不是概念删除)
     * @param id 需要删除的用户id
     * @return msg
     */
    @GetMapping(value = "/adminList/delete", produces = "application/json")
    @ResponseBody
    public String postAdminDeleteAction(@RequestParam("id") Integer id){//@RequestParam解析表单，Json得用@RequestBody转译,或者干脆点什么都不加
        userService.delete(id);
        System.out.println("删除用户："+id);//todo
        return "success";
    }

    /***
     * @By Artherine
     * @For 集群删除 删除选中
     * @param userIds
     * @return null
     */
    @PostMapping("/adminList/deleteByGroup")
    @ResponseBody
    public String postAdminDeleteByGroup(@RequestBody ArrayList<Integer> userIds){
        System.out.println("delete by group - ids:"+userIds);
        for(Integer id : userIds){
            System.out.println("delete userId:"+id);
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
    public String postAdminEditAction(User user){
        System.out.println("编辑管理员用户："+user);//todo
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
    public void postAdminValidSwitch(@RequestParam Integer userId, @RequestParam Integer status){
        System.out.println("switching admin user validation:" + userId+","+status);
        if(status==null){
            System.out.println("Warning： status value is null, nothing to do here");
            return;
        }
        if (status==1){
            System.out.println("user admin validation activated");
            userService.activate(userId);
        }else{
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
    //        public Object postTreeCheckEdit( UserGroupDTO userGroupDTO){
//    public Object postTreeCheckEdit( String str){
    public Object postTreeCheckEdit(@RequestBody UserGroupDTO userGroupDTO){
//        System.out.println(str);
//        UserGroupDTO userGroupDTO = (UserGroupDTO) JSON.parse(str);
        System.out.println("U-G dto: "+ userGroupDTO);
        Integer userId = userGroupDTO.getUserId();
        List<Integer> groupIds = userGroupDTO.getGroupIds();
        userService.setGroups(userId,groupIds);
        String result = "success";
        return result;
    }


    /***
     * @By Artherine
     * @For 为前端提供用户组多选框表 并预设当前用户的用户组关系
     * @param userId
     * @return NodeDTO(...,List<NodeDTO> nodes)
     */
    @GetMapping(value = "/adminList/treeCheck", produces = "application/json")
    @ResponseBody
    public Object getTreeCheckData(@RequestParam("id") Integer userId){
//    public Object getTreeCheckData(){//不需要设置原状态，不用id
        System.out.println("User manager adminList get Tree&Check Data");

        {//数据库数据 TODO
            List<GroupDTO> groupDTOS = groupService.selectAllGroups(0);//从库中获得所有对象
            List<Integer> groupIds = userService.getGroupIds(userId);//查询用户之前归属的用户组id
            List<NodeDTO> nodes = new ArrayList<>();
            for (GroupDTO group:groupDTOS){//封装为NodeDTO
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
            System.out.println("用户组节点树和状态："+nodeArr[0]);//todo
            return nodeArr;

        }//数据库调取

//        {//静态数据
//            return "[\n" +
//                    "  {\n" +
//                    "    \"text\": \"用户组\",\n" +
//                    "    \"href\": \"#action0\",\n" +
//                    "    \"nodes\": [\n" +
//                    "        {\n" +
//                    "        \"text\": \"代码测试组\"\n" +
//                    "        },\n" +
//                    "        {\n" +
//                    "        \"text\": \"市场部\"\n" +
//                    "        },\n" +
//                    "        {\n" +
//                    "        \"text\": \"班主任\"\n" +
//                    "        },\n" +
//                    "        {\n" +
//                    "        \"text\": \"测试教务\"\n" +
//                    "        },\n" +
//                    "        {\n" +
//                    "        \"text\": \"教务处\"\n" +
//                    "        },\n" +
//                    "        {\n" +
//                    "        \"text\": \"教师组\"\n" +
//                    "        },\n" +
//                    "        {\n" +
//                    "        \"text\": \"管理员组\"\n" +
//                    "        }\n" +
//                    "    ]";
//        }//静态伪数据

    }//method: get tree data and check status









    /***
     * @By: Artherine
     * @For: 跳转至学生管理页面
     * @return: page_.html
     */
    @GetMapping("/stuList")
    public String toStuListPage(){
        return "user/stuList";
    }

    @GetMapping("/stuList/getTable")
    @ResponseBody
    public Object getStuListTableData(@RequestParam("offset") int offset){

        System.out.println("User manager stuList get students table data");
        {
            List<Student> students = studentMapper.selectAll();
            System.out.println("管理员用户列表：");
            students.forEach( System.out::println);
            return  students;
        }//数据库
    }




    /***
     * @By: Artherine
     * @For: 跳转至教师管理页面
     * @return: page_.html
     */
    @GetMapping("/teacherList")
    public String toTeacherList(){
        return "user/teacherList";
    }





    /***
     * @By: Artherine
     * @For: 跳转至咨询师管理页面
     * @return: page_.html
     */
    @GetMapping("/advisorList")
    public String toAdvisorList(){
        return "user/advisorList";
    }






}
