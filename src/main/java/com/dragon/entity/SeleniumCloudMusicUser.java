package com.dragon.entity;

/**
 * 网易云用户实体类
 *
 * @Author: 龙万恒
 * @CreateTime: 2019-08-03 23:36
 */
public class SeleniumCloudMusicUser {
    /**
     * 网易云用户id
     */
    private String id;
    /**
     * 网易云用户昵称
     */
    private String nickName;
    /**
     * 网易云用户主页
     */
    private String userUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }
}
