package com.dragon.controller;

import com.dragon.dao.MailTemplateDAO;
import com.dragon.dao.MailTemplateUserDAO;
import com.dragon.service.MailSendService;
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
    private MailSendService mailSendService;

    @Autowired
    private MailTemplateDAO mailTemplateDAO;
    @Autowired
    private MailTemplateUserDAO templateUserDAO;

    @PostMapping("index")
    public ResultSet init() {
        return ResultSet.view(null);
    }

    @RequestMapping("mailSend")
    public ResultSet index() {

        return ResultSet.view(null);
    }
}