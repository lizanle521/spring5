package com.lzl.redis.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SelfBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor,ApplicationContextAware {
    private ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        beanDefinitionRegistry.registerBeanDefinition("test11", BeanDefinitionBuilder.rootBeanDefinition(Object.class).getBeanDefinition());
        System.out.println("postProcessBeanDefinitionRegistry");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory");
    }

    @Bean(name="test")
    public Object getTest(){
        System.out.println("getTestBean");
        Object test = applicationContext.getBean("test11");
        if(test != null){
            System.out.println("testbean get success");
        }
        return new Object();
    }

    @Bean
    public Object getObj(){
        System.out.println("getObjBean");
        return new Object();
    }
}
