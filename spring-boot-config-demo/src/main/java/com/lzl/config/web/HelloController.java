package com.lzl.config.web;

import com.lzl.config.config.BookComponent;
import com.lzl.config.config.BookProperties;
import com.lzl.config.config.BookPropertiesAutoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizanle
 * @data 2019/1/13 下午5:43
 */
@RestController
public class HelloController {

    @Autowired
    private BookProperties bookProperties;

    @Autowired
    private BookComponent bookComponent;

    @Autowired
    private BookPropertiesAutoConfig bookPropertiesAutoConfig;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/book")
    public String book(){
        return bookProperties.getName()+"" + bookProperties.getAuthor();
    }

    @GetMapping("/prop")
    public String book1(){
        return bookComponent.getName() + "" + bookComponent.getAuthor();
    }

    @GetMapping("/autoconfig")
    public String book2(){
        return bookPropertiesAutoConfig.getName() + "" + bookPropertiesAutoConfig.getAuthor();
    }

}
