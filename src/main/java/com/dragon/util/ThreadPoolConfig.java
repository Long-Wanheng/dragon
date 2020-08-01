package com.love.eveningwine.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolConfig
 *
 * @author : 龙万恒
 * @version :v1.0
 * @date : 2020-06-25 18:55
 */
@Configuration
public class ThreadPoolConfig {
    /**
     * 线程池维护线程的最少数量
     */
    @Value("${thread.corePoolSize:10}")
    private int corePoolSize;
    /**
     * 线程池维护线程的最大数量
     */
    @Value("${thread.maxPoolSize:30}")
    private int maxPoolSize;
    /**
     * 缓存队列
     */
    @Value("${thread.queueCapacity:300}")
    private int queueCapacity;
    /**
     * 允许的空闲时间
     */
    @Value("${thread.keepAlive:60}")
    private int keepAlive;

    @Bean(name = "threadPool")
    public ThreadPoolExecutor getThreadPool() {
        return new ThreadPoolExecutor(corePoolSize,
                maxPoolSize,
                keepAlive,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(queueCapacity),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Bean(name = "logThreadPool")
    public ThreadPoolExecutor getLogThreadPool() {
        return new ThreadPoolExecutor((int) (maxPoolSize * 0.8),
                maxPoolSize,
                keepAlive,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(queueCapacity),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Bean(name = "clientServerLogThreadPool")
    public ThreadPoolExecutor getClientServerLogThreadPool() {
        return new ThreadPoolExecutor(corePoolSize,
                maxPoolSize,
                keepAlive,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(queueCapacity),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
