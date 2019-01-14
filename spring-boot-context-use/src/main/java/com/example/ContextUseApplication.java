package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author lizanle
 * @data 2019/1/14 下午5:41
 */
@SpringBootApplication
public class ContextUseApplication {


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication();
        // 如果springmvc 和  springwebflux 同时存在，默认使用 springmvc
        //application.setApplicationContextClass(AnnotationConfigServletWebServerApplicationContext.class);
        //application.setWebApplicationType(WebApplicationType.REACTIVE);
        application.run(ContextUseApplication.class);
    }
}
