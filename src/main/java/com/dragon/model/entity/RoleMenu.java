package com.dragon.model.entity;

/**
 * 角色菜单中间表实体类
 *
 * @Author: 龙万恒
 * @CreateTime: 2019-08-18 00:19
 */
public class RoleMenu {

    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 菜单id
     */
    private Long menuId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
