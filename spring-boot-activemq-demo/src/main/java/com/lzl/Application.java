package com.lzl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * docker启动mq docker run -d --name myactivemq -p 61617:61616 -p 8162:8161 webcenter/activemq
 * @author lizanle
 * @data 2019/6/27 10:47 PM
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
