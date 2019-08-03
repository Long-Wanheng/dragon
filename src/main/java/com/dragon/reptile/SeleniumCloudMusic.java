package com.dragon.reptile;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-03 14:17
 * @Description: ${Description}
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SeleniumCloudMusic {
    public static final Logger LOGGER = LoggerFactory.getLogger(SeleniumCloudMusic.class);

    public static void main(String[] args) {
        String key = "webdriver.chrome.driver";
        //谷歌驱动在你本地位置
        String value = "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe";
        System.setProperty(key, value);

        WebDriver driver = new ChromeDriver();
        driver.get("https://music.163.com/#/song?id=1321020935");

        WebElement iframe = driver.findElement(By.className("cmmts j-flag"));
        driver.switchTo().frame(iframe);

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='u-cover u-cover-1']"));
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
            WebElement ifra = driver.findElement(By.className("s-fc7"));
            driver.switchTo().frame(ifra);

            WebElement subject = driver.findElement(By.tagName("a"));

            System.out.println(subject.getText());
            LOGGER.info("获取到的参数为: {}"+subject.getText());
        }
    }
}