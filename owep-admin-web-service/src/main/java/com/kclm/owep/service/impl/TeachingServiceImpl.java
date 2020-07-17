/*********************
 * 2018-2021 版权所有 CopyRight（c）
 */
package com.kclm.owep.service.impl;

import com.github.pagehelper.PageHelper;
import com.kclm.owep.dto.*;
import com.kclm.owep.entity.*;
import com.kclm.owep.mapper.*;
import com.kclm.owep.service.TeachingService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/*********************
 * @Auther shentr
 * @Version V1.0
 * @Create 2020/7/14 9:05
 * @Description 授课管理业务层接口
 */
@Service
public class TeachingServiceImpl implements TeachingService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private EvaluateMapper evaluateMapper;
    @Autowired
    private LeaveMapper leaveMapper;
    @Autowired
    private IllegalMapper illegalMapper;
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private HomeworkMapper homeworkMapper;
    @Autowired
    private HomeworkAnswerMapper homeworkAnswerMapper;
    @Autowired
    private MapperFactory mapperFactory;


    /**
     * 获取班级数据
     */
    @Override
    public List<ClassDTO> findAllClass(int pageNumber,int pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Clazz> clazzList = clazzMapper.selectAll();
        MapperFacade mapperFacade = this.mapperFactory.getMapperFacade();
        List<ClassDTO> classDTOS = mapperFacade.mapAsList(clazzList, ClassDTO.class);
        return classDTOS;
    }

    /**
     * 根据条件，获取班级数据
     */
    @Override
    public List<ClassDTO> findClassByConditions(String classNumber, String className, String instituteName,
                                                String branchName, String profession,int pageNumber,int pageSize) {
        return null;
    }

    /**
     * 根据classid获取一个班级的 信息、问题、资源、作业、评价、请假、违规的数据
     */
    @Override
    public TeachingDTO getTeachingDTO(Serializable classId,int pageNumber,int pageSize) {
        //获取一个班级的 信息、问题、资源、作业、评价、请假、违规list
        Clazz clazz = clazzMapper.selectById(classId);
        PageHelper.startPage(pageNumber,pageSize);
        List<HomeworkAnswer> homeworkAnswerList = homeworkAnswerMapper.selectByClassId(classId);
        PageHelper.startPage(pageNumber,pageSize);
        List<Question> questionList = questionMapper.selectByClassId(classId);
        PageHelper.startPage(pageNumber,pageSize);
        List<Evaluate> evaluateList = evaluateMapper.selectByClassId(classId);
        PageHelper.startPage(pageNumber,pageSize);
        List<Leave> leaveList = leaveMapper.selectByClassId(classId);
        PageHelper.startPage(pageNumber,pageSize);
        List<Illegal> illegalList = illegalMapper.selectByClassId(classId);

        //将list分别映射
        MapperFacade mapperFacade = this.mapperFactory.getMapperFacade();
        mapperFactory.classMap(Clazz.class,TeachingDTO.class)
                .field("resourceList","resourceDTOS").
                byDefault().register();
        TeachingDTO teachingDTO = mapperFacade.map(clazz, TeachingDTO.class);
        mapperFactory.classMap(HomeworkAnswer.class,HomeworkAnswerDTO.class)
                .field("student.stuRealName","studentName")
                .field("homework.workTitle","workTitle")
                .field("homework.workContent","workContent")
                .byDefault().register();
        List<HomeworkAnswerDTO> homeworkAnswerDTOS = mapperFacade.mapAsList(homeworkAnswerList, HomeworkAnswerDTO.class);
        List<QuestionDTO> questionDTOS = mapperFacade.mapAsList(questionList, QuestionDTO.class);
        mapperFactory.classMap(Evaluate.class,EvaluateDTO.class)
                .field("student.stuNumber","stuNumber")
                .field("student.gender","gender")
                .field("student.stuPhone","stuPhone")
                .field("student.stuEmail","stuEmail")
                .field("student.effectiveDate","effectiveDate")
                .byDefault().register();
        List<EvaluateDTO> evaluateDTOs = mapperFacade.mapAsList(evaluateList, EvaluateDTO.class);
        List<LeaveDTO> leaveDTOs = mapperFacade.mapAsList(leaveList, LeaveDTO.class);
        mapperFactory.classMap(Illegal.class,IllegalDTO.class)
                .field("student.stuNumber","stuNumber")
                .byDefault().register();
        List<IllegalDTO> illegalDTOs = mapperFacade.mapAsList(illegalList, IllegalDTO.class);

        teachingDTO.setHomeworkAnswerDTOS(homeworkAnswerDTOS);
        teachingDTO.setQuestionDTOS(questionDTOS);
        teachingDTO.setIllegalDTOs(illegalDTOs);
        teachingDTO.setEvaluateDTOs(evaluateDTOs);
        teachingDTO.setLeaveDTOs(leaveDTOs);
        return teachingDTO;
    }



    @Override
    public List<ResourceDTO> findResourceByName(String resourceName) {
        return null;
    }

    /**
     * 根据id删除资源
     */
    @Override
    public int deleteResourceById(Serializable resourceId) { return resourceMapper.deleteById(resourceId); }

    /**
     * 根据选择的id删除资源
     */
    @Override
    public int deleteSelectResource(List<Serializable> resourceIds) { return resourceMapper.deleteSelect(resourceIds); }

    /**
     * 根据id删除班级问题
     */
    @Override
    public int deleteQuestionById(Serializable questionId) {
        return questionMapper.deleteById(questionId);
    }

    /**
     * 根据id获取问题详情
     */
    @Override
    public QuestionDTO findQuestionById(Serializable questionId) {
        Question question = questionMapper.selectById(questionId);
        MapperFacade mapperFacade = this.mapperFactory.getMapperFacade();
        return mapperFacade.map(question,QuestionDTO.class);
    }

    /**
     * 更新问题
     */
    @Override
    public int updateQuestion(Question question) { return questionMapper.update(question); }

    /**
     * 根据id获取作业详情
     */
    @Override
    public HomeworkAnswerDTO findHomeworkAnswerById(Serializable homeworkAnswerId) {
        HomeworkAnswer homeworkAnswer = homeworkAnswerMapper.selectById(homeworkAnswerId);
        MapperFacade mapperFacade = this.mapperFactory.getMapperFacade();
        return mapperFacade.map(homeworkAnswer,HomeworkAnswerDTO.class);
    }

    /**
     * 更新作业 审批内容
     */
    @Override
    public int updateHomework(HomeworkAnswer homeworkAnswer) {
        return homeworkAnswerMapper.update(homeworkAnswer);
    }

    /**
     * 根据id获取学生评价详情
     */
    @Override
    public EvaluateDTO findEvaluateById(Serializable evaluateId) {
        Evaluate evaluate = evaluateMapper.selectById(evaluateId);
        MapperFacade mapperFacade = this.mapperFactory.getMapperFacade();
        return mapperFacade.map(evaluate,EvaluateDTO.class);
    }

    /**
     * 更新评价内容
     */
    @Override
    public int updateEvaluate(Evaluate evaluate) {
        return evaluateMapper.update(evaluate);
    }

    /**
     *审批请假数据
     */
    @Override
    public int updateApprovalStatus(Leave leave) {
        return leaveMapper.update(leave);
    }

    /**
     *  根据条件查找违纪数据
     */
    @Override
    public List<IllegalDTO> findIllegalByConditions(String stuNumber, String stuName, LocalDateTime startTime,
                                                     LocalDateTime endTime,int pageNumber,int pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Illegal> illegals = illegalMapper.selectByCondition(stuNumber, stuName, startTime, endTime);
        MapperFacade mapperFacade = this.mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(illegals, IllegalDTO.class);
    }

    /**
     * 根据id删除违纪数据
     */
    @Override
    public int deleteIllegalById(Serializable illegalId) {
        return illegalMapper.deleteById(illegalId);
    }

    /**
     * 添加违纪数据
     */
    @Override
    public int saveIllegal(Illegal illegal) {
        return illegalMapper.save(illegal);
    }
}
