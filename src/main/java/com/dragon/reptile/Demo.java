package com.dragon.reptile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-03 20:29
 * @Description: ${Description}
 */
public class Demo{
        public static void main(String[] args) {
            String key="webdriver.chrome.driver";
            //谷歌驱动在你本地位置
            String value = "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe";
            System.setProperty(key,value);

            WebDriver driver = new ChromeDriver();
//            driver.get("http://music.163.com/#");
            driver.get("https://music.163.com/#/song?id=1321020935");
            WebElement iframe = driver.findElement(By.className("g-iframe"));
            driver.switchTo().frame(iframe);

            List<WebElement> elements = driver.findElements(By.xpath("//div[@class='itm']"));
            List<String> playLists = new ArrayList<String>();

            for (WebElement webElement:elements){
                webElement.findElement(By.tagName("div"));
                WebElement node = webElement.findElement(By.tagName("a"));
                String url = node.getAttribute("href");
                System.out.println(url);
                playLists.add(url);
            }
            for (String str:playLists){
                driver.get(str);
                WebElement ifra = driver.findElement(By.className("g-iframe"));
                driver.switchTo().frame(ifra);
                WebElement subject = driver.findElement(By.tagName("h2"));
                System.out.println(subject.getText());
            }
        }
}
