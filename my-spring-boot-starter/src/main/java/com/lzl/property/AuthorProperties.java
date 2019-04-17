package com.lzl.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lizanle
 * @Date 2019/4/17 10:55
 */
@ConfigurationProperties(prefix = "author")
public class AuthorProperties {
    public AuthorProperties() {
        System.out.println("");
    }

    private String name;
    private String gender;
    private String company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
