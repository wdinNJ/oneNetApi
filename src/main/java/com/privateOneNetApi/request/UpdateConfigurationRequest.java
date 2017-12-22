package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.UpdateConfigurationBodyReqEntity;
import com.privateOneNetApi.entity.UpdateConfigurationReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.UpdateConfigurationResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 配置变更请求类
 */
public class UpdateConfigurationRequest extends BaseOneNetRequest<UpdateConfigurationBodyReqEntity,UpdateConfigurationResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/configuration";

    private UpdateConfigurationReqEntity updateConfigurationReqEntity;

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //将url地址中的？后面部分添加
        context.getParameter().putAll(updateConfigurationReqEntity);
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<UpdateConfigurationResponse> getResponseClass() {
        return UpdateConfigurationResponse.class;
    }

    public HTTPMETHOD getMethod()
    {
        return HTTPMETHOD.PUT;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();
        RequestCheckUtils.checkNotEmpty(updateConfigurationReqEntity.getToken(), "token");
        RequestCheckUtils.checkNotEmpty(updateConfigurationReqEntity.getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null:updateConfigurationReqEntity.getProductId(), "product_id");

        RequestCheckUtils.checkNotEmpty(getEntity().getSchema_id() == DefaultValue.DEFAULT_NULL_VALUE ? null:updateConfigurationReqEntity.getProductId(), "product_id");
        RequestCheckUtils.checkNotEmpty(getEntity().getBody(), "body");
        RequestCheckUtils.checkNotEmpty(getEntity().getGroup_ids(), "group_ids");
    }

    public UpdateConfigurationReqEntity getUpdateConfigurationReqEntity() {
        return updateConfigurationReqEntity;
    }

    public void setUpdateConfigurationReqEntity(UpdateConfigurationReqEntity updateConfigurationReqEntity) {
        this.updateConfigurationReqEntity = updateConfigurationReqEntity;
    }
}
