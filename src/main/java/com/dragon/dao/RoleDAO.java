package com.dragon.dao;

import com.dragon.model.entity.Role;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 22:02
 */
public interface RoleDAO {
    /**
     * 添加角色
     *
     * @param role
     * @return 添加条数
     */
    int addRole(Role role);

    /**
     * 获取所有角色
     *
     * @return 所有角色
     */
    List<Role> getAllRole();

    /**
     * 修改角色
     *
     * @param role
     * @return 修改条数
     */
    int updateRole(Role role);

    /**
     * 逻辑删除角色
     *
     * @param id
     * @return 删除条数
     */
    int logicDelete(Long id);
}
