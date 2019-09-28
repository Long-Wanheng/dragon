package com.dragon.dao.impl;

import com.dragon.dao.RoleMenuDAO;
import com.dragon.mapper.RoleMenuMapper;
import com.dragon.model.entity.Menu;
import com.dragon.model.entity.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-09-28 21:36
 * @Description: ${Description}
 */
@Service
public class RoleMenuDAOImpl implements RoleMenuDAO {
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<RoleMenu> queryByMenuIds(List<Menu> menus) {
        return roleMenuMapper.queryByMenuIds(menus);
    }
}
