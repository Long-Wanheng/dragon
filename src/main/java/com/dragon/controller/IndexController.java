package com.dragon.controller;

import com.dragon.common.config.MailSendConfig;
import com.dragon.entity.Mail;
import com.dragon.util.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
        Mail mail = new Mail();
        mail.setTitle("送给小袁同学的一封邮件");
        List<String> ccMail = new ArrayList<>();
       // ccMail.add("243027528@qq.com");
        List<String> toMail = new ArrayList<>();
        toMail.add("243027528@qq.com");
        mail.setCcMail(ccMail);
        mail.setToMail(toMail);
        mailSendConfig.send(mail);
        return "index";
    }
}