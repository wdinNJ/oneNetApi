package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取固件列表返回值
 */
public class GetSoftwaresRespEntity {

    //固件uuid
    private String uuid;

    //版本
    private String version;

    //固件信息
    private String file_name;

    private String md5sum;

    private String uploaded_time;

    //文件描述字段
    private String description;

    //文件大小
    private int length;

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

    public String getUploaded_time() {
        return uploaded_time;
    }

    public void setUploaded_time(String uploaded_time) {
        this.uploaded_time = uploaded_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
