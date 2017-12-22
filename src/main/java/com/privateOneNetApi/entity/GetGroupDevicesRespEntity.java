package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 用于组装获取设备分组下面设备的url地址
 */
public class GetGroupDevicesRespEntity {

    //设备id
    private String device_id;

    //在线状态
    private boolean online;

    //状态变化时间
    private String modified_time;

    //注册时间
    private String registered_time;

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getModified_time() {
        return modified_time;
    }

    public void setModified_time(String modified_time) {
        this.modified_time = modified_time;
    }

    public String getRegistered_time() {
        return registered_time;
    }

    public void setRegistered_time(String registered_time) {
        this.registered_time = registered_time;
    }
}
