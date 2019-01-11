package com.lzl.redis.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizanle
 * @Date 2019/1/8 12:11
 */
@RestController
public class HelloSpringBoot {

    @RequestMapping(value = {"",""})
    public String hiSpringBoot(){
        return "hi spring boot";
    }
}
