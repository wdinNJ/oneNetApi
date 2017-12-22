package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 获取产品事件列表返回值
 */
public class GetEventsRespEntity {

    //事件uuid
    private String uuid;

    //事件来源设备id
    private String at;

    //发生时间
    private String received_time;

    //事件模板id
    private int schema_id;

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

    public String getReceived_time() {
        return received_time;
    }

    public void setReceived_time(String received_time) {
        this.received_time = received_time;
    }

    public int getSchema_id() {
        return schema_id;
    }

    public void setSchema_id(int schema_id) {
        this.schema_id = schema_id;
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
