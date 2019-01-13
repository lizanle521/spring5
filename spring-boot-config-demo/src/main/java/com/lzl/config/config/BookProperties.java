package com.lzl.config.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author lizanle
 * @data 2019/1/13 下午6:22
 */
@Component
public class BookProperties {
    @Value("[spring book]")
    private String name;

    @Value("author lizanle")
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
