package com.dragon.mapper;

import com.dragon.model.entity.Role;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 22:02
 */
public interface RoleMapper {

    /**
     * 添加角色
     *
     * @param role
     * @return 添加条数
     */
    int add(Role role);

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
    int update(Role role);

}