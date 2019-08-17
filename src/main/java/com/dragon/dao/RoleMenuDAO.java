package com.dragon.dao;

import com.dragon.model.entity.Menu;
import com.dragon.model.entity.RoleMenu;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-18 00:22
 * @Description: ${Description}
 */
public interface RoleMenuDAO {

    /**
     * 根据菜单id列表获取角色_菜单关系
     *
     * @param menus
     * @return 角色菜单对应关系
     */
    List<RoleMenu> queryByMenuIds(List<Menu> menus);
}
