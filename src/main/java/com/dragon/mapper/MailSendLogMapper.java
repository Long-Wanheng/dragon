package com.dragon.mapper;

import com.dragon.model.entity.MailSendLog;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-04 01:54
 * @Description: ${Description}
 */
public interface MailSendLogMapper {
    /**
     * 邮件发送记录添加
     *
     * @param mailSendLog
     * @return int
     */
    int add(MailSendLog mailSendLog);
}
