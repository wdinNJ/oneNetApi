package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.SoftwareActivateBodyReqEntity;
import com.privateOneNetApi.entity.SoftwareActivateReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.SoftwareActivateResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/22
 * @description 固件升级请求类
 */
public class SoftwareActivateRequest extends BaseOneNetRequest<SoftwareActivateBodyReqEntity,SoftwareActivateResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/software_activate";

    private SoftwareActivateReqEntity softwareActivateReqEntity;

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //将url地址中的？后面部分添加
        context.getParameter().putAll(softwareActivateReqEntity);
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<SoftwareActivateResponse> getResponseClass() {
        return SoftwareActivateResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();

        RequestCheckUtils.checkNotEmpty(getEntity().getGroup_ids(), "group_ids");
        RequestCheckUtils.checkNotEmpty(getEntity().getSoftware_uuids(), "software_uuids");

        RequestCheckUtils.checkNotEmpty(softwareActivateReqEntity, "Entity");
        RequestCheckUtils.checkNotEmpty(softwareActivateReqEntity.getToken(),"token");
        RequestCheckUtils.checkNotEmpty(softwareActivateReqEntity.getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null : softwareActivateReqEntity.getProductId(),"product_id");
    }

    public HTTPMETHOD getMethod()
    {
        return HTTPMETHOD.POST;
    }

    public SoftwareActivateReqEntity getSoftwareActivateReqEntity() {
        return softwareActivateReqEntity;
    }

    public void setSoftwareActivateReqEntity(SoftwareActivateReqEntity softwareActivateReqEntity) {
        this.softwareActivateReqEntity = softwareActivateReqEntity;
    }
}
