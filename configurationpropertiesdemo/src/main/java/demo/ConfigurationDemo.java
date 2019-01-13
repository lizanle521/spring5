package demo;

import entity.People;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// 如果没有componentscan 配置的话，那么就会出现 TestController 无法被扫描到的情况
@ComponentScan("controller")
public class ConfigurationDemo {

    @Bean
    @ConfigurationProperties(prefix = "com.example.people")
    public People people(){
        return new People();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationDemo.class,args);
    }

}
