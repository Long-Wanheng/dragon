package com.dragon.model.entity;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 菜单实体类
 *
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 21:00
 */
public class Menu {
    private Long id;
    private String menuName;
    private String menuUrl;
    private List<Menu> children = Lists.newArrayList();
    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
