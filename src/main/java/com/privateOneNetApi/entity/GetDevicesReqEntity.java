package com.privateOneNetApi.entity;

import com.privateOneNetApi.common.DefaultValue;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 用于组装获取设备列表的url地址
 */
public class GetDevicesReqEntity extends BaseEntity{

    private static final long serialVersionUID = 7L;

    //游标数
    private final String CURSOR = "cursor";

    //遍历数量，最多100
    private final String LIMIT = "limit";

    public String getCursor(){
        return get(CURSOR);
    }

    public void setCursor(String cursor){
        put(CURSOR,cursor);
    }

    public int getLimit(){
        return get(LIMIT) == null ? DefaultValue.DEFAULT_NULL_VALUE : Integer.parseInt(get(LIMIT));
    }

    public void setLimit(int limit){
        put(LIMIT,limit);
    }

}
