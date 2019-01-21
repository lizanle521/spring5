package com.example.argumentsresolver;

import org.springframework.stereotype.Controller;

/**
 * @author lizanle
 * @Date 2019/1/21 15:39
 */
public @interface MyAnnotation {
     String value() default  "";
}
