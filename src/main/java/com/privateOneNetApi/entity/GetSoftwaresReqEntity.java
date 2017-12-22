package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 用于组装获取固件列表的url地址
 */
public class GetSoftwaresReqEntity extends PageEntity{

    private static final long serialVersionUID = 7L;

    //可选，查询名字
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
