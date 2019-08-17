package com.dragon.common.config.shrio;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyShiroFilter extends AuthorizationFilter{

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject= SecurityUtils.getSubject();//当前登陆用户
        String[] roleArray = (String[]) o;
        for (String s : roleArray) {
            if(subject.hasRole(s)){
                return true;
            }
        }
        return false;
    }


}
