package com.dragon.filter;


import com.dragon.common.utils.UserUtils;
import com.dragon.model.entity.User;
import org.apache.shiro.SecurityUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * 登录过滤器
 *
 * @Author: 龙万恒
 * @CreateTime: 2019-07-28 17:53
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        UserUtils.setCurrentUser(user);
    }
}
