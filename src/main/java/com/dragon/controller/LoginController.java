package com.dragon.controller;

import com.dragon.util.ResultSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 登录服务
 *
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 20:07
 */
@Controller
public class LoginController {

    @RequestMapping()
    public ResultSet login(HttpSession session) {

        return ResultSet.view(null);
    }
}
