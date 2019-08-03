package com.dragon.reptile;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-03 14:17
 * @Description: ${Description}
 */

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public class SeleniumCloudMusicConfig {
    @Value("${chrome.driver.path}")
    private  String chromeDriverPath;
    @Value("${chrome.driver.key}")
    private String chromeDriverKey;
    public static final Logger LOGGER = LoggerFactory.getLogger(SeleniumCloudMusicConfig.class);

    public  void getSeleniumCloudMusicUserInfo(String musicUrl) {
        LOGGER.info("开始进行网易云数据爬虫");

        try {
            System.setProperty(chromeDriverKey, chromeDriverPath);
        } catch (Exception e) {
            LOGGER.error("chrome driver initialization failed");
        }
        WebDriver driver = new ChromeDriver();
        //driver.get("https://music.163.com/#/song?id=1321020935");
        if(StringUtils.isBlank(musicUrl)){

        }
        driver.get(musicUrl);
        WebElement iframe = driver.findElement(By.className("g-iframe"));
        driver.switchTo().frame(iframe);

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='itm']"));
        List<String> playLists = new ArrayList<String>();

        for (WebElement webElement : elements) {
            webElement.findElement(By.tagName("div"));
            WebElement node = webElement.findElement(By.tagName("a"));
            String url = node.getAttribute("href");
            System.out.println(url);
            playLists.add(url);
        }
        for (String str : playLists) {
            driver.get(str);
            WebElement ifra = driver.findElement(By.className("g-iframe"));
            driver.switchTo().frame(ifra);
            WebElement subject = driver.findElement(By.tagName("h2"));
            System.out.println(subject.getText());
        }
    }
}