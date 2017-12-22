package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/16
 * @description 设备分组详情的分组固件
 */
public class GroupSoftware {

    private String uuid;

    //版本
    private String version;

    //固件信息
    private String file_name;

    private String md5sum;

    private String activated_time;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getMd5sum() {
        return md5sum;
    }

    public void setMd5sum(String md5sum) {
        this.md5sum = md5sum;
    }

    public String getActivated_time() {
        return activated_time;
    }

    public void setActivated_time(String activated_time) {
        this.activated_time = activated_time;
    }
}
