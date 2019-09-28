package com.dragon.dao.impl;

import com.dragon.dao.MailTemplateDAO;
import com.dragon.mapper.MailTemplateMapper;
import com.dragon.model.entity.MailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-09-28 21:31
 * @Description: ${Description}
 */
@Service
public class MailTemplateDAOImpl implements MailTemplateDAO {
    @Autowired
    private MailTemplateMapper mailTemplateMapper;

    @Override
    public MailTemplate getMailTemplateByName(String name) {
        return mailTemplateMapper.getMailTemplateByName(name);
    }
}
