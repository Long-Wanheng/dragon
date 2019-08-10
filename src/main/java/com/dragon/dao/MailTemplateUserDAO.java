package com.dragon.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-10 21:38
 * @Description: ${Description}
 */
public interface MailTemplateUserDAO {

    /**
     * 根据模板id,状态查询邮箱列表
     * @param id
     * @param type
     * @return
     */
    List<String> findUsersByTemplateId(@Param("id") Long id, @Param("type") Integer type);

}
