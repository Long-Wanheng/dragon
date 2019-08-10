package com.dragon.dao;

import com.dragon.model.entity.Mail;
import com.dragon.model.entity.MailSendLog;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-04 01:54
 * @Description: ${Description}
 */
public interface MailSendLogDAO {
    /**
     * 邮件发送记录添加
     *
     * @param mailSendLog
     * @return int
     */
    int add(MailSendLog mailSendLog);
}
