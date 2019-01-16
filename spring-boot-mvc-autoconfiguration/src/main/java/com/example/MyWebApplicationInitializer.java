package com.example;

import javax.servlet.ServletException;

/**
 *  定义一个接口相当于 WebApplicationInitializer
 * @author lizanle
 * @data 2019/1/15 下午5:21
 */
public interface MyWebApplicationInitializer

{
     void onStartup(javax.servlet.ServletContext servletContext) throws ServletException ;
}
