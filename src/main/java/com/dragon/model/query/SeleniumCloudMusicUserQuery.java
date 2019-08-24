package com.dragon.model.query;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-24 19:05
 * @Description: ${Description}
 */
public class SeleniumCloudMusicUserQuery extends Page {
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 歌曲id
     */
    private String songId;
    /**
     * 用户等级
     */
    private Integer lever;
    /**
     * 用户昵称
     */
    private String musicNickName;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public Integer getLever() {
        return lever;
    }

    public void setLever(Integer lever) {
        this.lever = lever;
    }

    public String getMusicNickName() {
        return musicNickName;
    }

    public void setMusicNickName(String musicNickName) {
        this.musicNickName = musicNickName;
    }
}
