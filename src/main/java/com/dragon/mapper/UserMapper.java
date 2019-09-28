package com.dragon.mapper;

import com.dragon.model.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 20:41
 * @Description: ${Description}
 */
public interface UserMapper {

    /**
     * 根据昵称查询登录用户
     *
     * @param nickName
     * @return user
     */
    User queryLoginUserByNickName(@Param("nickName") String nickName);

    /**
     * 根据邮件查询登录用户
     *
     * @param email
     * @return user
     */
    User queryLoginUserByEmail(@Param("email") String email);

    /**
     * 根据手机号查询登录用户
     *
     * @param phone
     * @return user
     */
    User queryLoginUserByPhone(@Param("phone") String phone);


    /**
     * 根据用户id查询角色
     *
     * @param userId
     * @return 用户权限
     */
    List<Integer> queryRoleIdsByUserId(@Param("userId") Long userId);

}
