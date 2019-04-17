package com.example.argumentsresolver;

import org.springframework.stereotype.Controller;

import java.lang.annotation.*;

/**
 * @author lizanle
 * @Date 2019/1/21 15:39
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
     String value() default  "";
}
