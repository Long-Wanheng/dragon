package com.dragon.dao;

import com.dragon.model.entity.SeleniumCloudMusicUser;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-11 00:26
 */
public interface MusicUserDAO {

    /**
     * 批量添加用户
     *
     * @param userList
     * @return 添加个数
     */
    int batchAdd(List<SeleniumCloudMusicUser> userList);
}
