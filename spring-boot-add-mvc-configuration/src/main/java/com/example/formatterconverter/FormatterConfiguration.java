package com.example.formatterconverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lizanle
 * @data 2019/1/16 下午4:18
 */
@Configuration
public class FormatterConfiguration implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(enumConvertorFactory());
    }

    @Bean
    public EnumConvertorFactory enumConvertorFactory(){
        return new EnumConvertorFactory();
    }
}
