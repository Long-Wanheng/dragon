package com.dragon.dao.impl;

import com.dragon.dao.MailSendLogDAO;
import com.dragon.mapper.MailSendLogMapper;
import com.dragon.model.entity.MailSendLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-09-28 21:30
 * @Description: ${Description}
 */
@Service
public class MailSendLogDAOImpl implements MailSendLogDAO {
    @Autowired
    private MailSendLogMapper mailSendLogMapper;

    @Override
    public int add(MailSendLog mailSendLog) {
        return mailSendLogMapper.add(mailSendLog);
    }
}
