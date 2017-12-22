package com.privateOneNetApi.entity;

import com.privateOneNetApi.common.DefaultValue;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/15
 * @description 用于组装获取产品列表的url地址
 */
public class ProductsReqEntity extends ParamMap {

    private static final long serialVersionUID = 7L;

    private final String TOKEN = "token";
    //页数
    private final String PAGE = "page";
    //每页条数
    private final String PER_PAGE = "per_page";

    public String getToken() {
        return get(TOKEN);
    }

    public int getPage() {
        return get(PAGE) == null ? -DefaultValue.DEFAULT_NULL_VALUE : Integer.parseInt(get(PAGE));
    }

    public int getPerPage() {
        return get(PER_PAGE) == null ? -DefaultValue.DEFAULT_NULL_VALUE : Integer.parseInt(get(PER_PAGE));
    }

    public void setToken(String token) {
        put(TOKEN,token);
    }

    public void setPage(int page) {
        put(PAGE,page);
    }

    public void setPerPage(int perPage) {
        put(PER_PAGE,perPage);
    }
}
