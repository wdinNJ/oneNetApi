
package com.privateOneNetApi.entity;

import com.privateOneNetApi.common.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * 向服务器请求服务时的参数映射Map，参数是指HTTP 请求URL中问号好后面的参数表 ParamMap内部负责完成参数的格式化
 * 
 * @author szl
 *
 */

public class ParamMap extends HashMap<String, String>
{
    public static Logger logger = LoggerFactory.getLogger(ParamMap.class);
    private static final long serialVersionUID = -1277791390393392630L;
    // 上行时间日期格式
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    // 下行时间日期格式
    public static final String DATE_TIMEZONE = "GMT+8";

    public ParamMap()
    {
        super();
    }

    public ParamMap(Map<? extends String, ? extends String> m)
    {
        super(m);
    }

    public Date getAsDate(String key)
    {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
        String stringDate = get(key);
        if (stringDate != null){

            try
            {
                date = sdf.parse(stringDate);
            }
            catch (ParseException e)
            {
                logger.info("date format error");
                date = null;
            }
            catch (Exception e2)
            {
                date = null;
            }
        }
        return date;
    }

    public String put(String key, Object value)
    {
        String strValue;

        if (value == null)
        {
            strValue = null;
        }
        else if (value instanceof String)
        {
            strValue = (String) value;
        }
        else if (value instanceof Integer)
        {
            strValue = ((Integer) value).toString();
        }
        else if (value instanceof Long)
        {
            strValue = ((Long) value).toString();
        }
        else if (value instanceof Float)
        {
            strValue = ((Float) value).toString();
        }
        else if (value instanceof Double)
        {
            strValue = ((Double) value).toString();
        }
        else if (value instanceof Boolean)
        {
            strValue = ((Boolean) value).toString();
        }
        else if (value instanceof Date)
        {
            DateFormat format = new SimpleDateFormat(DATE_TIME_FORMAT);
            format.setTimeZone(TimeZone.getTimeZone(DATE_TIMEZONE));
            strValue = format.format((Date) value);
        }
        else
        {
            strValue = value.toString();
        }
        return this.put(key, strValue);
    }

    public String put(String key, String value)
    {
        if (StringUtils.areNotEmpty(key, value))
        {
            return super.put(key, value);
        }
        else
        {
            return null;
        }
    }
}
