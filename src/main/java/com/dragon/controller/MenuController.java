package com.dragon.controller;

import com.dragon.model.entity.Menu;
import com.dragon.service.MenuService;
import com.dragon.util.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/add")
    public ResultSet add(@RequestBody Menu menu) {
        menuService.addMenu(menu);
        return ResultSet.view(true);
    }

    @RequestMapping("/update")
    public ResultSet update(@RequestBody Menu menu) {
        menuService.updateMenu(menu);
        return ResultSet.view(true);
    }

    @RequestMapping("/getUserMenu/{id}")
    public ResultSet getUserMenu(@RequestParam("id") Long id) {
        return ResultSet.view(menuService.getUserMenuByUserId(id));
    }

}
