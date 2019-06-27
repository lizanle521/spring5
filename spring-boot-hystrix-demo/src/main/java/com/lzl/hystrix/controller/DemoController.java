package com.lzl.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizanle
 * @Date 2019/4/17 17:30
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @HystrixCommand(fallbackMethod = "onError",
        commandProperties = {
                @HystrixProperty(name = "execution.isolation.strategy",value = "THREAD"),
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "100"),
                @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2")
        }, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "5"),
            @HystrixProperty(name = "maximumSize", value = "5"),
            @HystrixProperty(name = "maxQueueSize", value = "10")}
    )
    @RequestMapping("/sayHello")
    public String sayHello(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }

    @HystrixCommand
    @RequestMapping("/sayHi")
    public String sayHi(String name) {
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException("name不能为空");
        }
        return "Good morning, " + name;
    }

    public String onError(String name){
        return "error!"+name;
    }
}
