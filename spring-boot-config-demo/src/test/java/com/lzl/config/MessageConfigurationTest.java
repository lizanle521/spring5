package com.lzl.config;

import com.lzl.config.config.MessageConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Spring Boot MessageConfiguration 测试 - {@link MessageConfiguration}
 *
 */
public class MessageConfigurationTest {

    @Test
    public void testGetMessageBean() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MessageConfiguration.class);
        assertEquals("message configuration", ctx.getBean("message"));
    }

    @Test
    public void testScanPackages() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("com.lzl.config.config");
        ctx.refresh();
        assertEquals("message configuration", ctx.getBean("message"));
    }
}
