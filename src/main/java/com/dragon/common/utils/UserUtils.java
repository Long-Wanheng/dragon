package com.dragon.common.utils;

import com.dragon.model.entity.User;

import java.util.Optional;

/**
 * 用户工具类
 *
 * @Author: 龙万恒
 * @CreateTime: 2019-07-28 16:58
 */
public class UserUtils {
    /**
     * 保证每个线程有独立用户属性
     */
    private static ThreadLocal<User> currentUser = new ThreadLocal<User>();
    private static ThreadLocal<String> currentToken = new ThreadLocal<String>();

    public static void setCurrentUser(User user) {
        inforDesensitization(user);
        currentUser.set(user);
    }

    public static Optional<User> getCurrentUser() {
        return Optional.of(currentUser.get());
    }

    public static void setCurrentToken(String token) {
        currentToken.set(token);
    }

    public static Optional<String> getCurrentToken() {
        return Optional.of(currentToken.get());
    }

    public static void remove() {
        currentUser.remove();
        currentToken.remove();
    }

    public static void inforDesensitization(User user) {
        if (null == user) {
            return;
        }
        user.setPassword(null);
        user.setId(null);
        user.setPassword(null);
        user.setCreateTime(null);
    }
}
