package com.privateOneNetApi.entity;

import com.privateOneNetApi.common.DefaultValue;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 用于组装设备分组下面的设备的url地址
 */
public class GetGroupDevicesReqEntity extends BaseEntity{

    private static final long serialVersionUID = 7L;

    //游标数，首次为空
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
