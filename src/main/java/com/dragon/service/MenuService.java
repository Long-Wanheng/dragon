package com.dragon.service;

import com.dragon.model.entity.Menu;
import com.dragon.model.query.MenuQuery;
import com.dragon.model.query.PageQuery;
import com.dragon.util.TableData;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-18 02:17
 */
public interface MenuService {
    /**
     * 增加菜单
     *
     * @param menu
     */
    void addMenu(Menu menu);


    /**
     * 修改菜单
     *
     * @param menu
     */
    void updateMenu(Menu menu);

    /**
     * 删除菜单
     *
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 获取菜单树
     *
     * @return 菜单树
     */
    List<Menu> getMenuTree();

    /**
     * 菜单table
     *
     * @param query
     * @return 菜单树
     */
    TableData<Menu> getTable(MenuQuery query);

    /**
     * 根据用户id获取用户菜单
     *
     * @param userId
     * @return 用户菜单
     */
    List<Menu> getUserMenuByUserId(Long userId);
}
