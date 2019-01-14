package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author lizanle
 * @data 2019/1/14 下午5:07
 */
@SpringBootApplication
public class ListenerApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        SpringApplication build = builder.listeners(new MyListener())
                .build();
        build.run(ListenerApplication.class,args);
        /**
         * org.springframework.boot.context.event.ApplicationStartingEvent
         * org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent
         * org.springframework.boot.context.event.ApplicationPreparedEvent
         * org.springframework.context.event.ContextRefreshedEvent
         * org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent
         * org.springframework.boot.context.event.ApplicationStartedEvent
         * org.springframework.boot.context.event.ApplicationReadyEvent
         */
    }
}
