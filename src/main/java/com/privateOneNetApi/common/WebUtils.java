
package com.privateOneNetApi.common;


import com.privateOneNetApi.exception.OneNetException;
import com.privateOneNetApi.response.OneNetResult;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * 网络工具类。
 * 
 */
public abstract class WebUtils
{
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_GET = "GET";
    private static final String METHOD_PUT = "PUT";
    private static final String METHOD_DELETE = "DELETE";
    private static final String CONTENT_ENCODING_GZIP = "gzip";

    private WebUtils()
    {
    }
    /**
     * 执行HTTP POST请求。
     *
     * @param url
     *            请求地址
     * @param content
     *            请求字节数组，传入参数
     *@param connectTimeout
     *            链接超时时间
     * @param readTimeout
     *            链接读取超时时间
     * @return 响应字符串
     */
    public static OneNetResult doPost(String url, byte[] content,
                                      String charset, int connectTimeout, int readTimeout,
                                      Map<String, String> headerMap) throws IOException
    {
        String ctype = "application/json;charset=" + charset;
        return doPost(url, ctype, content, connectTimeout, readTimeout,
                headerMap);
    }

    /**
     * 执行HTTP POST请求。
     *
     * @param url
     *            请求地址
     * @param ctype
     *            请求类型
     * @param content
     *            请求字节数组，传入参数
     *@param connectTimeout
     *            链接超时时间
     * @param readTimeout
     *            链接读取超时时间
     * @return 响应字符串
     */
    public static OneNetResult doPost(String url, String ctype, byte[] content,
            int connectTimeout, int readTimeout) throws IOException
    {
        return doPost(url, ctype, content, connectTimeout, readTimeout, null);
    }
    /**
     * 执行HTTP POST请求。
     *
     * @param url
     *            请求地址
     * @param ctype
     *            请求类型
     * @param content
     *            请求字节数组，传入参数
     *@param connectTimeout
     *            链接超时时间
     * @param readTimeout
     *            链接读取超时时间
     * @return 响应字符串
     */
    private static OneNetResult doPost(String url, String ctype,
            byte[] content, int connectTimeout, int readTimeout,
            Map<String, String> headerMap) throws IOException
    {
        HttpURLConnection conn = null;
        OutputStream out = null;
        OneNetResult rsp = null;
        try
        {
            conn = getConnection(new URL(url), METHOD_POST, ctype, headerMap);
            conn.setConnectTimeout(connectTimeout);
            conn.setUseCaches(false);
            conn.setReadTimeout(readTimeout);
            out = conn.getOutputStream();
            out.write(content);
            rsp = getResponseAsContext(conn);
        }
        finally
        {
            if (out != null)
            {
                out.close();
            }
            if (conn != null)
            {
                conn.disconnect();
            }
        }

        return rsp;
    }


    /**
     * 执行HTTP GET请求。
     *
     * @param url
     *            请求地址
     *@param connectTimeout
     *            链接超时时间
     * @param readTimeout
     *            链接读取超时时间
     * @return 响应字符串
     */
    public static OneNetResult doGet(String url,int connectTimeout, int readTimeout) throws IOException
    {
        return doGet(url,connectTimeout, readTimeout, null, DEFAULT_CHARSET);
    }
    /**
     * 执行HTTP GET请求。
     *
     * @param url
     *            请求地址
     *@param connectTimeout
     *            链接超时时间
     * @param readTimeout
     *            链接读取超时时间
     * @return 响应字符串
     */
    public static OneNetResult doGet(String url,int connectTimeout, int readTimeout, Map<String, String> headerMap)
            throws IOException
    {
        return doGet(url,connectTimeout, readTimeout, headerMap, DEFAULT_CHARSET);
    }

