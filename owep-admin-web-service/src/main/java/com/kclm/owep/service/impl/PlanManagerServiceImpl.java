/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.service.impl;

import com.github.pagehelper.PageHelper;
import com.kclm.owep.convert.PlanManagerCourseConvert;
import com.kclm.owep.dto.PlanManagerCourseDTO;
import com.kclm.owep.dto.PlanManagerDTO;
import com.kclm.owep.entity.PlanManager;
import com.kclm.owep.entity.PlanManagerCourse;

import com.kclm.owep.mapper.PlanManagerCourseMapper;
import com.kclm.owep.mapper.PlanManagerMapper;
import com.kclm.owep.service.PlanManagerService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/14 16:41
 *@Description 培养方案业务层接口
 *
 */
@Service
public class PlanManagerServiceImpl implements PlanManagerService {

    @Autowired
    private PlanManagerMapper planManagerMapper;

    @Autowired
    private PlanManagerCourseMapper planManagerCourseMapper;

    @Autowired
    MapperFactory mapperFactory;


    /**
     * 获取所有的培养方案
     *
     * @return
     */
    @Override
    public List<PlanManagerDTO> findAllPlanManager() {
        List<PlanManager> planManagers = planManagerMapper.selectAll();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(planManagers, PlanManagerDTO.class);
    }

    /**
     * 分页查询 培养方案
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<PlanManagerDTO> findAllPlanManagerByPaging(int page, int size) {
        PageHelper.startPage(page, size);
        List<PlanManager> planManagers = planManagerMapper.selectAll();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(planManagers, PlanManagerDTO.class);
    }

    /**
     * 通过属性 去查找培养方案
     *
     * @param planManager
     * @return
     */
    @Override
    public List<PlanManagerDTO> findPlanManagerByField(PlanManager planManager) {
        List<PlanManager> planManagers = planManagerMapper.selectByField(planManager);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(planManagers, PlanManagerDTO.class);
    }

    /**
     * 修改培养方案
     *
     * @param planManager
     * @return
     */
    @Override
    public int alterPlanManager(PlanManager planManager) {
        return planManagerMapper.update(planManager);
    }

    /**
     * 通过ids ,删除多个培养方案
     *
     * @param ids
     * @return
     */
    @Override
    public int deletePlanManagerByIds(List<Serializable> ids) {
        return planManagerMapper.deleteSelect(ids);
    }

    /**
     * 通过id 删除培养方案
     *
     * @param id
     * @return
     */
    @Override
    public int deletePlanManagerById(Serializable id) {
        return planManagerMapper.deleteById(id);
    }

    /**
     * 分页查找 方案中设置的课程
     *
     * @param planId
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<PlanManagerCourseDTO> findPlanCoursePaging(Serializable planId, int page, int size) {
        PageHelper.startPage(page, size);
        List<PlanManagerCourse> planManagerCourses = planManagerCourseMapper.selectAllById(planId);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(planManagerCourses, PlanManagerCourseDTO.class);
    }

    @Override
    public PlanManager selectById(Serializable id) {
        return planManagerMapper.selectById(id);
    }

    /**
     * 方案中添加课程
     *
     * @param planManagerCourse
     * @return
     */
    @Override
    public int addPlanManagerCourse(PlanManagerCourse planManagerCourse) {
        return planManagerCourseMapper.save(planManagerCourse);
    }

    /**
     * 通过id， 删除方案中的课程
     *
     * @param id
     * @return
     */
    @Override
    public int deltePlanManagerCourseById(Serializable id) {
        return planManagerCourseMapper.deleteById(id);
    }


    /**
     * 方案中的课程上移下移
     * @param up
     * @param down
     * @return
     */
    @Transactional(rollbackFor = {RuntimeException.class,Error.class})
    @Override
    public int shiftCellsUpOrDown(PlanManagerCourse up, PlanManagerCourse down) {
        Integer courseOrder = up.getCourseOrder();
        if(courseOrder == 1){
            return 0;
        }
        planManagerCourseMapper.courseMoveUp(up);
        planManagerCourseMapper.courseMoveDown(down);
        return 0;
    }

    /**
     * 通过方案 id 查询方案中的所有课程
     * @param id
     * @return
     */
    @Override
    public List<PlanManagerCourseDTO> findAllPlanManagerCourse(Serializable id) {
        List<PlanManagerCourse> planManagerCourses = planManagerCourseMapper.selectAllById(id);

        //System.out.println(planManagerCourses.get(0).getCourse());
        List<PlanManagerCourseDTO> planManagerCourseDTOS = new ArrayList<PlanManagerCourseDTO>();
        /*MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(planManagerCourses, PlanManagerCourseDTO.class);*/
        for(PlanManagerCourse p:planManagerCourses){
            PlanManagerCourseDTO planManagerCourseDTO = PlanManagerCourseConvert.INSTANCE.entityToDTO(p);
            planManagerCourseDTOS.add(planManagerCourseDTO);
        }
        return planManagerCourseDTOS;
    }

    @Override
    public int addPlanManager(PlanManager planManager) {
        return planManagerMapper.save(planManager);
    }

    @Override
    public Integer findMaxCourseOrder(PlanManagerCourse planManagerCourse) {
        return planManagerCourseMapper.findMaxCourseOrder(planManagerCourse);
    }

    @Override
    public PlanManagerCourse findByCourseOrder(Integer courseOrder, Integer stageNum,PlanManager planManager) {
        return planManagerCourseMapper.findByCourseOrder(courseOrder,stageNum,planManager);
    }
}
