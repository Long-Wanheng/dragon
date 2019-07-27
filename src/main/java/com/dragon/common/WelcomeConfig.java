package com.dragon.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *  项目默认访问路径
 * @Author: 龙万恒
 * @CreateTime: 2019-07-27 23:08
 */
@Configuration
public class WelcomeConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //默认访问页面
        registry.addViewController("/").setViewName("index");
        //最先执行过滤
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);

        super.addViewControllers(registry);

    }
}