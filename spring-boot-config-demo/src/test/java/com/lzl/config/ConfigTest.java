package com.lzl.config;

import com.lzl.config.config.BookComponent;
import com.lzl.config.config.BookProperties;
import com.lzl.config.config.BookPropertiesAutoConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lizanle
 * @data 2019/1/13 下午6:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigTest {

    /**
     * 要想正确注入，configTest类必须和SpringBootApplication注解所在的包的层级及以下层级
     */
    @Autowired
    private BookProperties bookProperties;

    @Autowired
    private BookComponent bookComponent;

    @Autowired
    private BookPropertiesAutoConfig bookPropertiesAutoConfig;

    @Test
    public void test1(){
        Assert.assertEquals(bookProperties.getName(),"[spring book]");

    }
}
