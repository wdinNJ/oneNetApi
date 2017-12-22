package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/17
 * @description 获取产品事件列表返回值
 */
public class GetEventRespEntity {

    //事件内容
    private String body;

    //事件模板
    private String schema;

    //事件模板id
    private int schema_id;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public int getSchema_id() {
        return schema_id;
    }

    public void setSchema_id(int schema_id) {
        this.schema_id = schema_id;
    }
}
