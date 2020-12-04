/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.web.controller;

import com.kclm.owep.dto.BranchInstituteDTO;
import com.kclm.owep.dto.OrgInstituteDTO;
import com.kclm.owep.entity.OrgInstitute;
import com.kclm.owep.service.BranchInstituteService;
import com.kclm.owep.service.OrgInstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tanj
 * @version v1.0
 * @date 2020/6/28 21:15
 * @description 描述班级模块跳转到指定页面
 */
@Controller
@RequestMapping("clazz")
public class ClazzController {

    @Autowired
    private OrgInstituteService orgInstituteService;

    @Autowired
    private BranchInstituteService branchInstituteService;

    /***
     * 跳转到专业方向页面
     * @return
     */
    @GetMapping("major")
    public String toClazzMajor(){
        return "clazz/major";
    }

    /***
     * 跳转到班级列表页面
     * @return
     */
    @GetMapping("clazzList")
    public String toClazzList(){
        return "clazz/clazzList";
    }

    /***
     * 跳转到班级作业页面
     * @return
     */
    @GetMapping("homework")
    public String toHomework(){
        return "clazz/homework";
    }

    /***
     * 跳转到布置作业页面
     * @return
     */
    @GetMapping("question")
    public String toQuestion(){
        return "clazz/question";
    }

    /***
     * 跳转到学习进度页面
     * @return
     */
    @GetMapping("studyProcess")
    public String toStudyProcess(){
        return "clazz/studyProcess";
    }

    /***
     * 获取所有机构
     * @return
     */
    @RequestMapping(value = "getAllInstitute",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Map getAllInstitute(){
        List<OrgInstituteDTO> allinstitute = this.orgInstituteService.findAllinstitute();
        Map map = new HashMap();
        map.put("value",allinstitute);
        return map;
    }

    /***
     * 根据机构id获取分支
     * @param id
     * @return
     */
    @RequestMapping(value = "getBranchByInstitute",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Map getBranchByInstitute(Integer id){
        OrgInstitute orgInstitute = new OrgInstitute();
        orgInstitute.setId(id);
        List<BranchInstituteDTO> byInstitute = this.branchInstituteService.findByInstitute(orgInstitute);
        Map map = new HashMap();
        map.put("value",byInstitute);
        return map;
    }


}
