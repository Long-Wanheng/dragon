package com.dragon.service;

import com.dragon.model.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 21:20
 */
public interface UserService {

    /**
     * 根据参数获取登录用户
     *
     * @param loginParam
     * @param password
     * @return 登录用户
     */
    User getLoginUser(String loginParam, String password);

    /**
     * 根据用户id查询角色
     *
     * @param userId
     * @return 用户权限
     */
    List<Integer> queryRoleIdsByUserId(@Param("userId") Long userId);

}
