package com.dragon.dao.impl;

import com.dragon.dao.MenuDAO;
import com.dragon.mapper.MenuMapper;
import com.dragon.model.entity.Menu;
import com.dragon.model.entity.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-09-28 21:33
 * @Description: ${Description}
 */
@Service
public class MenuDAOImpl implements MenuDAO {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenu();
    }

    @Override
    public List<Integer> queryRoleIdsByMenuId(Long menuId) {
        return menuMapper.queryRoleIdsByMenuId(menuId);
    }

    @Override
    public List<Menu> getUserMenuByUserId(Long userId) {
        return menuMapper.getUserMenuByUserId(userId);
    }

    @Override
    public List<RoleMenu> queryByMenuIds(List<Menu> menus) {
        return menuMapper.queryByMenuIds(menus);
    }
}