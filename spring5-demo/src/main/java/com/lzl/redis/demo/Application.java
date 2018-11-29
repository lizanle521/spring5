package com.lzl.redis.demo;

import com.lzl.redis.demo.controller.NewServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author: peijiepang
 * @date 2018/10/10
 * @Description:
 */
@SpringBootApplication
 @ServletComponentScan  //扫描相应的包 看看类上边是否有 WebServlet注解
public class Application {
    // @Bean 可以通过 Bean进行servlet注入
    public ServletRegistrationBean servlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new NewServlet(), "/servlet");
        bean.setAsyncSupported(true);
        bean.setLoadOnStartup(0);
        return bean;
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
