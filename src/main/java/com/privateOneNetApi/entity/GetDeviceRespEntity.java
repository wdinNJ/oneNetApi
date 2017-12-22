package com.privateOneNetApi.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取设备详情的返回值
 */
public class GetDeviceRespEntity {

    //在线状态
    private boolean online;

    //设备详情
    private JSONObject body;

    //模板内容
    private JSONObject schema;

    //模板id
    private int schema_id;

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public JSONObject getBody() {
        return body;
    }

    public void setBody(JSONObject body) {
        this.body = body;
    }

    public JSONObject getSchema() {
        return schema;
    }

    public void setSchema(JSONObject schema) {
        this.schema = schema;
    }

    public int getSchema_id() {
        return schema_id;
    }

    public void setSchema_id(int schema_id) {
        this.schema_id = schema_id;
    }
}
