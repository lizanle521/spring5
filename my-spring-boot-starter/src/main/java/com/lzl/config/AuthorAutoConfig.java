package com.lzl.config;

import com.lzl.entity.Author;
import com.lzl.property.AuthorProperties;
import com.lzl.service.MyService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 自动装备类
 * @author lizanle
 * @Date 2019/4/17 11:06
 */
@Configuration
//当classpath下存在指定类时，该配置类才有效。
@ConditionalOnClass(MyService.class)
//支持配置属性
@EnableConfigurationProperties(AuthorProperties.class)
public class AuthorAutoConfig {

    public AuthorAutoConfig() {
        System.out.println("init");
    }

    @Resource
    private AuthorProperties authorProperties;
    /**
     * @ConditionalOnBean:当容器中有指定的Bean的条件下
     * @ConditionalOnClass：当类路径下有指定的类的条件下 
     * @ConditionalOnExpression:基于SpEL表达式作为判断条件 
     * @ConditionalOnJava:基于JVM版本作为判断条件 
     * @ConditionalOnJndi:在JNDI存在的条件下查找指定的位置 
     * @ConditionalOnMissingBean:当容器中没有指定Bean的情况下 
     * @ConditionalOnMissingClass:当类路径下没有指定的类的条件下 
     * @ConditionalOnNotWebApplication:当前项目不是Web项目的条件下 
     * @ConditionalOnProperty:指定的属性是否有指定的值 
     * @ConditionalOnResource:类路径下是否有指定的资源 
     * @ConditionalOnSingleCandidate:当指定的Bean在容器中只有一个，或者在有多个Bean的情况下，用来指定首选的Bean
     * @ConditionalOnWebApplication:当前项目是Web项目的条件下
     * * @return
     */
    @Bean
    // @ConditionOnMissingBean（MyService.class）表示当spring上下文中不存在MyService实例时才会加载该方法以生成实例。
    @ConditionalOnMissingBean(MyService.class)
    //@ConditionOnProperties 表示当配置文件中存在该配置时，才会加载该方法，若加了matchIfMissing = true,则表示即使配置文件中没有定义该属性配置，也会加载该方法
    @ConditionalOnProperty(name="author.enabled",matchIfMissing = true)
    public MyService authorResolver(){
        MyService myService = new MyService();
        Author author = new Author();
        author.setCompany(authorProperties.getCompany());
        author.setGender(authorProperties.getGender());
        author.setName(authorProperties.getName());
        myService.setAuthor(author);
        return myService;
    }
}
