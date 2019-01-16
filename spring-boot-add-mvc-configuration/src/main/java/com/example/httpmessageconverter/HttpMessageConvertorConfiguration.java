package com.example.httpmessageconverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author lizanle
 * @data 2019/1/16 下午2:18
 */
@Configuration
public class HttpMessageConvertorConfiguration implements WebMvcConfigurer {

    /**
     * 配置信息转换器
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(customConvertes());
    }

    @Bean
    public MappingJackson2HttpMessageConverter customConvertes(){
        return new MappingJackson2HttpMessageConverter(){
            @Override
            protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
                ObjectMapper mapper = new ObjectMapper();
                String s = mapper.writeValueAsString(object);
                String result = s + " MD5";
                outputMessage.getBody().write(result.getBytes());
            }
        };
    }
}
