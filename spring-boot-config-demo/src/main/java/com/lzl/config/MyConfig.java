package com.lzl.config;

import com.lzl.config.config.BookPropertiesAutoConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lizanle
 * @data 2019/1/13 下午6:37
 */
@Configuration
@EnableConfigurationProperties(BookPropertiesAutoConfig.class)
public class MyConfig {


    @Bean
    public Object test(BookPropertiesAutoConfig bookPropertiesAutoConfig){
        return new Object();
    }
}
