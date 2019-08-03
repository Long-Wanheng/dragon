package com.dragon.controller;

import com.dragon.common.config.MailSendConfig;
import com.dragon.util.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-07-27 23:30
 */
@RestController
public class IndexController {
    public static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private MailSendConfig mailSendConfig;

    @PostMapping("indexs")
    public ResultSet init() {
        return ResultSet.view(null);
    }

    @RequestMapping("mailSend")
    public String index(){
        mailSendConfig.send("测试邮件");
        return "index";
    }
}