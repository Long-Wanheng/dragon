package com.dragon.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 邮件实体类
 *
 * @Author: 龙万恒
 * @CreateTime: 2019-08-04 00:20
 */
public class Mail {

    /**
     * 邮件id
     */
    private Long id;
    /**
     * 邮件主题
     */
    private String title;
    /**
     * 邮件内容
     */
    private String context;
    /**
     * 是否 html内容
     */
    private boolean isHTML = false;
    /**
     * 接收邮箱
     */
    private List<String> toMail;
    /**
     * 抄送人
     */
    private List<String> ccMail = new ArrayList<String>();
    /**
     * 邮件状态
     */
    private Integer status = SENDING;

    public static final Integer SENDING = 0;
    public static final Integer SEND_SUCCESS = 1;
    public static final Integer SEND_FAILURE = 2;

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

    public boolean isHTML() {
        return isHTML;
    }

    public void setHTML(boolean HTML) {
        isHTML = HTML;
    }

    public List<String> getToMail() {
        return toMail;
    }

    public void setToMail(List<String> toMail) {
        this.toMail = toMail;
    }

    public List<String> getCcMail() {
        return ccMail;
    }

    public void setCcMail(List<String> ccMail) {
        this.ccMail = ccMail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
