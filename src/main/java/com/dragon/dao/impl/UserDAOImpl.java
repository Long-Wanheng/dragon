package com.dragon.dao.impl;

import com.dragon.dao.UserDAO;
import com.dragon.mapper.UserMapper;
import com.dragon.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-09-28 21:37
 * @Description: ${Description}
 */
@Service
public class UserDAOImpl implements UserDAO {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryLoginUserByNickName(String nickName) {
        return userMapper.queryLoginUserByNickName(nickName);
    }

    @Override
    public User queryLoginUserByEmail(String email) {
        return userMapper.queryLoginUserByEmail(email);
    }

    @Override
    public User queryLoginUserByPhone(String phone) {
        return userMapper.queryLoginUserByPhone(phone);
    }

    @Override
    public List<Integer> queryRoleIdsByUserId(Long userId) {
        return userMapper.queryRoleIdsByUserId(userId);
    }
}
