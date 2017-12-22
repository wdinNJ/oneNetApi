package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/22
 * @description 上传固件的HTTP内容
 */
public class UploadSoftwareBodyReqEntity {

    private byte [] name;

    public byte[] getName() {
        return name;
    }

    public void setName(byte[] name) {
        this.name = name;
    }
}
