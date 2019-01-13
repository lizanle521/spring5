package com.lzl.config.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lizanle
 * @data 2019/1/13 下午6:36
 */
@ConfigurationProperties(prefix = "book")
public class BookPropertiesAutoConfig {
    private String name;
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
