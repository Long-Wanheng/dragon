package com.dragon.common.utils;

import com.dragon.entity.User;

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

    public static void setCurrentUser(User user) {
        currentUser.set(user);
    }

    public static Optional<User> getCurrentUser() {
        return Optional.of(currentUser.get());
    }

    public static void remove() {
        currentUser.remove();
    }
}
