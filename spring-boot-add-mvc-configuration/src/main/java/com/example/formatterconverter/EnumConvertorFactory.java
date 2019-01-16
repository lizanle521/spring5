package com.example.formatterconverter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * 将字符串转换成枚举类型，如果找不到对应的枚举，就返回空
 * @author lizanle
 * @data 2019/1/16 下午4:19
 */
public class EnumConvertorFactory implements ConverterFactory<String,Enum> {

    @Override
    public <T extends Enum> Converter<String, T> getConverter(Class<T> aClass) {
        return new String2EnumConvertor<>(aClass);
    }

    class String2EnumConvertor<T extends Enum<T>> implements Converter<String,T> {
        Class<T> aClass;

        @Override
        public T convert(String source) {
            if (source != null && !source.isEmpty()) {
                try {
                    return Enum.valueOf(aClass, source);
                } catch (Exception e) {
                }
            }
            return null;

        }

        public String2EnumConvertor(Class<T> aClass) {
            this.aClass = aClass;
        }
    }
}
