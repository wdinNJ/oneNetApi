package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 获取产品通知列表 target属性
 */
public class GetNotificationsTarget {

    private String type;

    //可能是组名称或UUID
    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
