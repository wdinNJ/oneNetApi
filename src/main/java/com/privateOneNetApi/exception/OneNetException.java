
package com.privateOneNetApi.exception;

/**
 * 自定义异常
 */
public class OneNetException extends Exception
{
    private static final long serialVersionUID = 1L;
    private int errCode = 999999;
    private String errMsg = "Unknown exception!";

    public OneNetException()
    {
        super();
    }

    public OneNetException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public OneNetException(String message)
    {
        super(message);
    }

    public OneNetException(Throwable cause)
    {
        super(cause);
    }

    public OneNetException(int errCode, String errMsg)
    {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public int getErrCode()
    {
        return this.errCode;
    }

    public String getErrMsg()
    {
        return this.errMsg;
    }
}
