package com.dragon.controller;

import com.dragon.service.SeleniumCloudMusicService;
import com.dragon.util.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-11 00:35
 * @Description: ${Description}
 */
@RestController
@RequestMapping("/reptile")
public class ReptileController {
    @Autowired
    private SeleniumCloudMusicService seleniumCloudMusicService;

    @PostMapping("/cloudMusic")
    public ResultSet reptileCloudMusic(String songId) {
        return ResultSet.view(seleniumCloudMusicService.reptileMusicUsers(songId));
    }
}
