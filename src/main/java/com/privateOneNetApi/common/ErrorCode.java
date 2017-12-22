
package com.privateOneNetApi.common;

/**
 * 错误码封装枚举
 * 
 * @author zhangjian
 *
 */
public enum ErrorCode
{
    HTTP_METHOD(42, "http-method-error:Invalid method!");

    private int code;
    private String msg;

    private ErrorCode(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    public int code()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String msg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }
}
