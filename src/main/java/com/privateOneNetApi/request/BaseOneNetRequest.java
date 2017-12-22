
package com.privateOneNetApi.request;

import com.alibaba.fastjson.JSON;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.BaseResponse;
import com.privateOneNetApi.response.OneNetResult;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 请求消息内部封装了一个请求实体类的对象 当收到服务端的响应数据时，
 * 会尝试把服务端的响应数据转换为响应包的实体对象返回
 * 
 * @author zhangjian
 *
 * @param <REQENTITY> 请求实体类型
 * @param <RSPENTITY> 返回实体类型
 */
public abstract class BaseOneNetRequest<REQENTITY, RSPENTITY extends BaseResponse>
        implements OneNetRequest<RSPENTITY>
{
    /**
     * 增加到http包的头域，用于指示本调用来自OneNET sdk调用
     */
    public static final String API_FROM = "api-from";

    /**
     * 内部封装的实体类对象
     */
    protected REQENTITY e;

    protected HashMap paraMap;

    //上传文件的路径
    public String filePath;

    /**
     * 设置的实体
     * 
     * @param e
     */
    public void setEntity(REQENTITY e)
    {
        this.e = e;
    }

    public REQENTITY getEntity()
    {
        return this.e;
    }

    public HashMap getParaMap() {
        return paraMap;
    }

    public void setParaMap(HashMap paraMap) {
        this.paraMap = paraMap;
    }

    /**
     * 校验 ,默认校验实体不能为空,可根据需要进行复写
     */
    
    public void check() throws OneNetParameterException
    {
        RequestCheckUtils.checkNotEmpty(e, "Entity");
    }


    public HTTPMETHOD getMethod()
    {
        return HTTPMETHOD.GET;
    }

    /**
     * 本方法为抽象方法，派生类必须实现此方法 此方法的作用是提取本次请求的URL，不同的方法的URL的形式不同
     * 
     * @param context
     * @return
     */
    public abstract String getURL(OneNetContext context) throws OneNetParameterException;

    /***
     * 提取应该插入到HTTP请求消息中的头域的字段 默认api key写入http header中,可根据需要复写
     * 
     * @param context
     * @return
     */
    public Map<String, String> getHead(OneNetContext context)
    {
        Map<String, String> head = new HashMap<String, String>();
        head.put(API_FROM, "OneNET-sdk");
        return head;
    }

    /**
     * 通过OneNetContext提取响应结果，在OneNETContext中，会存储返回结果 OneNetContext context
     * 表示本次请求的上下文，内部存储了本次请求的结果
     */
    public RSPENTITY parser(OneNetResult result) throws OneNetException
    {
        int responseCode = result.getResponseCode();
        String rspMessage = result.getResponseMessaage();
        byte[] content = result.getResponseResult();

        if (responseCode > 400)
        {
            throw new OneNetException(responseCode, rspMessage);
        }
        return JSON.parseObject(content, getResponseClass());
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
