package com.dragon.model.vo;

import com.dragon.model.entity.SeleniumCloudMusicUser;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-24 16:28
 * @Description: ${Description}
 */
public class SeleniumCloudMusicUserVo extends SeleniumCloudMusicUser {
    /**
     * 歌曲名
     */
    private String songName;

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}
