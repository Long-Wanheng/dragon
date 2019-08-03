package com.dragon.reptile;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-03 16:31
 * @Description: ${Description}
 */

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {

    public static void main(String[] args) {
        String key = "webdriver.chrome.driver";
        //谷歌驱动在你本地位置
        String value = "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe";
        System.setProperty(key, value);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://news.baidu.com");

        List<WebElement> links = driver.findElements(By.xpath(".//*[@id='pane-news']/ul[1]/li/a"));

        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getText());
        }
    }
}