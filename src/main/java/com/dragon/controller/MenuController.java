package com.dragon.controller;

import com.dragon.model.entity.Menu;
import com.dragon.model.query.MenuQuery;
import com.dragon.service.MenuService;
import com.dragon.util.ResultSet;
import com.dragon.util.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping("/table")
    public TableData table(@RequestBody MenuQuery query) {
        return menuService.getTable(query);
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

    @RequestMapping("/delete/{ids}")
    public ResultSet delete(@PathVariable List<Long> ids) {
        menuService.delete(ids);
        return ResultSet.view(true);
    }

    @RequestMapping("/getUserMenu/{id}")
    public ResultSet getUserMenu(@RequestParam("id") Long id) {
        return ResultSet.view(menuService.getUserMenuByUserId(id));
    }

}
