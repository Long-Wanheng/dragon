package com.dragon.model.entity;

import java.util.Date;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-10 21:25
 * @Description: ${Description}
 */
public class MailSendLog {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 邮件标题
     */
    private String title;
    /**
     * 邮件内容
     */
    private String context;
    /**
     * 收件人
     */
    private String toMail;
    /**
     * 抄送人
     */
    private String ccMail;
    /**
     * 邮件状态
     */
    private Integer status;
    /**
     * 发送时间
     */
    private Date createdTime;
    /**
     * 是否删除
     */
    private Integer isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getToMail() {
        return toMail;
    }

    public void setToMail(String toMail) {
        this.toMail = toMail;
    }

    public String getCcMail() {
        return ccMail;
    }

    public void setCcMail(String ccMail) {
        this.ccMail = ccMail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
