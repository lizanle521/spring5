package com.lzl.hystrix.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizanle
 * @Date 2019/4/18 9:56
 */
@RestController
public class GreetingControllerImpl implements GreetingController {
    @Override
    public String greeting(@PathVariable("username") String username) {
        return "hello "+ username;
    }
}
