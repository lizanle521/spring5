package com.lzl.config.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lizanle
 */
@Configuration
public class MessageConfiguration {

    @Bean
    public String message() {
        return "message configuration";
    }
}
