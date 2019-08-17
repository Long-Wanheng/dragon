package com.dragon.controller;

import com.dragon.util.ResultSet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 登录服务
 *
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 20:07
 */
@RestController
public class LoginController {

    @RequestMapping()
    public ResultSet login(HttpSession session) {

        return ResultSet.view(null);
    }
}
