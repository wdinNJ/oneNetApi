
package com.privateOneNetApi.common;

import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.request.OneNetRequest;
import com.privateOneNetApi.response.BaseResponse;

/**
 * OneNet设备云客户端抽象基类
 * 
 * @author zhangjian
 *
 */
public interface OneNetClient
{
    /**
     * 执行API请求，反馈直接结果
     * 
     * @param <T>
     * @param request
     *            具体的Request请求
     * @return 具体的Rsp响应
     */
    <T extends BaseResponse> T execute(OneNetRequest<T> request) throws Exception;

}