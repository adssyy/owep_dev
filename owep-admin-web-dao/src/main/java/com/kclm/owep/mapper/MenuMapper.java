/*******************
 *版权所有 CopyRight(c) 快程乐码信息科技有限公司所有，未经授权，不得复制转发
 *
 */
package com.kclm.owep.mapper;

import com.kclm.owep.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: ZhangQi
 * @version:v1.0
 * @create: 2020/7/7 15:54
 * @description:菜单接口
 **/
@Mapper
public interface MenuMapper {
    /**
     * 根据Id删除菜单
     */
    int deleteById(Integer id);

    /**
     * 插入菜单
     */
    int insert(Menu menu);

    /**
     * 更新菜单信息
     */
    int update(Menu menu);


    /**
     * 根据Id查询菜单的基本信息(不包含父子关联)
     */
    Menu findById(Integer id);

    /**
     * 可根据Id查询菜单的父级菜单
     */
    Menu findParent(Integer id);

    /**
     * 查询所有菜单的基本的信息不包父子关联。
     */
    List<Menu> findByAll();

    /**
     * 自关联查询 查询子菜单
     */
    List<Menu> findMenuChild(Integer menuId);

    /**
     * 向中间表插入数据 给菜单分配行为 需要传入该菜单所关联的权限
     */
    int assignActionToMenuAndPermission(@Param("menuId") Integer menuId, @Param("actionId") Integer actionId, @Param("perId") Integer perId);

    /*更新中间表的数据 以菜单Id为条件*/
    int updateInAPM(@Param("perId") Integer perId, @Param("actionId") Integer actionId, @Param("menuId") Integer menuId);

    /**
     * 删除中间表的数据 以MenuId为准
     */
    int deleteByMenuIdInAPM(Integer menuId);

    /**
     * 外联查询 查询菜单所关联的行为 可利用ID查单个对象
     */
    List<Menu> findActionInMenu(Integer menuId);

    /**
     * 外联查询  查询菜单所关联的权限 可利用进行条件查询
     */
    List<Menu> findPermissionInMenu(Integer menuId);

    /**
     * 外联查询 三表关联查询
     */
    List<Menu> findAllInAPM(@Param("menuId") Integer menuId, @Param("perId") Integer perId, @Param("actionId") Integer actionId);

    /**
     * 统计中间表数据
     */
    int countInAPM();

    /**
     * 统计菜单表的数据
     */
    int count();
}