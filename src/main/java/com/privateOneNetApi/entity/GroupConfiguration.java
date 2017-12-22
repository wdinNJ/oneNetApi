package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/16
 * @description 设备分组详情配置
 */
public class GroupConfiguration {

    private int schema_id;

    private String version;

    private String name;

    private String activated_time;

    public int getSchema_id() {
        return schema_id;
    }

    public void setSchema_id(int schema_id) {
        this.schema_id = schema_id;
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

    public String getActivated_time() {
        return activated_time;
    }

    public void setActivated_time(String activated_time) {
        this.activated_time = activated_time;
    }
}
