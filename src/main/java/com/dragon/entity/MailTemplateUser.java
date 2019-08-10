package com.dragon.entity;

/**
 * 邮件模板用户关联表
 *
 * @Author: 龙万恒
 * @CreateTime: 2019-08-04 21:47
 */
public class MailTemplateUser {

    /**
     * 模板id
     */
    private Integer templateId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 接收类型 1接收 2抄送
     */
    private Integer sendType;

    public static final Integer TO_MAIL = 1;

    public static final Integer CC_MAIL = 2;

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }
}
