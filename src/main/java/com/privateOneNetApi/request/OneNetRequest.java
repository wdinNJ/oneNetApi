
package com.privateOneNetApi.request;

import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.BaseResponse;
import com.privateOneNetApi.response.OneNetResult;

/**
 * 请求接口
 * 
 * @author zhangjian
 *
 * @param <T>
 */
public interface OneNetRequest<T extends BaseResponse>
{
    public enum HTTPMETHOD
    {
        GET, POST, PUT, DELETE,UPLOAD_POST
    }

    /**
     * 返回实体类型
     * 
     * @return
     */
    public Class<T> getResponseClass();

    /**
     * 客户端参数检查，减少服务端无效调用。
     */
    public void check() throws OneNetParameterException;

    /**
     * 返回http操作类型
     * 
     * @return
     */
    public HTTPMETHOD getMethod();

    /**
     * 响应解析
     * 
     * @param response
     * @return
     */
    T parser(OneNetResult response) throws OneNetException;
}
