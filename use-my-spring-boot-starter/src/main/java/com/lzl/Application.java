package com.lzl;

import com.lzl.config.AuthorAutoConfig;
import com.lzl.entity.Author;
import com.lzl.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lizanle
 * @Date 2019/4/17 11:29
 */
@SpringBootApplication
@ImportAutoConfiguration({AuthorAutoConfig.class})
public class Application implements CommandLineRunner {
    @Autowired
    private MyService myService;
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = myService.getAuthor();
        System.out.println(author.getName());
    }
}
