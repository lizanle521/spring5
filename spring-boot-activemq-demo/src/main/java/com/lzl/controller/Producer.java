package com.lzl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizanle
 * @data 2019/6/27 10:50 PM
 */
@RestController
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @GetMapping("/sendMsg")
    public void sendMsg(String msg){
        jmsMessagingTemplate.convertAndSend("My_Msg",msg);
    }
}
