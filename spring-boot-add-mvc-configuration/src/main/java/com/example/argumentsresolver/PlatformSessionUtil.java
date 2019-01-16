package com.example.argumentsresolver;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lizanle
 * @data 2019/1/16 下午5:16
 */
public class PlatformSessionUtil {

    public static PlatformSession<Long> getSession(HttpServletRequest request){
        PlatformSession<Long> session = new PlatformSession<>();
        session.setId(100L);
        session.setUserName("lizanle");
        session.setExpireTime(100);
        return session;
    }
}
