package com.dragon.controller;

import com.dragon.model.entity.Menu;
import com.dragon.model.entity.User;
import com.dragon.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * 登录服务
 *
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 20:07
 */
@RestController
public class LoginController {
    public static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private MenuService menuService;

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/doLogin")
    public ModelAndView login(String loginParam, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginParam, password);
        try {
            subject.login(token);
        } catch (Exception e) {
            LOGGER.error("用户身份验证异常！登录参数:{},密码：{}", loginParam, password);
            return new ModelAndView("login", "message", "用户名或密码错误");
        }
        return new ModelAndView(new RedirectView("index"));
    }

    @RequestMapping("logout")
    public ModelAndView logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new ModelAndView(new RedirectView("login"));
    }

    @RequestMapping("index")
    public ModelAndView index(Model model) {
        Subject subject = SecurityUtils.getSubject();
        //因为认证方法返回的info对象的principal属性由原先的id变成了user对象，所以此处需要强转
        List<Menu> menus = menuService.getUserMenuByUserId((((User) subject.getPrincipal()).getId()));
        model.addAttribute("menus", menus);
        return new ModelAndView(new RedirectView("index"));
    }
}
