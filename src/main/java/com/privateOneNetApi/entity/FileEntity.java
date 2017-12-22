package com.privateOneNetApi.entity;

import com.privateOneNetApi.common.DefaultValue;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/27
 * @description 上传文件时的继承
 */
public class FileEntity extends BaseEntity{

    private final String FILEPATH = "filePath";

    //文件最大值(K)
    private final String MAXFILESIZE = "maxFileSize";

    private final String UPLOADFILENAME = "fileName";

    public String getFilePath() {
        return get(FILEPATH);
    }

    public void setFilePath(String filePath) {
        put(FILEPATH,filePath);
    }

    public int getMaxFileSize() {
        return get(MAXFILESIZE) == null ? DefaultValue.DEFAULT_NULL_VALUE:Integer.parseInt(get(MAXFILESIZE));
    }

    public void setMaxFileSize(int maxFileSize) {
        put(MAXFILESIZE,maxFileSize);
    }

    public String getUploadFileName() {
        return get(UPLOADFILENAME);
    }

    public void setUploadFileName(String uploadFileName) {
        put(UPLOADFILENAME,uploadFileName);
    }


}
