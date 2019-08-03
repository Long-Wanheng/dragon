package com.dragon.dao;

import com.dragon.entity.Mail;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-04 01:54
 * @Description: ${Description}
 */
public interface MailSendDAO {
    /**
     * 邮件发送记录添加
     * @param mail
     * @return int
     */
    int add(Mail mail);
}
