package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 获取产品通知列表返回值
 */
public class GetNotificationsRespEntity {

    //通知id
    private String uuid;

    //通知版本
    private String version;

    //通知schema名称
    private String name;

    //创建时间亦或发送时间
    private String sent_time;

    //通知设备数
    private int device_count;

    //接收设备数
    private int accepted_device_count;

    //响应设备数
    private int confirmed_device_count;

    private String expired_time;

    private int op_user_id;

    private GetNotificationsTarget target;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSent_time() {
        return sent_time;
    }

    public void setSent_time(String sent_time) {
        this.sent_time = sent_time;
    }

    public int getDevice_count() {
        return device_count;
    }

    public void setDevice_count(int device_count) {
        this.device_count = device_count;
    }

    public int getAccepted_device_count() {
        return accepted_device_count;
    }

    public void setAccepted_device_count(int accepted_device_count) {
        this.accepted_device_count = accepted_device_count;
    }

    public int getConfirmed_device_count() {
        return confirmed_device_count;
    }

    public void setConfirmed_device_count(int confirmed_device_count) {
        this.confirmed_device_count = confirmed_device_count;
    }

    public String getExpired_time() {
        return expired_time;
    }

    public void setExpired_time(String expired_time) {
        this.expired_time = expired_time;
    }

    public int getOp_user_id() {
        return op_user_id;
    }

    public void setOp_user_id(int op_user_id) {
        this.op_user_id = op_user_id;
    }

    public GetNotificationsTarget getTarget() {
        return target;
    }

    public void setTarget(GetNotificationsTarget target) {
        this.target = target;
    }
}
