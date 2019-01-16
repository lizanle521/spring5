package com.example.argumentsresolver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizanle
 * @data 2019/1/16 下午5:27
 */
@RestController
public class TestArgResolverController {

    @RequestMapping("/arg")
    public String arg( PlatformSession<Long> platformSession, String s){
        return platformSession.getUserName();
    }
}