package com.privateOneNetApi.entity;

import com.privateOneNetApi.common.DefaultValue;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 分页的字段
 */
public class PageEntity extends BaseEntity {

    //页数
    private final String PAGE = "page";

    //每页条数
    private final String PER_PAGE = "per_page";

    public int getPage() {
        return get(PAGE) == null ? DefaultValue.DEFAULT_NULL_VALUE:Integer.parseInt(get(PAGE));
    }

    public void setPage(long page) {
        put(PAGE,page);
    }

    public int getPerPage() {
        return get(PER_PAGE) == null ? DefaultValue.DEFAULT_NULL_VALUE:Integer.parseInt(get(PER_PAGE));
    }

    public void setPerPage(int perPage) {
        put(PER_PAGE,perPage);
    }

}
