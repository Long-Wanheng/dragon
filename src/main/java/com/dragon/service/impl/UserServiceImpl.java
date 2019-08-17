package com.dragon.service.impl;

import com.dragon.common.exception.DragonException;
import com.dragon.common.utils.DigestUtils;
import com.dragon.common.utils.LoginParamType;
import com.dragon.dao.UserDAO;
import com.dragon.model.entity.User;
import com.dragon.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 21:22
 * @Description: ${Description}
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User getLoginUser(String loginParam, String password) {
        verificationLoginParam(loginParam, password);
        Integer loginType = LoginParamType.getLoginParamType(loginParam);
        User user = null;
        if (LoginParamType.EMAIL.equals(loginType)) {
            user = userDAO.queryLoginUserByEmail(loginParam);
        } else if (LoginParamType.PHONE.equals(loginType)) {
            user = userDAO.queryLoginUserByPhone(loginParam);
        } else {
            user = userDAO.queryLoginUserByNickName(loginParam);
        }
        if (verificationPassword(user, password)) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public List<Integer> queryRoleIdsByUserId(Long userId) {
        return null;
    }

    private void verificationLoginParam(String loginParam, String password) {
        if (StringUtils.isBlank(loginParam)) {
            throw new DragonException("请正确输入昵称/邮箱/手机号");
        }
        if (StringUtils.isBlank(password)) {
            throw new DragonException("请输入密码!");
        }
    }

    private boolean verificationPassword(User user, String password) {
        if (null == user) {
            return false;
        }
        String truePassword = user.getPassword();
        String md5Password = DigestUtils.getMD5(password + user.getPrivateKey());
        if (truePassword.equals(md5Password)) {
            return true;
        } else {
            return false;
        }
    }
}
