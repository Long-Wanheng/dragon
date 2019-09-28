package com.dragon.dao.impl;

import com.dragon.dao.MailTemplateUserDAO;
import com.dragon.mapper.MailTemplateUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-09-28 21:32
 * @Description: ${Description}
 */
@Service
public class MailTemplateUserDAOImpl implements MailTemplateUserDAO {
    @Autowired
    private MailTemplateUserMapper mailTemplateUserMapper;

    @Override
    public List<String> findUsersByTemplateId(Long id, Integer type) {
        return mailTemplateUserMapper.findUsersByTemplateId(id, type);
    }
}
