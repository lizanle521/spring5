package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * RestController 是@Controller
 @ResponseBody  两个注解的 集合

 EnableAutoConfiguration
 其中最关键的要属@Import(AutoConfigurationImportSelector.class)，借助AutoConfigurationImportSelector，@EnableAutoConfiguration可以帮助SpringBoot应用将所有符合条件的@Configuration配置都加载到当前SpringBoot创建并使用的IoC容器。

 借助于Spring框架原有的一个工具类：SpringFactoriesLoader的支持，@EnableAutoConfiguration可以智能的自动配置功效才得以大功告成！

 在AutoConfigurationImportSelector类中可以看到通过 SpringFactoriesLoader.loadFactoryNames()
 把 spring-boot-autoconfigure.jar/META-INF/spring.factories中每一个xxxAutoConfiguration文件都加载到容器中，spring.factories文件里每一个xxxAutoConfiguration文件一般都会有下面的条件注解:

 @ConditionalOnClass ： classpath中存在该类时起效
 @ConditionalOnMissingClass ： classpath中不存在该类时起效
 @ConditionalOnBean ： DI容器中存在该类型Bean时起效
 @ConditionalOnMissingBean ： DI容器中不存在该类型Bean时起效
 @ConditionalOnSingleCandidate ： DI容器中该类型Bean只有一个或@Primary的只有一个时起效
 @ConditionalOnExpression ： SpEL表达式结果为true时
 @ConditionalOnProperty ： 参数设置或者值一致时起效
 @ConditionalOnResource ： 指定的文件存在时起效
 @ConditionalOnJndi ： 指定的JNDI存在时起效
 @ConditionalOnJava ： 指定的Java版本存在时起效
 @ConditionalOnWebApplication ： Web应用环境下起效
 @ConditionalOnNotWebApplication ： 非Web应用环境下起效
 * @author lizanle
 * @Date 2019/1/11 14:49
 */
@RestController("example")
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/")
    public String home() {
        return "hellow world";
    }

    public static void main(String[] args) {
        SpringApplication.run(Example.class,args);
    }
}
