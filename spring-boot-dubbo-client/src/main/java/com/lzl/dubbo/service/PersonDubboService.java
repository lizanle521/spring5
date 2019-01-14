package com.lzl.dubbo.service;

import com.lzl.dubbo.domain.Person;

/**
 * @author lizanle
 * @data 2019/1/14 上午10:06
 */
public interface PersonDubboService {
     Person findPerson() throws Exception;
}
