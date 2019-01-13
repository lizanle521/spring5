package com.lzl.config.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author lizanle
 * @data 2019/1/13 下午6:28
 */
@Component
@ConfigurationProperties(prefix = "book")
//@Validated 一般不这么做
public class BookComponent {

    @NotEmpty
    private String name;

    @NotNull
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
