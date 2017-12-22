package com.privateOneNetApi.entity;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/22
 * @description 用于组装上传固件的url地址
 */
public class UploadSoftwareReqEntity extends FileEntity{

    private static final long serialVersionUID = 7L;

    //版本
    private final String VERSION = "version";

    //名称
    private final String FILE_NAME = "file_name";

    //描述
    private final String DESCRIPTION = "description";

    public String getVersion() {
        return get(VERSION);
    }

    public void setVersion(String version) {
        put(VERSION,version);
    }

    public String getFileName() {
        return get(FILE_NAME);
    }

    public void setFileName(String fileName) {
        put(FILE_NAME,fileName);
    }

    public String getDescription() {
        return get(DESCRIPTION);
    }

    public void setDescription(String description) {
        put(DESCRIPTION,description);
    }

}
