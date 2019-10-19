package com.dragon.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-10-13 17:53
 */
//@Configuration
public class JedisPoolConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(JedisPoolConfig.class);
    private static JedisPool pool = null;

    static {
        InputStream in = JedisPoolConfig.class.getClassLoader().getResourceAsStream("redis.properties");
        Properties pro = new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            LOGGER.error("redis init failure {}", e.getMessage());
        }
        //获得池子对象
        redis.clients.jedis.JedisPoolConfig poolConfig = new redis.clients.jedis.JedisPoolConfig();
        //最大闲置个数
        poolConfig.setMaxIdle(Integer.parseInt(pro.get("redis.maxIdle").toString()));
        //最小闲置个数
        poolConfig.setMinIdle(Integer.parseInt(pro.get("redis.minIdle").toString()));
        //最大连接数
        poolConfig.setMaxTotal(Integer.parseInt(pro.get("redis.maxTotal").toString()));

        pool = new JedisPool(poolConfig, pro.getProperty("redis.url"), Integer.parseInt(pro.get("redis.port").toString()));
    }

    /**
     * 获得jedis资源的方法
     */
    private static Jedis getJedis() {
        return pool.getResource();
    }

    /**
     * redis写入值
     *
     * @param key
     * @param value
     */
    public static void setPool(String key, String value) {
        getJedis().set(key, value);
    }

    /**
     *
     */
    public static void getPool(String key) {
        getJedis().get(key);
    }
}