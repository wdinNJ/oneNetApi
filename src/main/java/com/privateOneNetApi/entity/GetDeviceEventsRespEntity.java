package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/20
 * @description 获取设备事件列表返回值
 */
public class GetDeviceEventsRespEntity {

    //事件uuid
    private String uuid;

    //发生时间
    private String at;

    //事件类型
    private String level;

    private String status;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
