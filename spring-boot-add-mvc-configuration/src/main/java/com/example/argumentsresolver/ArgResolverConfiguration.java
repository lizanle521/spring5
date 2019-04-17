package com.example.argumentsresolver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lizanle
 * @data 2019/1/16 下午5:21
 */
@Configuration
//@EnableWebMvc  // 只能有一个 这个注解的 configuration 类
public class ArgResolverConfiguration implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        System.out.println("addArgumentResolvers");
        resolvers.add(new MyHandlerMethodArgumentResolver());
        for (HandlerMethodArgumentResolver resolver : resolvers) {
            System.out.println(resolver.getClass().getName());
        }
    }

}
