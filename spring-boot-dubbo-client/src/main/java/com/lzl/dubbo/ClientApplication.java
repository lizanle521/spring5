package com.lzl.dubbo;

import com.lzl.dubbo.domain.Person;
import com.lzl.dubbo.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 用multicat 启动回出现 Can't assign requested addres 错误
 * 需要 加 虚拟机 参数  -Djava.net.preferIPv4Stack=true
 * @author lizanle
 * @data 2019/1/14 上午10:32
 */
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext run = SpringApplication.run(ClientApplication.class, args);
        PersonService bean = run.getBean(PersonService.class);
        Person person = bean.findPerson();
        System.out.println(person);
    }
}
