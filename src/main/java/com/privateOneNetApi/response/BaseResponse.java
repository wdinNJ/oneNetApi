package com.privateOneNetApi.response;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/15
 * @description 基本返回信息
 */
public abstract class BaseResponse {

    //返回码
    private int errno;

    //返回信息
    private String error;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