    /**
     * 执行HTTP GET请求。
     * 
     * @param url
     *            请求地址
     *@param connectTimeout
     *            链接超时时间
     * @param readTimeout
     *            链接读取超时时间
     * @param charset
     *            字符集，如UTF-8, GBK, GB2312
     * @return 响应字符串
     */
    private static OneNetResult doGet(String url,int connectTimeout, int readTimeout, Map<String, String> headerMap,
            String charset) throws IOException
    {
        HttpURLConnection conn = null;
        OneNetResult rsp = null;

        try
        {
            String ctype = "application/json;charset=" + charset;
            conn = getConnection(new URL(url), METHOD_GET, ctype, headerMap);
            conn.setConnectTimeout(connectTimeout);
            conn.setUseCaches(false);
            conn.setReadTimeout(readTimeout);
            rsp = getResponseAsContext(conn);
        }
        finally
        {
            if (conn != null)
            {
                conn.disconnect();
            }
        }

        return rsp;
    }
    /**
     * 设置URL链接请求参数。
     *
     * @param url
     *            请求地址
     * @param method
     *            请求类型
     * @return 响应链接
     */
    private static HttpURLConnection getConnection(URL url, String method,
            String ctype, Map<String, String> headerMap) throws IOException
    {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        if (conn instanceof HttpsURLConnection)
        {
            HttpsURLConnection connHttps = (HttpsURLConnection) conn;
            try
            {
                SSLContext ctx = SSLContext.getInstance("TLS");
                ctx.init(null,
                        new TrustManager[] { new TrustAllTrustManager() },
                        new SecureRandom());
                connHttps.setSSLSocketFactory(ctx.getSocketFactory());
                connHttps.setHostnameVerifier(new HostnameVerifier()
                {
                    public boolean verify(String hostname, SSLSession session)
                    {
                        return true;
                    }
                });
            }
            catch (Exception e)
            {
                throw new IOException(e);
            }
            conn = connHttps;
        }

        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Host", url.getHost());
        //conn.setRequestProperty("Accept", "application/json ;charset=utf-8");
        conn.setRequestProperty("Content-Type", ctype);
        if(headerMap.get("upload") != null && !"".equals(headerMap.get("upload"))){
            conn.setRequestProperty("Content-Disposition",headerMap.get("Content-Disposition"));
            conn.setRequestProperty("Content-Transfer-Encoding",headerMap.get("Content-Transfer-Encoding"));
        }
        if (headerMap != null)
        {
            for (Map.Entry<String, String> entry : headerMap.entrySet())
            {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        return conn;
    }
    /**
     * 获取URL返回数据。
     *
     * @param conn
     *          url链接
     * @return 请求返回数据
     */
    private static OneNetResult getResponseAsContext(HttpURLConnection conn)
            throws IOException
    {
        OneNetResult out = new OneNetResult();
        String charset = getResponseCharset(conn.getContentType());
        byte[] result;
        int responseCode = conn.getResponseCode();
        String contentEncoding = conn.getContentEncoding();
        if (CONTENT_ENCODING_GZIP.equalsIgnoreCase(contentEncoding))
        {
            result = getStreamAsBytes(
                    new GZIPInputStream(conn.getInputStream()), charset);
        }
        else
        {
            result = getStreamAsBytes(conn.getInputStream(), charset);
        }

        out.setResponseCode(responseCode);
        out.setResponseMessage(conn.getResponseMessage());
        out.setResponseResult(result);
        return out;
    }
    /**
     * 数据流转换成String。
     *
     * @param stream
     *          数据流
     * @return 返回String
     */
    public static String getStreamAsString(InputStream stream, String charset)
            throws IOException
    {
        try
        {
            Reader reader = new InputStreamReader(stream, charset);
            StringBuilder response = new StringBuilder();

            final char[] buff = new char[1024];
            int read;
            while ((read = reader.read(buff)) > 0)
            {
                response.append(buff, 0, read);
            }

            return response.toString();
        }
        finally
        {
            if (stream != null)
            {
                stream.close();
            }
        }
    }
    /**
     * 数据流转换成字节流。
     *
     * @param stream
     *          数据流
     * @return 返回字节流
     */
    public static byte[] getStreamAsBytes(InputStream stream, String charset)
            throws IOException
    {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        try
        {
            final byte[] buff = new byte[1024];
            int read = 0;
            while ((read = stream.read(buff)) > 0)
            {
                arrayOutputStream.write(buff, 0, read);
            }

            return arrayOutputStream.toByteArray();
        }
        finally
        {
            if (stream != null)
            {
                stream.close();
            }
            arrayOutputStream.close();
        }
    }
    /**
     * 获取charset
     *
     * @param ctype
     *        application/json;charset=utf-8
     * @return 返回编码
     */
    public static String getResponseCharset(String ctype)
    {
        String charset = DEFAULT_CHARSET;

        if (!StringUtils.isEmpty(ctype))
        {
            String[] params = ctype.split(";");
            for (String param : params)
            {
                param = param.trim();
                if (param.startsWith("charset"))
                {
                    String[] pair = param.split("=", 2);
                    if (pair.length == 2)
                    {
                        if (!StringUtils.isEmpty(pair[1]))
                        {
                            charset = pair[1].trim();
                        }
                    }
                    break;
                }
            }
        }

        return charset;
    }

    /**
     * 使用默认的UTF-8字符集反编码请求参数值。
     * 
     * @param value
     *            参数值
     * @return 反编码后的参数值
     */
    public static String decode(String value)
    {
        return decode(value, DEFAULT_CHARSET);
    }

    /**
     * 使用默认的UTF-8字符集编码请求参数值。
     * 
     * @param value
     *            参数值
     * @return 编码后的参数值
     */
    public static String encode(String value)
    {
        return encode(value, DEFAULT_CHARSET);
    }

    /**
     * 使用指定的字符集反编码请求参数值。
     * 
     * @param value
     *            参数值
     * @param charset
     *            字符集
     * @return 反编码后的参数值
     */
    public static String decode(String value, String charset)
    {
        String result = null;
        if (!StringUtils.isEmpty(value))
        {
            try
            {
                result = URLDecoder.decode(value, charset);
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    /**
     * 使用指定的字符集编码请求参数值。
     * 
     * @param value
     *            参数值
     * @param charset
     *            字符集
     * @return 编码后的参数值
     */
    public static String encode(String value, String charset)
    {
        String result = null;
        if (!StringUtils.isEmpty(value))
        {
            try
            {
                result = URLEncoder.encode(value, charset);
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    /**
     * 从URL中提取所有的参数。
     * 
     * @param query
     *            URL地址
     * @return 参数映射
     */
    public static Map<String, String> splitUrlQuery(String query)
    {
        Map<String, String> result = new HashMap<String, String>();

        String[] pairs = query.split("&");
        if (pairs != null && pairs.length > 0)
        {
            for (String pair : pairs)
            {
                String[] param = pair.split("=", 2);
                if (param != null && param.length == 2)
                {
                    result.put(param[0], param[1]);
                }
            }
        }
        return result;
    }
    /**
     * 执行HTTP PUT请求。
     *
     * @param url
     *            请求地址
     *@param connectTimeout
     *            链接超时时间
     * @param readTimeout
     *            链接读取超时时间
     * @return 响应字符串
     */
    public static OneNetResult doPut(String url, String params, String charset,
            int connectTimeout, int readTimeout, Map<String, String> headerMap)
                    throws IOException
    {
        String ctype = "application/json;charset=" + charset;
        byte[] content = {};
        if (params != null)
        {
            content = params.getBytes(charset);
        }
        return doPut(url, ctype, content, connectTimeout, readTimeout,
                headerMap);
    }
    /**
     * 执行HTTP PUT请求。
     *
     * @param url
     *            请求地址
     *@param connectTimeout
     *            链接超时时间
     * @param readTimeout
     *            链接读取超时时间
     * @return 响应字符串
     */
    public static OneNetResult doPut(String url, byte[] content, String charset,
            int connectTimeout, int readTimeout, Map<String, String> headerMap)
                    throws IOException
    {
        String ctype = "application/json;charset=" + charset;
        return doPut(url, ctype, content, connectTimeout, readTimeout,
                headerMap);
    }
    /**
     * 执行HTTP PUT请求。
     *
     * @param url
     *            请求地址
     *@param connectTimeout
     *            链接超时时间
     * @param readTimeout
     *            链接读取超时时间
     * @return 响应字符串
     */
    private static OneNetResult doPut(String url, String ctype, byte[] content,
            int connectTimeout, int readTimeout, Map<String, String> headerMap)
                    throws IOException
    {
        HttpURLConnection conn = null;
        OutputStream out = null;
        OneNetResult rsp = null;
        try
        {
            conn = getConnection(new URL(url), METHOD_PUT, ctype, headerMap);
            conn.setConnectTimeout(connectTimeout);
            conn.setReadTimeout(readTimeout);
            out = conn.getOutputStream();
            out.write(content);
            rsp = getResponseAsContext(conn);
        }
        finally
        {
            if (out != null)
            {
                out.close();
            }
            if (conn != null)
            {
                conn.disconnect();
            }
        }

        return rsp;
    }
    /**
     * 执行HTTP DELETE请求。
     *
     * @param url
     *            请求地址
     * @return 响应字符串
     */
    public static OneNetResult doDelete(String url) throws IOException
    {
        return doDelete(url, DEFAULT_CHARSET);
    }
    /**
     * 执行HTTP DELETE请求。
     *
     * @param url
     *            请求地址
     * @return 响应字符串
     */
    private static OneNetResult doDelete(String url, String charset)
            throws IOException
    {
        return doDelete(url, null, charset);
    }
    /**
     * 执行HTTP DELETE请求。
     *
     * @param url
     *            请求地址
     * @return 响应字符串
     */
    public static OneNetResult doDelete(String url,
            Map<String, String> headerMap) throws IOException
    {
        return doDelete(url, headerMap, DEFAULT_CHARSET);
    }
    /**
     * 执行HTTP DELETE请求。
     *
     * @param url
     *            请求地址
     * @return 响应字符串
     */
    public static OneNetResult doDelete(String url,
            Map<String, String> headerMap, String charset) throws IOException
    {
        HttpURLConnection conn = null;
        OneNetResult rsp = null;

        try
        {
            String ctype = "application/json;charset=" + charset;
            conn = getConnection(new URL(url), METHOD_DELETE, ctype, headerMap);
            rsp = getResponseAsContext(conn);
        }
        finally
        {
            if (conn != null)
            {
                conn.disconnect();
            }
        }

        return rsp;
    }

    public static class TrustAllTrustManager implements X509TrustManager
    {
        public X509Certificate[] getAcceptedIssuers()
        {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException
        {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException
        {
        }
    }

    /**
     * 执行HTTP POST请求。
     *
     * @param url
     *            请求地址
     * @param charset
     *            字符集，如UTF-8, GBK, GB2312
     * @param paraMap
     *            URL参数
     *@param connectTimeout
     *            链接超时时间
     * @param readTimeout
     *            链接读取超时时间
     * @return 响应字符串
     */
    public static OneNetResult doUploadPost(String url, String charset,Map<String, String> paraMap,
                                            int connectTimeout, int readTimeout,
                                       Map<String, String> headerMap) throws Exception
    {
        String ctype = "multipart/form-data;charset=" + charset;
        headerMap.put("upload","upload");
        headerMap.put("Content-Disposition", "form-data");
        headerMap.put("Content-Transfer-Encoding", "8bit");
        String BOUNDARY = java.util.UUID.randomUUID().toString();
        String PREFIX = "--", LINEND = "\r\n";
        HttpURLConnection conn = null;
        OutputStream out = null;
        OneNetResult rsp = null;
        try
        {
            conn = getUploadConnection(new URL(url), METHOD_POST);
            conn.setConnectTimeout(connectTimeout);
            conn.setUseCaches(false);
            conn.setReadTimeout(readTimeout);
            conn.setRequestProperty("Content-Type", ctype + ";boundary=" + BOUNDARY);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : paraMap.entrySet())
            {
                sb.append(PREFIX);
                sb.append(BOUNDARY);
                sb.append(LINEND);
                sb.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"" + LINEND);
                sb.append("Content-Type: text/plain; charset=" + charset + LINEND);
                sb.append("Content-Transfer-Encoding: 8bit" + LINEND);
                sb.append(LINEND);
                sb.append(entry.getValue());
                sb.append(LINEND);
            }
            DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
            outStream.write(sb.toString().getBytes());
            StringBuilder sb1 = new StringBuilder();
            sb1.append(PREFIX);
            sb1.append(BOUNDARY);
            sb1.append(LINEND);
            // name是post中传参的键 filename是文件的名称
            sb1.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + paraMap.get("uploadFileName") + "\"" + LINEND);
            sb1.append("Content-Type: application/octet-stream; charset=" + charset + LINEND);
            sb1.append(LINEND);
            outStream.write(sb1.toString().getBytes());
            InputStream is = null;
            try{
                //处理文件上传
                File file = handlerFile(paraMap);
                is = new FileInputStream(file);
                byte[] buffer = new byte[2048];
                int len = 0;
                //防止文件过大不一次性转换为二进制后在上传
                while ((len = is.read(buffer)) != -1)
                {
                    outStream.write(buffer, 0, len);
                }
            }finally {
                is.close();
            }
            outStream.write(LINEND.getBytes());
            //结束标志
            byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINEND).getBytes();
            outStream.write(end_data);
            outStream.flush();
            //out = conn.getOutputStream();
            //out.write(content);
            rsp = getResponseAsContext(conn);
        }
        finally
        {
            if (out != null)
            {
                out.close();
            }
            if (conn != null)
            {
                conn.disconnect();
            }
        }

        return rsp;
    }


    /**
     * 设置URL链接请求参数。
     *
     * @param url
     *            请求地址
     * @param method
     *            请求类型
     * @return 响应链接
     */
    private static HttpURLConnection getUploadConnection(URL url, String method) throws IOException
    {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        if (conn instanceof HttpsURLConnection)
        {
            HttpsURLConnection connHttps = (HttpsURLConnection) conn;
            try
            {
                SSLContext ctx = SSLContext.getInstance("TLS");
                ctx.init(null,
                        new TrustManager[] { new TrustAllTrustManager() },
                        new SecureRandom());
                connHttps.setSSLSocketFactory(ctx.getSocketFactory());
                connHttps.setHostnameVerifier(new HostnameVerifier()
                {
                    public boolean verify(String hostname, SSLSession session)
                    {
                        return true;
                    }
                });
            }
            catch (Exception e)
            {
                throw new IOException(e);
            }
            conn = connHttps;
        }

        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setRequestProperty("connection", "keep-alive");
        conn.setDoOutput(true);
        conn.setRequestProperty("Host", url.getHost());
        return conn;
    }

    private static File handlerFile(Map<String,String> paraMap) throws Exception{
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
        return file;
    }
}
