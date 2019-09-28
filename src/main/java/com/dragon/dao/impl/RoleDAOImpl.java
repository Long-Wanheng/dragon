package com.dragon.dao.impl;

import com.dragon.dao.RoleDAO;
import com.dragon.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-09-28 21:35
 * @Description: ${Description}
 */
@Service
public class RoleDAOImpl implements RoleDAO {
    @Autowired
    private RoleMapper roleMapper;
}
