
package com.privateOneNetApi.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * URL工具类，主要用于拼接和组装URL用
 * 
 * 
 * @author szl
 */

public class URIUtils
{
    private static final Logger LOGGER = LoggerFactory.getLogger(URIUtils.class);
    private final static Pattern PATTERN = Pattern.compile("<(.*?)>");
    private static final String DEFAULT_CHARSET = "UTF-8";



    /**
     * 根据 二进制数据上传 接口api(该接口不符restapi规范)要求修改 2015-12-15
     * 
     * @param uri
     *            形如"<scheme>://<API_ADDRESS>/keys"的字符串，其中会依据context中的内容替换<>中的内容
     * @param context
     *            数值，用于组装URL
     * @return
     */
    public static String fmtURI(String uri, OneNetContext context)
    {
        // 构造URL
        Matcher matcher = PATTERN.matcher(uri);
        StringBuffer sb = new StringBuffer();
        while (matcher.find())
        {
            String key = matcher.group(1);
            matcher.appendReplacement(sb, context.getContext().get(key).toString());
        }
        matcher.appendTail(sb);
        String url = sb.toString();
        sb = null;

        // 构造查询字符串
        Set<Entry<String, Object>> entrySet = context.getParameter().entrySet();
        String query = null;
        if (null != entrySet && !entrySet.isEmpty())
        {
            query = buildQuery(entrySet);
        }

        // 构造整个URL
        if (null != query)
        {
            try
            {
                url = buildUrl(url, query);
            }
            catch (IOException e)
            {
                LOGGER.error("Build url error: url={} and query = {}", url, query);
                url = null;
            }
        }
        return url;
    }

    /**
     * 构造URL中的查询字符串
     * 
     * @param entrySet
     *            URL中的参数键值对
     * @return 查询字符串
     */
    private static String buildQuery(Set<Entry<String, Object>> entrySet)
    {
        if (entrySet.isEmpty())
        {
            return null;
        }

        StringBuilder query = new StringBuilder(128);
        boolean isfirstParam = true;

        for (Entry<String, Object> entry : entrySet)
        {
            String name = entry.getKey();
            String value = (null != entry.getValue()) ? String.valueOf(entry.getValue()) : null;
            // 忽略参数名或参数值为空的参数
            if (StringUtils.areNotEmpty(name, value))
            {
                if (!isfirstParam)
                {
                    query.append("&");
                }
                else
                {
                    isfirstParam = false;
                }
                String encodeValue = "";
                try
                {
                    encodeValue = URLEncoder.encode(value, DEFAULT_CHARSET);
                }
                catch (UnsupportedEncodingException e)
                {
                    encodeValue = value;
                    LOGGER.error("encode url error:", e);
                }
                query.append(name).append("=").append(encodeValue);
            }
        }
        return query.toString();
    }

    /**
     * 构造完整的URL
     * 
     * @param strUrl
     *            URL的前半部分
     * @param query
     *            查询字符串
     * @return 新字符串
     * @throws IOException
     */
    private static String buildUrl(String strUrl, String query) throws IOException
    {
        URL url = new URL(strUrl);
        if (StringUtils.isEmpty(query))
        {
            return strUrl;
        }

        if (StringUtils.isEmpty(url.getQuery()))
        {
            if (strUrl.endsWith("?"))
            {
                strUrl = strUrl + query;
            }
            else
            {
                strUrl = strUrl + "?" + query;
            }
        }
        else
        {
            if (strUrl.endsWith("&"))
            {
                strUrl = strUrl + query;
            }
            else
            {
                strUrl = strUrl + "&" + query;
            }
        }
        return strUrl;
    }
}
