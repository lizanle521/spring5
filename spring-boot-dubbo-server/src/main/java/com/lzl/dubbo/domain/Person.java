package com.lzl.dubbo.domain;

import java.io.Serializable;

/**
 * @author lizanle
 * @data 2019/1/14 上午10:05
 */
public class Person implements Serializable {

    private String name;
    private String gender;

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
}
