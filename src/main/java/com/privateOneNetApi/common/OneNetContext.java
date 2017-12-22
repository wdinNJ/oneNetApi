
package com.privateOneNetApi.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文封装
 * 
 * @author zhangjian
 */
public class OneNetContext
{
    /**
     * 协议key，如http、https等等
     */
    public static final String SCHEME = "scheme";
    /**
     * api地址，默认为api.heclouds.com
     */
    public static final String API_ADDRESS = "API_ADDRESS";

    // OneNet上下文环境，请求URL中问号的前半部分需要的参数保存在context中，这部分参数一般比较固定
    private Map<String, Object> context = new HashMap<String, Object>();

    // OneNet请求的参数，对应URL中问号后面的部分中包括的参数，这部分参数一般每次请求都不同
    private Map<String, Object> parameter = new HashMap<String, Object>();

    public OneNetContext()
    {
        context.put(SCHEME, Scheme.HTTP.getScheme());
    }

    public OneNetContext(OneNetContext context)
    {
        this.context.put(SCHEME, Scheme.HTTP.getScheme());
        this.context.putAll(context.context);
        this.parameter.putAll(context.parameter);
    }

    public Map<String, Object> getContext()
    {
        return context;
    }

    public Map<String, Object> getParameter()
    {
        return parameter;
    }

    /**
     * 设置某个键值对
     * 
     * @param name
     * @param value
     */
    public void setContext(String name, Object value)
    {
        context.put(name, value);
    }

    /**
     * 提取某个上下文的值
     * 
     * @param name
     * @return
     */
    public Object getContext(String name)
    {
        return context.get(name);
    }

    /**
     * 移除某个键值对
     * 
     * @param name
     * @return
     */
    public Object removeContext(String name)
    {
        return context.remove(name);
    }

    public void removeAllContext()
    {
        context.clear();
    }

    public void setParameter(String name, Object value)
    {
        parameter.put(name, value);
    }

    public Object getParameter(String name)
    {
        return parameter.get(name);
    }

    public Object removeParameter(String name)
    {
        return parameter.remove(name);
    }

    public void removeAllParameter()
    {
        parameter.clear();
    }
}
