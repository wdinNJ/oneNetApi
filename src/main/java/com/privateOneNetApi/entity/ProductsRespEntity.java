package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/15
 * @description 产品列表返回值
 */
public class ProductsRespEntity {

    //产品product_id
    private int id;

    //产品名
    private String name;

    //简介
    private String description;

    //状态
    private String status;

    //是否收藏
    private Boolean favourite;

    //设备注册码
    private String rgcode;

    //设备调试码
    private String sb_rgcode;

    //设备数
    private int device_current_count;

    //分组数
    private int group_count;

    private String created_time;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    public String getRgcode() {
        return rgcode;
    }

    public void setRgcode(String rgcode) {
        this.rgcode = rgcode;
    }

    public String getSb_rgcode() {
        return sb_rgcode;
    }

    public void setSb_rgcode(String sb_rgcode) {
        this.sb_rgcode = sb_rgcode;
    }

    public int getDevice_current_count() {
        return device_current_count;
    }

    public void setDevice_current_count(int device_current_count) {
        this.device_current_count = device_current_count;
    }

    public int getGroup_count() {
        return group_count;
    }

    public void setGroup_count(int group_count) {
        this.group_count = group_count;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }
}
