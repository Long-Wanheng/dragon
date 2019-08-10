package com.dragon.entity;

/**
 * 邮件模板实体类
 * @Author: 龙万恒
 * @CreateTime: 2019-08-04 21:34
 */
public class MailTemplate {
    /**
     * 邮件模板id
     */
    private Long id;
    /**
     * 邮件模板名
     */
    private String name;
    /**
     * 邮件主题
     */
    private String title;
    /**
     * 邮件内容
     */
    private String context;
    /**
     * 是否删除
     */
    private Integer isDelete = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
