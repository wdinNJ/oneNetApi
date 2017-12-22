package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.UploadSoftwareBodyReqEntity;
import com.privateOneNetApi.entity.UploadSoftwareReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.UploadSoftwareResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/22
 * @description 上传固件请求类
 */
public class UploadSoftwareRequest extends BaseOneNetRequest<UploadSoftwareBodyReqEntity,UploadSoftwareResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/software";

    private UploadSoftwareReqEntity uploadSoftwareReqEntity;

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //将url地址中的？后面部分添加
        //context.getParameter().putAll(uploadSoftwareReqEntity);
        setParaMap(uploadSoftwareReqEntity);
        return URIUtils.fmtURI(URI, context);
    }

    public HTTPMETHOD getMethod()
    {
        return HTTPMETHOD.UPLOAD_POST;
    }

    @Override
    public Class<UploadSoftwareResponse> getResponseClass() {
        return UploadSoftwareResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {
        //super.check();

        RequestCheckUtils.checkNotEmpty(uploadSoftwareReqEntity.getToken(), "token");
        RequestCheckUtils.checkNotEmpty(uploadSoftwareReqEntity.getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null:uploadSoftwareReqEntity.getProductId(), "product_id");
        RequestCheckUtils.checkNotEmpty(uploadSoftwareReqEntity.getVersion(), "version");
        RequestCheckUtils.checkNotEmpty(uploadSoftwareReqEntity.getFileName(), "file_name");
        RequestCheckUtils.checkNotEmpty(uploadSoftwareReqEntity.getDescription(), "description");
        RequestCheckUtils.checkNotEmpty(uploadSoftwareReqEntity.getFilePath(), "filePath");

        //RequestCheckUtils.checkNotEmpty(getEntity().getName(), "name");

        //RequestCheckUtils.checkNotEmpty(getFilePath(),"filePath");
    }

    public UploadSoftwareReqEntity getUploadSoftwareReqEntity() {
        return uploadSoftwareReqEntity;
    }

    public void setUploadSoftwareReqEntity(UploadSoftwareReqEntity uploadSoftwareReqEntity) {
        this.uploadSoftwareReqEntity = uploadSoftwareReqEntity;
    }
}
