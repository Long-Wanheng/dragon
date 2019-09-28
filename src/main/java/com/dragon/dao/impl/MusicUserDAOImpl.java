package com.dragon.dao.impl;

import com.dragon.dao.MusicUserDAO;
import com.dragon.mapper.MusicUserMapper;
import com.dragon.model.entity.SeleniumCloudMusicUser;
import com.dragon.model.query.SeleniumCloudMusicUserQuery;
import com.dragon.model.vo.SeleniumCloudMusicUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-09-28 21:34
 * @Description: ${Description}
 */
@Service
public class MusicUserDAOImpl implements MusicUserDAO {
    @Autowired
    private MusicUserMapper musicUserMapper;

    @Override
    public int batchAdd(List<SeleniumCloudMusicUser> userList) {
        return musicUserMapper.batchAdd(userList);
    }

    @Override
    public List<SeleniumCloudMusicUserVo> queryMusicUser(SeleniumCloudMusicUserQuery query) {
        return musicUserMapper.queryMusicUser(query);
    }
}
