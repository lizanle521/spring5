package com.lzl.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzl.dubbo.domain.Person;
import com.lzl.dubbo.service.PersonDubboService;

/**
 * @author lizanle
 * @data 2019/1/14 上午10:19
 */
@Service(version = "1.0.0")
public class PersonDubboServiceImpl implements PersonDubboService {
    @Override
    public Person findPerson() throws Exception {
        return new Person();
    }
}
