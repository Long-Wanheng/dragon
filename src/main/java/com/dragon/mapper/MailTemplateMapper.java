package com.dragon.mapper;

import com.dragon.model.entity.MailTemplate;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-04 21:37
 */
public interface MailTemplateMapper {
    /**
     * 根据模板名获取模板
     * @param name
     * @return MailTemplate
     * */
    MailTemplate getMailTemplateByName(@Param("name") String name);

}
