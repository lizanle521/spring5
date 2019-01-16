package com.example.formatterconverter;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizanle
 * @data 2019/1/16 下午4:33
 */
@RestController
public class TestConvertorController {


    @RequestMapping("/getenum")
    public String get(@RequestParam MyEnum a){
        return a.getClass().getName() + "   " ;
    }
}
