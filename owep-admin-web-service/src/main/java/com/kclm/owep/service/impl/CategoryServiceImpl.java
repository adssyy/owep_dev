/********************************
 *版权所有 CopyRight(c) 快程乐码信息有限公司所有，未经授权，不得复制、转发
 */
package com.kclm.owep.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kclm.owep.dto.CourseCategoryDTO;
import com.kclm.owep.entity.CourseCategory;
import com.kclm.owep.mapper.CourseCategoryMapper;
import com.kclm.owep.service.CategoryService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/************
 *@Author yejx
 *@version v1.0
 *@create 2020/7/14 16:38
 *@Description 课程分类业务层实现类
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CourseCategoryMapper courseCategoryMapper;
    @Autowired
    private MapperFactory mapperFactory;

    /**
     * 通过分类名称获取课程分类DTO
     *
     * @param courseCategoryName
     * @return
     */
    @Override
    public CourseCategoryDTO findByCourseCategoryName(String courseCategoryName) {
        CourseCategory courseCategory = courseCategoryMapper.selectByCategoryName(courseCategoryName);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.map(courseCategory, CourseCategoryDTO.class);
    }

    @Override
    public void addCourseCategory(CourseCategory courseCategory) {
        courseCategoryMapper.save(courseCategory);
    }

    /**
     * 获取 所有的上层分类
     *
     * @return
     */
    @Override
    public List<CourseCategoryDTO> findAllCourseCategory() {
        List<CourseCategory> courseCategories = courseCategoryMapper.selectAll();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(courseCategories, CourseCategoryDTO.class);
    }

    /**
     * 获取所有的下层分类
     *
     * @param parentId
     * @return
     */
    @Override
    public List<CourseCategoryDTO> findAllSubCourseCategory(Serializable parentId) {
        List<CourseCategory> courseCategories = courseCategoryMapper.selectSubAll(parentId);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(courseCategories, CourseCategoryDTO.class);
    }

    /**
     * 更新课程分类
     *
     * @param courseCategory
     * @return
     */
    @Override
    public int alterCourseCategory(CourseCategory courseCategory) {
        return courseCategoryMapper.update(courseCategory);
    }

    /**
     * 通过id 删除课程分类
     *
     * @param id
     * @return
     */
    @Override
    public int deleteCourseCategory(Serializable id) {
        return courseCategoryMapper.deleteById(id);
    }

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<CourseCategoryDTO> findAllByPaging(int page, int size) {
        PageHelper.startPage(page, size);
        List<CourseCategory> courseCategories = courseCategoryMapper.selectAll();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.mapAsList(courseCategories, CourseCategoryDTO.class);
    }


}
