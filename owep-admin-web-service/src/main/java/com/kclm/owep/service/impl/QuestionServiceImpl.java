/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.service.impl;

import com.kclm.owep.dto.QuestionDTO;
import com.kclm.owep.entity.Course;
import com.kclm.owep.entity.Question;
import com.kclm.owep.mapper.CourseMapper;
import com.kclm.owep.mapper.QuestionMapper;
import com.kclm.owep.service.QuestionService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*****************
 *
 * @author tanj
 * @date 2020/7/15 16:21
 * @version v1.0
 * @description 班级问题业务层接口
 *
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private MapperFactory mapperFactory;
    @Autowired
    private CourseMapper courseMapper;

    /**
     * 保存班级问题
     * @param entity
     * @return
     */
    @Override
    public int save(Question entity) {
        return questionMapper.save(entity);
    }

    /**
     * 更新班级问题
     * @param entity
     * @return
     */
    @Override
    public int update(Question entity) {
        return questionMapper.update(entity);
    }

    /**
     * 根据id删除班级问题
     * @param id
     * @return
     */
    @Override
    public int deleteById(Serializable id) {
        return questionMapper.deleteById(id);
    }

    /**
     * 删除多个问题
     * @param idList
     * @return
     */
    @Override
    public int deleteSelect(List<Serializable> idList) {
        return questionMapper.deleteSelect(idList);
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    @Override
    public QuestionDTO selectById(Serializable id) {
        Question question = questionMapper.selectById(id);
        mapperFactory.classMap(Question.class,QuestionDTO.class)
                .field("course.courseName","courseName")
                .byDefault()
                .register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.map(question,QuestionDTO.class);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<QuestionDTO> selectAll() {
        List<Question> questions = questionMapper.selectAll();
        mapperFactory.classMap(Question.class,QuestionDTO.class)
                .field("course.courseName","courseName")
                .byDefault()
                .register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(questions,QuestionDTO.class);
    }

    /**
     * 根据课程名称来查询
     * @return
     */
    @Override
    public List<QuestionDTO> selectByCourseName(String courseName) {
        //根据课程名称来查询课程
        List<Course> courses = courseMapper.selectByCourseName(courseName);
        //如果没有课程 就返回空
        if (courses==null){
            return null;
        }
        //获取课程的迭代器
        Iterator<Course> iterator = courses.iterator();
        //定义一个list集合 用来存放问题
        List<Question> questions=new ArrayList<>();
        while (iterator.hasNext()){
            Course next = iterator.next();
            questions.addAll(questionMapper.selectByCourseId(next.getId()));

        }
        mapperFactory.classMap(Question.class,QuestionDTO.class)
                .field("course.courseName","courseName")
                .byDefault()
                .register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(questions,QuestionDTO.class);
    }
}
