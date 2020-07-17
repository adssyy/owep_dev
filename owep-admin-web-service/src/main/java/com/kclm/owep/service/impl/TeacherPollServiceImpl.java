/******************
 * 2018-2020 版权所有 Copyright(c)  快程乐码信息科技有限公司所有，未经授权，不得复制、转发
 */

package com.kclm.owep.service.impl;

import com.github.pagehelper.PageHelper;
import com.kclm.owep.dto.TeacherPollDTO;
import com.kclm.owep.entity.TeacherPoll;
import com.kclm.owep.mapper.TeacherPollMapper;
import com.kclm.owep.service.TeacherPollService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/*******************
 *Author:ZhongLei
 *version:V1.0
 *@Create: 2020/7/14 19:49
 *@Description:教师考评业务层实现类
 ***/
@Service
public class TeacherPollServiceImpl implements TeacherPollService {

    @Autowired
    private TeacherPollMapper teacherPollMapper;

    @Autowired
    private MapperFactory mapperFactory;

    /***
     * 通过搜索框条件分页查询教师考评记录
     * @param className
     * @param profName
     * @param teacherName
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<TeacherPollDTO> findByCondition(String className, String profName, String teacherName,int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<TeacherPoll> teacherPolls = teacherPollMapper.selectByCondition(className, profName, teacherName);
        //
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<TeacherPollDTO> teacherPollDTOS = mapperFacade.mapAsList(teacherPolls, TeacherPollDTO.class);
        //
        return teacherPollDTOS;
    }

    /***
     * 分页查询所有教师考评记录
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<TeacherPollDTO> findAllTeacherPoll(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<TeacherPoll> teacherPolls = teacherPollMapper.selectAll();
        //
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<TeacherPollDTO> teacherPollDTOS = mapperFacade.mapAsList(teacherPolls,TeacherPollDTO.class);
        //
        return teacherPollDTOS;
    }

    /***
     * 通过id查询教师考评记录
     * @param id
     * @return
     */
    @Override
    public TeacherPollDTO findById(Serializable id) {
        TeacherPoll teacherPoll = teacherPollMapper.selectById(id);
        //
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        TeacherPollDTO teacherPollDTO = mapperFacade.map(teacherPoll,TeacherPollDTO.class);
        //
        return teacherPollDTO;
    }

    /***
     * 修改教师考评记录
     * @param teacherPoll
     * @return
     */
    @Override
    public int update(TeacherPoll teacherPoll) {
        return teacherPollMapper.update(teacherPoll);
    }

    /***
     * 批量删除教师考评记录
     * @param idList
     * @return
     */
    @Override
    public int deleteSelectTeacherPoll(List<Serializable> idList) {
        return teacherPollMapper.deleteSelect(idList);
    }

    /***
     * 通过id删除教师考评记录
     * @param id
     * @return
     */
    @Override
    public int deleteTeacherPoll(Serializable id) {
        return teacherPollMapper.deleteById(id);
    }

    @Override
    public int addTeacherPoll(TeacherPoll teacherPoll) {
        return teacherPollMapper.save(teacherPoll);
    }
}
