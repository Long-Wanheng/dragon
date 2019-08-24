package com.dragon.common.config;


import com.dragon.common.exception.DragonException;
import com.dragon.model.entity.SeleniumCloudMusicUser;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

/**
 * 网易云爬虫工具类
 *
 * @Author: 龙万恒
 * @CreateTime: 2019-08-03 14:17
 */
@Configuration
public class SeleniumCloudMusicConfig {
    @Value("${chrome.driver.path}")
    private String chromeDriverPath;
    @Value("${chrome.driver.key}")
    private String chromeDriverKey;

    public static final Logger LOGGER = LoggerFactory.getLogger(SeleniumCloudMusicConfig.class);

    private static final String MUSIC_URL = "https://music.163.com/#/song?id=";

    /**
     * 根据歌曲id获取用户id信息爬虫
     */
    public List<SeleniumCloudMusicUser> getSeleniumCloudMusicUserInfo(String songId) {
        if (StringUtils.isNotBlank(songId)) {
            LOGGER.info("爬虫获取数据的歌曲id为 {}", songId);
        } else {
            throw new DragonException("歌曲id不能为空");
        }
        LOGGER.info("开始进行网易云数据爬虫");

        try {
            System.setProperty(chromeDriverKey, chromeDriverPath);
        } catch (Exception e) {
            LOGGER.error("chrome driver initialization failed");
        }
        WebDriver driver = new ChromeDriver();
        driver.get(MUSIC_URL + songId);
        WebElement iframe = driver.findElement(By.className("g-iframe"));
        driver.switchTo().frame(iframe);

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='itm']"));
        List<SeleniumCloudMusicUser> userList = Lists.newArrayList();

        Date currentTime = new Date();
        for (WebElement webElement : elements) {
            webElement.findElement(By.tagName("div"));
            WebElement node = webElement.findElement(By.tagName("a"));
            String url = node.getAttribute("href");
            SeleniumCloudMusicUser user = new SeleniumCloudMusicUser();
            user.setUserUrl(url);
            user.setMusicId(url.substring(MUSIC_URL.length()));
            userList.add(user);
        }
        for (SeleniumCloudMusicUser user : userList) {
            driver.get(user.getUserUrl());
            WebElement ifra = driver.findElement(By.className("g-iframe"));
            driver.switchTo().frame(ifra);
            WebElement subject = driver.findElement(By.tagName("h2"));
            user.setNickName(subject.getText());
            user.setMusicId(songId);
            user.setCreateTime(currentTime);
        }
        return userList;
    }
}