package com.privateOneNetApi.common;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/15
 * @description 用于指定网址开头
 */
public enum Scheme {

    HTTP("http"), HTTPS("https"), TCP("TCP"), UDP("UDP");

    private String scheme;

    private Scheme(String scheme)
    {
        this.scheme = scheme;
    }

    public String getScheme()
    {
        return scheme;
    }

}
