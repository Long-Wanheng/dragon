package com.dragon.controller;

import com.dragon.common.utils.VerificationCodeImgUtil;
import com.dragon.model.entity.Menu;
import com.dragon.model.entity.User;
import com.dragon.service.MenuService;
import com.dragon.util.ResultSet;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public ModelAndView loginPage() {
        return new ModelAndView("login");
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
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/getCode")
    public void validateCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession();
        VerificationCodeImgUtil vCode = new VerificationCodeImgUtil(120, 40, 5, 100);
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
    }

    @RequestMapping("/validateCode")
    public ResultSet validateCode(String code, HttpSession session) {
        String trueCode = (String) session.getAttribute("code");
        if (StringUtils.isEmpty(code)) {
            return ResultSet.view(false);
        }
        if (trueCode.equalsIgnoreCase(code)) {
            return ResultSet.view(true);
        } else {
            return ResultSet.view(false);
        }
    }

}
