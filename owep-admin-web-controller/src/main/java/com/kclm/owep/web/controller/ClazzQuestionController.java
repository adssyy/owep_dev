/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.web.controller;

import com.kclm.owep.dto.QuestionDTO;
import com.kclm.owep.entity.Question;
import com.kclm.owep.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*****************
 *
 * @author tanj
 * @date 2020/6/28 21:45
 * @version v1.0
 * @description 班级问题 功能具体控制层
 *
 */
@RestController
@RequestMapping("clazz")
public class ClazzQuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "allQuestion",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<QuestionDTO> selectAll(){

        return questionService.selectAll();
    }
}
