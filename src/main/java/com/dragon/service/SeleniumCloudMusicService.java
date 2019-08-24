package com.dragon.service;

import com.dragon.model.query.SeleniumCloudMusicUserQuery;
import com.dragon.model.vo.SeleniumCloudMusicUserVo;
import com.dragon.util.TableData;


/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-10 23:30
 */
public interface SeleniumCloudMusicService {

    /**
     * 抓取数据
     *
     * @param songId
     * @return 条数
     */
    int reptileMusicUsers(String songId);

    /**
     * 用户查询
     *
     * @param query
     * @return 用户集合
     */
    TableData<SeleniumCloudMusicUserVo> queryMusicUser(SeleniumCloudMusicUserQuery query);
}
