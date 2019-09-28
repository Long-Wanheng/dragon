package src.main.test.java.com.agoi.service;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-09-28 20:19
 * @Description: ${Description}
 */

import com.dragon.Application;
import com.dragon.service.SeleniumCloudMusicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class) //1.4版本之前用的是//@SpringApplicationConfiguration(classes = Application.class)
public class ConfigTest {

    @Autowired
    private SeleniumCloudMusicService config;

    @Test
    public void add() throws Exception {
        config.reptileMusicUsers("2001320");
    }


}