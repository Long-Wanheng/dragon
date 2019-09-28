package com.dragon.common.config.shrio;

import com.dragon.mapper.MenuMapper;
import com.google.common.collect.Maps;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.servlet.Filter;
import java.util.Map;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-17 20:22
 */
@Configuration
public class ShiroConfig {

    @Value("${dragon.redis.url}")
    public String redisUrl;
    @Value("${dragon.redis.port}")
    public Integer redisPort;
    @Value("${dragon.redis.timeout}")
    public Integer redisTimeOut;
    @Value("${dragon.redis.password}")
    public String redisPassword;

    /**
     * @return JedisPool
     */
    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        JedisPool jedisPool = new JedisPool(config, redisUrl, redisPort, redisTimeOut, redisPassword);
        return jedisPool;
    }

    @Bean
    public MyShiroRealm myShiroRealm() {
        return new MyShiroRealm();
    }

    /**
     * @param redisManager 因为该方法需要的参数是另外一个方法，那个方法上面加了Bean注解，所以可以声明
     * @return
     */
    @Bean
    public RedisCacheManager shiroRedisCacheManager(RedisManager redisManager) {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager);
        return redisCacheManager;
    }

    @Bean
    public RedisManager redisManager(JedisPool jedisPool) {
        RedisManager redisManager = new RedisManager();
        redisManager.setJedisPool(jedisPool);
        return redisManager;
    }

    /**
     * shiro和redis进行整合，shiro缓存写到redis中
     */
    @Bean
    public RedisSessionDAO redisSessionDAO(RedisManager redisManager) {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager);
        return redisSessionDAO;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(RedisCacheManager shiroRedisCacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        securityManager.setCacheManager(shiroRedisCacheManager);
        return securityManager;
    }

    @Bean
    public MyShiroFilterFactoryBean shiroFilter(MenuMapper menuDAO, SecurityManager securityManager) {
        MyShiroFilterFactoryBean factoryBean = new MyShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        factoryBean.setLoginUrl("/login");
        factoryBean.setSuccessUrl("/index");
        factoryBean.setUnauthorizedUrl("/auth_error.html");
        factoryBean.setMenuDAO(menuDAO);
        factoryBean.setFilterChainDefinitions("/login = anon\n/doLogin = anon\n/static/** = anon");
        Map<String, Filter> map = Maps.newHashMap();
        map.put("roles", new MyShiroFilter());
        factoryBean.setFilters(map);
        return factoryBean;
    }
}
