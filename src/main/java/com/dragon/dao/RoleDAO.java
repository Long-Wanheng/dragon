package com.dragon.dao;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 22:02
 */
public interface RoleDAO {

    /**
     * 获取所有角色id
     * @return 角色id
     */
    List<Integer> getAllRoleIds();
}
