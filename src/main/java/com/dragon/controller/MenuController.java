package com.dragon.controller;

import com.dragon.service.MenuService;
import com.dragon.util.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-10-01 00:23
 */
@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/tree")
    public ResultSet tree() {
        return ResultSet.view(menuService.getMenuTree());
    }
}
