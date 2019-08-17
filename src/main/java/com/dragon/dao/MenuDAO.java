package com.dragon.dao;

import com.dragon.model.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 20:39
 * @Description: ${Description}
 */
public interface MenuDAO {

    /**
     * 获取所有菜单
     *
     * @return 菜单
     */
    List<Menu> getAllMenu();

    /**
     * 根据菜单id获取角色id
     *
     * @param menuId
     * @return 角色id
     */
    List<Integer> queryRoleIdsByMenuId(@Param("menuId") Long menuId);


}
