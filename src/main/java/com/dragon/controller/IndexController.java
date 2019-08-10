package com.dragon.controller;

import com.dragon.dao.MailTemplateDAO;
import com.dragon.dao.MailTemplateUserDAO;
import com.dragon.model.entity.Mail;
import com.dragon.model.entity.MailTemplate;
import com.dragon.model.entity.MailTemplateUser;
import com.dragon.service.MailSendService;
import com.dragon.util.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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

    @PostMapping("indexs")
    public ResultSet init() {
        return ResultSet.view(null);
    }

    @RequestMapping("mailSend")
    public ResultSet index() {
        MailTemplate template = mailTemplateDAO.getMailTemplateByName("网易云音乐用户爬虫邮件");
        Mail mail = new Mail();
        BeanUtils.copyProperties(template,mail,"id");
        mail.setToMail(templateUserDAO.findUsersByTemplateId(template.getId(),MailTemplateUser.TO_MAIL));
        mail.setCcMail(templateUserDAO.findUsersByTemplateId(template.getId(),MailTemplateUser.CC_MAIL));
        return ResultSet.view(mailSendService.sendMail(mail));
    }
}