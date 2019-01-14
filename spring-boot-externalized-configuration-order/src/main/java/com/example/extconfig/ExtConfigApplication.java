package com.example.extconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lizanle
 * @data 2019/1/14 下午9:33
 */
@SpringBootApplication
public class ExtConfigApplication {

    public static void main(String[] args) {

        //System.setProperty("spring.devtools.restart.enabled", "true");
        SpringApplication.run(ExtConfigApplication.class,args);
    }
}
