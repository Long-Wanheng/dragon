package com.dragon.entity;

/**
 * 网易云用户实体类
 *
 * @Author: 龙万恒
 * @CreateTime: 2019-08-03 23:36
 */
public class SeleniumCloudMusicUser {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 网易云用户id
     */
    private String musicId;
    /**
     * 网易云用户昵称
     */
    private String musicNickName;
    /**
     * 网易云用户主页
     */
    private String userUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusicNickName() {
        return musicNickName;
    }

    public void setNickName(String musicNickName) {
        this.musicNickName = musicNickName;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }
}
