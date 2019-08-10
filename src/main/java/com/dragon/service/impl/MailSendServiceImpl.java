package com.dragon.service.impl;

import com.dragon.common.config.MailSendConfig;
import com.dragon.common.exception.DragonException;
import com.dragon.dao.MailSendLogDAO;
import com.dragon.model.entity.Mail;
import com.dragon.model.entity.MailSendLog;
import com.dragon.service.MailSendService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
    private MailSendLogDAO mailSendLogDAO;
    @Autowired
    private MailSendConfig mailSendConfig;

    @Override
    public int recordingMailSend(Mail mail, Integer status) {
        MailSendLog log = new MailSendLog();
        BeanUtils.copyProperties(mail, log, "id", "ccMail", "toMail");
        StringBuilder toMailStr = new StringBuilder("{");
        mail.getToMail().forEach(mails -> {
            toMailStr.append(mails);
        });
        toMailStr.append("}");
        log.setToMail(toMailStr.toString());
        if (mail.getCcMail().size() > 0) {
            StringBuilder ccMailStr = new StringBuilder("{");
            mail.getCcMail().forEach(mails -> {
                ccMailStr.append(mails);
            });
            ccMailStr.append("}");
            log.setCcMail(ccMailStr.toString());
        }
        log.setStatus(Mail.SEND_SUCCESS);
        return mailSendLogDAO.add(log);
    }

    @Override
    public boolean sendMail(Mail mail) {
        verificationMail(mail);
        try {
            boolean success = mailSendConfig.send(mail);
            if (!success) {
                recordingMailSend(mail, Mail.SEND_FAILURE);
                return false;
            } else {
                int result = recordingMailSend(mail, Mail.SEND_SUCCESS);
                return result > 0;
            }
        } catch (Exception e) {
            LOGGER.error("邮件发送失败!!!", e);
        }
        return false;
    }

    private boolean verificationMail(Mail mail) {
        if (null == mail) {
            throw new DragonException("非法参数");
        }
        if (StringUtils.isBlank(mail.getTitle())) {
            throw new DragonException("标题不能为空");
        }
        if (StringUtils.isBlank(mail.getContext())) {
            throw new DragonException("邮件内容不能为空");
        }
        if (null == mail.getToMail() || mail.getToMail().isEmpty()) {
            throw new DragonException("必须设置邮件接收人！");
        }
        if (null == mail.getStatus()) {
            throw new DragonException("必须设置邮件状态！");
        }
        return false;
    }
}
