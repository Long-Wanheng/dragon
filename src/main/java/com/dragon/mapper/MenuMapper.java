package com.dragon.mapper;

import com.dragon.model.entity.Menu;
import com.dragon.model.entity.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 20:39
 * @Description: ${Description}
 */
public interface MenuMapper {

    /**
     * 增加菜单
     *
     * @param menu
     */
    void add(Menu menu);


    /**
     * 修改菜单
     *
     * @param menu
     */
    void update(Menu menu);

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

    /**
     * 根据用户id获取用户菜单
     *
     * @param userId
     * @return 用户菜单
     */
    List<Menu> getUserMenuByUserId(@Param("userId") Long userId);

    /**
     * 根据菜单id列表获取角色_菜单关系
     *
     * @param menus
     * @return 角色菜单对应关系
     */
    List<RoleMenu> queryByMenuIds(@Param("menus") List<Menu> menus);
}
