package com.dragon.service.impl;

import com.dragon.common.config.ExcelConfig;
import com.dragon.common.config.SeleniumCloudMusicConfig;
import com.dragon.common.utils.DateUtils;
import com.dragon.dao.MailTemplateDAO;
import com.dragon.dao.MailTemplateUserDAO;
import com.dragon.dao.MusicUserDAO;
import com.dragon.model.entity.Mail;
import com.dragon.model.entity.MailTemplate;
import com.dragon.model.entity.MailTemplateUser;
import com.dragon.model.entity.SeleniumCloudMusicUser;
import com.dragon.service.MailSendService;
import com.dragon.service.SeleniumCloudMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-10 23:30
 * @Description: ${Description}
 */
@Service
public class SeleniumCloudMusicServiceImpl implements SeleniumCloudMusicService {
    @Autowired
    private SeleniumCloudMusicConfig musicConfig;
    @Autowired
    private ExcelConfig excelConfig;
    @Autowired
    private MailSendService mailSendService;
    @Autowired
    private MailTemplateDAO mailTemplateDAO;
    @Autowired
    private MailTemplateUserDAO templateUserDAO;
    @Autowired
    private MusicUserDAO musicUserDAO;

    @Override
    public int reptileMusicUsers(String songId) {
        List<SeleniumCloudMusicUser> userList = musicConfig.getSeleniumCloudMusicUserInfo(songId);
        String excelName = DateUtils.currentDateString("yyyy-MM-dd HH-mm-ss") + "get data and music is-" + songId;
        String path = excelConfig.writeExcel(userList, excelName);
        MailTemplate template = mailTemplateDAO.getMailTemplateByName("网易云音乐用户爬虫邮件");
        Mail mail = new Mail();
        BeanUtils.copyProperties(template, mail, "id");
        mail.setToMail(templateUserDAO.findUsersByTemplateId(template.getId(), MailTemplateUser.TO_MAIL));
        mail.setCcMail(templateUserDAO.findUsersByTemplateId(template.getId(), MailTemplateUser.CC_MAIL));
        mailSendService.sendMail(mail, path, excelName, true);

        return musicUserDAO.batchAdd(userList);
    }


    private List<SeleniumCloudMusicUser> removeDuplicateUser(List<SeleniumCloudMusicUser> users) {


        return null;
    }
}
