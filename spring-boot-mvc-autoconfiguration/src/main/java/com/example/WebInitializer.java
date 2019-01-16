package com.example;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author lizanle
 * @data 2019/1/15 下午5:46
 */
public class WebInitializer implements MyWebApplicationInitializer
{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
            ServletRegistration.Dynamic test = servletContext.addServlet("test", new MyServlet());
            test.setLoadOnStartup(1);
            test.addMapping("/test");
    }
}
