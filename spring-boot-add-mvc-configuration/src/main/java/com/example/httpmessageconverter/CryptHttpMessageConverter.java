package com.example.httpmessageconverter;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.List;

/**
 * 有这么一个场景，要对 springmvc返回的 json进行 加密
 * 如果是拦截器的话，是做不到的。因为程序运行到这里，是在数据返回之后，页面渲染之前。response的输出流已经关闭了，没有办法再进行操作。
 * 可行的方式是借助 HttpMessageConverter
 * @author lizanle
 * @data 2019/1/16 下午2:22
 */
public class CryptHttpMessageConverter implements HttpMessageConverter<String> {
    /**
     * 判断该转换器是否能将请求内容转换成 Java 对象
     * @param clazz
     * @param mediaType
     * @return
     */
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    /**
     * 判断该转换器是否可以将 Java 对象转换成返回内容
     * @param clazz
     * @param mediaType
     * @return
     */
    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    /**
     * 获得该转换器支持的 MediaType 类型
     * @return
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return null;
    }

    /**
     * 读取请求内容并转换成 Java 对象
     * @param clazz
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    public String read(Class<? extends String> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    /**
     * 将 Java 对象转换后写入返回内容
     * @param s
     * @param contentType
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    public void write(String s, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }
}
