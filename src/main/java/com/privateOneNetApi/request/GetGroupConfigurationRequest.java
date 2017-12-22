package com.privateOneNetApi.request;

import com.privateOneNetApi.common.DefaultValue;
import com.privateOneNetApi.common.OneNetContext;
import com.privateOneNetApi.common.RequestCheckUtils;
import com.privateOneNetApi.common.URIUtils;
import com.privateOneNetApi.entity.GetGroupConfigurationReqEntity;
import com.privateOneNetApi.exception.OneNetParameterException;
import com.privateOneNetApi.response.GetGroupConfigurationResponse;

/**
 * @author liaoyubo
 * @version 1.0 2017/11/21
 * @description 获取组配置内容详情的请求类
 */
public class GetGroupConfigurationRequest extends BaseOneNetRequest<GetGroupConfigurationReqEntity,GetGroupConfigurationResponse>{

    private static final String URI = "<scheme>://<API_ADDRESS>/pp/configuration";

    @Override
    public String getURL(OneNetContext context) throws OneNetParameterException {
        //将url地址中的？后面部分添加
        context.getParameter().putAll(getEntity());
        return URIUtils.fmtURI(URI, context);
    }

    @Override
    public Class<GetGroupConfigurationResponse> getResponseClass() {
        return GetGroupConfigurationResponse.class;
    }

    @Override
    public void check() throws OneNetParameterException {
        super.check();

        RequestCheckUtils.checkNotEmpty(getEntity().getToken(), "token");
        RequestCheckUtils.checkNotEmpty(getEntity().getProductId() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getProductId(), "product_id");
        RequestCheckUtils.checkNotEmpty(getEntity().getSchemaId() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getSchemaId(), "schema_id");
        RequestCheckUtils.checkNotEmpty(getEntity().getGroupId() == DefaultValue.DEFAULT_NULL_VALUE ? null:getEntity().getGroupId(), "group_id");

    }
}
