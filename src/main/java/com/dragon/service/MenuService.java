package com.dragon.service;

import com.dragon.model.entity.Menu;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-18 02:17
 */
public interface MenuService {
    /**
     * 获取菜单树
     *
     * @return 菜单树
     */
    List<Menu> getMenuTree();

    /**
     * 根据用户id获取用户菜单
     *
     * @param userId
     * @return 用户菜单
     */
    List<Menu> getUserMenuByUserId(Long userId);
}
