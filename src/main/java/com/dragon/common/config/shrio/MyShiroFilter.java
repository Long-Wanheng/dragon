package com.dragon.common.config.shrio;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 20:22
 */
public class MyShiroFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        String[] roleArray = (String[]) o;
        for (String s : roleArray) {
            if (subject.hasRole(s)) {
                return true;
            }
        }
        return false;
    }


}
