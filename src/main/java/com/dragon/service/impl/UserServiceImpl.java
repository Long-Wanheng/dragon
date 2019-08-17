package com.dragon.service.impl;

import com.dragon.model.entity.User;
import com.dragon.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 21:22
 * @Description: ${Description}
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getLoginUser(String loginParam) {

        return null;
    }

    @Override
    public List<Integer> queryRoleIdsByUserId(Long userId) {
        return null;
    }
}
