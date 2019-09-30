package com.dragon.service.impl;

import com.dragon.common.exception.DragonException;
import com.dragon.dao.MenuDAO;
import com.dragon.model.entity.Menu;
import com.dragon.service.MenuService;
import org.apache.commons.lang3.StringUtils;
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
    public void addMenu(Menu menu) {
        if (null == menu) {
            throw new DragonException("参数非法!!");
        }
        if (StringUtils.isEmpty(menu.getMenuName())) {
            throw new DragonException("菜单名不能为空!!");
        }
        menuDAO.addMenu(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        if (null == menu) {
            throw new DragonException("参数非法!!");
        }
        if (null == menu.getId()) {
            throw new DragonException("id非法!!");
        }
        menuDAO.updateMenu(menu);
    }

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
