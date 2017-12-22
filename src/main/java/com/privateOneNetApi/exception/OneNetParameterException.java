
package com.privateOneNetApi.exception;

/**
 * API local检查异常。
 * 
 * 
 */
public class OneNetParameterException extends OneNetException
{

    private static final long serialVersionUID = -7787145910600194272L;

    public OneNetParameterException(int errCode, String errMsg)
    {
        super(errCode, errMsg);
    }

}
