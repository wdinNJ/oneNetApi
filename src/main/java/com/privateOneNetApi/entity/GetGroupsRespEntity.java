package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/16
 * @description 获取设备分组列表返回值
 */
public class GetGroupsRespEntity {

    //分组id
    private int id;

    //分组名称
    private String name;

    //权重
    private int weight;

    //分组条件
    private String filter;

    //分组描述
    private String description;

    //组内设备数量
    private int device_count;

    //组内设备在线数
    private int online_device_count;

    //分组时间
    private String modified_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDevice_count() {
        return device_count;
    }

    public void setDevice_count(int device_count) {
        this.device_count = device_count;
    }

    public int getOnline_device_count() {
        return online_device_count;
    }

    public void setOnline_device_count(int online_device_count) {
        this.online_device_count = online_device_count;
    }

    public String getModified_time() {
        return modified_time;
    }

    public void setModified_time(String modified_time) {
        this.modified_time = modified_time;
    }
}
