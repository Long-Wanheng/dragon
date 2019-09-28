package com.dragon.controller;

import com.dragon.model.entity.Role;
import com.dragon.service.RoleService;
import com.dragon.util.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-09-28 22:38
 */
@RestController
@RequestMapping("/api/roleManage")
public class RoleManageController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/add")
    public ResultSet add(@RequestBody Role role) {
        return ResultSet.view(roleService.addRole(role));
    }

    @RequestMapping("/update")
    public ResultSet update(@RequestBody Role role) {
        return ResultSet.view(roleService.updateRole(role));
    }

    @RequestMapping("/list")
    public ResultSet list() {
        return ResultSet.view(roleService.getAllRole());
    }

    @RequestMapping("/delete/{id}")
    public ResultSet delete(@RequestParam Long id) {
        return ResultSet.view(roleService.logicDelete(id));
    }


    @RequestMapping("role")
    public ModelAndView role() {
        return new ModelAndView(new RedirectView("role"));
    }
}
