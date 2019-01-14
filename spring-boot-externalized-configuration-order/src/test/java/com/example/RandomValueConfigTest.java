package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lizanle
 * @data 2019/1/14 下午10:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@SpringBootConfiguration
public class RandomValueConfigTest {

    @Test
    public void testRandomvalue(){
        RandomValuePropertySource my = new RandomValuePropertySource("my.secret");
        Object secret = my.getProperty("random.value");
        System.out.println(secret);
    }
}
