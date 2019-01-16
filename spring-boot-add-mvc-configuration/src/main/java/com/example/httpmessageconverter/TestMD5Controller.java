package com.example.httpmessageconverter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizanle
 * @data 2019/1/16 下午2:54
 */
@RestController
public class TestMD5Controller {

    @RequestMapping("/getmap")
    public Map get(){
        HashMap<String, String> map = new HashMap<>();
        map.put("aaa","bbb");
        return map;

    }
}
