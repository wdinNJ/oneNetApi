
package com.privateOneNetApi.common;


import com.privateOneNetApi.exception.OneNetParameterException;

/**
 * 检查参数的基础类
 */
public class RequestCheckUtils
{

    public static final int ERROR_CODE_ARGUMENTS_MISSING = 40;
    public static final int ERROR_CODE_ARGUMENTS_INVALID = 41;

    public static void checkNotEmpty(Object value, String fieldName) throws OneNetParameterException
    {
        if (value == null)
        {
            throw new OneNetParameterException(ERROR_CODE_ARGUMENTS_MISSING,
                    "client-error:Missing required arguments:" + fieldName + "");
        }
        if (value instanceof String)
        {
            if (((String) value).trim().length() == 0)
            {
                throw new OneNetParameterException(ERROR_CODE_ARGUMENTS_MISSING,
                        "client-error:Missing required arguments:" + fieldName + "");
            }
        }
    }

    public static void checkMaxLength(String value, int maxLength, String fieldName)
            throws OneNetParameterException
    {
        if (value != null)
        {
            if (value.length() > maxLength)
            {
                throw new OneNetParameterException(ERROR_CODE_ARGUMENTS_INVALID,
                        "client-error:Invalid arguments:the string length of " + fieldName
                                + " can not be larger than " + maxLength + ".");
            }
        }
    }

    public static void checkMinLength(String value, int minLength, String fieldName)
            throws OneNetParameterException
    {
        if (value != null)
        {
            if (value.length() < minLength)
            {
                throw new OneNetParameterException(ERROR_CODE_ARGUMENTS_INVALID,
                        "client-error:Invalid arguments:the string length of " + fieldName
                                + " can not be smaller than " + minLength + ".");
            }
        }
    }

    public static void checkMaxListSize(String value, int maxSize, String fieldName)
            throws OneNetParameterException
    {
        if (value != null)
        {
            String[] list = value.split(",");
            if (list != null && list.length > maxSize)
            {
                throw new OneNetParameterException(ERROR_CODE_ARGUMENTS_INVALID,
                        "client-error:Invalid arguments:the array size of " + fieldName
                                + " must be less than " + maxSize + ".");
            }
        }
    }

    public static void checkMaxValue(Long value, long maxValue, String fieldName)
            throws OneNetParameterException
    {
        if (value != null)
        {
            if (value > maxValue)
            {
                throw new OneNetParameterException(ERROR_CODE_ARGUMENTS_INVALID,
                        "client-error:Invalid arguments:the value of " + fieldName
                                + " can not be larger than " + maxValue + ".");
            }
        }
    }

    public static void checkMinValue(Long value, long minValue, String fieldName)
            throws OneNetParameterException
    {
        if (value != null)
        {
            if (value < minValue)
            {
                throw new OneNetParameterException(ERROR_CODE_ARGUMENTS_INVALID,
                        "client-error:Invalid arguments:the value of " + fieldName
                                + " can not be less than " + minValue + ".");
            }
        }
    }
}
