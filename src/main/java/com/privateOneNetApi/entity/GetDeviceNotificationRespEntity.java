package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取设备通知列表返回值
 */
public class GetDeviceNotificationRespEntity {

    //通知id
    private String uuid;

    //创建时间亦或发送时间
    private String created_time;

    //确认时间
    private String acked_time;

    //响应时间
    private String confirm_time;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getAcked_time() {
        return acked_time;
    }

    public void setAcked_time(String acked_time) {
        this.acked_time = acked_time;
    }

    public String getConfirm_time() {
        return confirm_time;
    }

    public void setConfirm_time(String confirm_time) {
        this.confirm_time = confirm_time;
    }
}
