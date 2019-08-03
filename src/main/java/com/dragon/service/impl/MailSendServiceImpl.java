package com.dragon.service.impl;

import com.dragon.common.config.MailSendConfig;
import com.dragon.common.exception.DragonException;
import com.dragon.dao.MailSendDAO;
import com.dragon.entity.Mail;
import com.dragon.service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-04 01:47
 */
@Service
public class MailSendServiceImpl implements MailSendService {

    @Autowired
    private MailSendDAO mailSendDAO;
    @Autowired
    private MailSendConfig mailSendConfig;

    @Override
    public int recordingMailSend(Mail mail) {

        return mailSendDAO.add(mail);
    }

    @Override
    public boolean sendMail(Mail mail) {
        if (mail == null) {
            throw new DragonException("不能为空");
        }
        boolean success = mailSendConfig.send(mail);
        if (!success) {
            return false;
        } else {
            int result = recordingMailSend(mail);
            return result > 0;
        }
    }
}
