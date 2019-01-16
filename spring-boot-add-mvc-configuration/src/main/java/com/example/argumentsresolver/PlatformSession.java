package com.example.argumentsresolver;

/**
 * @author lizanle
 * @data 2019/1/16 下午4:58
 */
public class PlatformSession<T> {
    private T id;
    private String userName;
    private Integer expireTime;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }
}
