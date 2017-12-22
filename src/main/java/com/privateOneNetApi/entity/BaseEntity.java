package com.privateOneNetApi.entity;

import com.privateOneNetApi.common.DefaultValue;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 公共的字段
 */
public class BaseEntity extends ParamMap{

    private final String TOKEN = "token";

    //产品ID
    private final String PRODUCT_ID = "product_id";

    public String getToken() {
        return get(TOKEN);
    }

    public void setToken(String token) {
        put(TOKEN,token);
    }

    public int getProductId() {
        return get(PRODUCT_ID) == null ? DefaultValue.DEFAULT_NULL_VALUE:Integer.parseInt(get(PRODUCT_ID));
    }

    public void setProductId(int productId) {
        put(PRODUCT_ID,productId);
    }

}
