package com.lzl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizanle
 * @data 2019/6/27 10:48 PM
 */
@RestController
@RequestMapping("/consumer")
public class HelloConsumer {

    @Autowired
    private Environment environment;

    @RequestMapping("/info")
    public String info(){
        return environment.getProperty("url");
    }
}
