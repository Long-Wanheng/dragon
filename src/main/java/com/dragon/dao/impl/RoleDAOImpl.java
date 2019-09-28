package com.dragon.dao.impl;

import com.dragon.dao.RoleDAO;
import com.dragon.mapper.RoleMapper;
import com.dragon.model.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-09-28 21:35
 * @Description: ${Description}
 */
@Service
public class RoleDAOImpl implements RoleDAO {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int addRole(Role role) {
        return roleMapper.add(role);
    }

    @Override
    public List<Role> getAllRole() {
        return roleMapper.getAllRole();
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.update(role);
    }

    @Override
    public int logicDelete(Long id) {
        Role role = new Role();
        role.setId(id);
        role.setDeleteFlag(Role.DELETE);
        return roleMapper.update(role);
    }
}
