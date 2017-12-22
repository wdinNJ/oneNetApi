
package com.privateOneNetApi.common;

import com.alibaba.fastjson.JSON;
import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.request.BaseOneNetRequest;
import com.privateOneNetApi.request.OneNetRequest;
import com.privateOneNetApi.response.BaseResponse;
import com.privateOneNetApi.response.OneNetResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于连接访问onenet平台的默认链接类
 */
public class DefaultOneNetClient implements OneNetClient
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultOneNetClient.class);

    public static final String CHARSET_UTF8 = "UTF-8";

    /**
     * api请求的上下文，内部封装了一个Map，存储了请求相关的所有信息
     */
    private OneNetContext context;
    /**
     * 默认连接超时时间为15秒
     */
    private int connectTimeout = 15000;
    /**
     * 默认响应超时时间为30秒
     */
    private int readTimeout = 30000;

    private boolean needCheckRequest = true;

    public DefaultOneNetClient(String apiAddress)
    {
        this(Scheme.HTTP.getScheme(), apiAddress);
    }

    public DefaultOneNetClient(String scheme, String apiAddress)
    {
        this.context = new OneNetContext();
        this.context.setContext(OneNetContext.SCHEME, scheme);
        this.context.setContext(OneNetContext.API_ADDRESS, apiAddress);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public <T extends BaseResponse> T execute(OneNetRequest<T> request) throws Exception
    {
        long start = System.currentTimeMillis();
        T result;
        if (this.needCheckRequest)
        {
            try
            {
                request.check();
            }
            catch (OneNetParameterException e)
            {
                return errorResonse(request.getResponseClass(), e);
            }
        }
        OneNetContext context = new OneNetContext(this.context);
        context.removeAllParameter();
        BaseOneNetRequest baseIOTRequest = ((BaseOneNetRequest) request);
        OneNetRequest.HTTPMETHOD method = request.getMethod();
        String url = baseIOTRequest.getURL(context);
        OneNetResult response;
        try
        {
            switch (method)
            {
                case GET:
                    response = WebUtils.doGet(url,
                            connectTimeout, readTimeout, baseIOTRequest.getHead(context));
                break;
                case POST:
                    response = WebUtils.doPost(url, getContent(baseIOTRequest), CHARSET_UTF8,
                            connectTimeout, readTimeout, baseIOTRequest.getHead(context));
                break;
                case PUT:
                    response = WebUtils.doPut(url, getContent(baseIOTRequest), CHARSET_UTF8,
                            connectTimeout, readTimeout, baseIOTRequest.getHead(context));
                break;
                case DELETE:
                    response = WebUtils.doDelete(url, baseIOTRequest.getHead(context));
                break;
                case UPLOAD_POST:
                    Map<String, String> paraMap = ((BaseOneNetRequest) request).getParaMap();
                    response = WebUtils.doUploadPost(url, CHARSET_UTF8,paraMap,
                            connectTimeout, readTimeout, baseIOTRequest.getHead(context));
                    break;
                default:
                    throw new OneNetException(ErrorCode.HTTP_METHOD.code(),
                            ErrorCode.HTTP_METHOD.msg());
            }
            result = request.parser(response);
        }
        catch (OneNetException e)
        {
            return errorResonse(request.getResponseClass(), e);
        }
        catch (Exception e)
        {
            LOGGER.error("execute exception: {}", e.getMessage());
            throw new OneNetException(e);
        }
        LOGGER.info("Request[{}] processing time:[{}]ms", request.toString(),
                System.currentTimeMillis() - start);
        return result;
    }

    /**
     * DELETE 、GET
     * 
     * @param baseIOTRequest
     * @return
     */
    /*
     * @SuppressWarnings({ "rawtypes", "unchecked" }) private Map<String,
     * String> getEntity(BaseIOTRequest baseIOTRequest) { Map<String, String>
     * params = null; Object entity = baseIOTRequest.getEntity(); if (null ==
     * entity || entity instanceof Void) { return params; } if
     * (!entity.getClass().equals(String.class)) { params = (Map<String,
     * String>) entity; } return params; }
     */

    /**
     * POST 、PUT
     * 
     * @param baseIOTRequest
     * @return
     */
    @SuppressWarnings({ "rawtypes" })
    private byte[] getContent(BaseOneNetRequest baseIOTRequest)
    {
        byte[] buf;
        Object entity = baseIOTRequest.getEntity();
        if (entity instanceof byte[])
        {
            buf = (byte[]) entity;
        }
        else
        {
            buf = JSON.toJSONBytes(entity);
        }
        return buf;
    }

    private <T extends BaseResponse> T errorResonse(Class<T> responseClass, OneNetException e)
            throws OneNetException
    {
        T localResponse;
        try
        {
            localResponse = responseClass.newInstance();
        }
        catch (Exception xe)
        {
            throw new OneNetException(xe);
        }
        localResponse.setErrno(e.getErrCode());
        localResponse.setError(e.getErrMsg());
        return localResponse;
    }

    public void setNeedCheckRequest(boolean needCheckRequest)
    {
        this.needCheckRequest = needCheckRequest;
    }

    public void setConnectTimeout(int connectTimeout)
    {
        this.connectTimeout = connectTimeout;
    }

    public void setReadTimeout(int readTimeout)
    {
        this.readTimeout = readTimeout;
    }

    /**
     * 一次性将文件转化为二进制流
     * @param paraMap
     * @return
     * @throws Exception
     */
    private byte[] handlerFileToByte(Map<String,String> paraMap) throws Exception{
        String path = paraMap.get("filePath");
        String maxFileSize = paraMap.get("maxFileSize");
        if(path == null || "".equals(path)){
            throw new OneNetException("文件路径不能为空");
        }

        /*if(maxFileSize == null || Integer.parseInt(maxFileSize+"") < 1){
            throw new OneNetException("文件大小不能为空同时必须是整数且大于0");
        }*/

        File file = new File(path + "");

        if(!file.exists() || !file.isFile()){
            throw new OneNetException("文件不存在或不是文件");
        }
        //获取文件名称
        paraMap.put("uploadFileName",file.getName());

        long fileSize = file.length();
        if(maxFileSize != null){
            if(Integer.parseInt(maxFileSize+"") < 1){
                throw new OneNetException("文件大小必须是整数且大于0");
            }
            //1M=1024k=1048576字节，1k=1024字节
            if(fileSize > Integer.parseInt(maxFileSize+"") * 1024){
                throw new OneNetException("文件不能超过"+ maxFileSize +"M");
            }
        }

        byte[] uploadFileBytes = new byte[(int)fileSize];
        InputStream is = new FileInputStream(file);
        try{
            ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
            byte[] bb = new byte[2048];
            int ch;
            ch = is.read(bb);
            while (ch != -1) {
                bytestream.write(bb, 0, ch);
                ch = is.read(bb);
            }
            uploadFileBytes = bytestream.toByteArray();
        }finally {
            is.close();
        }
        return uploadFileBytes;
    }

}
