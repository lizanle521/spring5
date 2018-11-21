package com.lzl.redis.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SelfBeanDefinitionRegistryPostProcessor.class);
        ctx.refresh();
        ctx.close();

    }
}
