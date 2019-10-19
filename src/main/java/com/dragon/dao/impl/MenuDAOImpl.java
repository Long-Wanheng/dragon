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
 */
@Service
public class MenuDAOImpl implements MenuDAO {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public void addMenu(Menu menu) {
        menuMapper.add(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuMapper.update(menu);
    }

    @Override
    public void delete(List<Long> ids) {
        menuMapper.delete(ids);
    }

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
