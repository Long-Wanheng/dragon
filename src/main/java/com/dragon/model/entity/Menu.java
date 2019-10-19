package com.dragon.model.entity;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * 菜单实体类
 *
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 21:00
 */
public class Menu {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 菜单名
     */
    private String menuName;
    /**
     * 菜单URL
     */
    private String menuUrl;
    /**
     * 子菜单
     */
    private List<Menu> children = Lists.newArrayList();
    /**
     * 父id
     */
    private Long parentId;
    /**
     * layUI使用
     */
    private Map<String, Object> attributes = Maps.newHashMap();

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

    public String getText() {
        return menuName;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
