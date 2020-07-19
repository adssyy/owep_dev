/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.service.impl;

import com.kclm.owep.dto.HomeworkDTO;
import com.kclm.owep.entity.Homework;
import com.kclm.owep.mapper.HomeworkMapper;
import com.kclm.owep.service.HomeworkService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/*****************
 *
 * @author tanj
 * @date 2020/7/15 16:20
 * @version v1.0
 * @description 班级作业业务层接口
 *
 */
@Service
@Transactional
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    private HomeworkMapper homeworkMapper;
    @Autowired
    private MapperFactory mapperFactory;
    /***
     * 保存班级作业
     * @param entity
     * @return
     */
    @Override
    public int save(Homework entity) {
        return homeworkMapper.save(entity);
    }

    /***
     * 更新作业
     * @param entity
     * @return
     */
    @Override
    public int update(Homework entity) {
        return homeworkMapper.update(entity);
    }

    /***
     * 根据id删除
     * @param id
     * @return
     */
    @Override
    public int deleteById(Serializable id) {
        return homeworkMapper.deleteById(id);
    }

    /**
     * 删除多个
     * @param idList
     * @return
     */
    @Override
    public int deleteSelect(List<Serializable> idList) {
        return homeworkMapper.deleteSelect(idList);
    }

    @Override
    public HomeworkDTO selectById(Serializable id) {
        Homework homework = homeworkMapper.selectById(id);
        mapperFactory.classMap(Homework.class,HomeworkDTO.class)
                .field("course.courseName","courseName")
                .field("clazz.className","className")
                .byDefault()
                .register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        HomeworkDTO homeworkDTO = mapperFacade.map(homework, HomeworkDTO.class);
        return homeworkDTO;
    }

    /***
     * 查询所有的班级作业
     * @return
     */
    @Override
    public List<HomeworkDTO> selectAll() {
        List<Homework> homework = homeworkMapper.selectAll();
        mapperFactory.classMap(Homework.class,HomeworkDTO.class)
                .field("course.courseName","courseName")
                .field("clazz.className","className")
                .byDefault()
                .register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<HomeworkDTO> homeworkDTOS = mapperFacade.mapAsList(homework, HomeworkDTO.class);
        return homeworkDTOS;
    }

    /***
     * 根据课程名称来查找班级作业
     * @param courseName
     * @return
     */
    @Override
    public List<HomeworkDTO> selectByCourseName(String courseName) {
        List<Homework> homework = homeworkMapper.selectByCourseName(courseName);
        mapperFactory.classMap(Homework.class,HomeworkDTO.class)
                .field("course.courseName","courseName")
                .field("clazz.className","className")
                .byDefault()
                .register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<HomeworkDTO> homeworkDTOS = mapperFacade.mapAsList(homework, HomeworkDTO.class);
        return homeworkDTOS;
    }
}
