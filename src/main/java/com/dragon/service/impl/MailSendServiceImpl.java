package com.dragon.service.impl;

import com.dragon.common.config.MailSendConfig;
import com.dragon.common.exception.DragonException;
import com.dragon.dao.MailSendDAO;
import com.dragon.entity.Mail;
import com.dragon.service.MailSendService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-04 01:47
 */
@Service
public class MailSendServiceImpl implements MailSendService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailSendServiceImpl.class);

    @Autowired
    private MailSendDAO mailSendDAO;
    @Autowired
    private MailSendConfig mailSendConfig;

    @Override
    public int recordingMailSend(Mail mail) {
        StringBuilder toMailStr = new StringBuilder("{");
        mail.getToMail().forEach(mails -> {
            toMailStr.append(mails);
        });
        toMailStr.append("}");
        if (mail.getCcMail().size() > 0) {
            StringBuilder ccMailStr = new StringBuilder("{");
            mail.getCcMail().forEach(mails ->{
                ccMailStr.append(mails);
            });
            ccMailStr.append("}");
        }
        return 0;
    }

    @Override
    public boolean sendMail(Mail mail) {
        boolean success = mailSendConfig.send(mail);
        if (!success) {
            return false;
        } else {
            int result = recordingMailSend(mail);
            return result > 0;
        }
    }

    private  boolean verificationMail(Mail mail){
        return false;
    }
}
