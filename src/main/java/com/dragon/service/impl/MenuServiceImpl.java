package com.dragon.service.impl;

import com.dragon.dao.MenuDAO;
import com.dragon.model.entity.Menu;
import com.dragon.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-18 02:21
 * @Description: ${Description}
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDAO menuDAO;

    @Override
    public List<Menu> getMenuTree() {
        List<Menu> menus = menuDAO.getAllMenu();
        return makeMenuTree(menus);
    }

    private List<Menu> makeMenuTree(List<Menu> menus) {
        List<Menu> firstMenu = new ArrayList<>();
        Map<Long, Menu> menuMap = new HashMap<>();
        for (Menu menu : menus) {
            menuMap.put(menu.getId(), menu);
            if (menu.getParentId() == null) {
                firstMenu.add(menu);
            }
        }
        for (Menu menu : menus) {
            if (menu.getParentId() != null && menuMap.containsKey(menu.getParentId())) {
                menuMap.get(menu.getParentId()).getChildren().add(menu);
            }
        }
        return firstMenu;
    }

    @Override
    public List<Menu> getUserMenuByUserId(Long userId) {
        List<Menu> menus = menuDAO.getUserMenuByUserId(userId);
        return makeMenuTree(menus);
    }
}
