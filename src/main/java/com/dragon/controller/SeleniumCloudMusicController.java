package com.dragon.controller;

import com.dragon.model.query.SeleniumCloudMusicUserQuery;
import com.dragon.service.SeleniumCloudMusicService;
import com.dragon.util.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-24 20:06
 * @Description: ${Description}
 */
@RestController
@RequestMapping("/music")
public class SeleniumCloudMusicController {
    @Autowired
    private SeleniumCloudMusicService seleniumCloudMusicService;

    @PostMapping("/list")
    public ResultSet list(@RequestBody SeleniumCloudMusicUserQuery query) {
        return ResultSet.view(seleniumCloudMusicService.queryMusicUser(query));
    }
}
