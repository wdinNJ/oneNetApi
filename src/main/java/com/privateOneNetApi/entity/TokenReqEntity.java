package com.privateOneNetApi.entity;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.exception.OneNetParameterException;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/15
 * @description 用于组装获取token的url地址
 */
public class TokenReqEntity extends ParamMap {

    private static final long serialVersionUID = 7L;

    private final String USER_ID = "user_id";
    private final String SECRET = "secret";

    public int getUserID() {
        return get(USER_ID) == null ? DefaultValue.DEFAULT_NULL_VALUE : Integer.parseInt(get(USER_ID));
    }

    public void setUserID(int user_id) throws OneNetParameterException {
        put(USER_ID,user_id);
    }

    public String getSecret() {
        return get(SECRET);
    }

    public void setSecret(String secret) throws OneNetParameterException {
        put(SECRET,secret);
    }
}
