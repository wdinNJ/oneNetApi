package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 配置变更的HTTP内容
 */
public class UpdateConfigurationBodyReqEntity {

    //模板id
    private int schema_id;

    //同通知一样，根据schema填写，JSON
    private Object body;

    //组id
    private int [] group_ids;

    public int getSchema_id() {
        return schema_id;
    }

    public void setSchema_id(int schema_id) {
        this.schema_id = schema_id;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public int[] getGroup_ids() {
        return group_ids;
    }

    public void setGroup_ids(int[] group_ids) {
        this.group_ids = group_ids;
    }
}
