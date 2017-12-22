
package com.privateOneNetApi.response;

/**
 * 存储每次HTTP请求响应结果的对象
 * 
 * @author szl
 *
 */

public class OneNetResult
{
    private Object[] result = new Object[4];

    /**
     * http 报文响应内容，是http响应报文的消息体中的数据，是this->response中的key
     */
    public static final int IOT_RESTAPI_HTTP_RESULT = 0;

    /**
     * http返回码，例如：HTTP/1.0 404 Not Found，会存储 404，是this->response中的key
     */
    public static final int IOT_RESTAPI_HTTP_RESPONSE_CODE = 1;

    /**
     * http 响应消息，例如：HTTP/1.0 404 Not Found，会存储 Not found，是this->response中的key
     */
    public static final int IOT_RESTAPI_HTTP_RESPONSE_MESSAGE = 2;

    public OneNetResult()
    {

    }

    public void setResponseCode(int Code)
    {
        this.result[IOT_RESTAPI_HTTP_RESPONSE_CODE] = Code;
    }

    public void setResponseMessage(String message)
    {
        this.result[IOT_RESTAPI_HTTP_RESPONSE_MESSAGE] = message;
    }

    public void setResponseResult(byte[] result)
    {
        this.result[IOT_RESTAPI_HTTP_RESULT] = result;
    }

    public byte[] getResponseResult()
    {
        return (byte[]) result[IOT_RESTAPI_HTTP_RESULT];
    }

    public int getResponseCode()
    {
        return (Integer) result[IOT_RESTAPI_HTTP_RESPONSE_CODE];
    }

    public String getResponseMessaage()
    {
        return (String) result[IOT_RESTAPI_HTTP_RESPONSE_MESSAGE];
    }
}
