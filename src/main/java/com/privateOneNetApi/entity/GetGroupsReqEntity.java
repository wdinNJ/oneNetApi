package com.privateOneNetApi.entity;

import com.privateOneNetApi.common.DefaultValue;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/16
 * @description 用于组装获取设备分组列表的url地址
 */
public class GetGroupsReqEntity extends PageEntity {

    private static final long serialVersionUID = 7L;

    //可选，用于模糊查询，分组名称
    private final String KEYWORD = "keyword";

    public String getKeyword() {
        return get(KEYWORD);
    }

    public void setKeyword(String keyword) {
        put(KEYWORD,keyword);
    }

}
