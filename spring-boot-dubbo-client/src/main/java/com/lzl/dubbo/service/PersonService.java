package com.lzl.dubbo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lzl.dubbo.domain.Person;
import org.springframework.stereotype.Component;

/**
 * @author lizanle
 * @data 2019/1/14 上午10:06
 */
@Component
public class PersonService {
     @Reference(version = "1.0.0",check = false,url = "dubbo://127.0.0.1:20880")
     private PersonDubboService personDubboService;

     public Person findPerson() throws Exception{
          return personDubboService.findPerson();
     }

}
