package com.example;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

/**
 * @author lizanle
 * @data 2019/1/14 下午4:53
 */
public class MyListener implements ApplicationListener<ApplicationEvent>
{
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event.getClass().getName());
    }
}
