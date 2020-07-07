package com.lzl.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author lizanle
 * @data 2019/1/14 下午2:52
 */
@SpringBootApplication
@EnableWebFlux
public class WebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxApplication.class,args);
    }
}
