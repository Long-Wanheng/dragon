package com.dragon.mapper;

import com.dragon.model.entity.SeleniumCloudMusicUser;
import com.dragon.model.query.SeleniumCloudMusicUserQuery;
import com.dragon.model.vo.SeleniumCloudMusicUserVo;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-11 00:26
 */
public interface MusicUserMapper {

    /**
     * 批量添加用户
     *
     * @param userList
     * @return 添加个数
     */
    int batchAdd(List<SeleniumCloudMusicUser> userList);


    /**
     * 用户查询
     *
     * @param query
     * @return 用户集合
     */
    List<SeleniumCloudMusicUserVo> queryMusicUser(SeleniumCloudMusicUserQuery query);
}
