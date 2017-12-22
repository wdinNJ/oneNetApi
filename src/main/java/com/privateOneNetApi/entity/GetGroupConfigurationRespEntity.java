package com.privateOneNetApi.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取组配置内容详情的返回值
 */
public class GetGroupConfigurationRespEntity {

    //配置内容详情
    private JSONObject body;

    //模板内容
    private JSONObject schema;

    private int schema_id;

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
