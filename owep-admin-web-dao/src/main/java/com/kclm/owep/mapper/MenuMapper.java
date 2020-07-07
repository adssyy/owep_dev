package com.kclm.owep.mapper;

import com.kclm.owep.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     * 可根据Id查询菜单的父级菜单 Id可传入
     * */
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
}