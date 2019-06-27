package com.lzl.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author lizanle
 * @data 2019/6/27 10:53 PM
 */
@Component
public class Consumer {

    @JmsListener(destination = "My_Msg")
    public void readMsg(String text){
        System.out.println("consumer:"+text);
    }
}
