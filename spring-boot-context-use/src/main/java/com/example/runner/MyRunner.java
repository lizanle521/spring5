package com.example.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author lizanle
 * @data 2019/1/14 下午6:11
 */
@Component
public class MyRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("myrunner do sth.");
    }
}
