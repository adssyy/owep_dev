/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.web.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.kclm.owep.dto.ProfessionDTO;
import com.kclm.owep.entity.Profession;
import com.kclm.owep.service.ProfessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tanj
 * @version v1.0
 * @date 2020/6/28 21:35
 * @description 专业方向 功能的具体控制层
 */
@RestController()
@RequestMapping("clazz")
public class ClazzMajorController {

    private static final Logger log = LoggerFactory.getLogger(ClazzMajorController.class);

    @Autowired
    private ProfessionService professionService;

    @RequestMapping(value = "saveMajor",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String save(Profession profession){

        if (this.professionService.save(profession) > 0){
            return "添加成功";
        }else {
            return "添加失败";
        }

    }

    @RequestMapping(value = "majorList",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ProfessionDTO> list(){

        return this.professionService.selectAll();
    }

    @RequestMapping(value = "deleteMajor",produces = "text/plain;charset=utf-8")
    public String delete(Integer id){

        if (this.professionService.deleteById(id) > 0){
            return "成功";
        }else {
            return "失败";
        }

    }

    @RequestMapping(value = "toUpdateMajor",produces = "application/json")
    @ResponseBody
    public ProfessionDTO toUpdate(Integer id){

        return this.professionService.selectById(id);
    }

    @RequestMapping(value = "updateMajor",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String update(Profession profession){

        if (this.professionService.update(profession)> 0){
            return "修改成功！";
        }else {
            return "修改失败！";
        }
    }

    @RequestMapping(value = "deleteSelectMajor",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String deleteSelect(@RequestBody List<Integer> idList){

        List<Serializable> list = new ArrayList<>();
        for (Integer id:idList){
            list.add(id);
        }
        if (this.professionService.deleteSelect(list)> 0){
            return "删除成功！";
        }else {
            return "删除失败！";
        }
    }

    @RequestMapping(value = "selectByKeyword",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<ProfessionDTO> selectByKeyword(@RequestParam("profName") String profName,
                                               @RequestParam("instituteName") String instituteName,
                                               @RequestParam("instituteBranchName") String instituteBranchName){

        List<ProfessionDTO> professionDTOS1 = null;
        List<ProfessionDTO> professionDTOS2 = null;
        List<ProfessionDTO> professionDTOS3 = null;

        if (!profName.equals("")){
            professionDTOS1 = this.professionService.selectByProName(profName);
        }

        if (!instituteName.equals("")){
            professionDTOS2 = this.professionService.selectByInstituteName(instituteName);
        }

        if (!instituteBranchName.equals("")){
            professionDTOS3 = this.professionService.selectByBranchName(instituteBranchName);
        }

        if (professionDTOS1 != null && professionDTOS2 != null && professionDTOS3 != null){
            professionDTOS1.retainAll(professionDTOS2);
            professionDTOS1.retainAll(professionDTOS3);
            return professionDTOS1;

        }else if (professionDTOS1 != null && professionDTOS2 != null && professionDTOS3 == null){
            professionDTOS1.retainAll(professionDTOS2);
            return professionDTOS1;

        }else if (professionDTOS1 != null && professionDTOS2== null && professionDTOS3 != null){
            professionDTOS1.retainAll(professionDTOS3);
            return professionDTOS1;

        }else if (professionDTOS1 == null && professionDTOS2 != null && professionDTOS3 != null){
            professionDTOS2.retainAll(professionDTOS3);
            return professionDTOS2;

        }else if (professionDTOS1 != null && professionDTOS2 == null && professionDTOS3 == null){

            return professionDTOS1;

        }else if (professionDTOS1 == null && professionDTOS2 != null && professionDTOS3 == null){

            return professionDTOS2;

        }else if (professionDTOS1 == null && professionDTOS2 == null && professionDTOS3 != null){

            return professionDTOS3;

        }
        return null;
    }

    @RequestMapping(value = "getProfession",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Map getProfessions(@RequestParam("instituteName") String instituteName,
                              @RequestParam("instituteBranchName") String instituteBranchName){
        System.out.println("1111111111111111111111111111111");
        List<ProfessionDTO> list1 = this.professionService.selectByBranchName(instituteBranchName);
        List<ProfessionDTO> list2 = this.professionService.selectByInstituteName(instituteName);
        Map map = new HashMap();
        list1.retainAll(list2);
        System.out.println("length:" + list1.size());
        map.put("value",list1);
        return map;
    }

    @RequestMapping(value = "professionTrigger",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String trigger(String check,Integer id){
        Profession profession = new Profession();
        profession.setId(id);
        if (check.equals("false")){
            profession.setProfStatus(0);
            professionService.update(profession);
            return "已关闭";
        }else {
            profession.setProfStatus(1);
            professionService.update(profession);
            return "已启用";
        }
    }
}
