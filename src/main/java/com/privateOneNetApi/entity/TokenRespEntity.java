package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/15
 * @description 获取token后的返回值
 */
public class TokenRespEntity {

    //用于后续API的token调用
    private String token;

    //token过期时间，单位：秒
    private long timeout;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }
}
