package com.privateOneNetApi.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取设备传感器数据列表返回值
 */
public class GetDeviceSensorDatasRespEntity {

    //上传时间
    private String at;

    //内容
    private JSONObject body;

    //模板
    private JSONObject schema;

    //模板id
    private int schema_id;

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
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
