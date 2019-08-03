package com.dragon.service;

import com.dragon.entity.Mail;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-04 01:47
 */
public interface MailSendService {
    /**
     * 邮件发送记录添加
     * @param mail
     * @return int
     */
    int recordingMailSend(Mail mail);
    /**
     * 邮件发送服务
     * @param mail
     * @return boolean
     */
    boolean sendMail(Mail mail);
}
